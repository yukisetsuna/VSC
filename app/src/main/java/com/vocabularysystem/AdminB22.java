package com.vocabularysystem;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class AdminB22 extends AppCompatActivity {
    private EditText hex1;
    private EditText hex2;
    private EditText hex3;
    private EditText hex4;
    private Button hex6;
    private TextView hex7;

    private DatabaseHandlers mDBHelper;
    private SQLiteDatabase mDb;
    Cursor c = null;
    Cursor c1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminb22);
        stacks();
    }

    public void stacks() {

        hex1 = (EditText) findViewById(R.id.mc1);
        hex2 = (EditText) findViewById(R.id.idn2);
        hex3 = (EditText) findViewById(R.id.mc21);
        hex4 = (EditText) findViewById(R.id.idn22);
        hex6 = (Button) findViewById(R.id.idn3);
        hex7 = (TextView) findViewById(R.id.idntxt);

        hex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHandlers myDbHelper = new DatabaseHandlers(AdminB22.this);
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

                if (hex1.getText().length() == 0 ||
                        hex2.getText().length() == 0 ||
                        hex3.getText().length() == 0 ||
                        hex4.getText().length() == 0) {

                    Toast.makeText(getApplicationContext(), "missing data on one of the fields.", Toast.LENGTH_SHORT).show();

                } else {

                    c = myDbHelper.quester1();
                    int x3 = c.getCount() + 1;
                    DataHandlers xx = new DataHandlers();
                    String x1 = xx.getSubject().substring(0, 3);
                    String x2 = xx.getDificulty().substring(0, 3);


                }
            }
        });

    }
}
