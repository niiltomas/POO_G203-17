package Lab3;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa careta

public class Player {
    //Inici de la definició d'atributs
    protected boolean female;
    protected String name;
    protected int age;
    protected Country nationality;
    protected int noMatches;
  
    //finalització de la definició d'atributs
    //Els atributs de tipus int s'inicien automaticament a 0, per tant no els hem d'iniciar

    //constructor de la classe Player
    public Player(boolean g,String n,int a, Country nat){//Iniciem les variables female, name, age i nacionalitat.
        female=g;
        name=n;
        age=a;
        nationality=nat;
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
    public int getnoMatches(){//retorna el numero de partits
        return noMatches;
    }
    //fi de getters
    public boolean equals(Object o){//funció per comprovar si una instància és del tipus  Country
        if (o instanceof Player) {
            Player p = (Player) o; 
            return nationality==p.getNationality();//retornarà true si la igualtat es compleix
        
        }else return false;//si no es cumpleix retorna false
    }
    public void printStats(){};
}
