
package Lab4;

public class Outfielder extends Player {
    //Outfielder no té atributs

    //Constructor
    public Outfielder(boolean g,String n,int a, Country nat){
        super(g,n,a,nat);//Super a la primera línia
        //inicialitzem els atributs heredats de Player
        female=g;
        name=n;
        age=a;
        nationality=nat;
    }
    //Fi del constructor
 

    void update(Competition c,Match m) { 
        OutfielderStats outfielderStats = (OutfielderStats) stats.get(c);
        if (outfielderStats == null){ //La entrada del diccionari no està creada. En creem una nova
            outfielderStats = new OutfielderStats(this);
            stats.put(c,outfielderStats);
        }
       outfielderStats.updateStats(m);//crida el mètode updateStats de OutfielderStats
    }

    
}