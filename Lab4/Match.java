
package Lab4;

import java.util.*;

public class Match {
    //Inici de la definició d'atributs
    protected Team homeTeam; 
    protected Team awayTeam; 
    protected int homeGoals;
    protected int awayGoals;
    LinkedList <Player> homeScorers;
    LinkedList <Player> awayScorers;
    protected Random random;
    int g = 5; // número màxim de gols d'un equip
    int a;
    int h;
    //finalització de la definició d'atributs

    //constructor de la classe Match
    public Match(Team home, Team away){
        this.homeTeam = home;
        this.awayTeam = away;
        homeScorers = new LinkedList<Player>();
        awayScorers = new LinkedList<Player>();
        random = new Random();
        homeGoals = random.nextInt(g);
        awayGoals= random.nextInt(g);
        a = this.awayTeam.getPlayers().size(); // Jugadors d'un equip
        h = this.homeTeam.getPlayers().size();
    }//Fi del constructor
    
    //inici de la creació de mètodes
    //Getters
    public Team gethomeTeam(){
        return homeTeam;
    }

    public Team getawayTeam(){
        return awayTeam;
    }
    
    public int gethomeGoals(){
        return homeGoals;
    }

    public int getawayGoals(){
        return awayGoals;
    }
    //fi dels getters();up

    public void simulateMatch(){ //Simula un únic partit 
        int indexplayerA; 
        int indexplayerH;

        for (int i=0; i<awayGoals;i++){
            indexplayerA = random.nextInt(a); //índex del jugador away que ha marcat
            Player scorerA = awayTeam.getPlayers().get(indexplayerA); //Player Away
            if (!(scorerA instanceof Goalkeeper)) awayScorers.add(scorerA); 
            else{
                random.nextInt(a);
                scorerA = awayTeam.getPlayers().get(indexplayerA);
                awayScorers.add(scorerA);
            }
            
        }

        for (int j=0; j<homeGoals; j++){
            indexplayerH = random.nextInt(h); //índex del jugador home que ha marcat
            Player scorerH = homeTeam.getPlayers().get(indexplayerH); //Afegim el player Home que ha marcat a la llista de golejadors
            if (!(scorerH instanceof Goalkeeper)) homeScorers.add(scorerH);
            else{
                random.nextInt(h);
                scorerH = awayTeam.getPlayers().get(indexplayerH);
                homeScorers.add(scorerH);
            }
        }
    }    
        //Si es fes amb un únic for, llavors g seria el número máxim de gols que els dos equips poden maracar en total. Nosaltres volem 
        // que g sigui el número de gols que cada equip pot marcar, per això fem dos fors.
                

        
        
    public void printMatch(){ //Imprimeix les estadístiques del partit
        
        System.out.println("Equip local: "+ gethomeTeam().getName() + ": " + homeGoals+ " - "+ "Equip visitant: "+getawayTeam().getName() + ": "+ awayGoals);
        if (homeScorers.isEmpty()) System.out.println("No hi ha hagut gols de " + homeTeam.getName() + " en aquest partit ");
        else{
            System.out.println("Golejadors/es de l'equip local: ");
            for (Player scorerH : homeScorers) {
            System.out.print(scorerH.getName() + "    ");
            }
            System.out.println("\n");

        }
        if (awayScorers.isEmpty()) System.out.println("No hi ha hagut gols de " + awayTeam.getName() + " en aquest partit ");
        else{
            System.out.println("Golejadors/es de l'equip visitant: ");
            for (Player scorerH : awayScorers) {
            System.out.print(scorerH.getName() + "    ");
            }
            System.out.println("\n");

        }
        
        
    }
}