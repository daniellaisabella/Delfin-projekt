package Model;

import java.time.LocalDate;

public class TrainingResults {
    private LocalDate date;
    private double timePerformance;
    private SwimStroke stroke;

    public TrainingResults(LocalDate date, double timePerformance, SwimStroke stroke) {
        this.timePerformance = timePerformance;
        this.date = date;
        this.stroke = stroke;
    }
    // Getters
    public LocalDate getDate() {
        return date;
    }
    public double getTimePerformance() {
        return timePerformance;
    }
    public SwimStroke getStroke() {
        return stroke;
    }
}
