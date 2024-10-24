
package Lab3;

public class Outfielder extends Player {
    protected int noTackles;
    protected int noPasses;
    protected int noShots;
    protected int noAssists;
    protected int noGoals;

    //Constructor
    public Outfielder(boolean g,String n,int a, Country nat){
        super(g,n,a,nat);//Super a la primera línia
        female =g;

    }
    //Getters per a obtenir el numero de faltes, passes,xuts,assistencies, gols i numero de partits
    public int noTackles(){
        return noTackles;
    }
    public int noPasses(){
        return noPasses;
    }
    public int noShots(){
        return noShots;
    }
    public int noAssists(){
        return noAssists;
    }
    public int noGoals(){
        return noGoals;
    }
    public int getnoMatches(){
        return noMatches;
    }
    //Finalització de funcions getters

    public void updateStats(Match m){
        int goals = 0;
        noMatches+=1; // Incrementem el numero de partits jugats

        // Calcula les estadístiques en funció del partit
        for (int i = 0; i < m.homeScorers.size(); i++) {
            Player player = m.homeScorers.get(i);
            if (player.equals(this) && m.gethomeTeam().getPlayers().contains(this)) {
                goals++; // Si el jugador ha marcat, incrementem el contador
            }
        }
        //Hem de mirar si el jugador juga com a visitant o com a local
        for (int j = 0; j < m.awayScorers.size(); j++) {
            Player player = m.awayScorers.get(j);
            if (player.equals(this) && m.getawayTeam().getPlayers().contains(this)) {
                goals++; // Si el jugador ha marcat, incrementem el contador
            }
        }
        update(noTackles,noPasses,noShots,noAssists, goals);

    }
    
    public void update(int tackles, int passes, int shots, int assists, int goals){//actualitzem les variables de player amb els paràmetres d'entrada
         //sumem +1 al contador de partits
        noTackles+=tackles;
        noPasses+=passes;
        noShots+=shots;
        noAssists+=assists;
        noGoals+=goals;

        if(noShots < noGoals) {
            noShots = noGoals;
        }
    }

    public void printStats(){//imprimim les estadistiques del jugador
        System.out.println("Ha jugat: "+noMatches+" partits.");
        System.out.println("Ha fet: "+noTackles+" faltes.");
        System.out.println("Ha donat: "+noPasses+" passes.");
        System.out.println("Ha xutat: "+noShots+" cops a porteria.");
        System.out.println("Ha donat: "+noAssists+" assistencies.");
        System.out.println("Ha marcat: "+noGoals+" gols.");
        System.out.println("\n");
    }
}