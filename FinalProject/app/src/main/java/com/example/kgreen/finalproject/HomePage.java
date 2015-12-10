package com.example.kgreen.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class HomePage extends AppCompatActivity implements Button.OnClickListener {

    private Button btnSign;
    private Button btnAccount;
    private ImageView imgHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


      //this.deleteDatabase("account.db");
        btnSign = (Button) findViewById(R.id.btnSign);
        btnAccount = (Button) findViewById(R.id.btnAccount);
        imgHome = (ImageView) findViewById(R.id.imgHome);

        btnSign.setOnClickListener(this);
        btnAccount.setOnClickListener(this);


        //These numbers are for the randomly selected images that I have for whenever the app is loading anew
        int min = 1;
        int max = 5;
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        //Selects the image based on the number generated
        switch (randomNum) {
            case 1:
                if (randomNum == 1) {
                    imgHome.setImageResource(R.drawable.couple1);
                    break;
                }
            case 2:
                if (randomNum == 2) {
                    imgHome.setImageResource(R.drawable.couple2);
                    break;
                }
            case 3:
                if (randomNum == 3) {
                    imgHome.setImageResource(R.drawable.couple3);
                    break;
                }
            case 4:
                if (randomNum == 4) {
                    imgHome.setImageResource(R.drawable.couple4);
                    break;
                }
            case 5:
                if (randomNum == 5) {
                    imgHome.setImageResource(R.drawable.couple5);
                    break;
                }
            default:
                imgHome.setImageResource(R.drawable.couple1);
                break;
        }


      }


    @Override
    public void onClick(View v) {
        if (v == btnSign) {

            //Intent that takes the user to the sign in activity
            Intent myIntent = new Intent(HomePage.this, SignIn.class);
            HomePage.this.startActivity(myIntent);

        } else if (v == btnAccount) {
            //Intent that takes the user to the New Account activity
            Intent myIntent = new Intent(HomePage.this, NewAccount.class);
            HomePage.this.startActivity(myIntent);

        }

    }
}
