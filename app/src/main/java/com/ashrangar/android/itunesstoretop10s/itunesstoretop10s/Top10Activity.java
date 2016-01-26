package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Top10Activity extends AppCompatActivity {

    private final String TAG = Top10Activity.class.getSimpleName().toString();
    private RssEntry mRssEntry;
    private ListView mEntriesListView;
    private Toolbar mToolbar;
    private String mXmlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);

        mEntriesListView = (ListView) findViewById(R.id.rssListView);

        Intent intent = getIntent();
        mRssEntry = (RssEntry) intent.getSerializableExtra(getString(R.string.rss_entry_key));

        XmlData xmlData = new XmlData();
        xmlData.execute(mRssEntry.getUrl());

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(mRssEntry.getTitle());

    }

    private class XmlData extends AsyncTask<String, Void, String> {
        private final String TAG = XmlData.class.getSimpleName().toString();
        private String urlPath;

        public XmlData() {
            super();
        }

        @Override
        protected String doInBackground(String... params) {
            this.urlPath = params[0];
            mXmlData = downloadXMLFile();

            if(mXmlData == null) {
                Log.d(TAG, "Error downloading");
            }

            return mXmlData;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ITunesEntriesFactory ieFactory = new ITunesEntriesFactory();
            ArrayList<ITunesEntry> iTunesEntries =  ieFactory.getITunesEntries(mXmlData);;

            Log.d(TAG, "mRssEntry is " + mRssEntry);

            if(iTunesEntries.size() > 0) {
            }

            ArrayAdapter<ITunesEntry> arrayAdapter = new ArrayAdapter<ITunesEntry>(
                    Top10Activity.this, R.layout.itunes_list, iTunesEntries
            );

            mEntriesListView.setAdapter(arrayAdapter);

            Log.d(TAG, iTunesEntries.toString());

        }

        private String downloadXMLFile() {
            StringBuilder tempBuffer = new StringBuilder();

            try {
                URL url = new URL(urlPath);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
                Log.d(TAG, "The response code was " + response);

                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int charRead;
                char[] inputBuffer = new char[500];

                while(true) {
                    charRead = isr.read(inputBuffer);
                    if(charRead <= 0) {
                        break;
                    }
                    tempBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
                }

                return tempBuffer.toString();

            } catch (IOException e) {
                Log.d(TAG, "IOException reading data " + e.getMessage());
            } catch (SecurityException e) {
                Log.d(TAG, "SecurityException " + e.getMessage());
            }
            return null;
        }

    }


}
