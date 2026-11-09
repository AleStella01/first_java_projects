/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelepipedo;
/**
 *
 * @author aless
 */
public class Parallelepipedo extends Rettangolo{
    public float altezza;
    
    public Parallelepipedo (float h, float l, float b){
        super(b,l);
        this.altezza=h;
    }
    
    private double calc_vol(){
        double v;
        v= super.area()*this.altezza;
        return v;
    }
    
    private double calc_sup(){
        double s;
        s=(4*super.area())+(2*super.altezza);
        return s;
    }
    
    public double volume(){
        return(calc_vol());
    }
    
    public double superficie(){
        return(calc_sup());
    }
}
