package Model;

public class CompetitiveResults {
    private String swimDiscipline;
    private double preformanceTime;
    private int placement;

    public CompetitiveResults(String swimDiscipline, double preformanceTime, int placement) {
        this.swimDiscipline = swimDiscipline;
        this.preformanceTime = preformanceTime;
        this.placement = placement;
    }

    public String getSwimDiscipline() {
        return swimDiscipline;
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
        return "Discipline = " + swimDiscipline + ", Time = " + preformanceTime + ", Placement = " + placement;
    }
}

