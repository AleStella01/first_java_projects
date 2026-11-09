package programma;

import java.io.Serializable;
import java.util.UUID;
import java.util.ArrayList;

public class Persona implements Serializable{
    private UUID id_persona;
    public String nome;
    public String cognome;
    public int seno;
    public int sedere;
    public int viso;
    public int gambe;
    public int personale;
    public int n_foto;
    public float misura;
    public ArrayList account;
    
    public Persona(String nome, String cognome, int seno, int sedere, int viso, int gambe, int p, int n, float mis, ArrayList a){
        this.id_persona = UUID.randomUUID();
        this.nome=nome;
        this.cognome=cognome;
        this.seno=seno;
        this.sedere=sedere;
        this.viso=viso;
        this.gambe=gambe;
        this.personale=p;
        this.n_foto=n;
        this.misura=mis;
        this.account=a;
    }
    
    public void setID(){
        this.id_persona = UUID.randomUUID();
    }
    
    public UUID getID(){
        return this.id_persona;
    }
    
    public void controllaID(ArrayList persone, int pos){
        Persona p,p1;
        boolean trovo=false;
        
        p1=(Persona)persone.get(pos);
        for(int i=0; i<persone.size() && !trovo;i++){
            p=(Persona) persone.get(i);
            if(p1.getID().equals(p.getID()))
                trovo=true;
        }
        if(trovo)
            this.setID();
    }
}
