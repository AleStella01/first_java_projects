
package quadrato;

import java.lang.Math;

 /* @author aless
*/
public class Quadrato {
    
    //attributi
    public float lato;
    
    //Costruttore
    
    public Quadrato(float l){
        this.lato=l;
    }
    
    //metodi
    
    public double perimetro(){
        return this.lato * 4;
    }
    
    public double area(){
        return Math.pow(this.lato, 2);
    }
}
