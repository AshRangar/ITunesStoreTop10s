package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ashwin on 1/25/16.
 */
public class RssEntriesList implements Serializable{
    private ArrayList<RssEntry> mRssEntries;

    public RssEntriesList() {
        mRssEntries = new ArrayList<RssEntry>();
        initializeRssEntries();
    }

    private void initializeRssEntries() {
        mRssEntries.add(new RssEntry("Songs", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml"));
        mRssEntries.add(new RssEntry("Albums", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topalbums/limit=10/xml"));
        mRssEntries.add(new RssEntry("New Releases", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/newreleases/limit=10/rss.xml"));
        mRssEntries.add(new RssEntry("Just Added", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/justadded/limit=10/rss.xml"));
        mRssEntries.add(new RssEntry("Featured Albums", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/featuredalbums/limit=10/rss.xml"));
        mRssEntries.add(new RssEntry("Paid Apps", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=10/xml"));
        mRssEntries.add(new RssEntry("Free Apps", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"));
        mRssEntries.add(new RssEntry("Movies", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topMovies/limit=10/xml"));
        mRssEntries.add(new RssEntry("TV Seasons", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topTvSeasons/limit=10/xml"));
        mRssEntries.add(new RssEntry("TV Episodes", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topTvEpisodes/limit=10/xml"));
    }

    public ArrayList<RssEntry> getRssEntries() {
        return mRssEntries;
    }
}