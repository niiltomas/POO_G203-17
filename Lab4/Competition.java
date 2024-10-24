package Lab4;
import java.util.LinkedList;
import java.util.Collections;

public class Competition {
    //inici de la definició d'atributs
    public enum Gender{MALE,FEMALE,MIXTED}; 
    protected String name;
    protected Country country;
    protected Team.Gender gender;
    protected Boolean club;
    LinkedList<Team> teams;
    LinkedList<Match> matches;
    //fi de la definició d'atributs

    //constructor
    public Competition(Boolean cl, String n, Country c, Team.Gender g){
        name=n;
        country=c;
        gender=g;
        club = cl;
        teams = new LinkedList<Team>();//inicialitzem linked lists
        matches = new LinkedList<Match>();//inicialitzem linked lists
    }
    //fi del constructor
     
    //inici getters
    public String getName(){return name;}

    public Country getCountry(){return country;}

    public Team.Gender getGender(){//retorna el genere de la lliga
        return gender;
    }
    public Boolean getClub(){
        return club;
    }
    //fi getters


    public void addTeam(Team t){
        if(t.getCountry().equals(this.country) && ((t.getGender() == this.gender) || (this.gender == Team.Gender.MIXTED))) teams.add(t);
        else{
           System.out.println("L'equip " + t.getName() + " no es pot afegir perquè no coincideix amb gènere o nacionalitat.");
        }
    }

    public void generateMatches(){
        //La deixem buida perquè cada classe filla té el seu generateMatches(), que es diferent per cada classe.
    }



    public void simulatematches(){//actualització de simulatematches
        for (Match match : matches) {

            //equip local
            Team homeTeam = match.gethomeTeam();
            TeamStats homeTeamStats = homeTeam.stats.get(this);//cridem al diccionari de l'equip i fem un get del groupPlay

            if (homeTeamStats == null) {//comprovem que el diccionari no estigui buit en el TeamStats que tenim
                homeTeamStats = new TeamStats(homeTeam);
                homeTeam.stats.put(this, homeTeamStats);//si ho està, hi afegim un nou TeamStats
            }
            match.simulateMatch();
            homeTeam.update(this,match);
            homeTeamStats.updateStats(match, true);//actualitzem les dades de l'equip local amb el partit actual


            //equip visitant
            Team awayTeam = match.getawayTeam();
            TeamStats awayTeamStats = awayTeam.stats.get(this);

            if (awayTeamStats == null) {//comprovem que el diccionari no estigui buit en el TeamStats que tenim
                awayTeamStats = new TeamStats(awayTeam);
                awayTeam.stats.put(this, awayTeamStats);//si ho està, hi afegim un nou TeamStats 
            }
            match.simulateMatch();
            awayTeam.update(this, match);
            awayTeamStats.updateStats(match, false);//actualitzem les dades de l'equip visitant amb el partit actual
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

    public void printGoalScorers(int k){
        k --;
        LinkedList<OutfielderStats> scorers = new LinkedList<>();
        for (int i =0; i<teams.size(); i++){ //Índex teams
            for (int j=0; j<teams.get(i).getPlayers().size();j++){ //Índex player
                if (teams.get(i).getPlayers().get(j) instanceof Outfielder){ //Si eljugador és Outfielder
                    scorers.add((OutfielderStats)teams.get(i).getPlayers().get(j).getStats(this));
                    //Diccionario vacío. 

                    //System.out.println(teams.get(i).getPlayers().get(j).getName());
                }
            }
        }

        Collections.sort(scorers);//ordena els jugadors
        int contador = 1;
        if (k>=scorers.size()){
            if (k>scorers.size()) System.out.println("El número seleccionat supera la mida de jugadors d'aquesta competició. Per defecte, s'ha igualat al número de jugadors.");
            k = scorers.size()-1;
        }

        else if (k<=-1){
            System.out.println("El número seleccionat no és vàlid. Per defecte, s'ha igualat a 1.");
            k = 0;
        } 
        
        System.out.println("Els "+ (k+1) +" màxims golejadors d'aquesta competició són: ");
        for (int j=k; j>=0; j--){
            System.out.println("El " + contador + " jugador és: " + scorers.get(j).getplayer().getName());
            scorers.get(j).printStats();
            contador++;
            if (j==0) System.out.println("______________________________________________\n");
        }
        
    }


}