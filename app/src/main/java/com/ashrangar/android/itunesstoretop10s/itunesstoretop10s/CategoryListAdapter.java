package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ashwin on 3/2/16.
 */
public class CategoryListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Category> mCategories;

    // Constructor
    public CategoryListAdapter(Context context, ArrayList<Category> categories) {
        this.mContext = context;
        this.mCategories = categories;
    }

    @Override
    public int getCount() {
        return mCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return mCategories.get(position);
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
            convertView = inflater.inflate(R.layout.category_row, parent, false);

            // ViewHolder() to save the Views
            holder = new ViewHolder();

            // Map the view objects to manipulate as Java objects
            holder.categoryName = (TextView) convertView.findViewById(R.id.categoryName);

            // set the tag to be able to retrieve the holder later
            convertView.setTag(holder);
        } else {
            // Reuse the convertview. Obtain the ViewHolder from Tag
            holder = (ViewHolder) convertView.getTag();
        }

        // Set the name of the category
        holder.categoryName.setText(mCategories.get(position).getTitle().toUpperCase());

        // To make the list rows alternate colors
        if (position % 2 == 1) {
            convertView.setBackgroundColor(Color.LTGRAY);
            holder.categoryName.setTextColor(Color.WHITE);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
            holder.categoryName.setTextColor(Color.BLACK);
        }

        // Return the convertView
        return convertView;
    }

    // ViewHolder object to recycle the views
    private static class ViewHolder {
        public TextView categoryName;
    }

}
