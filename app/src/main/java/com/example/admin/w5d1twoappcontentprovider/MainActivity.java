package com.example.admin.w5d1twoappcontentprovider;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DatabaseHelper databaseHelper = new DatabaseHelper(this);

        Uri uri = Uri.parse("content://com.example.admin.w5d1twoappcontentprovider.contentprovider." +
                "DatabaseContentProvider/Contacts");

        Cursor cursor = getContentResolver().query(uri,null,null,null,null);

        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("email"));
            Log.d("TAG", "TECH: " + name);
        }

    }

    public void createNewUser(View view) {
        Intent intent = new Intent(this, CreateUserActivity.class);
        startActivity(intent);
    }
}
