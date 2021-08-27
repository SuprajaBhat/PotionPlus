package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DietPlanner extends AppCompatActivity {
    ImageButton b1;

    int num1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_diet_planner);

       // getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        EditText e1=findViewById(R.id.cal);
        b1=(ImageButton)findViewById(R.id.imageButton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TextView n1=findViewById(R.id.carbo);
                TextView n2=findViewById(R.id.prot);
                TextView n3=findViewById(R.id.fat);
                TextView n4=findViewById(R.id.min);
                TextView n5=findViewById(R.id.vit);
                TextView n6=findViewById(R.id.water);




                int a=Integer.parseInt(e1.getText().toString())*30/100;
                n1.setText("Clarories of Carbohydrates: "+a);

                int b=Integer.parseInt(e1.getText().toString())*34/100;
                n2.setText("Clarories of Protien: "+b);

                int c=Integer.parseInt(e1.getText().toString())*14/100;
                n3.setText("Clarories of Fats: "+c);

                int d=Integer.parseInt(e1.getText().toString())*10/100;
                n4.setText("Clarories of Minerals: "+d);

                int e=Integer.parseInt(e1.getText().toString())*12/100;
                n5.setText("Clarories of Vitamins: "+e);


                n6.setText("3L/Day");









            }
        });


    }
}