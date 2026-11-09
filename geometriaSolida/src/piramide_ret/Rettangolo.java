/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piramide_ret;

import parallelepipedo.*;

 /* @author aless
 */
public class Rettangolo {

    public double base;
    public double altezza;
    
    //costruttore
    
    public Rettangolo(double b, double a){
        this.base= b;
        this.altezza= a;
    }
    
    //metodi
    
    public double perimetro(){
        return this.base*2 + this.altezza*2;
    }
    
    public double area(){
        return this.base*this.altezza;
    }
}
