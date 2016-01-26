package com.ashrangar.android.itunesstoretop10s.itunesstoretop10s;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by ashwin on 1/25/16.
 */
public class ITunesEntriesFactory {
    private String mXmlData;
    private ArrayList<ITunesEntry> mITunesEntries;

    private final String TAG = ITunesEntriesFactory.class.getSimpleName().toString();


    public ArrayList<ITunesEntry> getITunesEntries(String xmlData) {
        mITunesEntries = new ArrayList<ITunesEntry>();
        mXmlData = xmlData;
        process();
        return mITunesEntries;
    }
}
