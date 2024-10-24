package Lab3;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa carpeta

import java.util.*;

public class Team {
    //Inici de la definició d'atributs
    public enum Gender{MALE,FEMALE,MIXTED}; //utilitzem la llibreria enum per a definir tres generes per l'equip
    private String name;
    protected Country country; //variable de classe Country
    protected Gender gender;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    protected int goalsScored;
    protected int goalsAgainst;
    LinkedList<Player> players; // Definim la linked list de tipus Player anomenada players
    //finalització de la definició d'atributs

    //constructor de la classe Team
    public Team(String nom,Country pais,Gender genero){//iniciem el nom, el pais, el genere de l'equip i a més iniciem la linked list de player
        name=nom;
        country=pais;
        gender=genero;
        players = new LinkedList<Player>();
    }
    //Fi del constructor

    //inici de la creació de mètodes
    public String getName(){//retorna el nom de l'equip
        return name;
    }
    public Country getCountry(){//retorna el país de l'equip
        return country;
    }
    public Gender getGender(){//retorna el genere de l'equip
        return gender;
    }
    public LinkedList<Player> getPlayers(){
        return players;
    }

    //mètode per a afegir jugador a l'equip
    public void addPlayer(Player p){
        if (gender==Gender.MIXTED){//si el gènere es mixte, qualsevol jugador podrà ser afegit a l'equip
            players.add(p);
            //System.out.println("Si que es pot afegir al jugador/a: "+p.getName()+" a l'equip mixte."+ " amb edat "+p.getAge());
            
        }
        else if (gender == Gender.MALE && !p.isFemale()) {
            //si no és mixte, haurem de mirar si el gènere de l'equip "gender" coincideix amb el genere MALE.
            //Si coincideixen voldrem mirar si a més el genere del jugador es també masculí, fet que ho obtindrem si la funció isFemale() de player (p) és false
            //Per això utilitzarem les portes lògiques AND
            players.add(p);
            //System.out.println("Si que es pot afegir al jugador/a: " + p.getName()+ " amb edat "+p.getAge());

        } else if (gender == Gender.FEMALE && p.isFemale()) {
            ///la mateixa condició que abans, però ara en comptes de què isFemale() sigui false mirarem si és true
    
            players.add(p);
            //System.out.println("Si que es pot afegir al jugador/a: " + p.getName()+ " amb edat "+p.getAge());
            
        } else {//si no es cumpleixen les condicions anteriors voldrà dir que no podrà ser afegir a l'equip perquè  són generes diferents
            System.out.println("No es pot afegir al jugador/a ja que són generes diferents");
        }
        
    }
        
    

    //mètode per eliminar player de l'equip, utilitzarem la funció remove()
    public void removePlayer(Player p){
        players.remove(p);
    }
    

    public void printStats(){//impressió de les estadístiques de l'equip
        System.out.println("L'equip ha jugat: "+noMatches+" partits.");
        System.out.println("L'equip porta: "+noWins+" victories, "+noLosses+" derrotes i "+noTies+" empats.");
        System.out.println("L'equip ha marcat: "+goalsScored+" gols.");
        System.out.println("L'equip ha encaixat: "+goalsAgainst+" gols en contra.");
        System.out.println("\n");
    }

    public void printPlayers(){//mètode per imprimir els jugadors d'un equip
        System.out.println("Jugadors del: "+getName());
        for(Player p:players){
            System.out.print("Name:" + p.getName() + " ");
        }
        System.out.println("\n");
    }

    public void UpdateStats(Match m,boolean juega_en_casa){
        int gols_a_favor;
        int gols_en_contra;
        
        if(juega_en_casa==true){
            gols_a_favor=m.gethomeGoals();
            gols_en_contra=m.getawayGoals();
        }
        else{
            gols_a_favor=m.getawayGoals();
            gols_en_contra=m.gethomeGoals();
        }
        noMatches+=1;
        if(gols_a_favor>gols_en_contra){//si els gols a favor són més que els gols en contra haurà guanyat, si és al contrari, hauran perdut (segon cas) i si són els mateixos serà un empat (tercer cas)
            noWins+=1;
        }
        else if(gols_a_favor<gols_en_contra){
            noLosses+=1;
        }
        else{
            noTies+=1;
        }
        //sumem els gols als respectius contadors de gols
        goalsScored+=gols_a_favor;
        goalsAgainst+=gols_en_contra;


    }

}
