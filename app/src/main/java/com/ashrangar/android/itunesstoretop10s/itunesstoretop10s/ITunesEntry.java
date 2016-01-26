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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void populateData() {

    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("Name: " + name + "\n");
        description.append("Artist: " + artist + "\n");
        description.append("Release Date: " + releaseDate);

        return description.toString();
    }
}
