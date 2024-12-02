package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<CompetitiveResults> competitiveResults;

    public Swimmer(String name, String surName, LocalDate birthDate, boolean isActive,
                   String address, int phoneNumber, String email, boolean isCompetitive) {
        super(name, surName, birthDate, address, phoneNumber, email, isActive, isCompetitive);
        competitiveResults = new ArrayList<>();
    }

    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }

    public void addCompetitiveResult(CompetitiveResults result) {
        this.competitiveResults.add(result);
    }
}
