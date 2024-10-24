package Lab1;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa careta

public class Player {
    //Inici de la definició d'atributs
    private boolean female;
    private String name;
    private int age;
    private Country nationality;
    private int noMatches;
    private int noTackles;
    private int noPasses;
    private int noShots;
    private int noAssists;
    private int noGoals;
    //finalització de la definició d'atributs
    //Els atributs de tipus int s'inicien automaticament a 0, per tant no els hem d'iniciar

    //constructor de la classe Player
    public Player(boolean g,String n,int a, Country nat){//Iniciem les variables female, name, age i nacionalitat.
        female=g;
        name=n;
        age=a;
        nationality=nat;
    }

    //mètodes
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
    public void update(int tackles, int passes, int shots, int assists, int goals){//actualitzem les variables de player amb els paràmetres d'entrada
        noMatches+=1; //sumem +1 al contador de partits
        noTackles=tackles;
        noPasses=passes;
        noShots=shots;
        noAssists=assists;
        noGoals=goals;

    }
    public void printStats(){//imprimim les estadistiques del jugador
        System.out.println("Ha jugat: "+noMatches+" partits.");
        System.out.println("Ha fet: "+noTackles+" faltes.");
        System.out.println("Ha donat: "+noPasses+" passes.");
        System.out.println("Ha xutat: "+noShots+" cops a porteria.");
        System.out.println("Ha donat: "+noAssists+" assistencies.");
        System.out.println("Ha marcat: "+noGoals+" gols.");
    }

}
