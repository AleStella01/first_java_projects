/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneconti;

/**
 *
 * @author aless
 */
public class ContoCorrente extends Persona{
    private float saldo;
    
    public ContoCorrente(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, float saldo){
        super(cod_f, n, c, s, via, num_c, r,d);
        this.saldo=saldo;
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Saldo: "+this.saldo+"€");
    }
    
    public void preleva(float p){
        
        if((this.saldo-p)<0){//Se l'importo inserito dovesse essere superiore al saldo
            System.out.println("Errore: importo non disponibile!");
            System.out.println("Il saldo rimanente è: "+this.saldo+"€");
        }
        else 
            this.saldo=this.saldo-p;
    }
    
    public void deposita(float d){
        this.saldo=this.saldo+d;
    }
    
    public float richiesta_saldo(){
        return(this.saldo);
    }
}
