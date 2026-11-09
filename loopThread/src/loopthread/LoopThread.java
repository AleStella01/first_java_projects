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
public class LoopThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Star t1=new Star();
        Star t2=new Star();
        Star t3=new Star();
        
        t1.start();
        t2.start();
        t3.start();
        
        try{
            t1.join();
        }catch(InterruptedException e){
            System.out.println("Errore");
        }
        try{
            t2.join();
        }catch(InterruptedException e){
            System.out.println("Errore");
        }
        try{
            t3.join();
        }catch(InterruptedException e){
            System.out.println("Errore");
        }
    }
    
}