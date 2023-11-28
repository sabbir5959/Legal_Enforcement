package com.example.legelenforcement.View;

public class FIR {

    public String  complainNo, location, crime, date;

    public FIR(String complainNo, String location, String crime, String date) {
        this.complainNo = complainNo;
        this.location = location;
        this.crime = crime;
        this.date = date;
    }

    public FIR()
    {
        this.complainNo = "";
        this.location = "";
        this.crime = "";
        this.date = "";
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
}
