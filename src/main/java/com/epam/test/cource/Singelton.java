package com.epam.test.cource;

public class Singelton {

    private static Singelton instance = new Singelton();

    private Singelton() {
    }

    public static Singelton createInstance() {
        return instance;
    }

}
