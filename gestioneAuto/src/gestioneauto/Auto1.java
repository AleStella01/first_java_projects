/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestioneauto;

/**
 *
 * @author aless
 */

public class Auto1 {

   //attributi
    public String colore;
    private String targa;
    public int porte;
    public char marcia;//C'è anche la retromarcia(R) e il folle(F)
    public float velocita;
    public float maxVel;//Velocità massima che può raggiungere la macchina
    public boolean chiave;
    
    //costruttore
    public Auto1(String c, int p, float m){
        this.colore=c;
        this.porte=p;
        this.targa=("");//La macchina non è immatricolata
        this.marcia=('F');//La macchina è in folle
        this.velocita=0;//La macchina è ferma al concessionario
        this.maxVel=m;
        this.chiave=false;
    }
    
    //metodi
    public void setTarga(String t){
        this.targa=t;
    }
    
    public String getTarga(){
        return this.targa;
    }
    
    public void accelera(float a){
        if((this.velocita+a)>this.maxVel)
            this.velocita=this.maxVel;//L'accelerazione supera quello che serve per arrivare al massimo
        else
            this.velocita=this.velocita+a;
    }
    
    public void decelera(float d){
        if((this.velocita-d)<0)
            this.velocita=0;
        else
            this.velocita=this.velocita-d;
    }
    
    public void accenzione(){
        if(!chiave){
            this.chiave=true;
            this.marcia='1';
        }
    }
    
    public void spengi(){
        if(this.chiave){
            this.chiave=false;
            this.marcia='R';
        }
    }
    
    public void cambia_marcia(char m){
        if(m!='R'&&m!='r')
            marcia='R';
        else
            marcia='1';
    }
}
