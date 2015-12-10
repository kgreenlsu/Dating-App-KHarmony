package com.example.kgreen.finalproject;

public class Account {


    private long accountId;
    private String Firstname;
    private String Lastname;
    private String UserName;
    private String Password;
    private String picPath;


    public Account() {
        Firstname = "";
        Lastname = "";
        UserName = "";
        Password = "";
        picPath = "";
    }

    public Account(String firstname, String lastname,
                String userName, String password, String picPath) {
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.UserName = userName;
        this.Password = password;
        this.picPath = picPath;
       // this.phoneNumber = phoneNumber;
    }

    public Account(int accountID,String firstname, String lastname,
                   String userName, String password, String picPath) {
        this.accountId = accountID;
        this.Firstname = firstname;
        this.Lastname = lastname;
        this.UserName = userName;
        this.Password = password;
        this.picPath = picPath;
        // this.phoneNumber = phoneNumber;
    }


    public long getId() {
        accountId++;
        return accountId;
    }

    public void setId(long accountId) {

        this.accountId = accountId;
    }
    public String getFirstName() {

        return Firstname;
    }

    public void setFirstNAME(String FirstNAME) {

        this.Firstname = FirstNAME;
    }

    public String getLastName() {

        return Lastname;
    }

    public void setLastNAME(String LastNAME) {

        this.Lastname = LastNAME;
    }

    public String getUserName() {

        return UserName;
    }

    public void setUserName(String usernamepara) {

        this.UserName = usernamepara;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Passwordpara) {

        this.Password = Passwordpara;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {

        this.picPath = picPath;
    }

}
