/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rombo;

import java.lang.Math;


 /* @author pantaleo.fabio
 */
public class Rombo {
    
    //attributi
    public double d1;
    public double d2;
    public double lato;
    
    //costruttore
    
    public Rombo( double diagonale1, double diagonale2){
        this.d1=diagonale1;
        this.d2=diagonale2;
    }
    
    //metodi
    
    public double lato(){
        double a;
        double b;
        a= d1/2;
        b=d2/2;
        lato=Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));
        return lato;
    }
    
    public double perimetro(){
        return this.lato*4;
    }
    public double area(){
        return (this.d1* this.d2)/2;
    }
}
