package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Coach extends User {

    private List<CompetitiveSwimmer> swimmers = new ArrayList<>();

    public void registerCompetitiveSwimmer(CompetitiveSwimmer competitiveSwimmer) {
        swimmers.add(competitiveSwimmer);
    }
    public Coach(String username, String password) {
        super(username, password);
    }
    //------------------------------Training Result------------------------
    public void registerTrainingResults(CompetitiveSwimmer competitiveSwimmer, LocalDate date, double time, SwimStroke stroke) {
        TrainingResults results = new TrainingResults(date, time, stroke);
        competitiveSwimmer.addTrainingResults(results);
    }
    public List<TrainingResults> getTrainingResults(CompetitiveSwimmer competitiveSwimmer) {
        return competitiveSwimmer.getTrainingResults();
    }

    //------------------------------Competitive Result------------------------
    public void registerCompetitiveResult(CompetitiveSwimmer competitiveSwimmer, String location, int placement,
                                          double time, LocalDate date, SwimStroke stroke) {

        CompetitiveResults result = new CompetitiveResults(location, placement, time, date, stroke);
        competitiveSwimmer.addCompetitiveResult(result);
    }
    //------------------------------Active Stroke------------------------
    public void registerActiveStroke(CompetitiveSwimmer competitiveSwimmer, SwimStroke stroke) {
        competitiveSwimmer.addActiveStroke(stroke);
    }
    //------------------------------Team members------------------------
    public List<CompetitiveSwimmer> getTeamMembers(Team team) {
        List<CompetitiveSwimmer> teamMembers = new ArrayList<>();
        for (CompetitiveSwimmer competitiveSwimmer : swimmers) {
            if (competitiveSwimmer.getTeam() == team) {
                teamMembers.add(competitiveSwimmer);
            }
        }
        return teamMembers;
    }
    //-----------------------------Get all swimmers-------------------------
    public List<CompetitiveSwimmer> getAllSwimmers() {
        return new ArrayList<>(swimmers);
    }
    //-----------------------------Get Top 5 Swimmers-------------------------
    public List<CompetitiveSwimmer> getTop5Swimmers(Team team, SwimStroke stroke) {
        List<CompetitiveSwimmer> eligibleSwimmers = new ArrayList<>();
        for (CompetitiveSwimmer competitiveSwimmer : swimmers) {
            if (competitiveSwimmer.getTeam() == team && competitiveSwimmer.hasActiveStroke(stroke)) {
                eligibleSwimmers.add(competitiveSwimmer);
            }
        }
        // Sort eligible swimmers by their best time for the given stroke
        for (int i = 0; i < eligibleSwimmers.size(); i++) {
            for (int j = i + 1; j < eligibleSwimmers.size(); j++) {
                if (eligibleSwimmers.get(i).getBestTime(stroke) > eligibleSwimmers.get(j).getBestTime(stroke)) {
                    CompetitiveSwimmer temp = eligibleSwimmers.get(i);
                    eligibleSwimmers.set(i, eligibleSwimmers.get(j));
                    eligibleSwimmers.set(j, temp);
                }
            }
        }
        // Return top 5 or fewer if there are less than 5 eligible swimmers
        return eligibleSwimmers.subList(0, Math.min(5, eligibleSwimmers.size()));
    }
    //-----------------------------display competitiveSwimmer info-------------------------
    public void displaySwimmerInfo(CompetitiveSwimmer competitiveSwimmer) {
        System.out.println("Name: " + competitiveSwimmer.getName());
        System.out.println("Age: " + competitiveSwimmer.getAge());
        System.out.println("Phone: " + competitiveSwimmer.getPhoneNumber());
        System.out.println("Team: " + competitiveSwimmer.getTeam());
        System.out.println("Active Strokes: " + competitiveSwimmer.getActiveStrokes());
        System.out.println("Has attended competition: " + competitiveSwimmer.hasAttendedCompetition());

//-------------------Has Attended Competition---------------------
        if (competitiveSwimmer.hasAttendedCompetition()) {
            System.out.println("Competition Results:");
            for (CompetitiveResults result : competitiveSwimmer.getCompetitiveResults()) {
                System.out.println("  Location: " + result.getLocation());
                System.out.println("  Date: " + result.getDate());
                System.out.println("  Stroke: " + result.getStroke());
                System.out.println("  Time: " + result.getTimePerformance());
                System.out.println("  Placement: " + result.getPlacement());
            }
        }
    }
}


