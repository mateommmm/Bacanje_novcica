package com.example.mateo.mikulicmateocoinflip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b,i;
    ImageView iv;
    TextView g,p;
    Random r;

    int strana;
    int glava = 0;
    int pismo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.novcic);
        b = (Button) findViewById(R.id.btnBacaj);
        i = (Button) findViewById(R.id.btnIzlaz);
        g = (TextView) findViewById(R.id.GlavaRez);
        p = (TextView) findViewById(R.id.PismoRez);

        r = new Random();


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strana = r.nextInt(2);


                if(strana == 0)
                {
                    iv.setImageResource(R.drawable.glava);
                    Toast.makeText(MainActivity.this,"GLAVA",Toast.LENGTH_SHORT).show();
                    glava++;

                }
                else
                {
                    iv.setImageResource(R.drawable.pismo);
                    Toast.makeText(MainActivity.this,"PISMO",Toast.LENGTH_SHORT).show();
                    pismo++;
                }

               RotateAnimation rotate = new RotateAnimation(0,360, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
              rotate.setDuration(1000);

                iv.startAnimation(rotate);

                g.setText(Integer.toString(glava));
                p.setText(Integer.toString(pismo));
                }
        });

      i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });



    }
}
