package com.example.legelenforcement.View;

public class Criminal implements Criminal_interface{

    private String idcriminal_list;
    private String Criminal_name;
    private String  Crime;

    public Criminal(String idcriminal_list, String criminal_name, String crime) {
        this.idcriminal_list = idcriminal_list;
        Criminal_name = criminal_name;
        Crime = crime;
    }

    public void setIdcriminal_list(String idcriminal_list) {
        this.idcriminal_list = idcriminal_list;
    }

    public void setCriminal_name(String criminal_name) {
        Criminal_name = criminal_name;
    }

    public void setCrime(String crime) {
        Crime = crime;
    }

    public String getIdcriminal_list() {
        return idcriminal_list;
    }

    public String getCriminal_name() {
        return Criminal_name;
    }

    public String getCrime() {
        return Crime;
    }


}
