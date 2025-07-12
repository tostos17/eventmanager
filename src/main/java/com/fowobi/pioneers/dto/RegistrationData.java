package com.fowobi.pioneers.dto;

import java.util.Date;

public class RegistrationData {
    private String title;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String childFirstname;
    private String childLastname;
    private String dob;
    private String gender;
    private String med;

    public RegistrationData() {
    }

    public RegistrationData(String title, String firstname, String lastname, String phone, String email, String childFirstname, String childLastname, String dob, String gender, String med) {
        this.title = title;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.childFirstname = childFirstname;
        this.childLastname = childLastname;
        this.dob = dob;
        this.gender = gender;
        this.med = med;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChildFirstname() {
        return childFirstname;
    }

    public void setChildFirstname(String childFirstname) {
        this.childFirstname = childFirstname;
    }

    public String getChildLastname() {
        return childLastname;
    }

    public void setChildLastname(String childLastname) {
        this.childLastname = childLastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMed() {
        return med;
    }

    public void setMed(String med) {
        this.med = med;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
