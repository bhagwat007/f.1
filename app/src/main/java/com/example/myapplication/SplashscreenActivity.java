package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

       getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView entity = findViewById(R.id.entity);
        entity.animate().translationX(-1000).setDuration(1500).setStartDelay(2000);

        TextView sports = findViewById(R.id.sports);
        sports.animate().translationX(1000).setDuration(1500).setStartDelay(2000);



        Thread thread =new Thread(){

            public void run(){
                try {
                    Thread.sleep(3100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(SplashscreenActivity.this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        };
        thread.start();
    }
}