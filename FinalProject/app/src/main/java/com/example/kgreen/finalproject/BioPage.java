package com.example.kgreen.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BioPage extends AppCompatActivity implements View.OnClickListener {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private Button button;
    private  SharedPreferences savedValues;
    private  SharedPreferences shre;
    private Boolean picTaken = false;
    private Button photoButton;

    private String picPathData;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_page);

        findViews();

        this.imageView = (ImageView) this.findViewById(R.id.imageView);

        photoButton.setOnClickListener(this);
    }


    //Based on the button that the user selects this method is run
    //This handles the camera

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {



            //Takes the image that the user has taken and places it into the bitmap
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

            String randomStringForPic ="";
            int length = 12;
            randomString(length);
            randomStringForPic = randomString(length);
            picPathData =   randomStringForPic;


            AccountClassDB db = new AccountClassDB(this);

            savedValues = getSharedPreferences("SavedValues",
                    MODE_PRIVATE);

            //Retrieves the information needed to update the user's account
            int id = savedValues.getInt("Number", 0);
            String firstName = savedValues.getString("First", "");
            String lastName = savedValues.getString("Last", "");
            String userName = savedValues.getString("User", "");
            String password = savedValues.getString("Pass", "");


            //Updating the user's account because of the picture that they have taken
            Account ex = new Account(id, firstName,lastName,userName,password, picPathData);
            ex.setPicPath(picPathData);
            db.updateAcc(ex);


            //Saves the image in the SD as picture.png
            //Not good practice to do this of course
            BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = drawable.getBitmap();


            //Saves the image to the user's SD card
            File sdCardDirectory = Environment.getExternalStorageDirectory();
            File image = new File(sdCardDirectory, picPathData + ".png");

            Uri imageUri = Uri.fromFile(image);

            //Send a broadcast so that the image that was just taken is saved to the users SD card
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, imageUri ));



            boolean success = false;

            FileOutputStream outStream;
            try {

                //COnverts the image into a smaller form while still trying to keep the quality of the image
                outStream = new FileOutputStream(image);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        /* 100 to keep full quality of the image */

                outStream.flush();
                outStream.close();
                success = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //If image is saved tell the user and if not then tell the user
            if (success) {
                Toast.makeText(getApplicationContext(), getResources().getText(R.string.ImageSaved),
                        Toast.LENGTH_LONG).show();
                picTaken = true;
            } else {
                Toast.makeText(getApplicationContext(),
                        getResources().getText(R.string.ErrorImage), Toast.LENGTH_LONG).show();
            }
        }
    }


    private void findViews() {
        button = (Button) findViewById(R.id.button);
        photoButton = (Button) this.findViewById(R.id.btnCapture);

        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        //Handler for the picture button
        if (v == button) {

            //If a picture has not been taken then the user will need to take a picture
            if(picTaken == false){
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.Imagenotification))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }


        }

        if(v == photoButton ){

            //Sends an intent for the usage of the camera
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }

        if(picTaken == true){

            //If the user has taken a picture then the user is taken to their profile page
            Intent myIntent = new Intent(BioPage.this, personalProfile.class);
            BioPage.this.startActivity(myIntent);
        }
    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onPause() {
        shre = getSharedPreferences("savedPic",MODE_PRIVATE);
        SharedPreferences.Editor edit=shre.edit();
       // edit.putString(picPathData)
       edit.putString("imagepath", picPathData);
        edit.commit();

        super.onPause();
    }

    public String randomString(int length){

        //Generates a random name for the image that the user has taken

        //THis is the alphabet that I will be using for the name
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();


        //Use a string buiolder to build a sequence of random numbers based on the length that is passed in the parameter
        StringBuilder sb = new StringBuilder( length );
        for( int i = 0; i < length; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}

