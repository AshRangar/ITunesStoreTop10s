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

}
