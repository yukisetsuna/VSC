package com.vocabularysystem;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class MainA2 extends AppCompatActivity {

    Cursor c = null;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina2);
        quiz1();
    }

    public void quiz1(){

        final DatabaseHandlers data1 = new DatabaseHandlers(MainA2.this);
        final DataHandlers data2 = new DataHandlers();

        final TextView set4 = (TextView) findViewById(R.id.ques1);

//        final Button go1 = (Button) findViewById(R.id.exxb);
        final Button go2 = (Button) findViewById(R.id.exxn);
        final Button go3 = (Button) findViewById(R.id.exxe);

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

        final HashMap<String, String> ax1 = new HashMap<>();
        final HashMap<String, String> ax2 = new HashMap<>();

        final Integer cc1;

        data2.setStat1(1);
        data2.setStat2(0);
        data2.setStat5(0);

        final Integer c1 = data2.getStat1();

        sets3.setVisibility(View.GONE);
        setss3.setVisibility(View.GONE);
        setsss3.setVisibility(View.GONE);

//        go1.setVisibility(View.GONE);
        go2.setVisibility(View.VISIBLE);
        go3.setVisibility(View.GONE);


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

        switch (data2.getTypes()){
            case "True or False":
                c = data1.quester3_2(cc1);
                hex2(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);

                break;
            case "Identification":
                c = data1.quester3_3(cc1);
                hex3(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
                break;
            case "Multiple Choice":
                c = data1.quester3_1(cc1);

                hex1(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
                break;
        }

//        go1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                sets3.clearCheck();
//                setss3.clearCheck();
//                setsss3.setText("");
//
//                Integer xx = data2.getStat1()-1;
//                if(xx!=1)
//                {
//                    go2.setVisibility(View.VISIBLE);
//                    data2.setStat1(xx);
//                }
//                else{
//                    go1.setVisibility(View.GONE);
//                    go2.setVisibility(View.VISIBLE);
//                    go3.setVisibility(View.GONE);
//                }
//                switch (data2.getTypes()){
//                    case "True or False":
//                        c = data1.quester3_2(cc1);
//                        hex2(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
//                        break;
//                    case "Identification":
//                        c = data1.quester3_3(cc1);
//                        hex3(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
//                        break;
//                    case "Multiple Choice":
//                        c = data1.quester3_1(cc1);
//
//                        hex1(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
//                        break;
//                }
//
//            }
//        });

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(go2.getContext(), "The Correct answer is "+data2.getStat4().toString(), Toast.LENGTH_SHORT).show();

                Integer set = data2.getStat5();
                if(data2.getStat3().toString().equals(data2.getStat4().toString())){
                    set = set + 1;
                    data2.setStat5(set);
                    Toast.makeText(go2.getContext(), "Your Score is "+data2.getStat5().toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(go2.getContext(), "Your Score is "+data2.getStat5().toString(), Toast.LENGTH_SHORT).show();
                }



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sets3.clearCheck();
                        setss3.clearCheck();
                        setsss3.setText("");
                        Integer xx = data2.getStat1()+1;
                        if(xx<cc1)
                        {
//                    go1.setVisibility(View.VISIBLE);
                            data2.setStat1(xx);
                        }
                        else{
                            go2.setVisibility(View.GONE);
                            go3.setVisibility(View.VISIBLE);
                        }
                        switch (data2.getTypes()){
                            case "True or False":
                                c = data1.quester3_2(cc1);
                                hex2(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
                                break;
                            case "Identification":
                                c = data1.quester3_3(cc1);
                                hex3(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
                                break;
                            case "Multiple Choice":
                                c = data1.quester3_1(cc1);

                                hex1(c, c1, set4, test1, ax1, ax2, sets3, setss3, setsss3, seta, setb, setc, setd);
                                break;
                        }
                    }
                }, SPLASH_TIME_OUT);

            }
        });

        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(go2.getContext(), "The Correct answer is "+data2.getStat4().toString(), Toast.LENGTH_SHORT).show();

                Integer set = data2.getStat5();
                if(data2.getStat3().toString().equals(data2.getStat4().toString())){
                    set = set + 1;
                    data2.setStat5(set);
                    Toast.makeText(go2.getContext(), "Your Score is "+data2.getStat5().toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(go2.getContext(), "Your Score is "+data2.getStat5().toString(), Toast.LENGTH_SHORT).show();
                }


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent splashout = new Intent(MainA2.this, MainA3.class);
                        startActivity(splashout);
                        finish();
                    }
                }, SPLASH_TIME_OUT);

            }
        });
    }

    public void hex1(Cursor c, Integer c1, TextView set4, final TextView test1, final HashMap<String, String> ax1,
                     HashMap<String, String> ax2, final RadioGroup sets3, RadioGroup setss3, EditText setsss3,
                     RadioButton seta, RadioButton setb, RadioButton setc, RadioButton setd ){
        sets3.setVisibility(View.VISIBLE);
        setss3.setVisibility(View.GONE);
        setsss3.setVisibility(View.GONE);
        if (c.moveToFirst()) {
            if (c.moveToPosition(c1-1)) {
                final DataHandlers data2 = new DataHandlers();
                set4.setText(c.getString(3));
                ArrayList<String> rans = new ArrayList<>();
                rans.add(c.getString(4));
                rans.add(c.getString(5));
                rans.add(c.getString(6));
                rans.add(c.getString(7));
                Collections.shuffle(rans);
                seta.setText(rans.get(0));
                setb.setText(rans.get(1));
                setc.setText(rans.get(2));
                setd.setText(rans.get(3));
                data2.setStat4(c.getString(4));

                sets3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        int sets4 = sets3.getCheckedRadioButtonId();
                        if (sets4 != -1) {
                            RadioButton selectedRadioButton = (RadioButton) findViewById(sets4);
                            String sets5 = selectedRadioButton.getText().toString();
                            data2.setStat3(sets5);
                        } else {
                            data2.setStat3("N/A");

                        }
                    }
                });
                setss3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int sets4 = sets3.getCheckedRadioButtonId();
                        if (sets4 != -1) {
                            RadioButton selectedRadioButton = (RadioButton) findViewById(sets4);
                            String sets5 = selectedRadioButton.getText().toString();
                            data2.setStat3(sets5);
                        } else {
                            data2.setStat3("N/A");

                        }
                    }
                });
                data2.setStat7(ax1);
                data2.setStat8(ax2);
            }
        } else {
            set4.setText("Database Not Connected");
        }
    }
    public void hex2(Cursor c, Integer c1, TextView set4, final TextView test1, final HashMap<String, String> ax1,
                     final HashMap<String, String> ax2, final RadioGroup sets3, final RadioGroup setss3, EditText setsss3,
                     RadioButton seta, RadioButton setb, RadioButton setc, RadioButton setd ){
        sets3.setVisibility(View.GONE);
        setss3.setVisibility(View.VISIBLE);
        setsss3.setVisibility(View.GONE);

        if (c.moveToFirst()) {
            if (c.moveToPosition(c1-1)) {
                final DataHandlers data2 = new DataHandlers();
                set4.setText(c.getString(3));
                data2.setStat4(c.getString(4));

                setss3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        int sets4 = setss3.getCheckedRadioButtonId();
                        if (sets4 != -1) {
                            RadioButton selectedRadioButton = (RadioButton) findViewById(sets4);
                            String sets5 = selectedRadioButton.getText().toString();
                            data2.setStat3(sets5);

                        } else {
                            data2.setStat3("N/A");

                        }
                    }
                });
            }

        } else {
            set4.setText("Database Not Connected");
        }
    }

    public void hex3(Cursor c, Integer c1, TextView set4, final TextView test1, final HashMap<String, String> ax1,
                     final HashMap<String, String> ax2, final RadioGroup sets3, final RadioGroup setss3, final EditText setsss3,
                     RadioButton seta, RadioButton setb, RadioButton setc, RadioButton setd ){

        sets3.setVisibility(View.GONE);
        setss3.setVisibility(View.GONE);
        setsss3.setVisibility(View.VISIBLE);
        if (c.moveToFirst()) {
            if (c.moveToPosition(c1-1)) {

                final DataHandlers data2 = new DataHandlers();
                set4.setText(c.getString(3));
                data2.setStat4(c.getString(4));
                data2.setStat3("N/A");

                TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
                    @Override
                    public void afterTextChanged(Editable s) {
                        data2.setStat3(setsss3.getText().toString());
                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        data2.setStat3("N/A");
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                };
                setsss3.addTextChangedListener(fieldValidatorTextWatcher);

            }

        } else {
            set4.setText("Database Not Connected");
        }
    }

    @Override
    public void onBackPressed() {

        return;
    }
}
