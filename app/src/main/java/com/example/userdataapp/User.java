package com.example.userdataapp;

public class User {

    String Name;
    String PhoneNo;
    String  emailid;
    String age;
    String Gender;

    public User() {
    }

    public User(String name, String phoneNo, String emailid, String age, String gender) {
        Name = name;
        PhoneNo = phoneNo;
        this.emailid = emailid;
        this.age = age;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
