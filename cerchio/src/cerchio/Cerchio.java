/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cerchio;

//import java.lang.Math;
/**
 *
 * @author pantaleo.fabio
 */
public class Cerchio {

//Caratteristiche - Attributi
    public double raggio;
    
//Costruttore
    public Cerchio(double r){
        this.raggio= r;
    }
//Metodi
    public double area (){
        double a;
        a= this.raggio * this.raggio * Math.PI;
        return a;
    
    }
    public double circonferenza(){
        return this.raggio * 2 * Math.PI;
    }
}