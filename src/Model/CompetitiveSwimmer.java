import Model.CompetitiveResults;
import Model.Member;
import Model.TrainingResults;

import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private List<String> swimDisciplines; // List of swimming disciplines
    private List<TrainingResults> trainingResults; // List of training results
    private List<CompetitiveResults> competitiveResults; // List of competition results

    // Constructor for CompetitiveSwimmer
    public CompetitiveSwimmer(String name, String surName, int age, boolean isActive) {
        super(name, surName,  age, isActive);
        this.swimDisciplines = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.competitiveResults = new ArrayList<>();
    }

    // Add a swim discipline
    public void addDiscipline(String swimDiscipline) {
        if (!swimDisciplines.contains(swimDiscipline)) {
            swimDisciplines.add(swimDiscipline);
        }
    }

    // Add a competition result for a specific discipline
    public void addCompetitionResult(String discipline, double time, int placement) {
        competitiveResults.add(new CompetitiveResults(discipline, time, placement));
    }

    // Get the list of swim disciplines
    public List<String> getSwimDisciplines() {
        return swimDisciplines;
    }

    // Get the list of training results
    public List<TrainingResults> getTrainingResults() {
        return trainingResults;
    }

    // Get the list of competition results
    public List<CompetitiveResults> getCompetitionResults() {
        return competitiveResults;
    }

    // Override toString() to display swimmer details
    @Override
    public String toString() {
        return
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", swimDisciplines=" + swimDisciplines +
                ", trainingResults=" + trainingResults +
                ", competitiveResults=" + competitiveResults +
                '}';
    }
}
