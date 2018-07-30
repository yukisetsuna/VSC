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
        store();
    }

    public void store() {
        final TextView set1 = findViewById(R.id.xaaa3);
        Button set2 = findViewById(R.id.xaaa1);
        final RadioGroup set3 = findViewById(R.id.xaaa2);
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int set4 = set3.getCheckedRadioButtonId();
                if (set4 != -1) {
                    RadioButton selectedRadioButton = findViewById(set4);
                    String set5 = selectedRadioButton.getText().toString();
                    String set6 = "";

                    switch (set5){
                        case "Can You Identify Me?":
                            set6 = "Identification";
                            break;
                        case "Is it Ture or is it False?":
                            set6 = "True or False";
                            break;
                        case "How Strong is Your Vocabulary?":
                            set6 = "Multiple Choice";
                            break;
                    }

                   DataHandlers data = new DataHandlers();
                    data.setTypes(set6);
                    set1.setText(data.getTypes());
                    startActivity(new Intent(MainAA.this, MainA1.class));
                } else {

                    Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
