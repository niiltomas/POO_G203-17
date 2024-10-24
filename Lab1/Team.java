package Lab1;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa carpeta

import java.util.*;

public class Team {
    //Inici de la definició d'atributs
    public enum Gender{MALE,FEMALE,MIXTED}; //utilitzem la llibreria enum per a definir tres generes per l'equip
    private String name;
    private Country country; //variable de classe Country
    private Gender gender;
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    private int goalsScored;
    private int goalsAgainst;
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


    //mètode per a afegir jugador a l'equip
    public void addPlayer(Player p){
        if (gender==Gender.MIXTED){//si el gènere es mixte, qualsevol jugador podrà ser afegit a l'equip
            players.add(p);
            System.out.println("Si que es pot afegir el jugador/a: "+p.getName()+" a l'equip mixte."+ " amb edat "+p.getAge());
            
        }
        else if (gender == Gender.MALE && !p.isFemale()) {
            //si no és mixte, haurem de mirar si el gènere de l'equip "gender" coincideix amb el genere MALE.
            //Si coincideixen voldrem mirar si a més el genere del jugador es també masculí, fet que ho obtindrem si la funció isFemale() de player (p) és false
            //Per això utilitzarem les portes lògiques AND
            players.add(p);
            System.out.println("Si que es pot afegir el jugador/a: " + p.getName()+ " amb edat "+p.getAge());

        } else if (gender == Gender.FEMALE && p.isFemale()) {
            ///la mateixa condició que abans, però ara en comptes de què isFemale() sigui false mirarem si és true
    
            players.add(p);
            System.out.println("Si que es pot afegir la jugador/a: " + p.getName()+ " amb edat "+p.getAge());
            
        } else {//si no es cumpleixen les condicions anteriors voldrà dir que no podrà ser afegir a l'equip perquè  són generes diferents
            System.out.println("No es pot afegir ja que són generes diferents");
        }
        
    }
        
    

    //mètode per eliminar player de l'equip, utilitzarem la funció remove()
    public void removePlayer(Player p){
        players.remove(p);
    }

    
    public void playMatch(int goles_afavor, int goles_against){
        noMatches+=1;//sumem +1 al contador de partits
        if(goles_afavor>goles_against){//si els gols a favor són més que els gols en contra haurà guanyat, si és al contrari, hauran perdut (segon cas) i si són els mateixos serà un empat (tercer cas)
            noWins+=1;
        }
        else if(goles_afavor<goles_against){
            noLosses+=1;
        }
        else{
            noTies+=1;
        }
        //sumem els gols als respectius contadors de gols
        goalsScored+=goles_afavor;
        goalsAgainst+=goles_against;
    }

    public void printStats(){//impressió de les estadístiques de l'equip
        System.out.println("El equipo ha jugado: "+noMatches+" partidos.");
        System.out.println("El equipo lleva: "+noWins+" victorias, "+noLosses+" derrotas y "+noTies+" empates.");
        System.out.println("El equipo ha marcado: "+goalsScored+" goles.");
        System.out.println("El equipo ha encajado: "+goalsAgainst+" goles en contra.");

    }

    public void printPlayers(){//mètode per imprimir els jugadors d'un equip
        System.out.println("Jugadors del: "+getName());
        for(Player p:players){
            System.out.println("Name: " + p.getName());
        }
    }

}


