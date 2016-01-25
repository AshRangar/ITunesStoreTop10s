package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class RssListActivity extends AppCompatActivity {

    private ListView mRssListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);

        mRssListView = (ListView) findViewById(R.id.rssListView);
        
    }

}
