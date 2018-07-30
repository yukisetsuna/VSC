package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainA3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maina3);

        TextView score1 = findViewById(R.id.score1);
        TextView score2 = findViewById(R.id.score2);

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

        score1.setText(data2.getStat5().toString());
        score2.setText(cc1.toString());


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
