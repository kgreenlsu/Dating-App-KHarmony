package com.example.kgreen.finalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Preferences extends AppCompatActivity implements View.OnClickListener {
    //Variables used

    private RadioGroup genderGroup;
    private RadioButton prefMale;
    private RadioButton prefFemale;
    private RadioGroup statusGroup;
    private RadioButton singleBtn;
    private RadioButton marriedBtn;
    private RadioButton divorceBtn;
    private RadioButton seperatedBtn;
    private RadioGroup orientationGroup;
    private RadioButton StraightBtn;
    private RadioButton GayBtn;
    private RadioButton BisexualBtn;
    private RadioGroup ethnicGroup;
    private RadioButton btnAsia;
    private RadioButton btnBlack;
    private RadioButton btnWhite;
    private RadioButton btnLatin;
    private RadioGroup educationGroup;
    private RadioButton HighSchool;
    private RadioButton collegeBtn;
    private RadioButton mastersBtn;
    private RadioButton DropoutBtn;
    private RadioButton OtherBtn;
    private RadioGroup religiousGroup;
    private RadioButton spiritBtn;
    private RadioButton ChristianBtn;
    private RadioButton btnCatholic;
    private RadioButton btnIslam;
    private RadioButton otherReligionBtn;
    private RadioGroup bodyTypeGroup;
    private RadioButton SkinnyBtn;
    private RadioButton thickBtn;
    private RadioButton MusclesBtn;
    private RadioButton BigBtn;
    private RadioButton otherBodyTypeBtn;
    private RadioGroup ageGroup;
    private RadioButton youngBtn;
    private RadioButton averageBtn;
    private RadioButton middleageBtn;
    private RadioButton btnOld;
    private RadioButton btnPlus;
    private Button nextBtn;



    private String prefGender;
    private String prefStatus;
    private String prefSexOrientation;
    private String prefEthnic;
    private String prefEducation;
    private  String prefReligion;
    private String prefBodyType;
    private String prefAge;

    private SharedPreferences shared;



    private String genderSaved;
    private String sexSaved;
    private String ethnicSaved;
    private String religionSaved;
    private String bodySaved;
    private String ageSaved;



    private boolean genderBoolean = false;
    private  boolean statusBoolean = false;
    private  boolean sexBoolean = false;
    private boolean ethnicBoolean = false;
    private boolean educationBoolean = false;
    private boolean religionBoolean = false;
    private boolean bodyBoolean = false;
    private boolean ageBoolean = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        findViews();
        shared = getSharedPreferences("savingValues",MODE_PRIVATE);

    }



    private void findViews() {
       genderGroup = (RadioGroup)findViewById( R.id.genderGroup );
        prefMale = (RadioButton)findViewById( R.id.prefMale );
        prefFemale = (RadioButton)findViewById( R.id.prefFemale );
        statusGroup = (RadioGroup)findViewById( R.id.statusGroup );
        singleBtn = (RadioButton)findViewById( R.id.singleBtn );
        marriedBtn = (RadioButton)findViewById( R.id.marriedBtn );
        divorceBtn = (RadioButton)findViewById( R.id.divorceBtn );
        seperatedBtn = (RadioButton)findViewById( R.id.seperatedBtn );
        orientationGroup = (RadioGroup)findViewById( R.id.orientationGroup );
        StraightBtn = (RadioButton)findViewById( R.id.StraightBtn );
        GayBtn = (RadioButton)findViewById( R.id.GayBtn );
        BisexualBtn = (RadioButton)findViewById( R.id.BisexualBtn );
        ethnicGroup = (RadioGroup)findViewById( R.id.ethnicGroup );
        btnAsia = (RadioButton)findViewById( R.id.btnAsia );
        btnBlack = (RadioButton)findViewById( R.id.btnBlack );
        btnWhite = (RadioButton)findViewById( R.id.btnWhite );
        btnLatin = (RadioButton)findViewById( R.id.btnLatin );
        educationGroup = (RadioGroup)findViewById( R.id.educationGroup );
        HighSchool = (RadioButton)findViewById( R.id.HighSchool );
        collegeBtn = (RadioButton)findViewById( R.id.collegeBtn );
        mastersBtn = (RadioButton)findViewById( R.id.mastersBtn );
        DropoutBtn = (RadioButton)findViewById( R.id.DropoutBtn );
        OtherBtn = (RadioButton)findViewById( R.id.OtherBtn );
        religiousGroup = (RadioGroup)findViewById( R.id.religiousGroup );
        spiritBtn = (RadioButton)findViewById( R.id.spiritBtn );
        ChristianBtn = (RadioButton)findViewById( R.id.ChristianBtn );
        btnCatholic = (RadioButton)findViewById( R.id.btnCatholic );
        btnIslam = (RadioButton)findViewById( R.id.btnIslam );
        otherReligionBtn = (RadioButton)findViewById( R.id.otherReligionBtn );
        bodyTypeGroup = (RadioGroup)findViewById( R.id.bodyTypeGroup );
        SkinnyBtn = (RadioButton)findViewById( R.id.SkinnyBtn );
        thickBtn = (RadioButton)findViewById( R.id.thickBtn );
        MusclesBtn = (RadioButton)findViewById( R.id.MusclesBtn );
        BigBtn = (RadioButton)findViewById( R.id.BigBtn );
        otherBodyTypeBtn = (RadioButton)findViewById( R.id.otherBodyTypeBtn );
        ageGroup = (RadioGroup)findViewById( R.id.ageGroup );
        youngBtn = (RadioButton)findViewById( R.id.youngBtn );
        averageBtn = (RadioButton)findViewById( R.id.averageBtn );
        middleageBtn = (RadioButton)findViewById( R.id.middleageBtn );
        btnOld = (RadioButton)findViewById( R.id.btnOld );
        btnPlus = (RadioButton)findViewById( R.id.btnPlus );
        nextBtn = (Button)findViewById( R.id.nextBtn );

        prefMale.setOnClickListener( this );
        prefFemale.setOnClickListener( this );
        singleBtn.setOnClickListener( this );
        marriedBtn.setOnClickListener( this );
        divorceBtn.setOnClickListener( this );
        seperatedBtn.setOnClickListener( this );
        StraightBtn.setOnClickListener( this );
        GayBtn.setOnClickListener( this );
        BisexualBtn.setOnClickListener( this );
        btnAsia.setOnClickListener( this );
        btnBlack.setOnClickListener( this );
        btnWhite.setOnClickListener( this );
        btnLatin.setOnClickListener( this );
        HighSchool.setOnClickListener( this );
        collegeBtn.setOnClickListener( this );
        mastersBtn.setOnClickListener( this );
        DropoutBtn.setOnClickListener( this );
        OtherBtn.setOnClickListener( this );
        spiritBtn.setOnClickListener( this );
        ChristianBtn.setOnClickListener( this );
        btnCatholic.setOnClickListener( this );
        btnIslam.setOnClickListener( this );
        otherReligionBtn.setOnClickListener( this );
        SkinnyBtn.setOnClickListener( this );
        thickBtn.setOnClickListener( this );
        MusclesBtn.setOnClickListener( this );
        BigBtn.setOnClickListener( this );
        otherBodyTypeBtn.setOnClickListener( this );
        youngBtn.setOnClickListener( this );
        averageBtn.setOnClickListener( this );
        middleageBtn.setOnClickListener( this );
        btnOld.setOnClickListener( this );
        btnPlus.setOnClickListener( this );
        nextBtn.setOnClickListener( this );
    }



    @Override
    public void onClick(View v) {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////



    // Handles all the preferences that ther user has selected and saves the values accordingly



    //////////////////////////////////////////////////////////////////////////////////////////////////////////

        if ( v == prefMale ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.genderGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefGender = radiovalue;
            genderBoolean = true;
            savingValues();


        } else if ( v == prefFemale ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.genderGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefGender = radiovalue;
            genderBoolean = true;
            savingValues();

        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        else if ( v == singleBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.statusGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefStatus = radiovalue;
            statusBoolean=true;
            savingValues();

        } else if ( v == marriedBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.statusGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefStatus = radiovalue;
            statusBoolean=true;
            savingValues();

        } else if ( v == divorceBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.statusGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefStatus = radiovalue;
            statusBoolean=true;
            savingValues();

        } else if ( v == seperatedBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.statusGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefStatus = radiovalue;
            statusBoolean=true;
            savingValues();

        } else if ( v == StraightBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.orientationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefSexOrientation = radiovalue;
            sexBoolean=true;
            savingValues();

        } else if ( v == GayBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.orientationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefSexOrientation = radiovalue;
            sexBoolean=true;
            savingValues();

        } else if ( v == BisexualBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.orientationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefSexOrientation = radiovalue;
            sexBoolean=true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////


        else if ( v == btnAsia ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ethnicGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEthnic = radiovalue;
            ethnicBoolean = true;
            savingValues();


        } else if ( v == btnBlack ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ethnicGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEthnic = radiovalue;
            ethnicBoolean = true;
            savingValues();

        } else if ( v == btnWhite ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ethnicGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEthnic = radiovalue;
            ethnicBoolean = true;
            savingValues();

        } else if ( v == btnLatin ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ethnicGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEthnic = radiovalue;
            ethnicBoolean = true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if ( v == HighSchool ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.educationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEducation = radiovalue;
            educationBoolean = true;
            savingValues();

        } else if ( v == collegeBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.educationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEducation = radiovalue;
            educationBoolean = true;
            savingValues();

        } else if ( v == mastersBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.educationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEducation = radiovalue;
            educationBoolean = true;
            savingValues();

        } else if ( v == DropoutBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.educationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEducation = radiovalue;
            educationBoolean = true;
            savingValues();

        } else if ( v == OtherBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.educationGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefEducation = radiovalue;
            educationBoolean = true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if ( v == spiritBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.religiousGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefReligion = radiovalue;
            religionBoolean = true;
            savingValues();

        } else if ( v == ChristianBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.religiousGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefReligion = radiovalue;
            religionBoolean = true;
            savingValues();

        } else if ( v == btnCatholic ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.religiousGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefReligion = radiovalue;
            religionBoolean = true;
            savingValues();

        } else if ( v == btnIslam ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.religiousGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefReligion = radiovalue;
            religionBoolean = true;
            savingValues();

        } else if ( v == otherReligionBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.religiousGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefReligion = radiovalue;
            religionBoolean = true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if ( v == SkinnyBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.bodyTypeGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefBodyType = radiovalue;
            bodyBoolean = true;
            savingValues();

        } else if ( v == thickBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.bodyTypeGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefBodyType = radiovalue;
            bodyBoolean = true;
           savingValues();


        } else if ( v == MusclesBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.bodyTypeGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefBodyType = radiovalue;
            bodyBoolean = true;
            savingValues();



        } else if ( v == BigBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.bodyTypeGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefBodyType = radiovalue;
            bodyBoolean = true;
            savingValues();


        } else if ( v == otherBodyTypeBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.bodyTypeGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefBodyType = radiovalue;
            bodyBoolean = true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        else if ( v == youngBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ageGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefAge = radiovalue;
            ageBoolean = true;
            savingValues();

        } else if ( v == averageBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ageGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefAge = radiovalue;
            ageBoolean = true;
            savingValues();

        } else if ( v == middleageBtn ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ageGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefAge = radiovalue;
            ageBoolean = true;
            savingValues();

        } else if ( v == btnOld ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ageGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefAge = radiovalue;
            ageBoolean = true;
            savingValues();

        } else if ( v == btnPlus ) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.ageGroup);
            String radiovalue = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
            prefAge = radiovalue;
            ageBoolean = true;
            savingValues();

        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the preferences that ther user has selected and saves the values accordingly



        //////////////////////////////////////////////////////////////////////////////////////////////////////////











        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        // Handles all the validation for the activity.
        // If the user tries to leave something blank the alert boxes appear for the user to select and answer


        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        else if ( v == nextBtn ) {

            if (genderGroup.getCheckedRadioButtonId() == -1) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForGender))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((statusGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForStatus))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((orientationGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForSexOrientation))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((ethnicGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForEthnicity))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((educationGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForEducate))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((religiousGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForReligion))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((bodyTypeGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForBody))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }

            if ((ageGroup.getCheckedRadioButtonId() == -1)) {
                new AlertDialog.Builder(this)
                        .setMessage(getResources().getText(R.string.alertForAge))
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                        .show();
            }



            //////////////////////////////////////////////////////////////////////////////////////////////////////////
            // If everything goes well then the user is taken to the bio page
            //////////////////////////////////////////////////////////////////////////////////////////////////////////

            else if((genderBoolean == true) && (sexBoolean) && (ageBoolean) && (ethnicBoolean) &&
                    (religionBoolean) && (bodyBoolean) && (educationBoolean) && (statusBoolean)) {

                savingValues();
                Intent myIntent = new Intent(Preferences.this, BioPage.class);
                Preferences.this.startActivity(myIntent);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void savingValues() {

        genderSaved = prefGender;
        sexSaved = prefSexOrientation;
        ethnicSaved = prefEthnic;
        religionSaved = prefReligion;
        bodySaved = prefBodyType;
        ageSaved = prefAge;

        SharedPreferences.Editor editor = shared.edit();
        editor.putString("PG", genderSaved);
        editor.putString("PSO", sexSaved);
        editor.putString("PE", ethnicSaved);
        editor.putString("PR", religionSaved);
        editor.putString("PBT", bodySaved);
        editor.putString("PA", ageSaved);
        editor.commit();

    }
}


