package com.example.legelenforcement.View;

import com.example.legelenforcement.Model;

public class person extends Model {
    String tname ;
    String tuser_name ;
    String tfather ;
    String tmother ;
    String temail;
    String taddress;
    String tpass;
    String tconfirmPass;
    String tbirthDate ;
    String tmobile;
    String tgender;
    String tmarry;
    String timage;



    public person(String tname, String tuser_name, String tfather, String tmother,String tmobile, String temail, String taddress, String tbirthDate, String tpass,String tgender, String tmarry, String timage) {
        super(tname, tuser_name);
        this.tname = tname;
        this.tuser_name = tuser_name;
        this.tfather = tfather;
        this.tmother = tmother;
        this.temail = temail;
        this.taddress = taddress;
        this.tbirthDate = tbirthDate;
        this.tmobile = tmobile;
        this.tpass = tpass;
        this.tgender = tgender;
        this.tmarry = tmarry;
        this.timage = timage;
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public String getTmarry() {
        return tmarry;
    }

    public void setTmarry(String tmarry) {
        this.tmarry = tmarry;
    }

    public String getTimage() {
        return timage;
    }

    public void setTimage(String timage) {
        this.timage = timage;
    }

    public person()
    {
        super("" , "");
        this.tname = "";
        this.tuser_name = "";
        this.tfather = "";
        this.tmother = "";
        this.temail = "";
        this.taddress = "";
        this.tpass = "";
        this.tbirthDate = "";
        this.tmobile = "";
        this.timage = "";
        this.tgender="";
        this.tmarry="";
    }

    public String getTconfirmPass() {
        return tconfirmPass;
    }

    public void setTconfirmPass(String tconfirmPass) {
        this.tconfirmPass = tconfirmPass;
    }

    public String getTname() {return tname;}

    public void setTname(String tname) {this.tname = tname;}

    public String getTuser_name() {return tuser_name;}

    public void setTuser_name(String tuser_name) {this.tuser_name = tuser_name;}

    public String getTfather() {return tfather;}

    public void setTfather(String tfather) {this.tfather = tfather;}

    public String getTmother() {return tmother;}

    public void setTmother(String tmother) {this.tmother = tmother;}

    public String getTemail() {return temail;}

    public void setTemail(String temail) {this.temail = temail;}

    public String getTaddress() {return taddress;}

    public void setTaddress(String taddress) {this.taddress = taddress;}

    public String getTpass() {return tpass;}

    public void setTpass(String tpass) {this.tpass = tpass;}
    public String getTbirthDate() {return tbirthDate;}

    public void setTbirthDate(String tbirthDate) {this.tbirthDate = tbirthDate;}

    public String getTmobile() {return tmobile;}

    public void setTmobile(String tmobile) {this.tmobile = tmobile;}
}
