package com.example.legelenforcement.View;

import com.example.legelenforcement.Forgot_pass;

public class log_in {

    String user;
    String password;


    public log_in(String user, String password) {
        this.user=user;
        this.password=password;
    }
    public log_in()
    {
        this.user = "";
        this.password = "";
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
