/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfera;

//import java.lang.Math;
/**
 *
 * @author aless
 */
public class Cerchio {

//Caratteristiche - Attributi
   private double raggio;
    
//Costruttore
    public Cerchio(double r){
        this.raggio= r;
    }
//Metodi
    public void setRaggio(double r){
        if(r==0)
            System.out.println("Errore: raggio non accettabile; non sarà modificato");
        else
            this.raggio=r;
    }
    public double getRaggio(){
        return this.raggio;
    }
    public double area (){
        double a;
        a= this.raggio * this.raggio * Math.PI;
        return a;
    
    }
    public double circonferenza(){
        return this.raggio * 2 * Math.PI;
    }
}