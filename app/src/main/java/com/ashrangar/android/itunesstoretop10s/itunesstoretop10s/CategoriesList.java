package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ashwin on 1/25/16.
 *
 * Contains the list of categories. Each category holds the Title of the category and the url
 *
 */
public class CategoriesList implements Serializable{
    private ArrayList<Category> mCategoryArrayList;

    // Constructor
    public CategoriesList() {
        mCategoryArrayList = new ArrayList<Category>();
        initializeRssEntries();
    }

    // Adds entries to the list with the names and url
    private void initializeRssEntries() {
        mCategoryArrayList.add(new Category("Songs", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml"));
        mCategoryArrayList.add(new Category("Albums", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topalbums/limit=10/xml"));
        mCategoryArrayList.add(new Category("New Releases", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/newreleases/limit=10/rss.xml"));
        mCategoryArrayList.add(new Category("Just Added", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/justadded/limit=10/rss.xml"));
        mCategoryArrayList.add(new Category("Featured Albums", "http://ax.itunes.apple.com/WebObjects/MZStore.woa/wpa/MRSS/featuredalbums/limit=10/rss.xml"));
        mCategoryArrayList.add(new Category("Music Videos", "https://itunes.apple.com/us/rss/topmusicvideos/limit=10/xml"));
        mCategoryArrayList.add(new Category("iOS Paid Apps", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=10/xml"));
        mCategoryArrayList.add(new Category("iOS Free Apps", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"));
        mCategoryArrayList.add(new Category("Mac Paid Apps", "https://itunes.apple.com/us/rss/toppaidmacapps/limit=10/xml"));
        mCategoryArrayList.add(new Category("Mac Free Apps", "https://itunes.apple.com/us/rss/topfreemacapps/limit=10/xml"));
        mCategoryArrayList.add(new Category("Movies", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topMovies/limit=10/xml"));
        mCategoryArrayList.add(new Category("Video Rentals", "https://itunes.apple.com/us/rss/topvideorentals/limit=10/genre=4401/xml"));
        mCategoryArrayList.add(new Category("TV Seasons", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topTvSeasons/limit=10/xml"));
        mCategoryArrayList.add(new Category("TV Episodes", "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topTvEpisodes/limit=10/xml"));
        mCategoryArrayList.add(new Category("iTunesU Collections", "https://itunes.apple.com/us/rss/topitunesucollections/limit=10/xml"));
        mCategoryArrayList.add(new Category("iTunesU Courses", "https://itunes.apple.com/us/rss/topitunesucourses/limit=10/xml"));
        mCategoryArrayList.add(new Category("Paid Books", "https://itunes.apple.com/us/rss/toppaidebooks/limit=10/xml"));
        mCategoryArrayList.add(new Category("Free Books", "https://itunes.apple.com/us/rss/topfreeebooks/limit=10/xml"));
        mCategoryArrayList.add(new Category("Audiobooks", "https://itunes.apple.com/us/rss/topaudiobooks/limit=10/xml"));
        mCategoryArrayList.add(new Category("Podcasts", "https://itunes.apple.com/us/rss/toppodcasts/limit=10/xml"));
    }

    // Returns the list of the
    public ArrayList<Category>getCategoryEntries() {
        return mCategoryArrayList;
    }
}