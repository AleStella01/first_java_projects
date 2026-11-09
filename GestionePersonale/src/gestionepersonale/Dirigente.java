/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionepersonale;

/**
 *
 * @author aless
 */
public class Dirigente extends Persona{
    public int straordinario;
    public int figli;
    public int stipendio;
    public int imp_straordinario;
    public int imp_figli;
    
    public Dirigente(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, int f){
        super(cod_f, n,c,s,via,num_c,r,d);
        this.figli=f;
        this.straordinario=0;
        this.stipendio=1200;
        this.imp_straordinario=60;
        this.imp_figli=100;
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Ore di straordinario: "+this.straordinario);
        System.out.println("Numero figli: "+this.figli);
        System.out.println("Stipendio: "+this.stipendio);
        System.out.println("Importo per straordinario: "+this.straordinario);
        System.out.println("Importo per figli: "+this.imp_figli);
    }
    
    public int calc_stipendio(){
        return(this.stipendio+(this.figli*this.imp_figli)+(this.stipendio*this.imp_straordinario));
    }
}
