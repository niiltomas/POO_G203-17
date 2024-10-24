package Lab4;

public class Goalkeeper extends Player {
    //Goalkeeper no té atributs

    //Constructor de goalkeeper
    public  Goalkeeper(boolean g,String n,int a, Country nat){
        super(g,n,a,nat);
        //inicialitzem els atributs heredats de Player
        female=g;
        name=n;
        age=a;
        nationality=nat;
    }
    
    public void update(Competition c,Match m) { 
        GoalkeeperStats porterStats = (GoalkeeperStats) stats.get(c);
        if (porterStats == null){ //SI l'entrada del poter no està al diccionari. En creem una de nova i l'afegim al diccionari amb la funció .put()
            porterStats = new GoalkeeperStats(this);
            stats.put(c,porterStats);
        } 
        porterStats.updateStats(m);//crida el mètode updateStats de goalkeeperStats
    }
    
}