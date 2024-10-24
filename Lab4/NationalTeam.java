package Lab4;

public class NationalTeam extends Team{

    //Constructor National Team
    public NationalTeam(String nom,Country pais,Gender genero){
        super(nom,pais,genero);
    }

    //Funció per afegir jugador a un equip nacional
    public void addPlayer(Player p){
        if(country.equals(p.getNationality())){//Comprovem que el país sigui el mateix a la nacionalitat de player
            super.addPlayer(p);//si es el cas, afegim el jugador
        }
            
    }
}
