package com.example.legelenforcement.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check_email {
    public static void main(String [] args){
        String e1 = "sabbir@gmail.com";
        String e2 = "sabbirgmail.com";

        System.out.println("e1 = "+isEmailValid(e1));
        System.out.println("e2 = "+isEmailValid(e2));
    }
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9.]+$";

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

}
