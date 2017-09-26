package com.example.admin.w5d1twoappcontentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import static android.provider.MediaStore.Images.Thumbnails.IMAGE_ID;

public class DatabaseContentProvider extends ContentProvider {
    private static final String PROVIDER_NAME = "/com.example.admin.w5d1twoappcontentprovide";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/MY_DATABASE");
    private static final int CONTACTS = 1;
    private static final UriMatcher uriMatcher = getUriMatcher();
    private static UriMatcher getUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "contacts", CONTACTS);
        return uriMatcher;
    }

    private DatabaseHelper databaseHelper = null;

    public DatabaseContentProvider() {
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case CONTACTS:
                return "vnd.android.cursor.dir/vnd.com.androidcontentproviderdemo.androidcontentprovider.provider.MY_DATABASE";
        }
        return "";
    }

    @Override
    public boolean onCreate() {
        Context context = getContext();
        databaseHelper = new DatabaseHelper(context);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return databaseHelper.getContacts(projection, selection, selectionArgs, sortOrder);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        try {
            long id = databaseHelper.saveContact(values.getAsString("fname"),
                    values.getAsString("fname"),values.getAsString("fname"),
                    values.getAsString("fname"),values.getAsString("fname"));
            Uri returnUri = ContentUris.withAppendedId(CONTENT_URI, id);
            return returnUri;
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String email = selection;

        return databaseHelper.deleteContact(email);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        return databaseHelper.updateContact(values.getAsString("fname"),
                values.getAsString("fname"),values.getAsString("fname"),
                values.getAsString("fname"),values.getAsString("fname"));
    }
}
