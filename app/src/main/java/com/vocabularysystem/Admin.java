package com.vocabularysystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class Admin extends AppCompatActivity {

    private DatabaseHandlers mDBHelper;
    private SQLiteDatabase mDb;
    Cursor c = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        logss1();

    }

    public void logss1() {
        Button logn = (Button) findViewById(R.id.adm1);
        final EditText ed1 = (EditText) findViewById(R.id.unm1);
        final EditText ed2 = (EditText) findViewById(R.id.pwdn1);
        final TextView ed3 = (TextView) findViewById(R.id.adminset);

        logn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHandlers myDbHelper = new DatabaseHandlers(Admin.this);
                try {
                    myDbHelper.createDataBase();
                } catch (IOException ioe) {
                    throw new Error("Unable to create database");
                }
                try {
                    myDbHelper.openDataBase();
                } catch (SQLException sqle) {
                    throw sqle;
                }

                c = myDbHelper.hexing(ed1.getText().toString(), ed2.getText().toString());
                if (c.moveToFirst()) {

                    DataHandlers ads1 = new DataHandlers();
                    ed3.setTextColor(Color.BLACK);
                    do {
                        ads1.setAdmis(c.getString(1));
                    } while (c.moveToNext());

                    startActivity(new Intent(Admin.this, AdminA.class));
                } else {
                    ed3.setText("Account Invalid");
                    ed3.setTextColor(Color.RED);
                }
            }
        });

    }
}
