package com.example.kgreen.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private Button signIn;
    private EditText usernnameSignIn;
    private EditText passwordSignIn;
    private TextView errorTxt;

    private SharedPreferences signInInfo;

    private String UN;
    private String PW;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        findViews();

        errorTxt.setVisibility(View.INVISIBLE);

        signInInfo = getSharedPreferences("SignIn",MODE_PRIVATE);

    }



    //Find Views method
    private void findViews() {
        signIn = (Button)findViewById( R.id.signIn);
        errorTxt = (TextView)findViewById(R.id.errorTxt);
        usernnameSignIn = (EditText)findViewById( R.id.usernnameSignIn );
        passwordSignIn = (EditText)findViewById( R.id.passwordSignIn );

        signIn.setOnClickListener( this );
    }


    @Override
    public void onClick(View v) {

        //Handles sign in button
        if ( v == signIn ) {

            //Variables for username and password

            String user = usernnameSignIn.getText().toString();
            String password = passwordSignIn.getText().toString();

            //Create the db in order to check it later
            AccountClassDB db = new AccountClassDB(this);


            //Checks to see if the user is inside the db or not. If it is give an intent to the next page

           if(db.getAcc(user) != null
                   && user.equals(db.getAcc(user).getUserName())
                   && db.password(password) != null
                   && password.equals(db.getAcc(user).getPassword())){

               Log.d("Username", user);
               Log.d("Password", password);

               saveInfo();

               Intent myIntent = new Intent(SignIn.this, personalProfile2.class);
               SignIn.this.startActivity(myIntent);

           }

           //Checks to see if the user is inside the db or not. If not display error message

          else{

                errorTxt.setVisibility(View.VISIBLE);

            }
        }
    }



    public void saveInfo() {
        // save the instance variables
        UN = usernnameSignIn.getText().toString();
        PW = passwordSignIn.getText().toString();


        SharedPreferences.Editor edit = signInInfo.edit();
        edit.putString("PasswordSign", PW);
        edit.putString("UsernameSign", UN);

        // editor.putString("Age", AGE);
        edit.commit();

        Log.d("Username", UN);
        Log.d("Password", PW);

    }

    @Override
    public void onResume () {
        super.onResume();

        // get the instance variables

        UN = signInInfo.getString("UsernameSign", "");
        PW = signInInfo.getString("PasswordSign", "");

    }

    @Override
    public void onPause() {
        // save the instance variables
        SharedPreferences.Editor editor2 = signInInfo.edit();

        editor2.putString("PasswordSign", PW);
        editor2.putString("UsernameSign", UN);

        editor2.commit();

        super.onPause();
    }

}
//(user.equals(db.getAcc(user).getUserName()) &&




