package com.example.admin.w5d1twoappcontentprovider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity {
    EditText etFName, etLName, etEmail, etColor, etBlood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etFName = (EditText) findViewById(R.id.etFirst);
        etLName = (EditText) findViewById(R.id.etLast);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etColor = (EditText) findViewById(R.id.etColor);
        etBlood = (EditText) findViewById(R.id.etBType);
    }

    public void createNewUser(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getBaseContext());
        long saved = databaseHelper.saveContact(etFName.getText().toString(), etLName.getText().toString(),
                etEmail.getText().toString(), etColor.getText().toString(), etBlood.getText().toString());
        Toast.makeText(this, "DATA SAVED " + saved, Toast.LENGTH_SHORT).show();
    }
}
