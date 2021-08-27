package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class signup_activity extends AppCompatActivity {

    Animation l_to_r,r_to_l;
    ImageView img;
    TextView hello,signup;
CheckBox cb;
    private static int SPLASH_SCREEN=5000;
    String username,passward;

   String regex="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//String regex="Sup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);


        l_to_r= AnimationUtils.loadAnimation(this,R.anim.l_to_r);
        r_to_l=AnimationUtils.loadAnimation(this,R.anim.r_to_l);

        img=findViewById(R.id.imageView9);
        hello=findViewById(R.id.hello);
        signup=findViewById(R.id.textView);
cb=findViewById(R.id.checkBox);


        EditText etUsername=findViewById(R.id.suname);
        EditText etPassward=findViewById(R.id.spassward);
        Button buttonsignup=findViewById(R.id.sbutton);
        EditText email=findViewById(R.id.email);
        EditText fname=findViewById(R.id.fname);
        EditText lname=findViewById(R.id.Lastname);
        EditText pn=findViewById(R.id.phnum);




        img.setAnimation(l_to_r);
        hello.setAnimation(l_to_r);
        signup.setAnimation(l_to_r);
        email.setAnimation(l_to_r);
        fname.setAnimation(l_to_r);
        lname.setAnimation(l_to_r);
        pn.setAnimation(l_to_r);


//uname.setAnimation(l_to_r);
       etUsername.setAnimation(l_to_r);
        //pass.setAnimation(l_to_r);
        etPassward.setAnimation(l_to_r);
       // buttonsignup.setAnimation(r_to_l);


        buttonsignup.setOnClickListener(new View.OnClickListener(){
//@Sup441$

            @Override
            public void onClick(View view) {
                username = etUsername.getText().toString();
                passward = etPassward.getText().toString();
                if (username.contentEquals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter user name", Toast.LENGTH_SHORT).show();

                }
                if (passward.contentEquals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter user name", Toast.LENGTH_SHORT).show();

                }
if(cb.isChecked()){
                if (passward.matches(regex)) {
                    Intent intent = new Intent(signup_activity.this, login_activity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("pwd", passward);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Your password doesn't match the validation criteria", Toast.LENGTH_SHORT).show();
                }


            }
else{
    Toast.makeText(getApplicationContext(), "Need to agree terms and conditions", Toast.LENGTH_SHORT).show();
}
            }

        });




    }
}