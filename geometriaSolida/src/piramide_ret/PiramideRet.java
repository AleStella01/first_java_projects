/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piramide_ret;

/**
 *
 * @author aless
 */
public class PiramideRet extends Rettangolo{
    public double altezza;
    
    public PiramideRet(double h, double b, double l){
        super(b,l);
        this.altezza=h;
    }
    
    private double calc_vol(){
        return(super.area()*this.altezza);
    }
    
    private double calc_sup(){
        return(super.area()+((super.perimetro()*super.base*0.28867)/2));
    }
    
    public double volume(){
        return(calc_vol());
    }
    
    public double superficie(){
        return(calc_sup());
    }
}
