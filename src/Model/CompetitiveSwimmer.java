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
    public CompetitiveSwimmer(String name, String surName, int age, boolean isActive, boolean activeStrokes, int []butterflyTime,String butterflyDate,boolean activeButterfly,
                              int [] backstrokeTime, String backstrokeDate,boolean activeBackstroke, int [] breaststrokeTime, String breaststrokeDate,boolean activeBreaststroke,
                              int [] crawlTime, String crawlDate,boolean activeCrawl, int[] backCrawlTime, String backCrawlDate,boolean activeBackCrawl) {

        super(name, surName,age, isActive);
        this.swimStrokes = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.competitiveResults = new ArrayList<>();
        this.butterflyTime = butterflyTime;
        this.butterflyDate = butterflyDate;
        this.activeButterfly = activeButterfly;
        this.backstrokeTime = backstrokeTime;
        this.backstrokeDate = backstrokeDate;
        this.activeBackstroke = activeBackstroke;
        this.breaststrokeTime = breaststrokeTime;
        this.breaststrokeDate = breaststrokeDate;
        this.activeBreaststroke = activeBreaststroke;
        this.crawlTime = crawlTime;
        this.crawlDate = crawlDate;
        this.activeCrawl = activeCrawl;
        this.backCrawlTime = backCrawlTime;
        this.backCrawlDate = backCrawlDate;
        this.activeBackCrawl = activeBackCrawl;
    }
// ...

    @Override
    public String toString() {
        return "name = " + getName() + ", age = " + getAge() + ", swimStrokes = " + swimStrokes + ", trainingResults = " + trainingResults
                + ", competitiveResults=" + competitiveResults;
    }

    // Add the new method here
    public List<String> getActiveSwimStrokes() {
        List<String> activeStrokes = new ArrayList<>();
        if (activeButterfly) {
            activeStrokes.add("Butterfly");
        }
        if (activeBackstroke) {
            activeStrokes.add("Backstroke");
        }
        if (activeBreaststroke) {
            activeStrokes.add("Breaststroke");
        }
        if (activeCrawl) {
            activeStrokes.add("Crawl");
        }
        if (activeBackCrawl) {
            activeStrokes.add("Back Crawl");
        }
        return activeStrokes;
    }
    // Add a swim stroke
    public void addSwimStroke(String swimStroke) {
        if (!swimStrokes.contains(swimStroke)) {
            swimStrokes.add(swimStroke);
        }
    }

    // Add a competition result for a specific stroke style
    public void addCompetitiveResult(String tournament, String swimStrokes, double timePerformance, int placement) {
        competitiveResults.add(new CompetitiveResults(tournament,swimStrokes, timePerformance, placement));
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





