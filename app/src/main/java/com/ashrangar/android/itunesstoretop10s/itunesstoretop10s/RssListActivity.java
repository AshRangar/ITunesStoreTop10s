package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RssListActivity extends AppCompatActivity {

    private ListView mRssListView;
    private RssEntriesList mRssEntriesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rss_list);

        mRssListView = (ListView) findViewById(R.id.rssListView);
        mRssEntriesList = new RssEntriesList();

        ArrayAdapter<RssEntry> arrayAdapter = new ArrayAdapter<RssEntry>(
                RssListActivity.this, R.layout.list_view, mRssEntriesList.getRssEntries()
        );

        mRssListView.setAdapter(arrayAdapter);

        mRssListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Log.d(TAG, "Selected item is " + selectedItem);

                RssEntry rssEntry = mRssEntriesList.getRssEntries().get(position);

                Intent intent = new Intent(RssListActivity.this, Top10Activity.class);
                intent.putExtra(getString(R.string.rss_entry_key), rssEntry);
                startActivity(intent);
            }
        });
    }

}
