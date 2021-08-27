package com.example.signuplab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class login_activity extends AppCompatActivity {
    EditText username,passward;
    int count=0;

    Animation l_to_r,r_to_l;
    ImageView img;
    TextView hello,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       // getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        String usrName=getIntent().getStringExtra("username");
        String pwd=getIntent().getStringExtra("pwd");

        Button buttonlogin=findViewById(R.id.lbutton);


        username=findViewById(R.id.luname);
        passward=findViewById(R.id.lpassward);



        l_to_r= AnimationUtils.loadAnimation(this,R.anim.l_to_r);
        r_to_l=AnimationUtils.loadAnimation(this,R.anim.r_to_l);

        img=findViewById(R.id.imageView9);
        hello=findViewById(R.id.hello);
        signup=findViewById(R.id.textView);



        img.setAnimation(r_to_l);
        hello.setAnimation(r_to_l);
        signup.setAnimation(r_to_l);
        username.setAnimation(r_to_l);
        passward.setAnimation(r_to_l);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=username.getText().toString();
                String pas=passward.getText().toString();

                if(uname.equals(usrName)&&pas.equals((pwd))){
                    Intent intent=new Intent(login_activity.this,RegForm.class);
                    intent.putExtra("name",uname);
                    intent.putExtra("img",R.id.imageView9 );
                    startActivity(intent);
                }

                else{
                    Toast.makeText(getApplicationContext(),"LoginFailed",Toast.LENGTH_SHORT).show();
                    count++;
                    if(count>2){
                        buttonlogin.setEnabled(false);
                    }
                }

            }
        });





    }
}