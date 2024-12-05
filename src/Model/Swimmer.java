package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<CompetitiveResults> competitiveResults;

    public Swimmer(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType);
        this.competitiveResults = new ArrayList<>();
    }

    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }
}
