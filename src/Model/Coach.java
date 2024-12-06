package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import java.util.Scanner;

public class Coach extends User {

    private List<Swimmer> swimmers = new ArrayList<>();

    public void registerSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }

    public Coach(String username, String password) {
        super(username, password);
    }
    //------------------------------Training Result------------------------
    public void registerTrainingResults(Swimmer swimmer, LocalDate date, double time, SwimStroke stroke) {
        TrainingResults results = new TrainingResults(date, time, stroke);
        swimmer.addTrainingResults(results);
    }
    public List<TrainingResults> getTrainingResults(Swimmer swimmer) {
        return swimmer.getTrainingResults();
    }

    //------------------------------Competitive Result------------------------
    public void registerCompetitiveResult(Swimmer swimmer, String location, int placement,
                                          double time, LocalDate date, SwimStroke stroke) {
        CompetitiveResults result = new CompetitiveResults(location, placement, time, date, stroke);
        swimmer.addCompetitiveResult(result);
    }
    //------------------------------Active Stroke------------------------
    public void registerActiveStroke(Swimmer swimmer, SwimStroke stroke) {
        swimmer.addActiveStroke(stroke);
    }
    //------------------------------Team members------------------------
    public List<Swimmer> getTeamMembers(Team team) {
        List<Swimmer> teamMembers = new ArrayList<>();
        for (Swimmer swimmer : swimmers) {
            if (swimmer.getTeam() == team) {
                teamMembers.add(swimmer);
            }
        }
        return teamMembers;
    }

    public List<Swimmer> getAllSwimmers() {
        return new ArrayList<>(swimmers);
    }

    public List<Swimmer> getTop5Swimmers(Team team, SwimStroke stroke) {
        List<Swimmer> eligibleSwimmers = new ArrayList<>();
        for (Swimmer swimmer : swimmers) {
            if (swimmer.getTeam() == team && swimmer.hasActiveStroke(stroke)) {
                eligibleSwimmers.add(swimmer);
            }
        }

        // Sort eligible swimmers by their best time for the given stroke
        for (int i = 0; i < eligibleSwimmers.size(); i++) {
            for (int j = i + 1; j < eligibleSwimmers.size(); j++) {
                if (eligibleSwimmers.get(i).getBestTime(stroke) > eligibleSwimmers.get(j).getBestTime(stroke)) {
                    Swimmer temp = eligibleSwimmers.get(i);
                    eligibleSwimmers.set(i, eligibleSwimmers.get(j));
                    eligibleSwimmers.set(j, temp);
                }
            }
        }

        // Return top 5 or fewer if there are less than 5 eligible swimmers
        return eligibleSwimmers.subList(0, Math.min(5, eligibleSwimmers.size()));
    }

    public void displaySwimmerInfo(Swimmer swimmer) {
        System.out.println("Name: " + swimmer.getName());
        System.out.println("Age: " + swimmer.getAge());
        System.out.println("Phone: " + swimmer.getPhoneNumber());
        System.out.println("Team: " + swimmer.getTeam());
        System.out.println("Active Strokes: " + swimmer.getActiveStrokes());
        System.out.println("Has attended competition: " + swimmer.hasAttendedCompetition());

        if (swimmer.hasAttendedCompetition()) {
            System.out.println("Competition Results:");
            for (CompetitiveResults result : swimmer.getCompetitiveResults()) {
                System.out.println("  Location: " + result.getLocation());
                System.out.println("  Date: " + result.getDate());
                System.out.println("  Stroke: " + result.getStroke());
                System.out.println("  Time: " + result.getTimePerformance());
                System.out.println("  Placement: " + result.getPlacement());
            }
        }
    }
}




