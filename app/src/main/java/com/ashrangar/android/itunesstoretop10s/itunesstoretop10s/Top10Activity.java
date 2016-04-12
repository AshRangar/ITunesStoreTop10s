package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ashwin on 2/29/16.
 *
 * Activity to display the Top 10 items for the particular category
 * Asynchronously download the XML file, then pass it to the ITunesEntriesFactory to parse the file and obtain the entries
 * Example: Displays the list of songs (after Songs category was selected from CategoriesListActivity)
 *
 */
public class Top10Activity extends AppCompatActivity {

    private final String TAG = Top10Activity.class.getSimpleName().toString();
    private Category mCategory;
    private ArrayList<ITunesEntry> mITunesEntries;
    private ListView mEntriesListView;
    private Toolbar mToolbar;
    private String mXmlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top10);

        mEntriesListView = (ListView) findViewById(R.id.rssListView);

        // Get the category_key from parent
        Intent intent = getIntent();
        mCategory = (Category) intent.getSerializableExtra(getString(R.string.category_key));

        // Obtain xmlData asynchronously (.execute method)
        XmlData xmlData = new XmlData();
        xmlData.execute(mCategory.getUrl());

        // Set the title of toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(mCategory.getTitle().toUpperCase());
    }

    // Inflates the context menu when it is created
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    // Choose the appropriate action when an item in the context menu is selected
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        // Switch case to determine which item in the menu was selected
        switch(item.getItemId()) {
            case R.id.open:
                openInternal(mITunesEntries.get(info.position).getUrl());
                return true;
            case R.id.openExternal:
                openExternal(mITunesEntries.get(info.position).getUrl());
                return true;
        }
        return super.onContextItemSelected(item);
    }

    // Helper method to create an explicit intent and view the web page using WebViewActivity
    public void openInternal(String url) {
        Intent intent = new Intent(Top10Activity.this, WebViewActivity.class);
        intent.putExtra("URL", url);
        startActivity(intent);
    }

    // Helper method to create an intent of ACTION_VIEW and start the activity
    public void openExternal(String url) {
        // Create an intent with ACTION_VIEW data
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        // Start the activity with the newly created intent
        // Provides lists of apps that can open the url
        startActivity(browserIntent);
    }

    // Obtain XmlData Asynchronously.
    private class XmlData extends AsyncTask<String, Void, String> {
        private final String TAG = XmlData.class.getSimpleName().toString();
        private String urlPath;

        public XmlData() {
            super();
        }

        // Download the XMLData in the background
        @Override
        protected String doInBackground(String... params) {
            this.urlPath = params[0];
            mXmlData = downloadXMLFile();

            if(mXmlData == null) {
                Log.d(TAG, "Error downloading");
            }

            return mXmlData;
        }

        // After XML has been downloaded, pass the XML Data to iTunesEntriesFactory to parse the data
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            // Get the list of iTunes Entries from the factory buy passing in the XmlData
            ITunesEntriesFactory ieFactory = new ITunesEntriesFactory();
            mITunesEntries =  ieFactory.getITunesEntries(mXmlData);;

            // Set the custom List Adapter to view the list of iTunes entires (list of songs for example)
            mEntriesListView.setAdapter(new Top10ListAdapter(Top10Activity.this, mITunesEntries));

            // Start the WebViewActivity when the item is selected
            mEntriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Top10Activity.this, WebViewActivity.class);
                    intent.putExtra("URL", mITunesEntries.get(position).getUrl());
                    startActivity(intent);
                }
            });

            // Register Context Menu when long pressed
            mEntriesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    registerForContextMenu(mEntriesListView);
                    return false;
                }
            });

            Log.d(TAG, mITunesEntries.toString());

        }

        // Method to download the XML File
        private String downloadXMLFile() {
            StringBuilder tempBuffer = new StringBuilder();

            try {
                URL url = new URL(urlPath);

                // Make connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // Get response
                int response = connection.getResponseCode();
                // Log.d(TAG, "The response code was " + response);

                // InputStream -> Obtain input in chunks of data
                InputStream is = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int charRead;
                char[] inputBuffer = new char[500];

                while(true) {
                    charRead = isr.read(inputBuffer);

                    // Break loop if there is no char to read
                    if(charRead <= 0) {
                        break;
                    }

                    // Append the chunk of chars to the buffer
                    tempBuffer.append(String.copyValueOf(inputBuffer, 0, charRead));
                }

                return tempBuffer.toString();

            } catch (IOException e) {
                // Log.d(TAG, "IOException reading data " + e.getMessage());
            } catch (SecurityException e) {
                // Log.d(TAG, "SecurityException " + e.getMessage());
            }
            return null;
        }

    }


}
