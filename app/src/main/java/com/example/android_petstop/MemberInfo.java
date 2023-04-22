package com.example.android_petstop;

import android.widget.EditText;

import java.lang.reflect.Member;

public class MemberInfo {
    private String name;
    private String phoneNumber;
    private String birthday;
    private String zipCode;

    public MemberInfo(String name, String phoneNumber, String birthday, String zipCode){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.zipCode = zipCode;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
    public String getZipCode(){
        return this.zipCode;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
}
