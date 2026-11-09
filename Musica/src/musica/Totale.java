/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;

/**
 *
 * @author aless
 */
public class Totale extends Thread{
    private float add;
    Buffer buffer;
    
    public Totale(float add){
        this.add=add;
        this.buffer= new Buffer();
    }
    public void run(){
        buffer.totale=buffer.prezzo+this.add;
    }
}
