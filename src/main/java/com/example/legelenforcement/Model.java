package com.example.legelenforcement;

abstract public class Model
{
    private String tfull, tfullN;

    public Model(String tfull, String tfullN) {
        this.tfull = tfull;
        this.tfullN = tfullN;
    }

    public String getTfull() {
        return tfull;
    }

    public void setTfull(String tfull) {
        this.tfull = tfull;
    }

    public String getTfullN() {
        return tfullN;
    }

    public void setTfullN(String tfullN) {
        this.tfullN = tfullN;
    }
}

