package Lab4;

public abstract class PlayerStats implements Comparable<PlayerStats> {
    //Inici de la definició d'atributs
    protected Player player;
    protected int noMatches;
    
    //finalització de la definició d'atributs

    //constructor de la classe PlayerStats
    public PlayerStats(Player p){
        this.player = p;
    }
    //Fi del constructor


    //Inici definició de Getters
    public Player getplayer(){
        return player;
    }


    public int getnoMatches(){
        return player.getNoMatches();
    }
    //Fi definició de getters



    public void updateStats(Match m){
    if (this instanceof GoalkeeperStats){
        Goalkeeper goalkeeper = (Goalkeeper) player;
        goalkeeper.getGoalkeeperStats();
    }
    else{
        Outfielder outfielder = (Outfielder) player;
        outfielder.getOutfielderStats();
    }
    }

    abstract void printStats();//Cada subclasse tindrà una implementació diferent
    }
