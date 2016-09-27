package com.jamesvuong.booklisting;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
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

    public Book (JSONObject object) {
        try {
            JSONObject volumeInfo = object.getJSONObject("volumeInfo");

            this.mTitle = volumeInfo.getString("title");
            this.mSubtitle = volumeInfo.getString("subtitle");
            this.mAuthors = new ArrayList<String>();

            JSONArray jsonArrayAuthors = volumeInfo.getJSONArray("authors");
            if (jsonArrayAuthors != null) {
                for (int i=0;i<jsonArrayAuthors.length();i++){
                    mAuthors.add(jsonArrayAuthors.get(i).toString());
                }
            }

            this.mPublishedDate = volumeInfo.getString("publishedDate");
            this.mDescription = volumeInfo.getString("description");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTitle() { return mTitle; }
    public String getSubtitle() { return mSubtitle; }
    public String getPublishedDate() { return mPublishedDate; }

    // Factory method to convert an array of JSON objects into a list of objects
    public static ArrayList<Book> fromJson(JSONArray jsonObjects) {
        ArrayList<Book> users = new ArrayList<Book>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                users.add(new Book(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
