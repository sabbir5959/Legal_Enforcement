package com.example.legelenforcement.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check_mobile {
    public static boolean isValid(String s)
    {
        Pattern p = Pattern.compile("(01)?[6-9][0-9]{8}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }
}
