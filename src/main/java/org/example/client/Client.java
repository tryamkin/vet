package org.example.client;

import org.example.Main;

public class Client {

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    //тут поля паблик но так никто не делает - надо прайват и гетеры  как выше и тогда меняем код в мейн
    public String firstName;

    //пример конструктора
//    public Client(String firstName, String lastName, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//    }

    public String lastName;
    public String email;

   //Обращаемся к полям мейн класса из методов
    public void getFromMain() {
       String s =  Main.PASSWORD;
    }

    public String getStringFromMain() {
        String s =  Main.PASSWORD;
        return s;
    }

}
