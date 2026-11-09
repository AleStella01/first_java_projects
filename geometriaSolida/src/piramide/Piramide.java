/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piramide;

/**
 *
 * @author aless
 */
public class Piramide extends Quadrato{
    public double altezza;
    
    public Piramide(double l, double h){
        super(l);
        this.altezza=h;
    }
    
    private double calc_vol(){
        return((super.area()*this.altezza)/3);
    }
    
    private double calc_sup(){
        double al,a;
        a=Math.sqrt(Math.pow(this.altezza, 2)+Math.pow(super.lato, 2));
        al=(super.perimetro()*a)/2;
        return(super.area()*al);
    }
    
    public double volume(){
        return(calc_vol());
    }
    
    public double superficie(){
        return(calc_sup());
    }
}
