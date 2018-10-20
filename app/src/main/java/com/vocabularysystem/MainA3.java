package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainA3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina3);
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
