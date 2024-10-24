package Lab4;

public class OutfielderStats extends PlayerStats {
   //Inici definició d'atributs
    protected int noTackles;
    protected int noPasses;
    protected int noShots;
    protected int noAssists;
    protected int noGoals;
    //Fi definició d'atributs
    
    //definició de constructor
    public OutfielderStats(Outfielder outfielder){
        super(outfielder);
    };

    //Getters per a obtenir el numero de faltes, passes,xuts,assistencies, gols i numero de partits
    public int getnoTackles(){
        return noTackles;
    }
    public int getnoPasses(){
        return noPasses;
    }
    public int getnoShots(){
        return noShots;
    }
    public int getnoAssists(){
        return noAssists;
    }
    public int getnoGoals(){
        return noGoals;
    }
    public int getnoMatches(){
        return noMatches;
    }
    //Finalització de funcions getters

    public void updateStats(Match m){
        noMatches+=1; // Incrementem el numero de partits jugats
        // Calcula les estadístiques en funció del partit
        //jugadors locals
        for (int i = 0; i < m.homeScorers.size(); i++) {
            Player player = m.homeScorers.get(i);
            if (player instanceof Outfielder && m.gethomeTeam().getPlayers().contains(player)) {
                noGoals++; // Si el jugador ha marcat, incrementem el contador
            }
        }
        //jugadors visitants
        for (int j = 0; j < m.awayScorers.size(); j++) {
            Player player = m.awayScorers.get(j);
            if (player instanceof Outfielder && m.getawayTeam().getPlayers().contains(player)) {
                noGoals++; // Si el jugador ha marcat, incrementem el contador
            }
        }
    }
    
    

    public void printStats(){//imprimim les estadistiques del outfielder
        System.out.println("Ha jugat: "+noMatches+" partits.");
        System.out.println("Ha fet: "+noTackles+" faltes.");
        System.out.println("Ha donat: "+noPasses+" passes.");
        System.out.println("Ha xutat: "+noShots+" cops a porteria.");
        System.out.println("Ha donat: "+noAssists+" assistencies.");
        System.out.println("Ha marcat: "+noGoals+" gols.");
        System.out.println("\n");
    }


    public int compareTo(PlayerStats ps) {
        if(ps instanceof OutfielderStats){
            OutfielderStats os =(OutfielderStats)ps;

            //comparem els gols de cadascun
            if (this.noGoals < os.noGoals) {
                return -1;//retorna -1 si el valor actual de la instància d'outfielder os s'ha d'ordenar ABANS que l'altre (this)
            } 
            else if (this.noGoals > os.noGoals) {
                return 1;//retorna 1 si el valor actual de la instància d'outfielder os s'ha d'ordenar DESPRÉS que l'altre (this)
            } 
            else {
                return 0; // Han marcat els mateixos gols
            }
        }
        return -2;//retornem -2 si la instancia es diferent
    }
}
