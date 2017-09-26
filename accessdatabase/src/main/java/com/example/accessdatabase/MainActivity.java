package com.example.accessdatabase;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTAG";
    RecyclerView rvContacts;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        Uri uri = Uri.parse("content://com.example.admin.w5d1twoappcontentprovider.contentprovider." +
                "DatabaseContentProvider/Contacts");

        ArrayList<Contact> contacts = new ArrayList<>();
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);

        Log.d(TAG, "onCreate: ");
        while (cursor.moveToNext()) {
            try {
                contacts.add(new Contact(cursor.getString(cursor.getColumnIndex("first_name")),
                        cursor.getString(cursor.getColumnIndex("last_name")),
                        cursor.getString(cursor.getColumnIndex("email")),
                        cursor.getString(cursor.getColumnIndex("favorite_color")),
                        cursor.getString(cursor.getColumnIndex("blood_type"))));
                Log.d(TAG, "onCreate: " + cursor.getString(cursor.getColumnIndex("email")));

            } catch (Exception e) {
                Log.d(TAG, "onCreate: " + e.getMessage());
            }
        }

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, this);
        rvContacts.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvContacts.setLayoutManager(layoutManager);
        rvContacts.setItemAnimator(itemAnimator);


        //}

    }
}
