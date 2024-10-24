package Lab4;
import java.util.*;
import java.util.Collections;


public class League extends Competition {
   //Aquesta classe no té atributs

   //Constructor
    public League(Boolean cl, String n, Country c, Team.Gender g){
        super(cl, n, c, g);//cridem a la superclasse de League que és Competition
    }
    //fi del constructor
     
    
    public void generateMatches(){
        int num_teams=teams.size();//calculem el numero d'equips amb la mida de la linked list de teams
        for (int i=0;i<num_teams;i++){
            for (int j=0;j<num_teams;j++){//a cada iteració anirem creant una combinació de partits 
                //en què tots els equips de la lliga jugaran contra tots els altres dos cops. Una com a visitant i l'altre com a local
                if(i==j){
                    continue;//evitem crear un partit entre el mateix equip. "Continue" en comptes de "break", ja que break ens surt del for, i per tant no ens crearia els altres partits
                }
                else{//afegim el partit a la llista match
                    matches.add(new Match(teams.get(i),teams.get(j)));
                }
                
            }

        }
            
    }
    
    public void printTables(){
    LinkedList<TeamStats> stats = new LinkedList<TeamStats>(); //Llista de TeamStats
    for (int i=0; i<teams.size(); i++){ 
        TeamStats tStatistics = teams.get(i).getTeamStats();
        stats.add(tStatistics);
    }
    
    Collections.sort(stats);//Ordenem la llista de TeamStats (stats)
    int contador = 1;
    System.out.println("La classificació de la lliga és la següent: \n");
    for (int j=stats.size()-1; j >= 0; j--){ //Si usem j>0, no estem contant el 0, que es el primer equip.
        System.out.print("L'equip número " + contador + " és: ");
        System.out.println(stats.get(j).getTeam().getName());
        stats.get(j).printStats();
        contador++;    
    }
    }   
}