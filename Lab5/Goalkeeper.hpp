#ifndef _GOALKEEPER_
#define _GOALKEEPER_

#include "Player.hpp"
#include "Match.hpp"

class Goalkeeper : public Player{
private:
    int noSaves;
    int noGoalsLet;

public:
    //Constructor de goalkeeper
    Goalkeeper(bool g, std::string n, int a, Country * c) : Player(g,n,a,c){
        noSaves=0;
        noGoalsLet=0;
        noMatches=0;
    }

    //getters de goalkeeper:
    int getNosaves(){
        return noSaves;
    }
    int getnoGoalslet(){
        return noGoalsLet;
    }
    int getnoMatches(){
        return noMatches;
    }
    //Fi dels getters


    void updateStats(Match * m){//funció per actualitzar les estadístiques de goalkeeper
        //actualitzem les estadístiques del porter del equip local
        noMatches+=1;
        for (Player * player : m->getTeamOne()->getPlayers() ){//recorrem tots els jugadors de l'equip
            Goalkeeper * porter_t1=dynamic_cast<Goalkeeper *>(player);//creem un porter si el jugador es del tipus goalkeeper
            if(porter_t1!=nullptr){//i llavors entrarà dins l'if, per a actualitzar les estadístiques
                porter_t1->noGoalsLet=porter_t1->noGoalsLet + m->getGoalTwo();// Actualizem gols
                porter_t1->noMatches= porter_t1->noMatches +1;// Actualizem numero de partits
            }
        }
        //actualitzem les estadístiques del porter del equip visitant
        for (Player * player2 : m->getTeamTwo()->getPlayers() ){//recorrem tots els jugadors de l'equip
            Goalkeeper * porter_t2=dynamic_cast<Goalkeeper *>(player2);//creem un porter si el jugador es del tipus goalkeeper
            if(porter_t2!=nullptr){//i llavors entrarà dins l'if, per a actualitzar les estadístiques
                porter_t2->noGoalsLet=porter_t2->noGoalsLet + m->getGoalOne();// Actualizem gols
                porter_t2->noMatches= porter_t2->noMatches +1;// Actualizem numero de partits
            }
        }
    }


    void printStats(){//imprimim les estadistiques del goalkeeper
        std::cout << "Ha jugat: " << noMatches << " partits." <<std::endl;
        std::cout << "Ha encaixat: " << noGoalsLet << " gols." <<std::endl;
        std::cout << "Ha parat: " << noSaves << " xuts." <<std::endl;
    }


};

#endif