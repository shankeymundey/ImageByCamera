 package com.example.shankey.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

 public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private  static  final int Requestimagecode=101;
   // Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // btn=(Button)findViewById(R.id.btn);
        imageView=(ImageView)findViewById(R.id.im1);
    }

     public void takepic(View view) {
         Intent imagetake_intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         if(imagetake_intent.resolveActivity(getPackageManager())!=null){
           startActivityForResult(imagetake_intent,Requestimagecode);



         }



     }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if( requestCode==Requestimagecode  &&  resultCode==RESULT_OK){

            Bundle extras= data.getExtras();
            Bitmap imageBitmap=  (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);


        }


     }
 }
