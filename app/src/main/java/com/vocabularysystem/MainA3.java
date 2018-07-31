package com.vocabularysystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainA3 extends AppCompatActivity {
    Cursor c = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina3);

        TextView score1 = findViewById(R.id.score1);
        TextView score2 = findViewById(R.id.score2);
        final EditText scname = findViewById(R.id.scname);
        final Button savescore = findViewById(R.id.score3);
        final DatabaseHandlers data1 = new DatabaseHandlers(MainA3.this);
        final DataHandlers data2 = new DataHandlers();


        final Integer cc1;

        switch (data2.getDificulty().toString()){
            case "Easy":
                cc1 = 5;
                break;
            case "Normal":
                cc1 = 10;
                break;
            case "Hard":
                cc1 = 15;
                break;
            default:
                cc1 = 5;
                break;
        }


        try {
            data1.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            data1.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }


        score1.setText(data2.getStat5().toString());
        score2.setText(cc1.toString());

        savescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(scname.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter a Name", Toast.LENGTH_SHORT).show();
                }else{

                    AlertDialog alertDialog = new AlertDialog.Builder(MainA3.this).create();
                    alertDialog.setTitle("Score");
                    alertDialog.setMessage("Are you sure that you want to save this score?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    c = data1.scorer(scname.getText().toString());
                                    Toast.makeText(getApplicationContext(), "Score Saved", Toast.LENGTH_SHORT).show();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    alertDialog.show();
                }

            }
        });
        endall();
    }

    public void endall(){

        Button byes = (Button) findViewById(R.id.endss1);

        byes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AudioPlayer.stopAudio();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}
