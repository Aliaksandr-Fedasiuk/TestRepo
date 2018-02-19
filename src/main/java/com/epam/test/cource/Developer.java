package com.epam.test.cource;

public class Developer {

    public String name;
    public String skill;
    private int level;
    private boolean isCoffeConsumer;

    public Developer(String name, String skill, int level, boolean isCoffeConsumer) {
        this.name = name;
        this.skill = skill;
        this.level = level;
        this.isCoffeConsumer = isCoffeConsumer;
    }

    public Developer() {

    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isCoffeConsumer() {
        return isCoffeConsumer;
    }

    public void setCoffeConsumer(boolean coffeConsumer) {
        isCoffeConsumer = coffeConsumer;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", isCoffeConsumer=" + isCoffeConsumer +
                '}';
    }
}
