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

public class AdminB1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminb1);
        store();
    }

    public void store() {
        final TextView set1 = (TextView) findViewById(R.id.ext31);
        Button set2 = (Button) findViewById(R.id.nxt3);
        final RadioGroup set3 = (RadioGroup) findViewById(R.id.dif);
        set2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int set4 = set3.getCheckedRadioButtonId();
                if (set4 != -1) {
                    RadioButton selectedRadioButton = (RadioButton) findViewById(set4);
                    String set5 = selectedRadioButton.getText().toString();
                    DataHandlers data = new DataHandlers();
                    data.setDificulty(set5);
                    set1.setText(data.getDificulty());
                    startActivity(new Intent(AdminB1.this, AdminB2.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Nothing selected from Radio Group.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
