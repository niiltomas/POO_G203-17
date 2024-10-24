package Lab3;


public class League extends Competition {
   //Aquesta cñasse no té atributs

    public League(Boolean cl, String n, Country c, Team.Gender g){
        super(cl, n, c, g);
    }
     
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
                
            }//

        }
            
    }
    
    public void printTables(){}//No fer    
}