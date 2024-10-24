package Lab2;
public class FootballApplication {
    public static void main(String[] args) {
        //a cada player li assignem un país, si són del mateix reaprofitem la variable del país
        //Creem un nou jugador cada vegada, amb el genere, nom, edat i país
        //per a cada equip (en total n'hi han dos) definim el nom, país i gènere.
        //cada cop que creem un player, actualitzem la llista de jugadors de l'equip
        //A mes cada player tindrà unes estadístiques al igual que l'equip, per tant les anirem actualitzant i imprimint respectivament
        //*********************Player 1*********************************** */
        //creem tots els paisos
    Country c1=new Country("Argentina");
    Country c2=new Country("Portugal");
    Country c3=new Country("Brasil");
    Country c4=new Country("Spain");
    Country c5=new Country("EEUU");

    //Creem la lliga
    League league =new League("Premier League",c1,League.Gender.MIXTED);//nova lliga

    //creem tots els equips
    Team t1=new Team("FC Barcelona",c1,Team.Gender.MALE);
    Team t2=new Team("Girona FC",c4,Team.Gender.FEMALE);
    Team t3=new Team("RCD Espanyol",c4,Team.Gender.MIXTED);//new team

    //afegim els equips a la lliga
    league.addTeam(t1);
    league.addTeam(t2);
    league.addTeam(t3);
    
    
    //creem a tots els jugadors i jugadores
    Player p1=new Player(false,"Messi",36,c1);
    Player p2=new Player(false,"Cristiano Ronaldo",30,c2);
    Player p3=new Player(false,"Pelé",70,c3);
    Player p4=new Player(false,"Iker Casillas",50,c4);
    Player p5=new Player(false,"Gerard Piqué",35,c4);
    
    Player p6=new Player(true,"Lorena Benítez",31,c1);
    Player p7=new Player(true,"Aitana Bonmati",26,c4);
    Player p8=new Player(true, "Carlota Coll", 20,c4);
    Player p9=new Player(true, "Megan Rapinoe",27,c5);
    Player p10=new Player(true, "Jéssica Silva",25,c3);
    
    Player p11=new Player(true,"Alexia Putellas",20,c4);
    Player p12=new Player(false,"Neymar",40,c3);
    Player p13=new Player(true, "Gabi Nunes", 50,c2);
    Player p14=new Player(true, "Cristina Primo",33,c1);
    Player p15=new Player(false, "Vinicius",25,c3);

    //Definim els equips
    t1.addPlayer(p1);
    t1.addPlayer(p2);
    t1.addPlayer(p3);
    t1.addPlayer(p4);
    t1.addPlayer(p5);
    t2.addPlayer(p6);
    t2.addPlayer(p7);
    t2.addPlayer(p8);
    t2.addPlayer(p9);
    t2.addPlayer(p10);
    t3.addPlayer(p11);
    t3.addPlayer(p12);
    t3.addPlayer(p13);
    t3.addPlayer(p14);
    t3.addPlayer(p15);

    //Simulem partits
    System.out.println("Els partits de la "+league.getName()+" són: ");
    System.out.println("\n");
    league.generateMatches(); 
    league.simulatematches();
    league.printmatches();
    
    //Imprimim les característiques de cada jugador
    System.out.println("__________________________________________________\n");
    System.out.println("Les característiques de cada jugador són: ");

    //*********************Player 1*********************************** */
    System.out.println("El nom del pais de "+p1.getName()+" és " +c1.getName());
    System.out.println("El nom del equip on juga és: "+t1.getName()+"\n");
    System.out.println("Estadístiques de: "+p1.getName());
    p1.update(4,3,2,1,1);//borrar linia al final
    p1.printStats();
    System.out.println("__________________________________________________\n");

    //*********************Player 2*********************************** */
    System.out.println("El nom del pais de "+p2.getName()+" és " +c2.getName());
    System.out.println("El nom del equip es: "+t1.getName()+"\n");
    System.out.println("Estadístiques de: "+p2.getName()+"\n");
    p2.update(2,5,2,1,2);
    p2.printStats();
    System.out.println("__________________________________________________\n");
    //t1.printPlayers();
    //t1.playMatch(3,3);
    //t1.printStats();
            
    //*********************Player 3*********************************** */
    System.out.println("El nom del pais de "+p3.getName()+" és " +c3.getName());
    System.out.println("El nom del equip es: "+t1.getName()+"\n");
    System.out.println("Estadístiques de: "+p3.getName()+"\n");
    p3.update(2,5,1,1,0);
    p3.printStats();
    System.out.println("__________________________________________________\n");
    //t1.printPlayers();
    //t1.playMatch(2,3);
    //t1.printStats();
    
    
    //*********************Player 4*********************************** */
            
    System.out.println("El nom del pais de "+p4.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t1.getName()+"\n");
    System.out.println("Estadístiques de: "+p4.getName()+"\n");
    p4.update(0,56,0,0,0);
    p4.printStats();
    System.out.println("__________________________________________________\n");
    //t1.printPlayers();
    //t1.playMatch(4,0);
    //t1.printStats();

    //*********************Player 5*********************************** */
    System.out.println("El nom del pais de "+p5.getName()+" és " +c1.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");
    System.out.println("El nom del pais de lequip es: "+t2.getCountry().getName()+" \n");
    System.out.println("Estadístiques de: "+p5.getName()+"\n");
    p5.update(4,3,2,0,0);
    p5.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(0,0);
    //t2.printStats();

    //*********************Player 6*********************************** */
    System.out.println("El nom del pais de "+p6.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");
    System.out.println("Estadístiques de: "+p6.getName()+"\n");
    p6.update(2,5,2,1,2);
    p6.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(3,2);
    //t2.printStats();

    //*********************Player 7*********************************** */        
    System.out.println("El nom del pais de "+p7.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");
    System.out.println("Estadístiques de: "+p7.getName()+"\n");
    p7.update(2,5,2,1,0);
    p7.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(2,7);
    //t2.printStats();

        //*********************Player 8*********************************** */        
    System.out.println("El nom del pais de "+p8.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");   
    System.out.println("Estadístiques de: "+p8.getName()+"\n");
    p8.update(0,2,4,1,1);
    p8.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(4,1);
    //t2.printStats();

    //*********************Player 9*********************************** */        
    System.out.println("El nom del pais de "+p9.getName()+" és " +c5.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");
    System.out.println("Estadístiques de: "+p9.getName()+"\n");
    p9.update(4,4,2,1,0);
    p9.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(2,0);
   // t2.printStats();

    //*********************Player 10*********************************** */        
    System.out.println("El nom del pais de "+p10.getName()+" és " +c3.getName());
    System.out.println("El nom del equip es: "+t2.getName()+"\n");
    System.out.println("Estadístiques de: "+p10.getName()+"\n");
    p10.update(2,7,1,3,1);
    p10.printStats();
    System.out.println("__________________________________________________\n");
    //t2.printPlayers();
    //t2.playMatch(3,4);
    //t2.printStats();

    //*********************Player 11*********************************** */
    System.out.println("El nom del pais de "+p11.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t3.getName()+"\n");
    System.out.println("Estadístiques de: "+p11.getName()+"\n");
    p11.update(2,7,1,3,1);
    p11.printStats();
    System.out.println("__________________________________________________\n");
    //t3.printPlayers();
    //t3.playMatch(3,4);
    //t3.printStats();

    //*********************Player 12*********************************** */
    System.out.println("El nom del pais de "+p12.getName()+" és " +c3.getName());
    System.out.println("El nom del equip es: "+t3.getName()+"\n");
    System.out.println("Estadístiques de: "+p12.getName()+"\n");
    p12.update(2,7,1,3,1);
    p12.printStats();
    System.out.println("__________________________________________________\n");
    //t3.printPlayers();
    //t3.playMatch(3,4);
    //t3.printStats();

    //*********************Player 13*********************************** */
    System.out.println("El nom del pais de "+p13.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t3.getName()+"\n");
    System.out.println("Estadístiques de: "+p13.getName()+"\n");
    p13.update(2,7,1,3,1);
    p13.printStats();
    System.out.println("__________________________________________________\n");
    //t3.printPlayers();
    //t3.playMatch(3,4);
    //t3.printStats();

    //*********************Player 14*********************************** */
    System.out.println("El nom del pais de "+p14.getName()+" és " +c4.getName());
    System.out.println("El nom del equip es: "+t3.getName()+"\n");
    System.out.println("Estadístiques de: "+p14.getName()+"\n");
    p14.update(2,7,1,3,1);
    p14.printStats();
    System.out.println("__________________________________________________\n");
    //t3.printPlayers();
    //t3.playMatch(3,4);
    //t3.printStats();


    //*********************Player 15*********************************** */
    System.out.println("El nom del pais de "+p15.getName()+" és " +c3.getName());
    System.out.println("El nom del equip es: "+t3.getName()+"\n");
    System.out.println("Estadístiques de: "+p15.getName()+"\n");
    p15.update(2,7,1,3,1);
    p15.printStats();
    System.out.println("__________________________________________________\n");
  
    //*********************Jugadors dels equips*********************************** */        
    t1.printPlayers();
    //System.out.println("__________________________________________________\n");
    t2.printPlayers();
    //System.out.println("__________________________________________________\n");
    t3.printPlayers();
    //System.out.println("__________________________________________________\n");

    System.out.println("Les estadístiques de l'equip "+t1.getName()+" són: ");
    t1.printStats();
    //System.out.println("__________________________________________________\n");

    System.out.println("Les estadístiques de l'equip "+t2.getName()+" són: ");
    t2.printStats();
    //System.out.println("__________________________________________________\n");

    System.out.println("Les estadístiques de l'equip "+t3.getName()+" són: ");
    t3.printStats();
       
    }
}
