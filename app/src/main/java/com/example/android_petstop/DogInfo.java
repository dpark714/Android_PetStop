package com.example.android_petstop;



public class DogInfo {
    private String username;
    private String age;
    private String breed;
    private String motto;

    public DogInfo(String username, String age, String breed, String motto){
        this.username = username;
        this.age = age;
        this.breed = breed;
        this.motto = motto;
    }

    public String getUsername(){return this.username;}

    public void setUsername(String username){this.username = username;}

    public String getAge(){return this.age;}
    public void setAge(String age){this.age = age;}

    public String getBreed(){return this.breed;}

    public void setBreed(String username){this.breed = breed;}

    public String getMotto(){return this.motto;}

    public void setMotto(String motto){this.motto = motto;}






}
