package com.example.legelenforcement;

public class Model
{
    private static Model model;



    public static synchronized Model get_model()
    {
        if(model==null) model=new Model();
        return model;
    }


}

