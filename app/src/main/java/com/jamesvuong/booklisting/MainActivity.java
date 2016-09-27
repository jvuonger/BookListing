package com.jamesvuong.booklisting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /** Tag for the log messages */
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    /** URL to query the Google Books API */
    private static final String GOOGLE_BOOKS_REQUEST_URL =
            "https://www.googleapis.com/books/v1/volumes"; //?q=ios&maxResults=10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("Testing"));
        bookList.add(new Book("Testing 2"));
        bookList.add(new Book("Testing 3"));
        bookList.add(new Book("Testing 4"));
        bookList.add(new Book("Testing 5"));
        bookList.add(new Book("Testing 6"));

        BookAdapter adapter = new BookAdapter(this, bookList);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
