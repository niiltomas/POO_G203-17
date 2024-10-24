package Lab1;

public class Main {
    public static void main(String[] args) {
        //a cada player li assignem un país, si són del mateix reaprofitem la variable del país
        //Creem un nou jugador cada vegada, amb el genere, nom, edat i país
        //per a cada equip (en total n'hi han dos) definim el nom, país i gènere.
        //cada cop que creem un player, actualitzem la llista de jugadors de l'equip
        //A mes cada player tindrà unes estadístiques al igual que l'equip, per tant les anirem actualitzant i imprimint respectivament
        //*********************Player 1*********************************** */
        Country c1=new Country("Argentina");
        Player p1=new Player(false,"Messi",36,c1);
        Team t1=new Team("FC Barcelona",c1,Team.Gender.MALE);
        System.out.println("El nom del pais de "+p1.getName()+" és " +c1.getName());
        t1.addPlayer(p1);
        System.out.println("El nom del equip es: "+t1.getName()+"\n");
        t1.printPlayers();
        
        t1.playMatch(5,3);
        t1.printStats();
        System.out.println("El nom del pais de lequip es: "+t1.getCountry().getName()+" \n");
        System.out.println("Estadístiques de: "+p1.getName());
        p1.update(4,3,2,1,1);
        p1.printStats();
        System.out.println("__________________________________________________\n");

        //*********************Player 2*********************************** */
        Country c2=new Country("Portugal");
        Player p2=new Player(false,"Cristiano Ronaldo",30,c2);

        System.out.println("El nom del pais de "+p2.getName()+" és " +c2.getName());
        t1.addPlayer(p2);
        t1.printPlayers();
        t1.playMatch(3,3);
        t1.printStats();
        System.out.println("El nom del equip es: "+t1.getName()+"\n");

        System.out.println("Estadístiques de: "+p2.getName()+"\n");
        p2.update(2,5,2,1,2);
        p2.printStats();
        System.out.println("__________________________________________________\n");
               
        //*********************Player 3*********************************** */
        Country c3=new Country("Brasil");
        Player p3=new Player(false,"Pelé",70,c3);

        System.out.println("El nom del pais de "+p3.getName()+" és " +c3.getName());
        t1.addPlayer(p3);
        t1.printPlayers();
        t1.playMatch(2,3);
        t1.printStats();
        System.out.println("El nom del equip es: "+t1.getName()+"\n");
;
        System.out.println("Estadístiques de: "+p3.getName()+"\n");
        p3.update(2,5,1,1,0);
        p3.printStats();
        System.out.println("__________________________________________________\n");

        
        
        //*********************Player 4*********************************** */
        Country c4=new Country("Spain");
        Player p4=new Player(false,"Iker Casillas",50,c4);
        
        System.out.println("El nom del pais de "+p4.getName()+" és " +c4.getName());
        t1.addPlayer(p4);
        t1.printPlayers();
        t1.playMatch(4,0);
        t1.printStats();
        System.out.println("El nom del equip es: "+t1.getName()+"\n");
;
        System.out.println("Estadístiques de: "+p4.getName()+"\n");
        p4.update(0,56,0,0,0);
        p4.printStats();
        System.out.println("__________________________________________________\n");


        //*********************Player 5*********************************** */
        Country c5=new Country("Spain");
        Player p5=new Player(true,"Alexia Putellas",30,c5);
        Team t2=new Team("Girona FC",c5,Team.Gender.FEMALE);
        System.out.println("El nom del pais de "+p5.getName()+" és " +c5.getName());
        t2.addPlayer(p5);
        System.out.println("El nom del equip es: "+t2.getName()+"\n");
        t2.printPlayers();
        t2.playMatch(0,0);
        t2.printStats();
        System.out.println("El nom del pais de lequip es: "+t2.getCountry().getName()+" \n");
        System.out.println("Estadístiques de: "+p5.getName()+"\n");
        p5.update(4,3,2,0,0);
        p5.printStats();
        System.out.println("__________________________________________________\n");

        //*********************Player 6*********************************** */
        
        Player p6=new Player(true,"Aitana Bonmati",26,c5);
        
        System.out.println("El nom del pais de "+p6.getName()+" és " +c5.getName());
        t2.addPlayer(p6);
        System.out.println("El nom del equip es: "+t2.getName()+"\n");
        t2.printPlayers();
        t2.playMatch(3,2);
        t2.printStats();
        System.out.println("Estadístiques de: "+p6.getName()+"\n");
        p6.update(2,5,2,1,2);
        p6.printStats();
        System.out.println("__________________________________________________\n");
        //*********************Player 7*********************************** */
        Player p7=new Player(false,"Gerard Piqué",35,c5);
        
        System.out.println("El nom del pais de "+p7.getName()+" és " +c5.getName());
        t2.addPlayer(p7);
        System.out.println("El nom del equip es: "+t2.getName()+"\n");
        t2.printPlayers();
        t2.playMatch(2,7);
        t2.printStats();
        System.out.println("Estadístiques de: "+p7.getName()+"\n");
        p7.update(2,5,2,1,0);
        p7.printStats();
        System.out.println("__________________________________________________\n");
        
    }
}
