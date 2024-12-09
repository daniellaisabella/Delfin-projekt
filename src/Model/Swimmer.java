package Model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Swimmer extends Member {
    private String name;
    private int age;
    private String phoneNumber;
    private Team team;
    private List<SwimStroke> activeStrokes = new ArrayList<>();

    public Swimmer(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
        this.team = (age < 18) ? Team.JUNIOR : Team.SENIOR;
    }
    //------------------Active Stroke--------------------
    public void addActiveStroke(SwimStroke stroke) {
        if (!activeStrokes.contains(stroke)) {
            activeStrokes.add(stroke);
        }
    }
    public boolean hasActiveStroke(SwimStroke stroke) {
        return activeStrokes.contains(stroke);
    }
    public List<SwimStroke> getActiveStrokes() {
        return activeStrokes;
    }


    //---------------------------- Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public Team getTeam() {
        return team;
    }

}





