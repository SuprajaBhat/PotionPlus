package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.Locale;

public class Nutrition extends AppCompatActivity {
    TextToSpeech texttoSpeech;
TextView t,sym;
    Button bt;
//String symptopms=getIntent().getStringExtra("symptopms");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);


       // getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        t=findViewById(R.id.pay);
        sym=findViewById(R.id.sym);
        bt = findViewById(R.id.bt);
/*

        texttoSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    texttoSpeech.setLanguage(Locale.UK);
                }
            }
        });
        */




        bt.setOnClickListener(this::parseJson);

    }

    private void parseJson(View v) {

       String symptopms=getIntent().getStringExtra("symptopms");

            JSONObject pcod;
        JSONObject diabetes;
        JSONObject cold;
        JSONObject covid;
        if(symptopms.toLowerCase().contains("pcod")){
            try {


                InputStream is = getAssets().open("pcod.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                pcod = new JSONObject(new String(buffer, "UTF-8"));

                ((TextView) findViewById(R.id.breakfast)).setText("BREAKFAST: " + pcod.getString("Breakfast"));
                ((TextView) findViewById(R.id.MidMeal)).setText("MidMeal: " + pcod.getString("MidMeal"));
                ((TextView) findViewById(R.id.Lunch)).setText("Lunch: " + pcod.getString("Lunch"));
               ((TextView) findViewById(R.id.Evening)).setText("Evening: " + pcod.getString("Evening"));
                //((TextView) findViewById(R.id.Evening)).setText(symptopms);
                ((TextView) findViewById(R.id.Dinner)).setText("Dinner: " + pcod.getString("Dinner"));
t.setText("It Requires 280 bucks every day!!");
sym.setText("PCOD : ");
                bt.setVisibility(View.GONE);

            } catch (Exception e) {

                e.printStackTrace();
            }



    }
        else if(symptopms.toLowerCase().contains("diabetes")){

            try {


                InputStream is = getAssets().open("diabetes.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                diabetes = new JSONObject(new String(buffer, "UTF-8"));
                bt.setVisibility(View.GONE);
                ((TextView) findViewById(R.id.breakfast)).setText("BREAKFAST: " + diabetes.getString("Breakfast"));
                ((TextView) findViewById(R.id.MidMeal)).setText("MidMeal: " + diabetes.getString("MidMeal"));
                ((TextView) findViewById(R.id.Lunch)).setText("Lunch: " + diabetes.getString("Lunch"));
                ((TextView) findViewById(R.id.Evening)).setText("Evening: " + diabetes.getString("Evening"));
                //((TextView) findViewById(R.id.Evening)).setText(symptopms);
                ((TextView) findViewById(R.id.Dinner)).setText("Dinner: " + diabetes.getString("Dinner"));
sym.setText("DIABETES :");
                t.setText("It Requires 210 bucks every day!!");

            } catch (Exception e) {

                e.printStackTrace();
            }



        }
        else if(symptopms.toLowerCase().contains("covid")){

            try {


                InputStream is = getAssets().open("covid.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                covid = new JSONObject(new String(buffer, "UTF-8"));
                bt.setVisibility(View.GONE);
                ((TextView) findViewById(R.id.breakfast)).setText("BREAKFAST: " + covid.getString("Breakfast"));
                ((TextView) findViewById(R.id.MidMeal)).setText("MidMeal: " + covid.getString("MidMeal"));
                ((TextView) findViewById(R.id.Lunch)).setText("Lunch: " + covid.getString("Lunch"));
                ((TextView) findViewById(R.id.Evening)).setText("Evening: " + covid.getString("Evening"));
                //((TextView) findViewById(R.id.Evening)).setText(symptopms);
                ((TextView) findViewById(R.id.Dinner)).setText("Dinner: " + covid.getString("Dinner"));
                sym.setText("COVID :");
                t.setText("It Requires 190 bucks every day!!");

            } catch (Exception e) {

                e.printStackTrace();
            }



        }
       else if(symptopms.toLowerCase().contains("cold") || symptopms.toLowerCase().contains("fewer")){

            try {


                InputStream is = getAssets().open("cold.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                cold = new JSONObject(new String(buffer, "UTF-8"));
                bt.setVisibility(View.GONE);
                ((TextView) findViewById(R.id.breakfast)).setText("BREAKFAST: " + cold.getString("Breakfast"));
                ((TextView) findViewById(R.id.MidMeal)).setText("MidMeal: " + cold.getString("MidMeal"));
                ((TextView) findViewById(R.id.Lunch)).setText("Lunch: " + cold.getString("Lunch"));
                ((TextView) findViewById(R.id.Evening)).setText("Evening: " + cold.getString("Evening"));
                //((TextView) findViewById(R.id.Evening)).setText(symptopms);
                ((TextView) findViewById(R.id.Dinner)).setText("Dinner: " + cold.getString("Dinner"));
                sym.setText("COLD :");
                t.setText("It Requires 170 bucks every day!!");

            } catch (Exception e) {

                e.printStackTrace();
            }



        }





        //texttoSpeech.speak(((TextView) findViewById(R.id.breakfast)).getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

        //texttoSpeech.speak(((TextView) findViewById(R.id.MidMeal)).getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

    }
}
