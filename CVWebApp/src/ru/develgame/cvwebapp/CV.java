/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.develgame.cvwebapp;

/**
 *
 * @author pasca
 */
public class CV {
    private static String name;
    private static String email;
    private static String phone;
    private static String birthDay;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CV.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        CV.email = email;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        CV.phone = phone;
    }

    public static String getBirthDay() {
        return birthDay;
    }

    public static void setBirthDay(String birthDay) {
        CV.birthDay = birthDay;
    }
    
    
}
