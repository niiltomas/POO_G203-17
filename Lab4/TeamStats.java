package Lab4;

//import java.util.LinkedList;

public class TeamStats implements Comparable<TeamStats>{
    //Inici de la definició d'atributs
    protected int noPoints;//numero de punts
    private int noMatches;
    private int noWins;
    private int noTies;
    private int noLosses;
    protected int goalsScored;
    protected int goalsAgainst;
    protected Team Team;
    protected TeamStats teamStats;
    //finalització de la definició d'atributs


    //constructor de la classe TeamStats
    public TeamStats(Team t){
        Team = t;
        noPoints=0;//iniciem els punts a 0
    }
    //Fi del constructor


    //getters
    public TeamStats getTeamStats(){
        return teamStats;
    }
    public Team getTeam() {
       return Team;
    }

    //inici mètodes
    public void updateStats(Match m,boolean juega_en_casa){
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
            noPoints+=3;//Actualitzem els punts
        }
        else if(gols_a_favor<gols_en_contra){
            noLosses+=1;
            noPoints+=0;//Actualitzem els punts
        }
        else{
            noTies+=1;
            noPoints+=0;//Actualitzem els punts
        }
        //sumem els gols als respectius contadors de gols
        goalsScored+=gols_a_favor;
        goalsAgainst+=gols_en_contra;
    }

    public int compareTo(TeamStats ts){
        //retorna -1 si la instancia (ts) s'ha d'ordenar abans que l'altre
        //retorna 1 si la instancia (ts) s'ha d'ordenar després que l'altre
        if(this.noPoints<ts.noPoints){
            return -1;
        }
        if(this.noPoints>ts.noPoints){
            return 1;
        }
        //comparem les diferències de gols (gols a favor - gols en contra)
        int this_dif_gols=this.goalsScored-this.goalsAgainst;
        int ts_dif_gols=ts.goalsScored-ts.goalsAgainst;
        
        if (this_dif_gols<ts_dif_gols){
            return -1;
        }
        if (this_dif_gols>ts_dif_gols){
            return 1;
        }
        //Comparem els gols marcats per a cada equip
        if (this.goalsScored < ts.goalsScored) {
            return -1;
        }
        if (this.goalsScored >ts.goalsScored) {
            return 1;
        }
        return 0;//els equips són iguals

    }
    public void printStats(){//impressió de les estadístiques de l'equip
        System.out.println("L'equip ha jugat: "+noMatches+" partits.");
        System.out.println("L'equip porta: "+noWins+" victories, "+noLosses+" derrotes i "+noTies+" empats.");
        System.out.println("L'equip ha marcat: "+goalsScored+" gols.");
        System.out.println("L'equip ha encaixat: "+goalsAgainst+" gols en contra.");
        System.out.println("L'equip té: "+noPoints+" punts.");
        System.out.println("\n");
    }
}
