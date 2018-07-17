package com.example.shivrana.shivrana_comp304_assingment03;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FrameAnimation extends AppCompatActivity {
    Button start,stop;
    ImageView imageView;
    AnimationDrawable animationDrawable;
    int duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        declaration();
        ButtonListeners();

    }

    public void drawImage(){
        BitmapDrawable frame1 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame1));
        BitmapDrawable frame2 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame2));
        BitmapDrawable frame3 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame3));
        BitmapDrawable frame4 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame4));
        BitmapDrawable frame5 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame5));
        BitmapDrawable frame6 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame6));
        BitmapDrawable frame7 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame7));
        BitmapDrawable frame8 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame8));
        BitmapDrawable frame9 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame9));
        BitmapDrawable frame10 = ((BitmapDrawable) getResources().getDrawable(R.drawable.frame10));

        animationDrawable = new AnimationDrawable();
        duration = 120;
        animationDrawable.setOneShot(false);

        animationDrawable.addFrame(frame1,duration);
        animationDrawable.addFrame(frame2,duration);
        animationDrawable.addFrame(frame3,duration);
        animationDrawable.addFrame(frame4,duration);
        animationDrawable.addFrame(frame5,duration);
        animationDrawable.addFrame(frame6,duration);
        animationDrawable.addFrame(frame7,duration);
        animationDrawable.addFrame(frame8,duration);
        animationDrawable.addFrame(frame9,duration);
        animationDrawable.addFrame(frame10,duration);

        imageView.setImageDrawable(animationDrawable);

        animationDrawable.setVisible(true,true);
        animationDrawable.start();

    }

    public void declaration(){
        start = findViewById(R.id.Start);
        stop = findViewById(R.id.Stop);
        imageView = findViewById(R.id.FrameImageView);

    }

    public void ButtonListeners(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawImage();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animationDrawable == null || animationDrawable.isRunning() != true){
                    Toast.makeText(FrameAnimation.this, "Please Click Start to Play", Toast.LENGTH_SHORT).show();
                }
                else{
                    animationDrawable.stop();
                    animationDrawable.setVisible(false,false);
                }
            }
        });
    }
}
