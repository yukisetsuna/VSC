package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainb);

        opsset();
        opsset2();
        opsset3();
        opsset4();
        opsset5();
    }

    public void opsset() {
        final Button opsset1 = (Button) findViewById(R.id.opt1);
        final String hacks = opsset1.getText().toString();


        opsset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (opsset1.getText().toString() == "Off") {
                    opsset1.setText("On");
                    AudioPlayer.stopAudio();
                } else {
                    opsset1.setText("Off");
                    AudioPlayer.playAudio(MainB.this, R.raw.hit3);
                }

            }
        });

        if (opsset1.getText().toString() == "Off") {
            opsset1.setText("On");
        } else {
            opsset1.setText("Off");
            AudioPlayer.stopAudio();
            AudioPlayer.playAudio(MainB.this, R.raw.hit3);
        }


    }

    public void opsset2() {
        Button btn2 = (Button) findViewById(R.id.opt2);

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(new Intent(MainB.this, MainC.class));
                                    }
                                }
        );
    }

    public void opsset3() {
        Button btn2 = (Button) findViewById(R.id.opt3);

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                       startActivity(new Intent(MainB.this, Admin.class));
                                    }
                                }
        );
    }

    public void opsset4() {
        Button btn2 = (Button) findViewById(R.id.rets);

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        finish();
                                    }
                                }
        );
    }

    public void opsset5() {
        Button btn2 = (Button) findViewById(R.id.bouts);

        btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startActivity(new Intent(MainB.this, MainD.class));
                                    }
                                }
        );
    }
}
