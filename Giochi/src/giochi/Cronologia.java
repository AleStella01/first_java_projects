/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giochi;
import java.io.Serializable;
/**
 *
 * @author aless
 */
public class Cronologia implements Serializable{
    public String squadra_1,squadra_2,punti1,punti2,gioco;
    
    public Cronologia (String s1, String s2, String p1, String p2, String gioco){
        this.squadra_1=s1;
        this.squadra_2=s2;
        this.punti1=p1;
        this.punti2=p2;
        this.gioco=gioco;
    }
}
