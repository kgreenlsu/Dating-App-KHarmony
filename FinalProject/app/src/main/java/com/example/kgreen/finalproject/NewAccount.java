package com.example.kgreen.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Random;

public class NewAccount extends AppCompatActivity implements View.OnClickListener    {


    //Sets all the variables
    private EditText FirstTxt;
    private EditText LastTxt;
    private EditText EmailTxt;
    private RadioGroup genderNewAcc;
    private RadioButton MaleRadio;
    private RadioButton FemaleRadio;
    private EditText UsernameTxt;
    private EditText PasswordTxt;
    private Button nextBtn;
    private EditText NumberTxt;
    private EditText AgeTxt;

    //Use 2 shared pref. One is for the values and the other is for the gender
    private SharedPreferences savedValues;
    private SharedPreferences savedGender;

    //FN,LN,UN,PW,AGE are all being stored for the personal profile page
    private String FN;
    private String LN;
    private String UN;
    private String PW;
    private String AGE;
    private int Number;

    private String genderAcc;
    private String genderAccSaved;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);
        //this.deleteDatabase("account.db");
        findViews();


        savedValues = getSharedPreferences("SavedValues",MODE_PRIVATE);
        savedGender = getSharedPreferences("SavedGender",MODE_PRIVATE);
    }

    private void findViews() {
        FirstTxt = (EditText)findViewById( R.id.FirstTxt );
        LastTxt = (EditText)findViewById( R.id.LastTxt );
        EmailTxt = (EditText)findViewById( R.id.EmailTxt );
        genderNewAcc = (RadioGroup)findViewById( R.id.genderNewAcc );
        MaleRadio = (RadioButton)findViewById( R.id.MaleRadio );
        FemaleRadio = (RadioButton)findViewById( R.id.FemaleRadio );
        UsernameTxt = (EditText)findViewById( R.id.UsernameTxt );
        PasswordTxt = (EditText)findViewById( R.id.PasswordTxt );
        nextBtn = (Button)findViewById( R.id.nextBtn );
        NumberTxt = (EditText)findViewById( R.id.NumberTxt );
        AgeTxt = (EditText)findViewById(R.id.AgeTxt);


        MaleRadio.setOnClickListener(this);
        FemaleRadio.setOnClickListener( this );
        nextBtn.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {

        //Handles what gender the user selected and calls the finction savedGender in order to save the genders
        if (v == MaleRadio) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.genderNewAcc);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            genderAcc = radiovalue;
            saveGender();

        } else if (v == FemaleRadio) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.genderNewAcc);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            genderAcc = radiovalue;
            saveGender();

        } else {
            if (v == nextBtn) {

                //Gets the values form each of the fields that I will need
                FN = FirstTxt.getText().toString();
                LN = LastTxt.getText().toString();
                UN = UsernameTxt.getText().toString();
                PW = PasswordTxt.getText().toString();
                AGE = AgeTxt.getText().toString();


                //If any of these fields are blank then sent an alert to the user
                if (FN.equals("") || LN.equals("") || UN.equals("") || PW.equals("")) {


                    //Alert dialog for missing information...Must be filled out to continue
                    new AlertDialog.Builder(this)
                            .setMessage(getResources().getText(R.string.alertForBlanks))
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                }

                else if(UN.length() < 6){
                    new AlertDialog.Builder(this)
                            .setMessage(getResources().getText(R.string.alertForUN))
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();

                }

                else if(PW.length() < 5){
                    new AlertDialog.Builder(this)
                            .setMessage(getResources().getText(R.string.alertForPW))
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    })
                                    .show();
                }
                //Alert dialog for missing information...Must be filled out to continue
                if ((genderNewAcc.getCheckedRadioButtonId() == -1)) {
                    new AlertDialog.Builder(this)
                            .setMessage(getResources().getText(R.string.alertForGender2))
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            .show();
                } else {

                    // get db and StringBuilder objects
                    AccountClassDB db = new AccountClassDB(this);
                    StringBuilder sb = new StringBuilder();




                    //Gets a random number from 1- 1000000000
                    int numberCounter;
                    Random num = new Random();
                    numberCounter = num.nextInt(1000000000);

                    String text = "";
                    Number = numberCounter;
                    //This random number is used as an id for the user...This wil cause a bug
                    // eventually because too many users and not enough numbers


                    //Creates a new account based on the passed information
                    Account acc = new Account(numberCounter, this.FirstTxt.getText().toString(), LastTxt.getText().toString(),
                            UsernameTxt.getText().toString(), PasswordTxt.getText().toString(), text);


        // I should probably do a check on making sure no two usernames are not the same because that will be a bug also

                        long insertId = db.insertAcc(acc);


                    //Inserts the user into the db
                        if (insertId > 0) {
                            System.out.println(insertId);
                            sb.append("Row inserted! Insert Id: " + insertId + "\n");
                            sb.toString();
                        }

                    //Takes the user to the next activity which is preferences
                        Intent myIntent = new Intent(NewAccount.this, Preferences.class);
                        NewAccount.this.
                                startActivity(myIntent);
                }
            }
        }
    }


            @Override
            public void onResume () {
                super.onResume();

                // get the instance variables
                FN = savedValues.getString("First", "");
                LN = savedValues.getString("Last", "");
                UN = savedValues.getString("User", "");
                PW = savedValues.getString("Pass", "");
                AGE = savedValues.getString("Age", "");
                Number = savedValues.getInt("Number", 0);
    }

    public void saveGender(){

        //Saves gender into the shared pref
        genderAccSaved = genderAcc;

        SharedPreferences.Editor editor = savedGender.edit();
        editor.putString("GenderForAcc", genderAccSaved);
        editor.commit();
    }

    @Override
    public void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor2 = savedValues.edit();
        editor2.putString("First", FN);
        editor2.putString("Last", LN);
        editor2.putString("Pass", PW);
        editor2.putString("User", UN);
        editor2.putString("Age", AGE);
        editor2.putInt("Number", Number);

       // editor.putString("Age", AGE);
        editor2.commit();

        super.onPause();
    }

}
