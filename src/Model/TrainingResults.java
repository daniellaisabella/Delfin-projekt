package Model;

public class TrainingResults {
    private String swimStroke;
    private double timePerformance;

    public void trainingResults(String swimStroke, double timePerformance) {
        this.swimStroke = swimStroke;
        this.timePerformance = timePerformance;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePerformance() {
        return timePerformance;
    }

    // Display results details
    @Override
    public String toString() {
        return "stroke style = " + swimStroke + ", time = " + timePerformance;
    }
}

