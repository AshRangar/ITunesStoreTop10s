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

    public boolean process() {
        boolean status = true;
        ITunesEntry currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);

            XmlPullParser xpp = xmlPullParserFactory.newPullParser();
            xpp.setInput(new StringReader(mXmlData));

            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        Log.d(TAG, "Starting tag for " + tagName);

                        if (tagName.equalsIgnoreCase("entry") || tagName.equalsIgnoreCase("item")) {
                            inEntry = true;
                            currentRecord = new ITunesEntry();
                        }

                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        Log.d(TAG, "Ending tag for " + tagName);

                        if (inEntry) {
                            if (tagName.equalsIgnoreCase("entry") || tagName.equalsIgnoreCase("item")) {
                                Log.d(TAG, "HEREEEEE! in item");
                                mITunesEntries.add(currentRecord);
                                inEntry = false;
                            } else if (tagName.equalsIgnoreCase("name") || tagName.equalsIgnoreCase("title")) {
                                Log.d(TAG, "HEREEEEE! in title");
                                currentRecord.setName(textValue);
                            } else if (tagName.equalsIgnoreCase("artist")) {
                                currentRecord.setArtist(textValue);
                            } else if (tagName.equalsIgnoreCase("releaseDate")) {
                                currentRecord.setReleaseDate(textValue);
                            }
                        }

                        break;
                }

                eventType = xpp.next();
            }
        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        return true;
    }

}
