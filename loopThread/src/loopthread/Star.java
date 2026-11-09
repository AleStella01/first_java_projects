/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopthread;

/**
 *
 * @author aless
 */
public class Star extends Thread{
    boolean x=true;
    public void run(){
        do{
            System.out.print("S");
            System.out.print("T");
            System.out.print("A");
            System.out.print("R");
            System.out.print(" ");
            System.out.print("\n");
        }while(x);
    }
}
