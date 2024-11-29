package Model;

public class TrainingResults {
    private String swimStroke;
    private double timePreformance;

    public void trainingResults(String swimStroke, double timePreformance) {
        this.swimStroke = swimStroke;
        this.timePreformance = timePreformance;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePreformance() {
        return timePreformance;
    }


    //Result method ????
    public void addResult(String discipline, double time) {
        this.discipline = discipline;
        this.time = time;
    }


    // Display results details
    @Override
    public String toString() {
        return "discipline = " + swimStroke + ", time = " + timePreformance;
    }
}

