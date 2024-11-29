package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private List<String> swimStrokes; // List of swimming disciplines
    private List<TrainingResults> trainingResults; // List of training results
    private List<CompetitiveResults> competitiveResults; // List of competition results

    // Constructor for CompetitiveSwimmer
    public CompetitiveSwimmer(String name, String surName, LocalDate age, boolean isActive) {
        super(name, surName,age, isActive);
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

    // Add a competition result for a specific discipline
    public void addCompetitionResult(String swimStrokes, double timePreformance, int placement) {
        competitiveResults.add(new CompetitiveResults(swimStrokes, timePreformance, placement));
    }

    // Get the list of swim disciplines
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
        return "name = " + getName() + ", age = " + getAge() + ", swimStrokes = " + swimStrokes + ", trainingResults = " + trainingResults
        + ", competitiveResults=" + competitiveResults;
    }
}





