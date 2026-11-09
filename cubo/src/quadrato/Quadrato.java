
package quadrato;

import java.lang.Math;

 /* @author pantaleo.fabio
*/
public class Quadrato {
    
    //attributi
    public double lato;
    
    //Costruttore
    
    public Quadrato(double l){
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
