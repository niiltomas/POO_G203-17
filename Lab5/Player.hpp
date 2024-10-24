#ifndef _PLAYER_
#define _PLAYER_


#include "Country.hpp"
class Match;

class Player{
protected:
    bool female;
    std::string name;
    int age;
    Country* nationality;
    int noMatches;
    
public:
    //constructor de la classe Player
    Player(bool g, std::string n, int a, Country * c){
        female=g;
        name=n;
        age=a;
        nationality=c;
    }
    //getters 
    bool isFemale(){//retorna true/false del genere
    return female;
    }
    std::string getName() {
		return name;
	}
    int getAge(){//retorna l'edat del jugador
        return age;
    }
    Country * getNationality(){//retorna la nacionalitat del jugador
        return nationality;
    }
    int getnoMatches(){//retorna el numero de partits
        return noMatches;
    }

    //mètodes abstractes que tenen una implementació concreta a goalkeeper i Outfielder
    virtual void updateStats(Match * m) = 0;

    virtual void printStats() = 0;
};
#endif