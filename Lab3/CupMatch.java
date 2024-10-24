package Lab3;

public class CupMatch extends Match {
    //CupMatch no té atributs


    //constructor: Com no té atributs, el seu constructor será el del seu pare.
    public CupMatch(Team home, Team away){
        super(home, away);
    }

    public void simulateMatch() {
        super.simulateMatch();
        super.printMatch();        
        while(homeGoals == awayGoals){  //Mira si están empatados
            int indexplayerA; 
            int indexplayerH;
            int newHomeGoals = random.nextInt(g);
            int newAwayGoals= random.nextInt(g);
        
            for (int i=0; i<newAwayGoals;i++){
                indexplayerA = random.nextInt(a); //jugador away que ha marcat
                awayScorers.add(awayTeam.getPlayers().get(indexplayerA)); //Player Away
            }
            for (int j=0; j<newHomeGoals; j++){
                indexplayerH = random.nextInt(h); //jugador home que ha marcat
                homeScorers.add(homeTeam.getPlayers().get(indexplayerH)); //Player Home genera partidos hasta que se desempate
            }
            if (newAwayGoals != newHomeGoals){
            homeGoals = homeGoals + newHomeGoals;
            awayGoals = awayGoals + newAwayGoals;

            System.out.print("Empat! Per desempatar es fa una ronda de penalties. Resultat final:\n");
            super.printMatch();
            }
        }
    }
}

