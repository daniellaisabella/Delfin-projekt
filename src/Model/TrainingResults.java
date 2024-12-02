package Model;

public class TrainingResults {
    private String swimStroke;
    private double timePerformance;
    private String discipline;
    private double time;

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


    //Result method ????
    public void addResult(String discipline, double time) {
        this.discipline = discipline;
        this.time = time;
    }


    // Display results details
    @Override
    public String toString() {
        return "stroke style = " + swimStroke + ", time = " + timePerformance;
    }
}

