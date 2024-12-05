package Model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Swimmer extends Member {
    private String name;
    private int age;
    private String phoneNumber;
    private EnumSet<SwimStroke> activeStrokes;
    private List<TrainingResults> trainingResults;
    private List<CompetitiveResults> competitiveResults;
    private String team;

    public Swimmer(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.activeStrokes = EnumSet.noneOf(SwimStroke.class);
        assignTeam();
    }
    private void assignTeam() {
        if (age >= 0 && age < 18) {
            team = "Junior";
        } else if (age >= 18 && age < 60) {
            team = "Senior";
        } else {
            team = "Pensionist"; // For swimmers 60 and above
        }
    }
    //----------------------------------------
    public void addTrainingResults(TrainingResults result) {
        trainingResults.add(result);
    }
    //----------------------------------------

    public void addActiveStroke(SwimStroke stroke) {
        activeStrokes.add(stroke);
    }
    //----------------------------------------

    public void addCompetitiveResults(CompetitiveResults result) {
        competitiveResults.add(result);
    }

    public boolean hasAttendedTournament() {
        return !competitiveResults.isEmpty();
    }
    // Getters and setters
    //----------------------------------------
    // Getters and setters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public EnumSet<SwimStroke> getActiveStrokes() {
        return activeStrokes;
    }
    public List<TrainingResults> getTrainingResults() {
        return trainingResults;
    }
    public List<CompetitiveResults> getCompetitiveResults(){
        return competitiveResults; // Return the list of competitiveResults;
    }
}




