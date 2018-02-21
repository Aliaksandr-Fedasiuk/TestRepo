package com.epam.test.cource;

import java.util.List;

public class BioReactor {

    private static Human instance = new Citizen();

    public static Human getHuman(String type) {

        if (type.equals("SuperHero")) {
            return new SuperHero();
        } else {
            return new Citizen();
        }
    }

    public BioReactor() {

    }

    public List<String> emailAdresses;

    public void setEmailAdresses(List<String> emailAdresses) {
        this.emailAdresses = emailAdresses;
    }

    String type;
    public BioReactor(String type) {
        this.type = type;
    }

    public Human getNewHuman(String type) {
        System.out.println("Type: " + type);
        if (type.equals("SuperHero")) {
            return new SuperHero();
        } else {
            return new Citizen();
        }
    }

    public static Human createInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "BioReactor{" +
                "emailAdresses=" + emailAdresses +
                ", type='" + type + '\'' +
                '}';
    }
}
