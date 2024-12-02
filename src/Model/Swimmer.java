package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<CompetitiveResults> competitiveResults;

    // Constructor updated to use int age instead of LocalDate
    public Swimmer(String name, String surName, int age, boolean isActive,
                   String address, int phoneNumber, String email, boolean isCompetitive) {
        super(name, surName, age, address, phoneNumber, email, isActive, isCompetitive); // Updated super call
        this.competitiveResults = new ArrayList<>();
    }

    // Get the list of competitive results
    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }

    // Add a new competitive result
    public void addCompetitiveResult(CompetitiveResults result) {
        this.competitiveResults.add(result);
    }

    // Override toString() to include competitive results
    @Override
    public String toString() {
        return "Name: " + getName() +
                ", Age: " + getAge() +
                ", Active: " + isActive() +
                ", Competitive: " + isCompetitive() +
                ", Competitive Results: " + competitiveResults;
    }
}
