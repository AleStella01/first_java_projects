/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contocorrente;

/**
 *
 * @author aless
 */


public class ContoCorrente {

    //Attributi
    public String codf;
    public String cognome;
    public String nome;
    public String ind;
    public String data;
    public char sesso;
    private float saldo;
    
    //Costruttore
    public ContoCorrente(String codf, String c, String n, String i, String d, char s, float saldo){
        this.codf=codf;
        this.cognome=c;
        this.nome=n;
        this.ind=i;
        this.data=d;
        this.sesso=s;
        this.saldo=saldo;
    }
    
    //Metodi
    public void setSaldo(float s){
        this.saldo=s;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public void preleva(float p){
        if(p<0)
            p=p*-1;
        if((this.saldo-p)<0){//Se l'importo inserito dovesse essere superiore al saldo
            System.out.println("Errore: il saldo mancante è inferiore alla cifra inserita");
            System.out.println("Il saldo rimanente è: "+this.saldo);
            System.out.println("Sarà prelevata solo questa somma");
            this.saldo=0;
        }
        else 
            this.saldo=this.saldo-p;
    }
    
    public void deposita(float d){
        if (d<0)
            d=d*(-1);
        this.saldo=this.saldo+d;
    }
    
    public void richiestaSaldo(){
        System.out.println("L'importo complessivo presente sul conto è: "+this.saldo);
    }
    
    public void mostra(){
        System.out.println("Codice fiscale: "+this.codf);
        System.out.print("Cognome: "+this.cognome+"\t");
        System.out.println("Nome: "+this.nome);
        System.out.println("Indirizzo: "+this.ind);
        System.out.println("Data di nascita: "+this.data);
        System.out.println("Sesso: "+this.sesso);
    }
}
