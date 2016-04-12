package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by ashwin on 2/29/16.
 *
 * List Adapter to display the Cover Art, Title and Artist for each ITunesEntry (Example: A Song)
 *
 */
public class Top10ListAdapter extends BaseAdapter {

    ArrayList<ITunesEntry> mITunesEntries;          // List of iTunes Entries to be displayed
    Context mContext;

    // Constructor
    public Top10ListAdapter(Context context, ArrayList<ITunesEntry> iTunesEntries) {
        mContext = context;
        mITunesEntries = iTunesEntries;
    }

    @Override
    public int getCount() {
        return mITunesEntries.size();
    }

    @Override
    public Object getItem(int position) {
        return mITunesEntries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // No convertView is available
        if (convertView == null) {
            // Inflate the layout
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.top10_row, parent, false);

            // ViewHolder() to save the Views
            holder = new ViewHolder();

            // Map the view objects to manipulate as Java objects
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.artist = (TextView) convertView.findViewById(R.id.artist);
            holder.tumbnail = (WebView) convertView.findViewById(R.id.tumbnail);

            // set the tag to be able to retrieve the holder later
            convertView.setTag(holder);
        } else {
            // Reuse the convertview. Obtain the ViewHolder from Tag
            holder = (ViewHolder) convertView.getTag();
        }

        String name = mITunesEntries.get(position).getName();

        // Shrink the text if the length is over 90 characters
        if(name.length() > 90) {
            name = name.substring(0, 90);
        }

        // Set the Title and Artist
        holder.title.setText(name);
        holder.artist.setText(mITunesEntries.get(position).getArtist());

        // Set the WebView to load the CoverArt
        holder.tumbnail.setWebViewClient(new WebViewClient());

        // Load in OverviewMode with zoomed out to fit the width
        holder.tumbnail.getSettings().setLoadWithOverviewMode(true);
        holder.tumbnail.getSettings().setUseWideViewPort(true);

        // Disable the scrollbars
        holder.tumbnail.setVerticalScrollBarEnabled(false);
        holder.tumbnail.setHorizontalScrollBarEnabled(false);

        // Load the URL
        holder.tumbnail.loadUrl(mITunesEntries.get(position).getImageUrl());

        // To make the list rows alternate colors
        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.YELLOW);
        } else {
            convertView.setBackgroundColor(Color.GREEN);
        }

        // Return the convertView
        return convertView;
    }

    // ViewHolder object to recycle the views
    private static class ViewHolder {
        public TextView title;
        public TextView artist;
        public WebView tumbnail;
    }
}
