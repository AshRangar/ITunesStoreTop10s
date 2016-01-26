package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

/**
 * Created by ashwin on 1/25/16.
 */
public class ITunesEntry {
    private String name;
    private String artist;
    private String releaseDate;

    public ITunesEntry() {
        this.name = new String();
        this.artist = new String();
        this.releaseDate = new String();
    }

    public ITunesEntry(String name, String artist, String releaseDate) {
        this.name = name;
        this.artist = artist;
        this.releaseDate = releaseDate;
    }
}
