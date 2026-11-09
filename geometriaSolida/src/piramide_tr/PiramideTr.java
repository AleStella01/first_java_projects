/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piramide_tr;

/**
 *
 * @author aless
 */
public class PiramideTr extends Triangoli{
    public double altezza;
    
    public PiramideTr(double h, double l){
        super(l);
        this.altezza=h;
    }
    
    private double calc_vol(){
        return(super.area()*this.altezza);
    }
    
    private double calc_sup(){
        double al,a;
        a=Math.sqrt(Math.pow(this.altezza, 2)+Math.pow(super.base, 2));
        al=(super.perimetro()*a)/2;
        return(super.area()+al);
    }
    
    public double volume(){
        return(calc_vol());
    }
    
    public double superficie(){
        return(calc_sup());
    }
}
