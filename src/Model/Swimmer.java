package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<CompetitiveResults> competitiveResults;
    private List <TrainingResults> trainingResults;

    public Swimmer(String name, String surName, int age, boolean isActive,
                   String address, int phoneNumber, String email, boolean isCompetitive) {
        super(name, surName, age, address, phoneNumber, email, isActive, isCompetitive);
        this.competitiveResults = new ArrayList<>();
        this.trainingResults = new ArrayList<>();

    }

    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }
   public List<TrainingResults> getTrainingResults() {
        return trainingResults;

    };

    }



