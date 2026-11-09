/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piramide_tr;

import java.lang.Math;


 /* @author pantaleo.fabio
 */
public class Triangoli {
    
    //Caratteristiche
    public double base;
    public double altezza;
    public double l1;
    public double l2;
    public double l3;

    //Costruttore
    
    public Triangoli(double b){
        this.base=b;
        this.l1=b;
        this.l2=b;
        this.l3=b;
        this.altezza= Math.sqrt(Math.pow(l1, 2)- Math.pow(this.base/2,2));
    }
    
    public Triangoli(double b, double l){
        this.base=b;
        this.l1=b;
        this.l2=l;
        this.l3=l;
        this.altezza= Math.sqrt(Math.pow(l2,2)- Math.pow(this.base/2,2));
    }
    
    public Triangoli( double b, double lato2, double lato3, double a){
        this.base=b;
        this.l1=b;
        this.l2=lato2;
        this.l3=lato3;
        this.altezza=a;
    }
    
    //Metodi
    
    public double perimetro(){
        double p;
        p=this.l1+this.l2+this.l3;
        return p;
    }
    
    public double area(){
        double area;
        area=(this.altezza*this.base)/2;
        return area;
    }
}
