package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 *
 * Created by ashwin on 1/25/16.
 *
 * Launching Activity
 * Activity to display the list of all the categories.
 * Example: Songs, Albums, Movies, etc
 *
 */
public class CategoriesListActivity extends AppCompatActivity {

    private static final String TAG = CategoriesListActivity.class.getSimpleName().toString();
    private ListView mCategoryListView;
    private CategoriesList mCategoriesList;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        // Map the view to manipulate as java object
        mCategoryListView = (ListView) findViewById(R.id.rssListView);
        mCategoriesList = new CategoriesList();

        // Set the title of the toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.app_name).toUpperCase());

        // Set the custom list adapter to display the list of categories
        mCategoryListView.setAdapter(new CategoryListAdapter(this, mCategoriesList.getCategoryEntries()));

        // Start the Top10Activity when the category is selected
        mCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = mCategoriesList.getCategoryEntries().get(position);

                // Explicit intent
                Intent intent = new Intent(CategoriesListActivity.this, Top10Activity.class);
                intent.putExtra(getString(R.string.category_key), category);
                startActivity(intent);
            }
        });
    }

}
