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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainA2 extends AppCompatActivity {

    Cursor c = null;
    Cursor xc = null;
    Cursor zc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina2);
        quiz1();
    }

    public void quiz1(){
        final TextView set4 = (TextView) findViewById(R.id.ques1);
        final Button go1 = (Button) findViewById(R.id.exxb);
        final Button go2 = (Button) findViewById(R.id.exxn);
        final Button go3 = (Button) findViewById(R.id.exxe);
        final DataHandlers dsx1 = new DataHandlers();
        final RadioGroup sets3 = (RadioGroup) findViewById(R.id.sets);
        final TextView test1 = (TextView) findViewById(R.id.ansTest);
        final RadioButton seta = (RadioButton) findViewById(R.id.seta);
        final RadioButton setb = (RadioButton) findViewById(R.id.setb);
        final RadioButton setc = (RadioButton) findViewById(R.id.setc);
        final RadioButton setd = (RadioButton) findViewById(R.id.setd);
        final RadioGroup setss3 = (RadioGroup) findViewById(R.id.sets2);
        final RadioButton setsa = (RadioButton) findViewById(R.id.set2a);
        final RadioButton setsb = (RadioButton) findViewById(R.id.set2b);
        final EditText setsss3 = (EditText) findViewById(R.id.sets3);
        dsx1.setStat1(1);
        dsx1.setStat2(0);
        go3.setVisibility(View.GONE);
        go3.setEnabled(false);

        final DatabaseHandlers myDbHelper = new DatabaseHandlers(MainA2.this);
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

        final Integer cc1;



        switch (dsx1.getDificulty().toString()){
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


        final Integer c1 = dsx1.getStat1();

        c = myDbHelper.quester3_1(cc1);
        xc = myDbHelper.quester3_2(cc1);
        zc = myDbHelper.quester3_3(cc1);

        if (c.moveToFirst()) {

             if (c.moveToPosition(c1-1)) {

                 setss3.setVisibility(View.GONE);
                 setsss3.setVisibility(View.GONE);

                 set4.setText(c1.toString()+". "+c.getString(3));
                 seta.setText(c.getString(4));
                 setb.setText(c.getString(5));
                 setc.setText(c.getString(6));
                 setd.setText(c.getString(7));
             }

        } else {
            set4.setText("Database Not Connected");
        }

        RelativeLayout rlset;
        switch (dsx1.getSubject()) {
            case "Science":
                rlset = (RelativeLayout) findViewById(R.id.que_1);
                rlset.setBackgroundResource(R.drawable.sci2);
                break;
            case "English":
                rlset = (RelativeLayout) findViewById(R.id.que_1);
                rlset.setBackgroundResource(R.drawable.eng2);
                break;
            case "History":
                rlset = (RelativeLayout) findViewById(R.id.que_1);
                rlset.setBackgroundResource(R.drawable.hist2);
        }


        if(dsx1.getStat1()==1){
            go1.setEnabled(false);
        }
        else{
            go1.setEnabled(true);
        }

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets3.clearCheck();

                Integer x1 = 0;

                switch (dsx1.getDificulty().toString()){
                    case "Easy":
                        x1 = 5;
                        break;
                    case "Normal":
                        x1 = 10;
                        break;
                    case "Hard":
                        x1 = 15;
                        break;
                        default:
                            x1 = 5;
                            break;
                }



                Integer xx = dsx1.getStat1()-1;
                Integer yy = dsx1.getStat1()/x1;

                if(xx==(x1*3)){
                    go2.setVisibility(View.GONE);
                    go2.setEnabled(false);
                    go3.setVisibility(View.VISIBLE);
                    go3.setEnabled(true);

                }else{

                    go3.setVisibility(View.GONE);
                    go3.setEnabled(false);
                    go2.setVisibility(View.VISIBLE);
                    go2.setEnabled(true);
                }

                if(xx<(1+x1)) {
                    sets3.setVisibility(View.VISIBLE);
                    setss3.setVisibility(View.GONE);
                    setsss3.setVisibility(View.GONE);

                    int sets4 = sets3.getCheckedRadioButtonId();
                    if (sets4 != -1) {
                        RadioButton selectedRadioButton = (RadioButton) findViewById(sets4);
                        String sets5 = selectedRadioButton.getText().toString();
                        test1.setText(sets5);

                    } else {
                        test1.setText("Nothing Selected");

                    }

                    if (c.moveToFirst()) {

                        if (c.moveToPosition(xx - 1)) {


                            set4.setText(xx.toString() + ". " + c.getString(3));
                            seta.setText(c.getString(4));
                            setb.setText(c.getString(5));
                            setc.setText(c.getString(6));
                            setd.setText(c.getString(7));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }
                }else if(xx>=(1+x1)&&xx<(1+(x1*2))){

                    sets3.setVisibility(View.GONE);
                    setss3.setVisibility(View.VISIBLE);
                    setsss3.setVisibility(View.GONE);

                    if (xc.moveToFirst()) {
                        int xx2 = xx -(1+x1);

                        if (xc.moveToPosition(xx2)) {


                            set4.setText(xx.toString() + ". " + xc.getString(3));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }
                }else{
                    sets3.setVisibility(View.GONE);
                    setss3.setVisibility(View.GONE);
                    setsss3.setVisibility(View.VISIBLE);
                    if (zc.moveToFirst()) {
                        int xx2 = xx -(1+(x1*2));

                        if (zc.moveToPosition(xx2)) {


                            set4.setText(xx.toString() + ". " + zc.getString(3));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }

                }



                dsx1.setStat1(xx);

                if(dsx1.getStat1()==1){
                    go1.setEnabled(false);
                }
                else{
                    go1.setEnabled(true);
                }
                if(dsx1.getStat1()==(x1*3)){
                    go2.setEnabled(false);
                }
                else{
                    go2.setEnabled(true);
                }


                dsx1.setStat2(yy);

            }
        });

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                sets3.clearCheck();

                Integer x1 = 0;
                switch (dsx1.getDificulty().toString()){
                    case "Easy":
                        x1 = 5;
                        break;
                    case "Normal":
                        x1 = 10;
                        break;
                    case "Hard":
                        x1 = 15;
                        break;
                    default:
                        x1 = 5;
                        break;
                }

                Integer xx = dsx1.getStat1()+1;
                Integer yy = dsx1.getStat1()/x1;

                if(xx==(x1*3)){
                    go2.setVisibility(View.GONE);
                    go2.setEnabled(false);
                    go3.setVisibility(View.VISIBLE);
                    go3.setEnabled(true);

                }else{

                    go3.setVisibility(View.GONE);
                    go3.setEnabled(false);
                    go2.setVisibility(View.VISIBLE);
                    go2.setEnabled(true);
                }


                if(xx<(1+x1)) {
                    sets3.setVisibility(View.VISIBLE);
                    setss3.setVisibility(View.GONE);
                    setsss3.setVisibility(View.GONE);

                    int sets4 = sets3.getCheckedRadioButtonId();
                    if (sets4 != -1) {
                        RadioButton selectedRadioButton = (RadioButton) findViewById(sets4);
                        String sets5 = selectedRadioButton.getText().toString();
                        test1.setText(sets5);

                    } else {
                        test1.setText("Nothing Selected");

                    }

                    if (c.moveToFirst()) {

                        if (c.moveToPosition(xx - 1)) {


                            set4.setText(xx.toString() + ". " + c.getString(3));
                            seta.setText(c.getString(4));
                            setb.setText(c.getString(5));
                            setc.setText(c.getString(6));
                            setd.setText(c.getString(7));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }
                }else if(xx>=(1+x1)&&xx<(1+(x1*2))){

                    sets3.setVisibility(View.GONE);
                    setss3.setVisibility(View.VISIBLE);
                    setsss3.setVisibility(View.GONE);

                    if (xc.moveToFirst()) {
                        int xx2 = xx -(1+x1);

                        if (xc.moveToPosition(xx2)) {


                            set4.setText(xx.toString() + ". " + xc.getString(3));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }
                }else{
                    sets3.setVisibility(View.GONE);
                    setss3.setVisibility(View.GONE);
                    setsss3.setVisibility(View.VISIBLE);
                    if (zc.moveToFirst()) {
                        int xx2 = xx -(1+(x1*2));

                        if (zc.moveToPosition(xx2)) {


                            set4.setText(xx.toString() + ". " + zc.getString(3));
                        }

                    } else {
                        set4.setText("Database Not Connected");
                    }

                }


                dsx1.setStat1(xx);

                if(dsx1.getStat1()==1){
                    go1.setEnabled(false);
                }
                else{
                    go1.setEnabled(true);
                }
                if(dsx1.getStat1()==(x1*3)){
                    go2.setEnabled(false);
                }
                else{
                    go2.setEnabled(true);
                }
                dsx1.setStat2(yy);

            }
        });

        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ends1 = new AlertDialog.Builder(MainA2.this)
                        .setTitle("Finish")
                        .setMessage("Do You Really Want to End This Exam?")
                        .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "You Have Finished The Exam.", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(MainA2.this, MainA3.class));
                            }
                        })
                        .setNegativeButton(R.string.ends, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                            }
                        });

                ends1.create();
                ends1.show();

            }
        });
    }

    @Override
    public void onBackPressed() {

        return;
    }
}
