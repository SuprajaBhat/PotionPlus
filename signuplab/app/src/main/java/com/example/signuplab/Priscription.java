package com.example.signuplab;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Priscription extends AppCompatActivity {


    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAM_REQ_CODE = 102;
    TextView c,c2;
    int count=0;
    ImageView i,i2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priscription);

        i=findViewById(R.id.imageView1);
        i2=findViewById(R.id.imageView2);
        c=findViewById(R.id.Cam);
        c2=findViewById(R.id.cam);

        c2.setVisibility(View.GONE);


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askcampermisson();
                c.setVisibility(View.GONE);
                c2.setVisibility(View.VISIBLE);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askcampermisson();

            }
        });



    }

    private void askcampermisson() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }
        else{
            openCamera();
        }




    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            }
            else{
                Toast.makeText(this,"Cam  permission required",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        count++;
        Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam, CAM_REQ_CODE);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        if(requestCode==CAM_REQ_CODE){
            Bitmap image= (Bitmap) data.getExtras().get("data");
            if(count == 1)
                i.setImageBitmap(image);
            else{
                i2.setImageBitmap(image);
            }
        }
    }
}