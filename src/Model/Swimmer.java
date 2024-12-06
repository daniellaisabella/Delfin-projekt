package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<String> competitiveResults;

    public Swimmer(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
        this.competitiveResults = new ArrayList<>();
    }

    public List<String> getCompetitiveResults() {
        return competitiveResults;
    }

    public void addCompetitiveResult(String result) {
        competitiveResults.add(result);
    }
}
