/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneoperai;

/**
 *
 * @author aless
 */
public class Operaio extends Persona{
    public int ore_straordinario;
    public int figli;
    public float stipendio;
    
    public Operaio(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, int f, float stip){
        super(cod_f, n,c,s,via,num_c,r,d);
        this.figli=f;
        this.ore_straordinario=0;
        this.stipendio=stip;
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Ore di straordinario: "+this.ore_straordinario);
        System.out.println("Numero figli: "+this.figli);
        System.out.println("Stipendio: "+this.stipendio);
    }
    
    public float calc_stipendio(float imp_figli, float imp_straordinario){
        return(this.stipendio+(this.figli*imp_figli)+(this.ore_straordinario*imp_straordinario));
    }
}
