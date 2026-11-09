/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package docente;

/**
 *
 * @author aless
 */
import java.io.*;

public class Docente {

    //Attributi
    public String codf;
    public String cognome;
    public String nome;
    public String ind;
    public String data;
    private String materia;
    
    //Costruttore
    public Docente(String codf, String c, String n, String i, String d){
        this.codf=codf;
        this.cognome=c;
        this.nome=n;
        this.ind=i;
        this.data=d;
        this.materia=("***");
    }
    
    public void assegna(String m){
        if(m==(""))
            System.out.println("Non è stata inserita la materia");
        else
            this.materia=m;
    }
    
    public String getMateria(){
        return this.materia;
    }
    
    public Boolean controlla(){
        boolean x=false;
        
        if(this.materia!=("***"))
            x=true;
        return x;
    }
    
    public void mostra(){
        System.out.println("Codice fiscale: "+this.codf);
        System.out.print("Cognome: "+this.cognome+"\t");
        System.out.println("Nome: "+this.nome);
        System.out.println("Indirizzo: "+this.ind);
        System.out.println("Data: "+this.data);
        if(controlla())
            System.out.println("Materia: "+this.materia);
        else
            System.out.println("Materia: Non ancora assegnata");
    }
}
