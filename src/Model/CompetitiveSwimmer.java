package Model;

import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private List<String> swimStrokes; // List of stroke styles
    private List<TrainingResults> trainingResults; // List of training results
    private List<CompetitiveResults> competitiveResults; // List of competition results

    // Constructor for CompetitiveSwimmer
    public CompetitiveSwimmer(String name, String surName, int age, String membershipType, String address, String phoneNumber, String mail, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType); // Updated super call
        this.swimStrokes = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.competitiveResults = new ArrayList<>();
    }

    // Add a swim stroke
    public void addSwimStroke(String swimStroke) {
        if (!swimStrokes.contains(swimStroke)) {
            swimStrokes.add(swimStroke);
        }
    }

    // Add a competition result for a specific stroke style
    public void addCompetitionResult(String swimStroke, double timePerformance, int placement) {
        competitiveResults.add(new CompetitiveResults(swimStroke, timePerformance, placement));
    }

    // Get the list of swim stroke styles
    public List<String> getSwimStrokes() {
        return swimStrokes;
    }

    // Get the list of training results
    public List<TrainingResults> getTrainingResults() {
        return trainingResults;
    }

    // Get the list of competition results
    public List<CompetitiveResults> getCompetitionResults() {
        return competitiveResults;
    }

    // Override toString() to display swimmer details
    @Override
    public String toString() {
        return String.format(
                "Name: %s %s, Age: %d, Membership Type: %s, Member Type: %s, Address: %s, Phone: %d, Email: %s, Swim Strokes: %s, Training Results: %s, Competitive Results: %s",
                getName(), getSurname(), getAge(), getMembershipType(), getMemberType(), getAddress(), getPhoneNumber(), getMail(), swimStrokes, trainingResults, competitiveResults
        );
    }
}
