package Lab4;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa careta

import java.util.HashMap;

public abstract class Player {
    //Inici de la definició d'atributs
    protected boolean female;
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches;
    protected HashMap<Competition,PlayerStats> stats;//Diccionari stats
    //finalització de la definició d'atributs


    private GoalkeeperStats goalkeeperStats;
    private OutfielderStats outfielderStats;


    //Els atributs de tipus integers s'inicien automaticament a 0, per tant no els hem d'iniciar

    //constructor de la classe Player
    public Player(boolean g,String n,int a, Country nat){//Iniciem les variables female, name, age i nacionalitat.
        female=g;
        name=n;
        age=a;
        nationality=nat;
        stats = new HashMap<Competition,PlayerStats>();
    }



    //getters 
    public boolean isFemale(){//retorna true/false del genere
        return female;
    }
    public String getName(){//retorna el nom del jugador
        return name;
    }
    public int getAge(){//retorna l'edat del jugador
        return age;
    }
    public Country getNationality(){//retorna la nacionalitat del jugador
        return nationality;
    }
    public int getNoMatches(){
        return noMatches;
    }

    public GoalkeeperStats getGoalkeeperStats() {
        return goalkeeperStats;
    }

    public OutfielderStats getOutfielderStats() {
        return outfielderStats;
    }
    
    //fi de getters




    public boolean equals(Object o){//funció per comprovar si una instància és del tipus  Country
        if (o instanceof Player) {
            Player p = (Player) o; 
            return nationality==p.getNationality();//retornarà true si la igualtat es compleix
        
        }else return false;//si no es cumpleix retorna false
    }


    //metode abstracte update
    abstract void update(Competition c,Match m);


    //metode getStats
    public PlayerStats getStats(Competition c){
        if (stats.containsKey(c)){ //comprova que per aquesta competició ja exisiteixi una entrada al diccionari de player
            return stats.get(c); //retorna les estadísitques del jugador (que sabem que estàn creades) 
        }
        PlayerStats newStats;
        if (this instanceof Goalkeeper){
            newStats = new GoalkeeperStats((Goalkeeper) this);
        }
        else if (this instanceof Outfielder){
            newStats = new OutfielderStats((Outfielder) this);
        }
        else newStats = null;
        stats.put(c, newStats);
        return newStats;
    }
}
