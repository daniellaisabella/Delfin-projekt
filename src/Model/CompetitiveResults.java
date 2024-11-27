package Model;

public class CompetitiveResults {
    private String swimStroke;
    private double timePreformance;
    private int placement;

    public CompetitiveResults(String swimStroke, double timePreformance, int placement) {
        this.swimStroke = swimStroke;
        this.timePreformance = timePreformance;
        this.placement = placement;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePreformance() {
        return timePreformance;
    }

    public int getPlacement() {
        return placement;
    }

    // Display competition result details
    @Override
    public String toString() {
        return "Discipline = " + swimStroke + ", Time = " + timePreformance + ", Placement = " + placement;
    }
}

