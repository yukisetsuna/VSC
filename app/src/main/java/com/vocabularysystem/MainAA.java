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

public class MainAA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainaa);
    }

    public void store() {
        final TextView set1 = findViewById(R.id.xaaa3);
        Button set2 = findViewById(R.id.xaaa1);
        final RadioGroup set3 = findViewById(R.id.xaaa2);
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Testing", Toast.LENGTH_SHORT).show();

                int set4 = set3.getCheckedRadioButtonId();
                if (set4 != -1) {
                    RadioButton selectedRadioButton = findViewById(set4);
                    String set5 = selectedRadioButton.getText().toString();
                    Toast.makeText(getApplicationContext(), set5, Toast.LENGTH_SHORT).show();
                    switch (set5){
                        case "Can You Identify Me?":
                            Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();
                            break;
                        case "Is it Ture or is it False?":
                            Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();
                            break;
                        case "How Strong is Your Vocabulary?":
                            Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();
                            break;
                    }
//
//                    DataHandlers data = new DataHandlers();
//                    data.setSubject(set5);
//                    set1.setText(data.getSubject());
//                    startActivity(new Intent(MainAA.this, MainA1.class));
                } else {

                    Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
