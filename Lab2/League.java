package Lab2;

import java.util.LinkedList;

public class League {
    public enum Gender{MALE,FEMALE,MIXTED}; 
    private String name;
    private Country country;
    private Gender gender;
    LinkedList<Team> teams;
    LinkedList<Match> matches;

    public League(String n, Country c, Gender g){
        name=n;
        country=c;
        gender=g;
        teams = new LinkedList<Team>();//inicialitzem linked lists
        matches = new LinkedList<Match>();//inicialitzem linked lists
    }
     
    public String getName(){return name;}

    public Country getCountry(){return country;}

    public Gender getGender(){//retorna el genere de la lliga
        return gender;
    }

    public void addTeam(Team t){
        teams.add(t);//afegim equip a la lliga
    }
    public void generateMatches(){
        int num_teams=teams.size();//calculem el numero d'equips amb la mida de la linked list de teams
        for (int i=0;i<num_teams;i++){
            for (int j=0;j<num_teams;j++){//a cada iteració anirem creant una combinació de partits 
                //en què tots els equips de la lliga jugaran contra tots els altres dos cops. Una com a visitant i l'altre com a local
                if(i==j){
                    continue;//evitem crear un partit entre el mateix equip. "Continue" en comptes de "break", ja que break ens surt del for, i per tant no ens crearia els altres partits
                }
                else{//afegim el partit a la llista match
                    matches.add(new Match(teams.get(i),teams.get(j)));
                }
                
            }//

        }
            
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
        System.out.println("\n");
    }


    public void printTables(){}//No fer
    public void printGoalScorers(int k){}//no fer
    
}