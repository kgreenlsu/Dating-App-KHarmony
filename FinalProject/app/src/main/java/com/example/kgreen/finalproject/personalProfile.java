package com.example.kgreen.finalproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.widget.ImageView;
import android.widget.TextView;

public class personalProfile extends AppCompatActivity  {


    private TextView first;
    private TextView last;
    private TextView age;
    private TextView username;
    private TextView location;

    private SharedPreferences savedValues;
    private SharedPreferences shre;

    public static String ageInt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile);


        savedValues = getSharedPreferences("SavedValues",
                MODE_PRIVATE);

        shre = getSharedPreferences("savedPic",
                MODE_PRIVATE);


        String firstName = savedValues.getString("First", "");
        String lastName = savedValues.getString("Last", "");
        String userName = savedValues.getString("User", "");
        String picPath = shre.getString("imagepath", "");
        ageInt = savedValues.getString("Age", "");

        int id = savedValues.getInt("Number", 0);


        findViews();

        //Sets the users name and age on their profile page

        first.setText(firstName);
        last.setText(lastName);
        username.setText(userName);
        age.setText(ageInt);


        //Looks through the database to retieve all the information needed and posts it on the page
        AccountClassDB db = new AccountClassDB(this);
        db.getAcc(userName).setPicPath(picPath);

        Account newUpdate = new Account(id, db.getAcc2(userName).getFirstName(), db.getAcc2(userName).getLastName(),
                db.getAcc2(userName).getUserName(), db.getAcc2(userName).getPassword(), db.getAcc2(userName).getPicPath());


        db.updateAcc(newUpdate);
        String path = db.getAcc(userName).getPicPath();


        //Retrieves the image that they were forced to take and palces it into the image view
        ImageView jpgView = (ImageView)findViewById(R.id.imageView);
        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/" + picPath +".png");
        jpgView.setImageBitmap(bitmap);


        //In 10 seconds of the page loading a notification appears alerting the user that they have a match
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        sendNotification("");
                    }
                },
                10000
        );


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
        //CharSequence tickerText = "Congrats! " + firstName + " You have  a match!" ;
        CharSequence tickerText = getResources().getText(R.string.notification);
        CharSequence contentTitle = getText(R.string.MatchMade);
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


    private void findViews() {
        first = (TextView)findViewById( R.id.first);
        last = (TextView)findViewById( R.id.last);
        username = (TextView)findViewById( R.id.username);
        age = (TextView)findViewById( R.id.age);
        location = (TextView)findViewById( R.id.location);
    }




}
