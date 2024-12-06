/*package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private List<String> swimStrokes; // List of stroke styles
    private List<TrainingResult> trainingResults; // List of training results
    private List<CompetitiveResults> competitiveResults; // List of competition results

    // Constructor for CompetitiveSwimmer
    public CompetitiveSwimmer(String name, String surName, int age, boolean isActive) {
        super(name, surName, age, isActive); // Updated to accept age as int
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
    public void addTrainingResult(String swimStrokes, double timePerformance, int placement) {
        trainingResults.add(new TrainingResult(swimStrokes, timePerformance, placement));
    }


    //-----------------Getters---------------

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
