package Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import java.util.Scanner;

public class Coach extends User {
    private List<Swimmer> juniorTeam;
    private List<Swimmer> seniorTeam;
   private List<Swimmer> allSwimmers;
    private EnumSet<SwimStroke> activeStrokes;

    public Coach(String username, String password){
        super(username, password);
    }
    public Coach() {
        juniorTeam = new ArrayList<>();
        seniorTeam = new ArrayList<>();
        activeStrokes = EnumSet.noneOf(SwimStroke.class);
    }


    public void registerSwimmer(Swimmer swimmer) {
        if (swimmer.getAge() < 18) {
            juniorTeam.add(swimmer);
        } else {
            seniorTeam.add(swimmer);
        }
    }


    public void registerTrainingResult(Swimmer swimmer, LocalDate date, double time, SwimStroke stroke) {
        TrainingResults result = new TrainingResults(date, time, stroke);
        swimmer.addTrainingResults(result);
    }

    public void registerTournamentResult(Swimmer swimmer, String location, int placement,
                                         double time, LocalDate date, SwimStroke stroke) {
        CompetitiveResults result = new CompetitiveResults(location, placement, time, date, stroke);
        swimmer.addCompetitiveResults(result);
    }

    public void registerActiveStroke(Swimmer swimmer, SwimStroke stroke) {
        swimmer.addActiveStroke(stroke);
    }
    //------------------------------------------
    public List<Swimmer> getAllSwimmers() {
        List<Swimmer> allSwimmers = new ArrayList<>(juniorTeam);
        allSwimmers.addAll(seniorTeam);
        return allSwimmers;
    }

    public List<Swimmer> getJuniorTeam() {
        return juniorTeam;
    }

    public List<Swimmer> getSeniorTeam() {
        return seniorTeam;
    }

    public void displaySwimmerInfo(Swimmer swimmer) {
        System.out.println("Name: " + swimmer.getName());
        System.out.println("Age: " + swimmer.getAge());
        System.out.println("Phone: " + swimmer.getPhoneNumber());
        System.out.println("Team: " + swimmer.getTeam());
        System.out.println("Active Strokes: " + swimmer.getActiveStrokes());
        System.out.println("Has attended tournament: " + swimmer.hasAttendedTournament());

        if (swimmer.hasAttendedTournament()) {
            System.out.println("Tournament Results:");
            for (CompetitiveResults result : swimmer.getCompetitiveResults()) {
                System.out.println("  Location: " + result.location);
                System.out.println("  Date: " + result.date);
                System.out.println("  Stroke: " + result.stroke);
                System.out.println("  Time: " + result.time);
                System.out.println("  Placement: " + result.placement);
            }
        }


    @Override
    public void displayMenu() {
        System.out.println("\n---- Coach Menu ----");
        System.out.println("1. View all members");
        System.out.println("2. View top swimmers by stroke category");
        System.out.println("3. Register and edit time performance");
        System.out.println("0. Exit");
    }

    
}
