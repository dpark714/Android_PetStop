package com.example.android_petstop;

public class MemberInfo {
    private String name;
    private String phoneNumber;
    private String birthday;
    private String address;
    private String photoUrl;

    public MemberInfo(String name, String phoneNumber, String birthday, String address, String photoUrl) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
        this.photoUrl = photoUrl;
    }

    public MemberInfo(String name, String phoneNumber, String birthday, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getZipCode() {
        return this.address;
    }

    public void setZipCode(String zipCode) {
        this.address = zipCode;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
