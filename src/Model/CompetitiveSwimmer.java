
package Model;

import java.util.ArrayList;
import java.util.List;

public class CompetitiveSwimmer extends Member {
    private String name;
    private String surname;
    private int age;
    private String address;
    private String phoneNumber;
    private String mail;
    private MembershipType membershipTypeEnum;
    private Team team;
    private String tournamentAttendance;
    private List<TrainingResults> trainingResults = new ArrayList<>();
    private List<CompetitiveResults> competitiveResults = new ArrayList<>();
    private List<SwimStroke> activeStrokes = new ArrayList<>();

    public CompetitiveSwimmer(String name, String surname, int age, String address, String phoneNumber, String mail, Team team, MembershipType membershipType,String tournamentAttendance) {
        super(name, surname, age, address, phoneNumber, mail, membershipType.toString(), "competition");
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.tournamentAttendance = tournamentAttendance;
        // Initialize other fields as needed
        this.team = (age < 18) ? Team.JUNIOR : Team.SENIOR;

        //-------------------Membership type-------------------

        if (membershipType != MembershipType.ACTIVE && membershipType != MembershipType.PASSIVE) {
            throw new IllegalArgumentException("Invalid membership type. Must be ACTIVE or PASSIVE.");
        }
        this.membershipTypeEnum = membershipType;
    }

    public String getTournamentAttendance() {
        return tournamentAttendance;
    }

    //------------------Active Stroke--------------------
    public void addActiveStroke(SwimStroke stroke) {
        if (!activeStrokes.contains(stroke)) {
            activeStrokes.add(stroke);
        }
    }
    public boolean hasActiveStroke(SwimStroke stroke) {
        return activeStrokes.contains(stroke);
    }
    public List<SwimStroke> getActiveStrokes() {
        return activeStrokes;
    }
    //---------------------Has attended a competition----------------
    public boolean hasAttendedCompetition() {
        return !competitiveResults.isEmpty();
    }
    public double getBestTime(SwimStroke stroke) {
        double bestTime = Double.MAX_VALUE;
        for (CompetitiveResults result : competitiveResults) {
            if (result.getStroke() == stroke && result.getTimePerformance() < bestTime) {
                bestTime = result.getTimePerformance();
            }
        }
        return bestTime;
    }
    //---------------------------- Getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getMail() {
        return mail;
    }
    public MembershipType getMembershipTypeEnum() {
        return membershipTypeEnum;
    }
    public Team getTeam() {
        return team;
    }
    //---------------------Training Results--------------------------
    public List<TrainingResults> getTrainingResults() {
        return trainingResults;
    }
    public void addTrainingResults(TrainingResults results) {
        trainingResults.add(results);
    }
    //----------------------------Competitive Results------------------------
    public List<CompetitiveResults> getCompetitiveResults() {
        return competitiveResults;
    }
    public void addCompetitiveResult(CompetitiveResults result) {
        competitiveResults.add(result);
    }
}





