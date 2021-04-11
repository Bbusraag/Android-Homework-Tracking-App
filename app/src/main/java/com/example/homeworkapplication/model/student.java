package com.example.homeworkapplication.model;

public class student {
String Name;
String Surname;
int image;

    public student(String name, String surname, int image) {
        Name = name;
        Surname = surname;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

