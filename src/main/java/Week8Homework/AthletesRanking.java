package Week8Homework;

import java.util.ArrayList;
import java.util.List;

public class AthletesRanking{
    private List<Athlete> athletes;

    public AthletesRanking(){
        this.athletes = new ArrayList<>();
    }

    public void addAthlete(Athlete athlete){
        if(athlete == null){
            throw new NullPointerException("The athlete can t be added because is null");
        }
        athletes.add(athlete);
    }

    public List<Athlete> getAthletes(){
        return athletes;
    }

    public void displayRankings(){
        athletes.sort(new AthleteRankingComparator());
        for (int i = 0; i < athletes.size(); i++) {
            Athlete a = athletes.get(i);
            String rankLabel = "";
            if(i == 0){
                rankLabel = ("Winner - ");
            }else if(i == 1){
                rankLabel = ("Runner Up - ");
            }else if(i == 2){
                rankLabel = ("Third place - ");
            }
            System.out.println(rankLabel + a.toString());
        }
    }
}