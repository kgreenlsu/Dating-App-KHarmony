package com.example.kgreen.finalproject;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Match extends AppCompatActivity implements View.OnClickListener {

    private TextView textView23;
    private TextView textView26;
    private ImageView imageView2;
    private Button sayHi;

    private SharedPreferences shared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        sayHi = (Button)findViewById(R.id.sayHi);
        textView23 = (TextView) findViewById(R.id.textView23);
        textView26 = (TextView) findViewById(R.id.textView26);
        imageView2 = (ImageView)findViewById(R.id.imageView2);

         sayHi.setOnClickListener(this);
         shared  = getSharedPreferences("savingValues",MODE_PRIVATE);


        String Gender = shared.getString("PG", "");
        String ethnic = shared.getString("PE","");
        String AgePref = shared.getString("PA","");


/*
All of this is for the matching purposes. Based on what the user has selected the choices generate a pre made match
*/

        if(Gender.equals("Female") && (ethnic.equals("Asian")) && (AgePref.equals("18-25"))){
            textView23.setText(getResources().getText(R.string.asianMatchName) );
            textView26.setText(getResources().getText(R.string.asianMatchNameBio));
            imageView2.setImageResource(R.drawable.lucy);

        }

        if(Gender.equals("Female") && (ethnic.equals("Asian")) && (AgePref.equals("25-36"))){
            textView23.setText(getResources().getText(R.string.asianThick) );
            textView26.setText(getResources().getText(R.string.asianThickBio));
            imageView2.setImageResource(R.drawable.thickyasian);

        }

        if(Gender.equals("Female") && (ethnic.equals("Asian"))  && (AgePref.equals("37-45"))){
            textView23.setText(getResources().getText(R.string.asianMuscular));
            textView26.setText(getResources().getText(R.string.asianMuscle));
            imageView2.setImageResource(R.drawable.muscleasian);

        }

        if(Gender.equals("Female") && (ethnic.equals("Asian"))  && (AgePref.equals("46-65"))){
            textView23.setText(getResources().getText(R.string.asianMiddleAged) );
            textView26.setText(getResources().getText(R.string.asain65));
            imageView2.setImageResource(R.drawable.shruti);

        }

        if(Gender.equals("Female") && (ethnic.equals("Asian"))  && (AgePref.equals("66+"))){
            textView23.setText(getResources().getText(R.string.asianPlus));
           // textView25.setText("");
            textView26.setText(getResources().getText(R.string.asain66));
            imageView2.setImageResource(R.drawable.plusasian);

        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        if(Gender.equals("Female") && (ethnic.equals("Black/African")) && (AgePref.equals("18-25"))){
            textView23.setText("Evelyn,");
           // textView25.setText("21");
            textView26.setText(getResources().getText(R.string.blackyoung));
            imageView2.setImageResource(R.drawable.youngblack);

        }

        if(Gender.equals("Female") && (ethnic.equals("Black/African")) && (AgePref.equals("25-36"))){
            textView23.setText("Sophia");
            //textView25.setText("29");
            textView26.setText(getResources().getText(R.string.ThickBlack));
            imageView2.setImageResource(R.drawable.thickblack);

        }

        if(Gender.equals("Female") && (ethnic.equals("Black/African"))  && (AgePref.equals("37-45"))){
            textView23.setText("Traci");
           // textView25.setText("");
            textView26.setText(getResources().getText(R.string.trackRun));
            imageView2.setImageResource(R.drawable.trackrunner);

        }

        if(Gender.equals("Female") && (ethnic.equals("Black/African"))  && (AgePref.equals("46-65"))){
            textView23.setText("Amy");
           // textView25.setText("52");
            textView26.setText(getResources().getText(R.string.fifty));
            imageView2.setImageResource(R.drawable.fiftyblack);

        }

        if(Gender.equals("Female") && (ethnic.equals("Black/African"))  && (AgePref.equals("66+"))){
            textView23.setText("Carmen");
           // textView25.setText("");
            textView26.setText(getResources().getText(R.string.sixtyBlack));
            imageView2.setImageResource(R.drawable.sixtyblack);

        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        if(Gender.equals("Female") && (ethnic.equals("White")) && (AgePref.equals("18-25"))){
            textView23.setText("April");
            //textView25.setText("22");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.whiteyoung);

        }

        if(Gender.equals("Female") && (ethnic.equals("White")) && (AgePref.equals("25-36"))){
            textView23.setText("Katelyn");
            //textView25.setText("27");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.thickwhite);

        }

        if(Gender.equals("Female") && (ethnic.equals("White"))  && (AgePref.equals("37-45"))){
            textView23.setText("Emily");
            //textView25.setText("");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.athleticwhite);

        }

        if(Gender.equals("Female") && (ethnic.equals("White"))  && (AgePref.equals("46-65"))){
            textView23.setText("Heather");
            //textView25.setText("52");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.middleagedwhite);

        }

        if(Gender.equals("Female") && (ethnic.equals("White"))  && (AgePref.equals("66+"))){
            textView23.setText("Jennifer");
            //textView25.setText("73");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.overfiftywhite);

        }


        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        if(Gender.equals("Female") && (ethnic.equals("Latin/Spanish")) && (AgePref.equals("18-25"))){
            textView23.setText("Laura");
           // textView25.setText("");
            textView26.setText(":)");
            imageView2.setImageResource(R.drawable.skinnyyoungspanish);

        }

        if(Gender.equals("Female") && (ethnic.equals("Latin/Spanish")) && (AgePref.equals("25-36"))){
            textView23.setText("Jessye");
           // textView25.setText("27");
            textView26.setText("Hey I am here for fun");
            imageView2.setImageResource(R.drawable.thickspanish);

        }

        if(Gender.equals("Female") && (ethnic.equals("Latin/Spanish"))  && (AgePref.equals("37-45"))){
            textView23.setText("Mary");
            //textView25.setText("");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.fortyspanish);

        }

        if(Gender.equals("Female") && (ethnic.equals("Latin/Spanish"))  && (AgePref.equals("46-65"))){
            textView23.setText("Alexis");
           // textView25.setText("");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.twentyfivespanish);

        }

        if(Gender.equals("Female") && (ethnic.equals("Latin/Spanish"))  && (AgePref.equals("66+"))){
            textView23.setText("Brittney");
            //textView25.setText("69");
            textView26.setText("");
            imageView2.setImageResource(R.drawable.olderspanish);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pref2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_pref:

                //If the user selects the icon in the top right corner then they will be directed to a new preferences page
                Intent myIntent = new Intent(Match.this, Pref2.class);
                Match.this.startActivity(myIntent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        if (v == sayHi) {

            //The say hi button allows the user to notify the person that they like them
            new AlertDialog.Builder(this)
                    .setMessage(getResources().getText(R.string.Lover))
                    .setPositiveButton(getResources().getText(R.string.SendLove), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            sendNotification("");
                        }
                    })

                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            Intent myIntent = new Intent(Match.this, Pref2.class);
                            Match.this.startActivity(myIntent);


                        }
                    })
                    .show();
        }
    }


    private void sendNotification(String text) {


        // create the intent for the notification
        Intent notificationIntent = new Intent(this, Match.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // create the pending intent
        int flags = PendingIntent.FLAG_UPDATE_CURRENT;
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, notificationIntent, flags);

        // create the variables for the notification
        int icon = R.drawable.heart;
        CharSequence tickerText = getResources().getText(R.string.SentLove) ;
        CharSequence contentTitle = getText(R.string.app_name);
        CharSequence contentText = text;

        // create the notification and set its data
        Notification notification =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(icon)
                        .setTicker(tickerText)
                        .setContentTitle(contentTitle)
                        .setContentText(contentText)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();

        // display the notification
        NotificationManager manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        final int NOTIFICATION_ID = 1;
        manager.notify(NOTIFICATION_ID, notification);
    }





}
