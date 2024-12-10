package Model;

import java.time.LocalDate;

public class CompetitiveResults {
    private final String location;
    private final int placement;
    private final double timePerformance;
    private final LocalDate date;
    private final SwimStroke stroke;

    public CompetitiveResults(String location, int placement, double timePerformance, LocalDate date, SwimStroke stroke) {
        this.location = location;
        this.placement = placement;
        this.timePerformance = timePerformance;
        this.date = date;
        this.stroke = stroke;
    }

    public String getLocation() {
        return location;
    }

    public int getPlacement() {
        return placement;
    }

    public double getTimePerformance() {
        return timePerformance;
    }

    public LocalDate getDate() {
        return date;
    }

    public SwimStroke getStroke() {
        return stroke;
    }
}

