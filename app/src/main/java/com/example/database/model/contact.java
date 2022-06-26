package com.example.database.model;

public class contact {

    private static String phonenumber;
    private static String name;
    private static String address;
    private int id;

    public contact(String name, String phonenumber,String address) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public contact(int id, String name, String phonenumber,String address) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public contact(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        contact.address = address;
    }
}
