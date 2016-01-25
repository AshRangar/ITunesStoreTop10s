package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import java.util.ArrayList;

/**
 * Created by ashwin on 1/25/16.
 */
public class RssEntriesList {
    private ArrayList<RssEntry> mRssEntries;

    public RssEntriesList() {
        mRssEntries = new ArrayList<RssEntry>();
        initializeRssEntries();
    }

    private void initializeRssEntries() {
        mRssEntries.add(new RssEntry("Songs", ""));
        mRssEntries.add(new RssEntry("Albums", ""));
        mRssEntries.add(new RssEntry("New Releases", ""));
        mRssEntries.add(new RssEntry("Just Added", ""));
        mRssEntries.add(new RssEntry("Featured Albums & Exclusives", ""));
        mRssEntries.add(new RssEntry("Paid Apps", ""));
        mRssEntries.add(new RssEntry("Free Apps", ""));
        mRssEntries.add(new RssEntry("Movies", ""));
        mRssEntries.add(new RssEntry("TV Seasons", ""));
        mRssEntries.add(new RssEntry("TV Episodes", ""));
    }
}
