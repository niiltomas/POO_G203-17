package Lab4;
//programa donat pel professorat de classe
public class Country {
    protected String name;
    //constructor
    public Country(String n) {
        name = n;
    }
    //getter per obtenir el nom del país
    public String getName() {
        return name;
    } 
    
    public boolean equals(Object o){//funció per comprovar si una instància és del tipus  Country
        if(o instanceof Country){
            Country c=(Country)o;
            return name==c.name;//retornarà true si la igualtat es compleix
        }
        else return false;//si no es cumpleix retorna false
    }
}
