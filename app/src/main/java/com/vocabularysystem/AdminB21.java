package com.vocabularysystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class AdminB21 extends AppCompatActivity {

    private DatabaseHandlers mDBHelper;
    private SQLiteDatabase mDb;
    Cursor c = null;
    Cursor c1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminb21);
        stack();


    }

    public void stack() {
        final EditText tx1 = (EditText) findViewById(R.id.tof1);
        final RadioGroup tx2 = (RadioGroup) findViewById(R.id.tof2);
        Button tx3 = (Button) findViewById(R.id.idn3);
        final TextView tx4 = (TextView) findViewById(R.id.idntxt);

        tx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandlers myDbHelper = new DatabaseHandlers(AdminB21.this);
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

                c = myDbHelper.quester1();
                DataHandlers xx = new DataHandlers();
                String x1 = xx.getSubject().substring(0, 3);
                String x2 = xx.getDificulty().substring(0, 3);
                int x3 = c.getCount() + 1;
                int set4 = tx2.getCheckedRadioButtonId();

                if (tx1.getText().length() != 0) {
                    if (set4 != -1) {
                        RadioButton selectedRadioButton = (RadioButton) findViewById(set4);
                        String x4 = x1 + x2 + x3;
                        String x5 = xx.getSubject();
                        String x6 = tx1.getText().toString();
                        String x7 = selectedRadioButton.getText().toString();
                        Toast.makeText(getApplicationContext(), x4 + x5 + x6 + x7, Toast.LENGTH_SHORT).show();
                        String[] boxs = {x4, x5, x6, x7};
                        c1 = myDbHelper.quester2(boxs);
                        startActivity(new Intent(AdminB21.this, AdminB24.class));

                    } else {
                        Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Empty Question field.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
