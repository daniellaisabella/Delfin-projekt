package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompetitiveResults {
    private String tournament;
    private double timePerformance;
    private int placement;

    private LocalTime time;
    private LocalDate date;
    private SwimStroke stroke;
    private boolean isTournament;
    private String location; // Only for tournaments
     // Only for tournaments

    public CompetitiveResults(LocalTime time, LocalDate date, SwimStroke stroke,
                              boolean isTournament, String location, Integer placement) {
        this.time = time;
        this.date = date;
        this.stroke = stroke;
        this.isTournament = isTournament;
        this.location = location;
        this.placement = placement;
    }
    public String getTournament() {
        return tournament;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePerformance() {
        return timePerformance;
    }

    public int getPlacement() {
        return placement;
    }

    // Display competition result details
    @Override
    public String toString() {
        return "Swim Stroke = " + swimStroke + ", Time = " + timePerformance + ", Placement = " + placement;
    }
}

