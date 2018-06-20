package com.vocabularysystem;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        opts1();
        opts2();
        opts3();
        AudioPlayer.playAudio(Splash.this, R.raw.hit2);
    }

     public void opts1() {
         Button btn1 = (Button) findViewById(R.id.playgo);

         btn1.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {

                                         startActivity(new Intent(Splash.this, MainA.class));
                                     }
                                 }
         );
     }



     public void opts2() {
         Button btn2 = (Button) findViewById(R.id.optgo);

         btn2.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         startActivity(new Intent(Splash.this, MainB.class));
                                     }
                                 }
         );
     }

     public void opts3() {
         Button btn3 = (Button) findViewById(R.id.endgo);

         btn3.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         finish();
                                     }
                                 }
         );
     }

    @Override
    protected void onDestroy() {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }


}
