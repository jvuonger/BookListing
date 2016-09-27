package com.jamesvuong.booklisting;

import android.content.Context;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jvuonger on 9/27/16.
 */

public class Book {
    private String mTitle;
    private String mSubtitle;
    private ArrayList<String> mAuthors;
    private String mPublishedDate;
    private String mDescription;
    private URL mThumbnail;

    public Book (String title) {
        mTitle = title;
    }

    public String getTitle() { return mTitle; }
}
