/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cilindro;
/**
 *
 * @author aless
 */
public class Cilindro extends Cerchio {
    public float altezza;
    
    public Cilindro(float h, float r){
        super(r);
        this.altezza=h;
    }
    
    public double volume(){
        return (super.area()*this.altezza);
    }
    
    public double sup_tot(){
        return((2*super.area())+(super.circonferenza()*this.altezza));
    }
}
