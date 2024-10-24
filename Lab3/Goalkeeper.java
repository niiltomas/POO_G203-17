package Lab3;

public class Goalkeeper extends Player {
    protected int noSaves;
    protected int noGoalsLet;


    //Constructor de goalkeeper
    public  Goalkeeper(boolean g,String n,int a, Country nat){
        super(g,n,a,nat);
    }
    
    //getters de goalkeeper: retornem el numero de parades,els gols encaixats respectivament i el numero de partits jugats
    public int getNosaves(){
        return noSaves;
    }
    public int getnoGoalslet(){
        return noGoalsLet;
    }
    public int getnoMatches(){
        return noMatches;
    }
    //Fi dels getters


    //funció per actualitzar les estadístiques de goalkeeper
    public void updateStats(Match m){
        noMatches+=1;
        Goalkeeper porter=this;
        //comprovem si el porter pertany al equip local o visitant
        //en funció d'això, el numero de gols encaixats (noGoalsLet) seran el numero de gols de l'equip contrari en cada cas respectivament
        if (m.gethomeTeam().getPlayers().contains(porter)) {
            noGoalsLet += m.getawayGoals(); // Actualizem gols
        }
        // Verifica si el portero pertenece al equipo visitante
        else if (m.getawayTeam().getPlayers().contains(porter)) {
            noGoalsLet += m.gethomeGoals(); // Actualizem gols
        }
    }

    public void printStats(){//imprimim les estadistiques del jugador
        System.out.println("Ha jugat: "+noMatches+" partits.");
        System.out.println("Ha encaixat: "+noGoalsLet+" gols.");
        System.out.println("Ha parat: "+noSaves+" xuts.");
        System.out.println("\n");

    }
    
}