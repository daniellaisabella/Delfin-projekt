package Model;

public class CompetitiveResults {
    private String swimStroke;
    private double preformanceTime;
    private int placement;

    public CompetitiveResults(String swimStroke, double preformanceTime, int placement) {
        this.swimStroke = swimStroke;
        this.preformanceTime = preformanceTime;
        this.placement = placement;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getPreformanceTime() {
        return preformanceTime;
    }

    public int getPlacement() {
        return placement;
    }

    // Display competition result details
    @Override
    public String toString() {
        return "Discipline = " + swimStroke + ", Time = " + preformanceTime + ", Placement = " + placement;
    }
}

