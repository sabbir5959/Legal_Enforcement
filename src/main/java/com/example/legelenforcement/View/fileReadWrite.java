package com.example.legelenforcement.View;

public class fileReadWrite {
    String Fname;
    String Name;
    String Father;
    String Mother;
    String Mobile;
    String Email;
    String Address;

    public fileReadWrite(String Fname, String Name, String Father, String Mother, String Mobile, String Email, String Address) {
        this.Fname = Fname;
        this.Name = Name;
        this.Father = Father;
        this.Mother = Mother;
        this.Mobile = Mobile;
        this.Email = Email;
        this.Address = Address;
    }
    public fileReadWrite() {
        this.Fname = "";
        this.Name = "";
        this.Father = "";
        this.Mother = "";
        this.Mobile = "";
        this.Email = "";
        this.Address = "";
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFather() {
        return Father;
    }

    public void setFather(String father) {
        Father = father;
    }

    public String getMother() {
        return Mother;
    }

    public void setMother(String mother) {
        Mother = mother;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
