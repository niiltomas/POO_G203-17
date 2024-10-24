#ifndef _OUTFIELDER_
#define _OUTFIELDER_


#include "Player.hpp"
#include "Match.hpp"
class Outfielder : public Player{
private:

    int noTackles;
    int noPasses;
    int noShots;
    int noAssists;
    int noGoals;
    
public:
    //Constructor
    Outfielder (bool g, std::string n, int a, Country * c) : Player(g,n,a,c){
        noTackles=0;
        noPasses=0;
        noShots=0;
        noAssists=0;
        noGoals=0; 
        noMatches=0; 
    }

    //Getters
    int getnoTackles(){
        return noTackles;
    }
    int getnoPasses(){
        return noPasses;
    }
    int getnoShots(){
        return noShots;
    }
    int getnoAssists(){
        return noAssists;
    }
    int getnoGoals(){
        return noGoals;
    }
    int getnoMatches(){
        return noMatches;
    }
    //Finalització de funcions getters


    void updateStats(Match * m){
        noMatches+=1;

        //Equip 1
        for( Player * scorer_t1 : m->getScorersOne() ){//recorrem tots els scorers de l'equip
            Outfielder * outfielder_t1 = dynamic_cast<Outfielder * >(scorer_t1);//creem un ourfielder si el jugador es del tipus outfielder
            if(outfielder_t1!=nullptr){//i llavors entrarà dins l'if, per a actualitzar les estadístiques
                outfielder_t1->noGoals = outfielder_t1->noGoals + 1;//actualitzem el numero de gols
            }
        }

        //Equip 2
        for( Player * scorer_t2 : m->getScorersTwo() ){//recorrem tots els scorers de l'equip
            Outfielder * outfielder_t2 = dynamic_cast<Outfielder * >(scorer_t2);//creem un ourfielder si el jugador es del tipus outfielder
            if(outfielder_t2!=nullptr){//i llavors entrarà dins l'if, per a actualitzar les estadístiques
                outfielder_t2->noGoals = outfielder_t2->noGoals + 1;//actualitzem el numero de gols
            }
        }


    }


    void printStats(){//imprimim les estadistiques del jugador
        std::cout << "Ha jugat: " << *noMatches << " partits." <<std::endl;
        std::cout << "Ha fet: " << noTackles << " faltes." <<std::endl;
        std::cout << "Ha donat: " << noPasses << " passes." <<std::endl;
        std::cout << "Ha xutat: " << noShots << " cops a porteria." <<std::endl;
        std::cout << "Ha donat: " << noAssists << " assistencies." <<std::endl;
        std::cout << "Ha marcat: " << noGoals << " gols." <<std::endl; 
    }

};
#endif