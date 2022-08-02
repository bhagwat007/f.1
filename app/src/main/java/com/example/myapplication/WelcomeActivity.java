package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Thread thread =new Thread(){

            public void run(){
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(WelcomeActivity.this,Main_Activity.class);
                    startActivity(intent);
                    finish();

                }
            }
        };
        thread.start();
    }
    public void onButtonSignUpClicked(View view){

    }
    public void onButtonSignInClicked(View view){

    }
    public void onSkipClicked(View view){
        Intent skip = new Intent(WelcomeActivity.this,Main_Activity.class);
        startActivity(skip);
        finish();

    }
}