package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by ashwin on 2/29/16.
 *
 * Activity to display the iTunes Store page for the selected item
 * Example: Displays the webpage of the ITunes Store (after an item was selected from Top10Activity)
 *
 */
public class WebViewActivity extends AppCompatActivity {

    WebView mWebView;
    String mUrl;
    final String URLTAG = "URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        // Map the View to manipulate as Java object
        mWebView = (WebView) findViewById(R.id.webView);

        // Sets the WebViewClient that will receive various notifications and requests.
        mWebView.setWebViewClient(new WebViewClient());

        // Disable JavaScript
        mWebView.getSettings().setJavaScriptEnabled(false);
        // Enable Zoom
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);

        // Make WebView loads pages in overview mode, that is, zooms out the content to fit on screen by width.
        mWebView.getSettings().setLoadWithOverviewMode(true);
        // Enable support for the "viewport" HTML meta tag
        mWebView.getSettings().setUseWideViewPort(true);

        // Get the extra URL string from the parent intent
        Bundle bundle = getIntent().getExtras();
        mUrl = bundle.getString(URLTAG);

        // Default URL, if no URL string is passed, set the URL
        if(mUrl == null) {
            mUrl = "https://itunes.com";
        }

        // Load the webView
        mWebView.loadUrl(mUrl);
    }
}
