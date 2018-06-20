package com.vocabularysystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AdminA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admina);
        howl();
        move();

    }

    public void howl() {
        Button lout = (Button) findViewById(R.id.lout1);
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataHandlers dtx = new DataHandlers();

                dtx.setAdmis("");
                finish();

            }
        });
    }

    public void creat() {

        LinearLayout hexx = (LinearLayout) findViewById(R.id.hook);


        for (int x = 0; x < 5; x++) {


            Button button = new Button(this);
            button.setText("this" + x);
            hexx.addView(button);


        }

    }

    public void move() {
        Button m1 = (Button) findViewById(R.id.move1);
        Button m2 = (Button) findViewById(R.id.move2);
        Button m3 = (Button) findViewById(R.id.move3);

        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminA.this, AdminB.class));
            }
        });


        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminA.this, AdminC.class));
            }
        });


        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminA.this, AdminD.class));
            }
        });
    }

}
