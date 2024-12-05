package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private List<String> swimStrokes; // List of stroke styles
    private List<TrainingResults> trainingResults; // List of training results
    private List<CompetitiveResults> competitiveResults; // List of competition results




    private int [] butterflyTime;
    private String butterflyDate;
    private boolean activeButterfly;

    private int [] backstrokeTime;
    private String backstrokeDate;
    private boolean activeBackstroke;

    private int [] breaststrokeTime;
    private String breaststrokeDate;
    private boolean activeBreaststroke;

    private int [] crawlTime;
    private String crawlDate;
    private boolean activeCrawl;

    private int[] backCrawlTime;
    private String backCrawlDate;
    private boolean activeBackCrawl;

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
        trainingResults.add(new TrainingResults(swimStrokes, timePerformance, placement));
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
        return "Name: " + getName() + ", Age: " + getAge() + ", Active: " + isActive() +
                ", Swim Strokes: " + swimStrokes + ", Training Results: " + trainingResults +
                ", Competitive Results: " + competitiveResults;
    }
}





