package Lab3;
public class Main {
    public static void main(String[] args) {
    
    //creem tots els paisos
    Country c1 = new Country("Espanya");
    Country c2 = new Country("EEUU");
    Country c3 = new Country("Brasil");
    
    //creem a tots els jugadors i jugadores
    //MALES
    Player p1 = new Goalkeeper(false, "Iker Casillas", 35, c1);
    Player p2 = new Outfielder(false, "Xavi Hernandez", 41, c1);
    Player p3 = new Outfielder(false, "David Silva", 35, c1);
    Player p4 = new Goalkeeper(false, "Iago Aspas", 34, c1);
    Player p5 = new Outfielder(false, "Christian Pulisic", 23, c2);
    Player p6 = new Outfielder(false, "Weston McKennie", 23, c2);
    Player p7 = new Goalkeeper(false, "Tyler Adams", 22, c2);
    Player p8 = new Outfielder(false, "Sergiño Dest", 21, c2);
    Player p9 = new Outfielder(false, "Neymar Jr.", 29, c3);
    Player p10 = new Outfielder(false, "Gabriel Jesus", 24, c3);
    Player p11 = new Outfielder(false, "Casemiro", 29, c3);
    Player p12 = new Goalkeeper(false, "Firmino", 30, c3);
    Player p13 = new Goalkeeper(false, "Thiago Silva", 37, c3);
    Player p14 = new Outfielder(false, "Marquinhos", 27, c3);         

    //FEMALES
    Player p15 = new Outfielder(true, "Marta Torrejón", 32, c1);
    Player p16 = new Goalkeeper(true, "Carlota Coll", 21, c1);
    Player p17 = new Outfielder(true, "Jennifer Hermoso", 31, c1);
    Player p18 = new Outfielder(true, "Aitana Bonmati", 23, c1);
    Player p19 = new Outfielder(true, "Salma Paralluelos", 20, c1);
    Player p20 = new Outfielder(true, "Alexia Putella", 28, c1);
    Player p21 = new Outfielder(true, "Marta Cardona", 24, c1);
    Player p22 = new Goalkeeper(true, "Nahikari García", 25, c1);
    Player p23 = new Outfielder(true, "Alex Morgan", 32, c2);
    Player p24 = new Outfielder(true, "Megan Rapinoe", 36, c2);
    Player p25 = new Goalkeeper(true, "Julie Ertz", 29, c2);
    Player p26 = new Outfielder(true, "Rose Lavelle", 26, c2);
    Player p27 = new Goalkeeper(true, "Marta", 35, c3);
    Player p28 = new Outfielder(true, "Andressa Alves", 29, c3);

    //creem tots els equips i afegim els jugadors als equips
    Team t1 = new Team("FC Barcelona",c1,Team.Gender.MALE);
    Team t2 = new Team("Betis",c1,Team.Gender.MALE);
    Team t3 = new Team("RCD Espanyol",c1,Team.Gender.FEMALE);
    Team t4 = new Team("Girona FC",c1,Team.Gender.FEMALE);
    Team t5 = new Team("Real Sociedad",c1,Team.Gender.FEMALE);
    Team t6 = new Team("Rayo Vallecano",c1,Team.Gender.MIXTED);

    Team t7 = new Team("Orlando",c2,Team.Gender.FEMALE);
    Team t8 = new Team("New York Red Bulls",c2,Team.Gender.MALE);
    Team t9 = new Team("Philadelphia Union",c2,Team.Gender.MALE);
    Team t10 = new Team("Gotham F",c2,Team.Gender.FEMALE);

    Team t11 = new Team("Palmeiras",c3,Team.Gender.MALE);
    Team t12 = new Team("Brasília Futebol Clube", c3, Team.Gender.MIXTED);
    Team t13 = new Team("Vasco da Gama", c3, Team.Gender.MALE);
    Team t14 = new Team("Flamengo F", c3, Team.Gender.FEMALE);

    t1.addPlayer(p1);
    t1.addPlayer(p2);
    t2.addPlayer(p3);
    t2.addPlayer(p4);
    t3.addPlayer(p15);
    t3.addPlayer(p16);
    t4.addPlayer(p17);
    t4.addPlayer(p18);
    t5.addPlayer(p19);
    t5.addPlayer(p20);
    t6.addPlayer(p21);
    t6.addPlayer(p22);
    t7.addPlayer(p23);
    t7.addPlayer(p24);
    t8.addPlayer(p5);
    t8.addPlayer(p6);
    t9.addPlayer(p7);
    t9.addPlayer(p8);
    t10.addPlayer(p25);
    t10.addPlayer(p26);
    t11.addPlayer(p9);
    t11.addPlayer(p10);
    t12.addPlayer(p11);
    t12.addPlayer(p12);
    t13.addPlayer(p13);
    t13.addPlayer(p14);
    t14.addPlayer(p27);
    t14.addPlayer(p28);   
   
    //Creem i afegim els equips a les lligues
    League league1 = new League(false,"Premier League",c1,Team.Gender.MIXTED);
    League league2 = new League(true, "Serie A", c3, Team.Gender.MIXTED);
    League league3 = new League(true, "United Soccer League Championship (USL Championship)",c2, Team.Gender.MALE);
    League league4 = new League(true, "Major League Soccer (MLS)",c2, Team.Gender.FEMALE);
    

    league1.addTeam(t1);
    league1.addTeam(t4);
    league1.addTeam(t2);
    league1.addTeam(t3);

    league2.addTeam(t11);
    league2.addTeam(t13);
    league2.addTeam(t14);

    league3.addTeam(t8);
    league3.addTeam(t9);

    league4.addTeam(t10);
    league4.addTeam(t7);

    //Simulem partits lliga
    System.out.println("Els partits de la "+league1.getName()+" són: ");
    System.out.println("\n");
    league1.generateMatches(); 
    league1.simulatematches();
    league1.printmatches();
    
    System.out.println("Els partits de la "+league2.getName()+" són: ");
    System.out.println("\n");
    league2.generateMatches(); 
    league2.simulatematches();
    league2.printmatches();

    System.out.println("Els partits de la "+league3.getName()+" són: ");
    System.out.println("\n");
    league3.generateMatches(); 
    league3.simulatematches();
    league3.printmatches();

    System.out.println("Els partits de la "+league4.getName()+" són: ");
    System.out.println("\n");
    league4.generateMatches(); 
    league4.simulatematches();
    league4.printmatches();
    
    //Creem i afegim equips a les copes 
    Cup cup1 = new Cup(true, "Copa del Rey",c1, Team.Gender.MIXTED);
    Cup cup2 = new Cup(false, "Lamar Hunt U.S. Open Cup",c2, Team.Gender.FEMALE);
    //simulem partits de les copes
    cup1.addTeam(t1);
    cup1.addTeam(t2);
    cup1.addTeam(t3);
    cup1.addTeam(t4);
    cup1.addTeam(t5);
    cup1.addTeam(t8);

    cup2.addTeam(t7);
    cup2.addTeam(t10);
    cup2.addTeam(t5);
    System.out.println("Els partits de la "+cup1.getName()+" són: ");
    cup1.simulateMatches();

    System.out.println("Els partits de la "+cup2.getName()+" són: ");
    cup2.simulateMatches();

    //Creem i simulem partits dels group plays
    GroupPlay groupStage = new GroupPlay(true, "Group Stage", c1, Team.Gender.MIXTED, 2);
    groupStage.addTeamtoGroup(t1);
    groupStage.addTeamtoGroup(t2);
    groupStage.addTeamtoGroup(t3);
    groupStage.addTeamtoGroup(t4);
    groupStage.addTeamtoGroup(t5);
    groupStage.addTeamtoGroup(t6);

    System.out.println("Els partits de la " + groupStage.getName() + " són: ");
    System.out.println("\n");
    groupStage.generateMatches();
    groupStage.simulatematches();
    
    //Imprimim les estadíisitques de cada jugador i de cada equip
    System.out.println("Les estadístiques de " + p1.getName() + " són: ");
    p1.printStats();
    System.out.println("Les estadístiques de " + p2.getName() + " són: ");
    p2.printStats();
    System.out.println("Les estadístiques de " + p3.getName() + " són: ");
    p3.printStats();
    System.out.println("Les estadístiques de " + p4.getName() + " són: ");
    p4.printStats();
    System.out.println("Les estadístiques de " + p5.getName() + " són: ");
    p5.printStats();
    System.out.println("Les estadístiques de " + p6.getName() + " són: ");
    p6.printStats();
    System.out.println("Les estadístiques de " + p7.getName() + " són: ");
    p7.printStats();
    System.out.println("Les estadístiques de " + p8.getName() + " són: ");
    p8.printStats();
    System.out.println("Les estadístiques de " + p9.getName() + " són: ");
    p9.printStats();
    System.out.println("Les estadístiques de " + p10.getName() + " són: ");
    p10.printStats();
    System.out.println("Les estadístiques de " + p11.getName() + " són: ");
    p11.printStats();
    System.out.println("Les estadístiques de " + p12.getName() + " són: ");
    p12.printStats();
    System.out.println("Les estadístiques de " + p13.getName() + " són: ");
    p13.printStats();
    System.out.println("Les estadístiques de " + p14.getName() + " són: ");
    p14.printStats();
    System.out.println("Les estadístiques de " + p15.getName() + " són: ");
    p15.printStats();
    System.out.println("Les estadístiques de " + p16.getName() + " són: ");
    p16.printStats();
    System.out.println("Les estadístiques de " + p17.getName() + " són: ");
    p17.printStats();
    System.out.println("Les estadístiques de " + p18.getName() + " són: ");
    p18.printStats();
    System.out.println("Les estadístiques de " + p19.getName() + " són: ");
    p19.printStats();
    System.out.println("Les estadístiques de " + p20.getName() + " són: ");
    p20.printStats();
    System.out.println("Les estadístiques de " + p21.getName() + " són: ");
    p21.printStats();
    System.out.println("Les estadístiques de " + p22.getName() + " són: ");
    p22.printStats();
    System.out.println("Les estadístiques de " + p23.getName() + " són: ");
    p23.printStats();
    System.out.println("Les estadístiques de " + p24.getName() + " són: ");
    p24.printStats();
    System.out.println("Les estadístiques de " + p25.getName() + " són: ");
    p25.printStats();
    System.out.println("Les estadístiques de " + p26.getName() + " són: ");
    p26.printStats();
    System.out.println("Les estadístiques de " + p27.getName() + " són: ");
    p27.printStats();
    System.out.println("Les estadístiques de " + p28.getName() + " són: ");
    p28.printStats();
    
    System.out.println("Les estadístiques de " + t1.getName() + " són: ");
    t1.printStats();
    System.out.println("Les estadístiques de " + t2.getName() + " són: ");
    t2.printStats();
    System.out.println("Les estadístiques de " + t3.getName() + " són: ");
    t3.printStats();
    System.out.println("Les estadístiques de " + t4.getName() + " són: ");
    t4.printStats();
    System.out.println("Les estadístiques de " + t5.getName() + " són: ");
    t5.printStats();
    System.out.println("Les estadístiques de " + t6.getName() + " són: ");
    t6.printStats();
    System.out.println("Les estadístiques de " + t7.getName() + " són: ");
    t7.printStats();
    System.out.println("Les estadístiques de " + t8.getName() + " són: ");
    t8.printStats();
    System.out.println("Les estadístiques de " + t9.getName() + " són: ");
    t9.printStats();
    System.out.println("Les estadístiques de " + t10.getName() + " són: ");
    t10.printStats();
    System.out.println("Les estadístiques de " + t11.getName() + " són: ");
    t11.printStats();
    System.out.println("Les estadístiques de " + t12.getName() + " són: ");
    t12.printStats();
    System.out.println("Les estadístiques de " + t13.getName() + " són: ");
    t13.printStats();
    System.out.println("Les estadístiques de " + t14.getName() + " són: ");
    t14.printStats();
    }
}
