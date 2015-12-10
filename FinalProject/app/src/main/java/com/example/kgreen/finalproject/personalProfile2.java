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

import java.io.File;

public class personalProfile2 extends AppCompatActivity  {


    private TextView first;
    private TextView last;
    private TextView username;

    private SharedPreferences signInInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_profile2);


        AccountClassDB db = new AccountClassDB(this);
        findViews();
        signInInfo = getSharedPreferences("SignIn",
                MODE_PRIVATE);


        //Gets the username from the shared preferences
        String userName = signInInfo.getString("UsernameSign", "");


       //Sets the names needed based on the username that is passed
        first.setText(db.getAcc2(userName).getFirstName());
        last.setText(db.getAcc2(userName).getLastName());
        username.setText(db.getAcc2(userName).getUserName());


        //Retrieves the image that they were forced to take and plalces it into the image view

        File f = new File(Environment.getExternalStorageDirectory().getPath()  +
                db.getAcc2(userName).getPicPath() + ".png");
        ImageView mImgView1 = (ImageView)findViewById(R.id.imageView);
        Bitmap bmp = BitmapFactory.decodeFile(f.getAbsolutePath());
        mImgView1.setImageBitmap(bmp);



//        ImageView jpgView = (ImageView)findViewById(R.id.imageView);
//        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/" +
//                db.getAcc2(userName).getPicPath() + ".png");
//        jpgView.setImageBitmap(bitmap);



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
    }




}
