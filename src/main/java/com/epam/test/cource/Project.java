package com.epam.test.cource;

public class Project {

    public String name;

    public Developer teamLead;

    public Project(String name, Developer teamLead) {
        this.name = name;
        this.teamLead = teamLead;
    }

    public Project() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Developer teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", teamLead=" + teamLead +
                '}';
    }
}
