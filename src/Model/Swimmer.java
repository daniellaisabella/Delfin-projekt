package Model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends Member {
    private List<CompetitiveResults> competitiveResults;

    public Swimmer(String name, String surName, int age, String address, int phoneNumber, String email, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, email, membershipType, memberType);
        this.competitiveResults = new ArrayList<>();
    }

    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }
}
