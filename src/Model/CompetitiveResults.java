package Model;

public class CompetitiveResults {
    private String tournament;
    private String swimStroke;
    private double timePerformance;
    private int placement;

    public CompetitiveResults(String tournament, String swimStroke, double timePerformance, int placement) {
        this.tournament = tournament;
        this.swimStroke = swimStroke;
        this.timePerformance = timePerformance;
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

