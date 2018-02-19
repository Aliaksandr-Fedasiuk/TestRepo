package com.epam.test.cource;

public class BioReactor {

    public static Human getHuman(String type) {

        if (type.equals("SuperHero")) {
            return new SuperHero();
        } else {
            return new Citizen();
        }
    }
}
