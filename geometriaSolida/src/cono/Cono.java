/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cono;
/**
 *
 * @author aless
 */
public class Cono extends Cerchio{
    public float altezza;
    
    public Cono(float r, float h){
        super(r);
        this.altezza=h;
    }
    private float calc_vol(){
        float v;
        v=(float) ((super.area()*this.altezza)/3);
        return v;
    }
    private double calc_sup(){
        double ap, s1;
        ap=Math.sqrt(Math.pow(this.altezza, 2)+Math.pow(super.getRaggio(), 2));
        s1=Math.PI*super.getRaggio()*ap;
        return s1;
    }
    public float volume (){
        return calc_vol();
    }
    
    public double superficie(){
        return (calc_sup());
    }
}
