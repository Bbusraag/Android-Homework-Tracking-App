package com.example.homeworkapplication.model;

import java.util.ArrayList;

public class DbHelper {
    private static ArrayList<User> Db;

    public DbHelper() {
        Db= new ArrayList<>();
    }
    public boolean AddUser(User user){
        Db.add(user);
        return true;
    }
    public static boolean Login(String email,String password){
        boolean result=false;
        for(User user:Db){
            if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
                result=true;
                break;
            }
        }
        return result;
    }
    public ArrayList<User>GetAllUser(){
        return Db;
    }
}
