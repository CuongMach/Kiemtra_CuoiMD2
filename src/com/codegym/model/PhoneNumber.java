package com.codegym.model;

public class PhoneNumber {
    private String id;
    private String group;
    private String name;
    private String number;
    private String gender;
    private String address;
    private String email;

    public PhoneNumber(){

    }

    public PhoneNumber(String id, String name, String number, String gender, String address, String group, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.address = address;
        this.group = group;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.group + ", " + this.id + ", " + this.name + ", " + this.number + ", " + this.gender + ", " + this.address + ", " + this.email;
    }
}
