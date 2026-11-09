/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cubo;
/**
 *
 * @author aless
 */
public class Cubo extends Quadrato {
    
    public Cubo(float l){
        super(l);
    }
    
    private float calc_vol(){
        float v;
        v=(float) Math.pow(super.lato,3);
        return v;
    }
    
    private float calc_sup(){
        float a;
        a=(float) (6*super.area());
        return a;
    }
    
    public float volume(){
        return calc_vol();
    }
    
    public float superficie(){
        return calc_sup();
    }
    
}
