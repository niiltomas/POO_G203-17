
#ifndef _COUNTRY_
#define _COUNTRY_

#include <cstdlib>
#include <iostream>
#include <list>

class Country {

private:

	std::string name;
	
public:

	Country(std::string n) {
		name = n;
	}
	
	std::string getName() {
		return name;
	}
	
};

#endif

