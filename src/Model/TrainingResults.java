package Model;

import java.time.LocalDate;

class TrainingResult {
    private LocalDate date;
    private double timePerformance;
    private SwimStroke stroke;

    public TrainingResult(LocalDate date, double timePerformance, SwimStroke stroke) {
        this.date = date;
        this.timePerformance = timePerformance;
        this.stroke = stroke;
        this.location = location;
        this.placement = placement;
        this.timePerformance = timePerformance;
        this.date = date;
        this.stroke = stroke;
    }
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
