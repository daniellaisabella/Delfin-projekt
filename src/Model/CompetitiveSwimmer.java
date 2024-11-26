package Model;
import java.util.ArrayList;
import java.util.List;

public class CompetitveSwimmer extends Member {
    private List<String> SwimmingDisciplines;
    private List<TrainingResults> trainingResults;
    private List<CompetitiveResults> competitonResults;
    private List<SwimDisciplines> swimDisciplines;
    private ArrayList<Object> competitivenResults;


    public void CompetitionSwimmer(String name, String surName int age, boolean isActive, String swimCategory) {
        super(name, surName, age, isActive, false, swimDisciplines);
        this.swimDisciplines = new ArrayList<>();
        this.trainingResults = new ArrayList<>();
        this.competitivenResults = new ArrayList<>();

    public void addDiscipline(String swimDiscipline) {
        if(!swimDisciplines.contains(swimDiscipline);
        swimDisciplines.add(swimDisciplines);
        }
    }

public void addTrainingResult(String swimDiscipline, double time) {
    trainingResults.add(new TrainingResults(swimDiscipline, time));
}

public void addCompetitionResult(String discipline, double time, int placement) {
    competitiveResults.add(new CompetetiveResult(discipline, time, placement));
}

public List SwimDisciplines getSwimDisciplines() {
    return swimDisciplines;
}

public List TrainingResults getTrainingResults() {
    return trainingResults;
}

public List<CompetitiveResult> getCompetitionResults() {
    return competitiveResults;
}



    // Display swimmer details
@Override
public String toString() {
            return "Name= " + getName() + ", Age = " + getAge() + ", Disciplines = " + swimDisciplines + ", Training result = " + trainingResults +
                    ", competitiveResults=" + competitiveResults;
        }
    }





