/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alunno;

import persona.*;

/**
 *
 * @author aless
 */
public class Alunno extends Persona{
       
    public String matricola;
    public int crediti[] = {0,0,0};
    public int classe;
    public char sez;
    
    //costruttore da utilizzare per gli alunni frequenranti la 1-2-3
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.classe=cl;
        this.sez=sez;
    }
    
    //costruttore da usare per gli alunni frequentanti la quarta
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cred_3, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.crediti[0]=cred_3;
        this.classe=cl;
        this.sez=sez;
    }
    
    //costruttore da usare per gli alunni frequentanti la quinta
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cred_3, int cred_4, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.crediti[0]=cred_3;
        this.crediti[1]=cred_4;
        this.classe=cl;
        this.sez=sez;
    }
       
    public void caricaCredito(int cr,int a){
        this.crediti[a]=cr;
    }
    
    public int visualizzaCrediti(int a){
        return this.crediti[a];
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Matricola "+this.matricola);
        System.out.print("Classe"+this.classe+"\t");
        System.out.println("Sezione: "+this.sez);
    }
}
