package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina);

        store();
    }


    public void store() {
        final TextView set1 = findViewById(R.id.xma3);
        Button set2 = findViewById(R.id.xma1);
        final RadioGroup set3 = findViewById(R.id.xma2);
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int set4 = set3.getCheckedRadioButtonId();
                if (set4 != -1) {
                    RadioButton selectedRadioButton = findViewById(set4);
                    String set5 = selectedRadioButton.getText().toString();
                    DataHandlers data = new DataHandlers();
                    data.setSubject(set5);
                    set1.setText(data.getSubject());
                    startActivity(new Intent(MainA.this, MainA1.class));
                } else {

                    Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
