package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class covid_assistant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_assistant);
       // getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        ImageView b1=findViewById(R.id.guidevaccine);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/JXlr21jv32Q")));
            }
        });



        ImageView b2=findViewById(R.id.guidemask);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/iQwHKgzTSJM")));
            }
        });

        ImageView b3=findViewById(R.id.guidemask);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/mmmenqIGxUE")));
            }
        });

        ImageView b4=findViewById(R.id.princyoga);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/aJb1AWMc-64")));
            }
        });


        ImageView b5=findViewById(R.id.princpranayama);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/qSYJePpP7Uw")));
            }
        });


        ImageView b6=findViewById(R.id.princayu);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/L-o08wcV2cI")));
            }
        });


        ImageView b7=findViewById(R.id.mythMaget);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("//https://youtu.be/AIduxSySCWU")));
            }
        });





    }
}