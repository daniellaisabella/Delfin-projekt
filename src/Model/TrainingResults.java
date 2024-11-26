package Model;

public class TrainingResults {
    private String discipline;
    private double time;

    public void trainingResults(String discipline, double time) {
        this.discipline = discipline;
        this.time = time;
    }

    public String getDiscipline() {
        return discipline;
    }

    public double getTime() {
        return time;
    }

    // Display results details
    @Override
    public String toString() {
        return "discipline = " + discipline + ", time = " + time;
    }
}

