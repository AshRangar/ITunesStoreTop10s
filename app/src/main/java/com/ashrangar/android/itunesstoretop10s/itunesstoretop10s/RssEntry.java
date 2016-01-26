package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ashwin on 1/25/16.
 */
public class RssEntry implements Serializable{
    private String title;
    private String url;
    private ArrayList<ITunesEntry> mITunesEntries;

    public RssEntry(String title, String url) {
        this.title = title;
        this.url = url;
        this.mITunesEntries = new ArrayList<ITunesEntry>();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return "Top 10 " + title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Top 10 " + title;
    }

    public ArrayList<ITunesEntry> getITunesEntries() {
        ITunesEntriesFactory iteFactory = new ITunesEntriesFactory();
        mITunesEntries = iteFactory.getITunesEntries(url);

        return mITunesEntries;
    }
}
