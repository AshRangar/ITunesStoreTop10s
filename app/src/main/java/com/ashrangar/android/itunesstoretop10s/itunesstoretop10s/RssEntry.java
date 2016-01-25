package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

/**
 * Created by ashwin on 1/25/16.
 */
public class RssEntry {
    private String title;
    private String url;

    public RssEntry(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Top 10 " + title;
    }
}
