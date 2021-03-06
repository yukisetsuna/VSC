package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainA1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina1); store();
    }

    public void store() {
          final DataHandlers data = new DataHandlers();
        RelativeLayout rlset;

        switch (data.getSubject()){
            case "Science":
                rlset = (RelativeLayout) findViewById(R.id.bcke);
                rlset.setBackgroundResource(R.drawable.sci2);
                break;
            case "English":
                rlset = (RelativeLayout) findViewById(R.id.bcke);
                rlset.setBackgroundResource(R.drawable.eng2);
                break;
            case "History":
                rlset = (RelativeLayout) findViewById(R.id.bcke);
                rlset.setBackgroundResource(R.drawable.hist2);
                break;
        }
        final TextView set1 = (TextView) findViewById(R.id.mad1);
        Button set2 = (Button) findViewById(R.id.ma2);
        final RadioGroup set3 = (RadioGroup) findViewById(R.id.mad2);
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int set4 = set3.getCheckedRadioButtonId();
                if (set4 != -1) {
                    RadioButton selectedRadioButton = (RadioButton) findViewById(set4);
                    String set5 = selectedRadioButton.getText().toString();

                    data.setDificulty(set5);
                    set1.setText(data.getDificulty());
                    startActivity(new Intent(MainA1.this, MainA2.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
