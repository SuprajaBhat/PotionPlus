package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstPage extends AppCompatActivity {

    Animation topAnim,bottomAnim;
    ImageView img;
    TextView logo,slogan;

    private static int SPLASH_SCREEN=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_page);


        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img=findViewById(R.id.imageView2);
        logo=findViewById(R.id.textView4);
        slogan=findViewById(R.id.textView13);

        img.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent=new Intent(FirstPage.this,signup_activity.class);
startActivity(intent);
finish();
    }
},SPLASH_SCREEN);

    }
}