package Lab3;
import java.util.LinkedList;

public class Competition {
    
    public enum Gender{MALE,FEMALE,MIXTED}; 
    protected String name;
    protected Country country;
    protected Team.Gender gender;
    protected Boolean club;
    LinkedList<Team> teams;
    LinkedList<Match> matches;

    public Competition(Boolean cl, String n, Country c, Team.Gender g){
        name=n;
        country=c;
        gender=g;
        club = cl;
        teams = new LinkedList<Team>();//inicialitzem linked lists
        matches = new LinkedList<Match>();//inicialitzem linked lists
    }
     
    public String getName(){return name;}

    public Country getCountry(){return country;}

    public Team.Gender getGender(){//retorna el genere de la lliga
        return gender;
    }
    public Boolean getClub(){
        return club;
    }


    public void addTeam(Team t){
        if(t.getCountry().equals(this.country) && ((t.getGender() == this.gender) || (this.gender == Team.Gender.MIXTED))) teams.add(t);
        else{
           System.out.println("L'equip " + t.getName() + " no es pot afegir perquè no coincideix amb gènere o nacionalitat.");
        }
    }

    public void generateMatches(){
        //La deixem buida perquè cada classe filla té el seu generateMatches(), que es diferent per cada classe.
    }

     public void simulatematches(){ //Simulem els partits i actualitzem els resultats
        int num_matches=matches.size();
        for (int i=0;i<num_matches;i++){
            Match partit = matches.get(i);
            partit.simulateMatch(); // Simulate the match

        // Actualitzem les estadístiques de l'equip visitant i local respectivament
            Team homeTeam = partit.gethomeTeam();
            homeTeam.UpdateStats(partit,true);

            Team awayTeam = partit.getawayTeam();
            awayTeam.UpdateStats(partit,false);
        }

    }   
   
    public void printmatches(){//imprimim els partits
        for (int i = 0; i < matches.size(); i++) {
            System.out.println("Match " + (i + 1)+":");
            matches.get(i).printMatch();
        }
        System.out.println("__________________________________________________\n");
        System.out.println("\n");

    }

    public void printGoalScorers(int k){}//no fer
    
}