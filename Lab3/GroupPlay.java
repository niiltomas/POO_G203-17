package Lab3;

public class GroupPlay extends Competition {
    //Inici de la definició d'atributs
    private int nGrups;
    private Team[][] leagueArray; //declarames array
    //Finalització de la definició d'atributs 

    //constructor de la classe Cup
    public GroupPlay (Boolean cl, String n, Country c, Team.Gender g,int num){
        super(cl,n,c,g);
        nGrups=num;
        leagueArray=new Team[nGrups][3];
        
    }
    public void addTeamtoGroup(Team t){
        for (int i = 0; i < nGrups; i++) {
             
            // Encuentra el primer grupo vacío o con el mismo género
            for (int j = 0; j < 3; j++) {
                if (leagueArray[i][j] == null) {
                    leagueArray[i][j] = t;
                    return;
                }
            }
            
        }
    }
    //Inici declaració de getters
    public int getnGrups() {
        return nGrups;
    }

    //Fi declaració de getters
    public void generateMatches() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && leagueArray[0][i] != null && leagueArray[0][j] != null) {
                    Match match = new Match(leagueArray[0][i], leagueArray[0][j]);
                    match.simulateMatch();
                    matches.add(match);
                }
            }
        }
    
        // Crear partidos para el segundo grupo si existe
        if (nGrups > 1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i != j && leagueArray[1][i] != null && leagueArray[1][j] != null) {
                        Match match = new Match(leagueArray[1][i], leagueArray[1][j]);
                        match.simulateMatch();
                        matches.add(match);
                    }
                }
            }
        }
    
        // Simular los partidos y actualizar estadísticas
        simulatematches();
        printmatches();
        }
    
    public void simulatematches(){
        for (Match match : matches) {
            Team homeTeam = match.gethomeTeam();
            homeTeam.UpdateStats(match, true);

            Team awayTeam = match.getawayTeam();
            awayTeam.UpdateStats(match, false);
        }
    }


    public void printTables(){//no fer

    }
}
