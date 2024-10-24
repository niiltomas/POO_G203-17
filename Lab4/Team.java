package Lab4;//necessaria per a què el programa pugui obtenir classes d'altres fitxers dins de la mateixa carpeta
import java.util.*;

public class Team {
    //Inici decalaració mètodes
    public enum Gender{MALE,FEMALE,MIXTED}; //utilitzem la llibreria enum per a definir tres generes per l'equip
    protected String name;
    protected Country country; //variable de classe Country
    protected Gender gender;
    protected HashMap<Competition,TeamStats> stats;
    LinkedList<Player> players;
    protected TeamStats teamStats;
    //Fi declaració mètodes

    //constructor de la classe Team
    public Team (String nom,Country pais,Gender genero){//iniciem el nom, el pais, el genere de l'equip i a més iniciem la linked list de player
    name=nom;
    country=pais;
    gender=genero;
    stats=new HashMap<Competition,TeamStats>();
    players = new LinkedList<>(); //inicialitzem la llista de jugadors
    }
    //Fi del constructor

    //getters
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

    public TeamStats getTeamStats(){
        return teamStats;
    }
    //fi de getters

    

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
    


    public void printPlayers(){//mètode per imprimir els jugadors d'un equip
    System.out.println("Jugadors del: "+getName());
    for(Player p:players){
        System.out.print("Name:" + p.getName() + " ");
    }
    System.out.println("\n");
    }



    public void update(Competition c, Match m){
        teamStats = stats.get(c);

        if (teamStats == null) {
            // If not, create a new TeamStats and add it to the dictionary
            teamStats = new TeamStats(this);
            stats.put(c, teamStats);
        }

        // Call updateStats of TeamStats with the given match
        teamStats.updateStats(m, true);  // Assuming the team is always playing at home
        teamStats.getTeamStats();

        // Call update method of each player in the team
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            p.update(c, m);
        }
    }


    //Nou mètode per a imprimir les estadístiques de l'equip
    public void printStats(Competition c) {
        if (stats.containsKey(c)) {
            teamStats = stats.get(c);
            teamStats.printStats();
        } else {
            System.out.println("No tenim estadístiques de l'equip " +name+" per a aquesta competició: "+c);
        }
    }
    

}
