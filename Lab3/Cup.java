package Lab3;
import java.util.*;

public class Cup extends Competition{
    //Definició atributs
    LinkedList <Team> roundTeams; //declaració de les linkedlists
    LinkedList <Match> matches;
    //Fí definició d'atributs

    //definició constructor
    public Cup(Boolean cl, String name, Country c, Team.Gender g){
        super(cl,name,c,g);
        roundTeams = new LinkedList<Team>(); //Inicializatció de les linkedists
        matches = new LinkedList<Match>();
    }

    //Declaració dels getters
    public String getName(){return name;}

    public Country getCountry(){return country;}

    public Team.Gender getGender(){//retorna el genere de la Copa
        return gender;
    }   
    
    //Inici declaració de mètodes
    public void addTeam(Team t){
        if(t.getCountry().equals(this.country) && ((t.getGender() == this.gender) || (this.gender == Team.Gender.MIXTED))) roundTeams.add(t);
        else{
           System.out.println("L'equip " + t.getName() + " no es pot afegir a " + this.getName() + " perquè no coincideix amb gènere o nacionalitat.");
        }
    }
    
   // public void printTeams(){
    //for (Team team: roundTeams) System.out.println(team.getName());
    //}
    
  public void generateMatches(){ //generar tots els partits. 
        for (int i=0; i<roundTeams.size(); i++){

           if (roundTeams.size()-1 == i) break; //ja s'han generat tots els partits que volíem
            Team homeTeam = roundTeams.get(i);
            Team awayTeam = roundTeams.get(i+1); 
            CupMatch cupMatch = new CupMatch(homeTeam,awayTeam);
            matches.add(cupMatch); // get(i) -> homeTeam, get(i+1) ->awayTeam
            if ((roundTeams.size()%2) != 0) matches.add(cupMatch);
        }
    }

    public void simulateMatches(){
        int i = 0;
        Collections.shuffle(roundTeams); //randomitza la llista d'equips que jugaran a la copa
        generateMatches();
        if (((roundTeams.size()%2) != 0)){ //comprova si el size és parell o senar
                addTeam(roundTeams.getFirst()); //Afegim el primer equip de la llista roundTeams per que torni a jugar
        }
        while ((roundTeams.size() != 1)){ //mentre quedi més d'un equip per jugar
            System.out.print("\n");
            System.out.println("Nou partit");
            Team homeTeam = roundTeams.get(i);
            Team awayTeam = roundTeams.get(i+1); 
            CupMatch cupMatch = new CupMatch(homeTeam,awayTeam);
            cupMatch.simulateMatch();
            
            if (cupMatch.gethomeGoals() > cupMatch.getawayGoals()) {
                System.out.print("Equip eliminat: " + awayTeam.getName() + "\n");
                roundTeams.remove(i + 1);
            } else {
                System.out.print("Equip eliminat: " + homeTeam.getName() + "\n");
                roundTeams.remove(i);
            }

            if ((roundTeams.size()-1 == i) || roundTeams.size() == 2){
                i = 0;
            }
            else{
                i = i + 1;
            }
            if ((homeTeam.getName().equals(awayTeam.getName())) && (roundTeams.size() == 2)){
                roundTeams.removeLast();
            }
        }
        System.out.print("L'equip guanyador de la copa és:");
        for (Team winTeam: roundTeams) System.out.println(winTeam.getName());
        System.out.println("_________________________________________________");
    }
}