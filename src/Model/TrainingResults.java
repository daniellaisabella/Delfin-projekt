package Model;

public class TrainingResults {
    private String swimStroke;
    private double timePerformance;
    private int placement;

    public TrainingResults(String swimStroke, double timePerformance, int placement) {
        this.swimStroke = swimStroke;
        this.timePerformance = timePerformance;
        this.placement = placement;
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
    //Result method ????
//    public void addResult(String discipline, double time) {
//        this.discipline = discipline;
//        this.time = time;
//    }


    // Display results details
    @Override
    public String toString() {
        return "stroke style = " + swimStroke + ", time = " + timePerformance + ", placement = " + placement;
    }
}

