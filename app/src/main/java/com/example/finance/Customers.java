package com.example.finance;

public class Customers {
    String serialnumber;
    String name;
    String password;
    String date;
    String dateofeveryweek;

    public Customers(String serialnumber, String name, String password, String date, String dateofeveryweek) {
        this.serialnumber = serialnumber;
        this.name = name;
        this.password = password;
        this.date = date;
        this.dateofeveryweek = dateofeveryweek;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getDateofeveryweek() {
        return dateofeveryweek;
    }
}
