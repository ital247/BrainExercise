package com.example.derick.brainexercise;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;


public class MainActivity extends Activity {

    AnimationDrawable rocketAnimation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView rocketImage;
        rocketImage = (ImageView) findViewById(R.id.rocket_image);
        rocketImage.setBackgroundResource(R.drawable.rocket_thrust);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();



    }

    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();
                  playSound();


            return true;
            }
        return super.onTouchEvent(event);


    }
     private void playSound(){
         final MediaPlayer player = MediaPlayer.create(this, R.raw.audio);
         player.start();
         player.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
             public void onCompletion(MediaPlayer mediaPlayer){
                 mediaPlayer.release();


             }


         });
         getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
     }



}
