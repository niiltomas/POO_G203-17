package Lab4;

public class GoalkeeperStats extends PlayerStats{
    //inici definició d'atributs
    protected int noSaves;
    protected int noGoalsLet;
    //fi definició d'atributs


    //Constructor de goalkeeperStats
    public  GoalkeeperStats(Goalkeeper goalkeeper){
        super(goalkeeper);
        this.noSaves=0;
    }//fi del constructor


    //getters
    public int getnoMatches(){
        return noMatches;
    }
    public int getnoGoalsLet(){
        return noGoalsLet;
    }
    public int getnoSaves(){
        return noSaves;
    }
    //fi definició de getters



    public void updateStats(Match m){
        noMatches+=1;
        Goalkeeper porter= (Goalkeeper) player;
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


    public void printStats(){//imprimim les estadistiques del porter
        System.out.println("Ha jugat: "+noMatches+" partits.");
        System.out.println("Ha encaixat: "+noGoalsLet+" gols.");
        System.out.println("Ha parat: "+noSaves+" xuts.");
        System.out.println("\n");

    }

    
    public int compareTo(PlayerStats o) {//En aquest mètode retorna 0, ja que no li hem implementat cap funcionalitat
        return 0;
    }
}
