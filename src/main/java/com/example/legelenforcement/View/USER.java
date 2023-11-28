package com.example.legelenforcement.View;

public class USER{
    public String name, email, address, phone, dob, vic_img, complainNo, location, crime, date, description;

    public USER(String name, String email, String address, String phone, String dob, String vic_img, String complainNo, String location, String crime, String date, String description) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.vic_img = vic_img;
        this.complainNo = complainNo;
        this.location = location;
        this.crime = crime;
        this.date = date;
        this.description = description;
    }
    public USER()
    {
        this.name = "";
        this.email = "";
        this.address = "";
        this.phone = "";
        this.dob = "";
        this.vic_img = "";
        this.complainNo = "";
        this.location = "";
        this.crime = "";
        this.date = "";
        this.description = "";
    }

    public String getComplainNo() {
        return complainNo;
    }

    public void setComplainNo(String complainNo) {
        this.complainNo = complainNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getDob() {return dob;}
    public void setDob(String dob) {this.dob = dob;}
    public String getVic_img() {return vic_img;}
    public void setVic_img(String vic_img) {this.vic_img = vic_img;}
}
