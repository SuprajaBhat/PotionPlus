package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class welcome_activity extends AppCompatActivity {
Button b1;
TextView t9;

    Animation l_to_r,r_to_l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        l_to_r= AnimationUtils.loadAnimation(this,R.anim.l_to_r);

        r_to_l=AnimationUtils.loadAnimation(this,R.anim.r_to_l);


t9=findViewById(R.id.welcometext);


     
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        String name=getIntent().getStringExtra("name");

        String symptopms=getIntent().getStringExtra("symptopms");



        TextView uname=findViewById(R.id.welcometext);

        uname.setText("Hello...Welcome !!");

        TextView uname2=findViewById(R.id.welcometext2);
        uname2.setText(name);

t9.setAnimation(l_to_r);
        findViewById(R.id.textView6).setAnimation(l_to_r);
        findViewById(R.id.textView8).setAnimation(l_to_r);
        findViewById(R.id.textView10).setAnimation(l_to_r);

        findViewById(R.id.textView7).setAnimation(r_to_l);
        findViewById(R.id.textView9).setAnimation(r_to_l);
        findViewById(R.id.textView11).setAnimation(r_to_l);
        findViewById(R.id.welcometext2).setAnimation(r_to_l);
//textView7


        findViewById(R.id.textView6).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in=new Intent(welcome_activity.this,DietPlanner.class);
        startActivity(in);

    }
});
        findViewById(R.id.textView7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(welcome_activity.this,Priscription.class);
                startActivity(in);
            }
        });
//textView8

        findViewById(R.id.textView8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(welcome_activity.this,health_tracker.class);
                in.putExtra("symptopms",symptopms);

                startActivity(in);

            }
        });







findViewById(R.id.textView9).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent in=new Intent(welcome_activity.this,Nutrition.class);
        in.putExtra("symptopms",symptopms);
        
        startActivity(in);

    }
});

        findViewById(R.id.textView10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(welcome_activity.this,Reminder.class);
                startActivity(in);

            }
        });
findViewById(R.id.textView11).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent in=new Intent(welcome_activity.this,covid_assistant.class);
        startActivity(in);
    }
});




    }

}