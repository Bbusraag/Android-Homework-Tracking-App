package com.example.homeworkapplication.model;

public class student {
    String Name;
    String Surname;
    String Department;
    int Image;

    public student(String name, String surname, String department, int image) {
        Name = name;
        Surname = surname;
        Department = department;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}

