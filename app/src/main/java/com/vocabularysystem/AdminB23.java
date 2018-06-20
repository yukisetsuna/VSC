package com.vocabularysystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class AdminB23 extends AppCompatActivity {

    private DatabaseHandlers mDBHelper;
    private SQLiteDatabase mDb;
    Cursor c = null;
    Cursor c1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminb23);

        stack();
    }

    public void stack() {
        EditText s1 = (EditText) findViewById(R.id.mc1);
        EditText s2 = (EditText) findViewById(R.id.mc2);
        EditText s3 = (EditText) findViewById(R.id.mc21);
        EditText s4 = (EditText) findViewById(R.id.mc22);
        EditText s5 = (EditText) findViewById(R.id.mc23);
        Button s6 = (Button) findViewById(R.id.mc3);


    }
}
