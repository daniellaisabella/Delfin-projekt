package Model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Swimmer extends Member {
    private String name;
    private int age;
    private String phoneNumber;
    private Team team;
    private List<TrainingResults> trainingResults = new ArrayList<>();
    private List<CompetitiveResults> competitiveResults = new ArrayList<>();
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
    //---------------------Has attended a competition----------------
    public boolean hasAttendedCompetition() {
        return !competitiveResults.isEmpty();
    }
    public double getBestTime(SwimStroke stroke) {
        double bestTime = Double.MAX_VALUE;
        for (CompetitiveResults result : competitiveResults) {
            if (result.getStroke() == stroke && result.getTimePerformance() < bestTime) {
                bestTime = result.getTimePerformance();
            }
        }
        return bestTime;
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
    //---------------------Training Results--------------------------
    public List<TrainingResults> getTrainingResults() {
        return trainingResults;
    }
    public void addTrainingResults(TrainingResults results) {
        trainingResults.add(results);
    }
    //----------------------------Competitive Results------------------------
    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }
    public void addCompetitiveResult(CompetitiveResults result) {
        competitiveResults.add(result);
    }
}





