package com.example.signuplab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RegForm extends AppCompatActivity {
    Spinner sp;
    boolean invalid = false;
    String Colector="";
    TextView txtalertName;
    EditText UserName,dob,age,weight,height,bg,MajorIssue;
    Button SubmitSave;
    RadioButton Malebtn,Femalbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);
        age=findViewById(R.id.age);
        UserName=findViewById(R.id.userName);
        bg=findViewById(R.id.bg);
        weight=findViewById(R.id.weight);
        height=findViewById(R.id.height);
        dob=findViewById(R.id.Dob);

        Malebtn =findViewById(R.id.Male);
        Femalbtn=findViewById(R.id.Female);
        MajorIssue=findViewById(R.id.majorissue);
        SubmitSave=findViewById(R.id.btnsubmit);


        //getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(Malebtn.isChecked()) {
            Femalbtn.setEnabled(false);

        }



        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String Dob=dob.getText().toString();
                String Age=age.getText().toString();
                String Height=height.getText().toString();
                String Weight=weight.getText().toString();
                String Bg=bg.getText().toString();
                boolean M= Malebtn.isPressed();
                boolean F= Femalbtn.isPressed();
                String symptopms=MajorIssue.getText().toString();
                if (name.isEmpty()){Toast.makeText(RegForm.this,"Pleas fill the Contact field",Toast.LENGTH_SHORT).show();
                Toast.makeText(RegForm.this,"Pleas fill the password field",Toast.LENGTH_SHORT).show();
                }





                else if (Age.isEmpty()){
                    Toast.makeText(RegForm.this,"Pleas fill the age field",Toast.LENGTH_SHORT).show();
                }

                else if (Weight.isEmpty()){
                    Toast.makeText(RegForm.this,"Pleas fill the weight field",Toast.LENGTH_SHORT).show();
                }
                else if (Height.isEmpty()){
                    Toast.makeText(RegForm.this,"Pleas fill the height field",Toast.LENGTH_SHORT).show();
                }

                else if (Bg.isEmpty()){
                    Toast.makeText(RegForm.this,"Pleas fill the Comment field",Toast.LENGTH_SHORT).show();
                }
                else if (Dob.isEmpty()){
                    Toast.makeText(RegForm.this,"Pleas fill the DateofBirth field",Toast.LENGTH_SHORT).show();
                }
                //else if(!M && !F){
                  //  Toast.makeText(RegForm.this,"Pleas fill the Gender field",Toast.LENGTH_SHORT).show();
                //}





                else{

                    Colector+=name+"\n";
                    //  Colector+=Pascode+"\n";
                    Colector+=Age+"\n";
                    Colector+=Dob+"\n";
                    Colector+=Weight+"\n";
                    Colector+=Height+"\n";
                    Colector+=Bg+"\n";

                    //else{
                      //  Colector += "Female\n";
                   // }
                    Toast.makeText(RegForm.this,"User Info \n:"+Colector,Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(RegForm.this,welcome_activity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("symptopms",symptopms);
                    startActivity(intent);
                }

            }
        });



    }
}