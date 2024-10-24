#include <iostream>
#include <string> 
#include "Goalkeeper.hpp"
#include "Outfielder.hpp"


int main() {
    //Creem Paisos
    Country c1 ("Espanya");
    Country c2 ("EEUU");
    Country c3 ("Brasil");

    //Creem Outfielders 
    Outfielder p1(false,"Xavi Hernandez",41,&c1);
    Outfielder p2(false,"David Silva",35,&c1);
    Outfielder p3(false, "Christian Pulisic", 23, &c2);
    Outfielder p4(false, "Weston McKennie", 23, &c2);
    Outfielder p5(false, "Gabriel Jesus", 24, &c3);
    Outfielder p6(false, "Casemiro", 29, &c3);

    Outfielder p7(true, "Marta Torrejón", 32, &c1);
    Outfielder p8(true, "Salma Paralluelos", 20, &c1);
    Outfielder p9(true, "Alex Morgan", 32, &c2);
    Outfielder p10(true, "Megan Rapinoe", 36, &c2);
    Outfielder p11(true, "Andressa Alves", 29, &c3);
    Outfielder p12(true, "Rosa Lavelle", 26, &c3);

    //Creem Goalkeepers
    Goalkeeper p13(false, "Iker Casillas", 35, &c1);
    Goalkeeper p14(false, "Tyler Adams", 22, &c2);
    Goalkeeper p15(false, "Firmino", 30, &c3);

    Goalkeeper p16(true, "Carlota Coll", 21, &c1);
    Goalkeeper p17(true, "Julie Ertz", 29, &c2);
    Goalkeeper p18(true, "Marta", 35, &c3);

    //Creem equips
    Team t1("FC Barcelona",&c1,Team::MALE);
    Team t2("New York Red Bulls",&c2,Team::MALE);
    Team t3("Palmeiras",&c3,Team::MALE);

    Team t4("Girona FC",&c1,Team::FEMALE);
    Team t5("Gotham F",&c2,Team::FEMALE);
    Team t6("Flamengo F",&c3,Team::FEMALE);

    //Afegim els/les players als equips
    t1.addPlayer(&p1);
    t1.addPlayer(&p2);
    t1.addPlayer(&p13);

    t2.addPlayer(&p3);
    t2.addPlayer(&p4);
    t2.addPlayer(&p14);

    t3.addPlayer(&p5);
    t3.addPlayer(&p6);
    t3.addPlayer(&p15);

    t4.addPlayer(&p7);
    t4.addPlayer(&p8);
    t4.addPlayer(&p16);

    t5.addPlayer(&p9);
    t5.addPlayer(&p10);
    t5.addPlayer(&p17);

    t6.addPlayer(&p11);
    t6.addPlayer(&p12);
    t6.addPlayer(&p18);

    //Creem i simulem partits
    Match m1(&t1,&t2);
    m1.simulateMatch();
    m1.printMatch();
    
    Match m2(&t3,&t4);
    m2.simulateMatch();
    m2.printMatch();

    Match m3(&t5,&t6);
    m3.simulateMatch();
    m3.printMatch();

    Match m4(&t6,&t1);
    m4.simulateMatch();
    m4.printMatch();

    Match m5(&t4,&t2);
    m5.simulateMatch();
    m5.printMatch();

    Match m6(&t5,&t3);
    m6.simulateMatch();
    m6.printMatch();
    std::cout << "_______________________________________________________________________________________\n";
    //Imprimim les estadístiques de cada jugador
    std::cout << p1.getName() << "\n";
    p1.printStats();
    std::cout << p2.getName() << "\n";
    p2.printStats();
    std::cout << p3.getName() << "\n";
    p3.printStats();
    std::cout << p4.getName() << "\n";
    p4.printStats();
    std::cout << p5.getName() << "\n";
    p5.printStats();
    std::cout << p6.getName() << "\n";
    p6.printStats();
    std::cout << p7.getName() << "\n";
    p7.printStats();
    std::cout << p8.getName() << "\n";
    p8.printStats();
    std::cout << p9.getName() << "\n";
    p9.printStats();
    std::cout << p10.getName() << "\n";
    p10.printStats();
    std::cout << p11.getName() << "\n";
    p11.printStats();
    std::cout << p12.getName() << "\n";
    p12.printStats();
    std::cout << p13.getName() << "\n";
    p13.printStats();
    std::cout << p14.getName() << "\n";
    p14.printStats();
    std::cout << p15.getName() << "\n";
    p15.printStats();
    std::cout << p16.getName() << "\n";
    p16.printStats();
    std::cout << p17.getName() << "\n";
    p17.printStats();
    std::cout << p18.getName() << "\n";
    p18.printStats();

}