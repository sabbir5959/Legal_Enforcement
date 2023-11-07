package com.example.legelenforcement.Controller;


public class Case {

    private String complainid;
    private String typeofcrime;
    private String dateofcrime;
    private String locationofcrime;

    private String status;

    public Case(String complainid, String typeofcrime, String dateofcrime, String locationofcrime, String status) {
        this.complainid = complainid;
        this.typeofcrime = typeofcrime;
        this.dateofcrime = dateofcrime;
        this.locationofcrime = locationofcrime;
        this.status = status;
    }

    public void setComplainid(String complainid) {
        this.complainid = complainid;
    }

    public void setTypeofcrime(String typeofcrime) {
        this.typeofcrime = typeofcrime;
    }

    public void setDateofcrime(String dateofcrime) {
        this.dateofcrime = dateofcrime;
    }

    public void setLocationofcrime(String locationofcrime) {
        this.locationofcrime = locationofcrime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplainid() {
        return complainid;
    }

    public String getTypeofcrime() {
        return typeofcrime;
    }

    public String getDateofcrime() {
        return dateofcrime;
    }

    public String getLocationofcrime() {
        return locationofcrime;
    }

    public String getStatus() {
        return status;
    }
}