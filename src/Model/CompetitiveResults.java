package Model;

public class CompetitiveResults {
    private String swimDiscipline;
    private double time;
    private int placement;

    public CompetitiveResults(String swimDiscipline, double time, int placement) {
        this.swimDiscipline = swimDiscipline;
        this.time = time;
        this.placement = placement;
    }

    public String getSwimDiscipline() {
        return swimDiscipline;
    }

    public double getTime() {
        return time;
    }

    public int getPlacement() {
        return placement;
    }

    // Display competition result details
    @Override
    public String toString() {
        return "Discipline = " + swimDiscipline + ", Time = " + time + ", Placement = " + placement;
    }
}

