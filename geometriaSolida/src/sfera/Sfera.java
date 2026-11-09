/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sfera;

/**
 *
 * @author aless
 */
public class Sfera extends Cerchio{
    
    public Sfera(double r){
        super(r);
    }
    
    private double calc_vol(){
        return ((4*Math.PI*(Math.pow(super.getRaggio(),3))/3));
    }
    
    private double calc_sup(){
        return(4*super.area());
    }
    
    public double volume(){
        return(calc_vol());
    }
    
    public double superficie(){
        return(calc_sup());
    }
}
