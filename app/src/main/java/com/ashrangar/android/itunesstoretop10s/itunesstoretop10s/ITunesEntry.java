package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

/**
 * Created by ashwin on 1/25/16.
 *
 * Each item is an object of class ITunesEntry.
 * Example: Each song is an object of class ITunesEntry
 *
 */
public class ITunesEntry {
    private String name;
    private String artist;
    private String releaseDate;
    private String url;
    private String imageUrl;

    // Constructor
    public ITunesEntry() {
        this.name = new String();
        this.artist = new String();
        this.releaseDate = new String();
        this.url = new String();
        this.imageUrl = new String();
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
