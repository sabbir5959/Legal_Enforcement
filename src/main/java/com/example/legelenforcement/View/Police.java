package com.example.legelenforcement.View;


public class Police {
    String ID;
    String BatchNo;
    String Name;
    String Rank;
    String JoinDate;

    public String getID() {
        return ID;
    }

    public String getBatchNo() {
        return BatchNo;
    }

    public String getName() {
        return Name;
    }

    public String getRank() {
        return Rank;
    }

    public String getJoinDate() {
        return JoinDate;
    }

    public Police(String ID, String batchNo, String name, String rank, String joinDate) {
        this.ID = ID;
        this.BatchNo = batchNo;
        this.Name = name;
        this.Rank = rank;
        this.JoinDate = joinDate;
    }
}