
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometriapiana;

/**
 *
 * @author aless
 */
import java.io.*;
import cerchio.*;
import quadrato.*;
import rettangolo.*;
import rombo.*;
import triangoli.*;

public class GeometriaPiana {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x;
        
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        
        try{
            do{
                System.out.println("Inserisci la scelta della forma geometrica");
                System.out.println("1. Quadrato");
                System.out.println("2. Rettangolo");
                System.out.println("3. Cerchio");
                System.out.println("4. Rombo");
                System.out.println("5. Triangolo");
                System.out.println("0. ESCI");
                do{
                    x=Integer.parseInt(miaTastiera.readLine());//Trasforma la stringa in int
                    if(x<0||x>5){
                        System.out.println("Scelta non valida");
                        System.out.println("Reinserisci la scelta");
                    }
                }while (x<0 || x>5);
                switch(x){
                    case 1:
                        calcolaQuadrato();
                        break;
                    case 2:
                        calcolaRettangolo();
                        break;
                    case 3:
                        calcolaCerchio();
                        break;
                    case 4:
                        calcolaRombo();
                        break;
                    case 5:
                        do{
                            System.out.println("Con quale triangolo vuoi lavorare? ");
                            System.out.println("\t1. Equilatero");
                            System.out.println("\t2. Isoscele");
                            System.out.println("\t3. Scaleno");
                            System.out.println("");
                            x=Integer.parseInt(miaTastiera.readLine());
                            if(x<=0 || x>3)
                                System.out.println("La scelta non è accettabile");
                        }while(x<=0 || x>3);
                        switch(x){
                            case 1:
                                calcolaEqui();
                                break;
                            case 2:
                                calcolaIso();
                                break;
                            case 3:
                                calcolaSca();
                        }
                }
            }while (x!=0);
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
        
    }
    
    private static void calcolaQuadrato(){
        float l;
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci il lato del quadrato: ");
            l=Float.parseFloat(miaTastiera.readLine());
            Quadrato q = new Quadrato (l);
            System.out.println("Il perimetro è: "+q.perimetro());
            System.out.println("L'area è: "+q.area());
            System.out.println("");
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }

    private static void calcolaRettangolo(){
        float b,a;
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci la base del rettangolo: ");
            b=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci l'altezza del rettangolo: ");
            a=Float.parseFloat(miaTastiera.readLine());
            Rettangolo r = new Rettangolo (b,a);
            System.out.println("Il perimetro è: "+r.perimetro());
            System.out.println("L'area è: "+r.area());
            System.out.println("");
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }
    
    private static void calcolaCerchio(){
        float r;
        int x;
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci il raggio: ");
            r=Float.parseFloat(miaTastiera.readLine());
            Cerchio c=new Cerchio (r);
            System.out.println("Tra le seguenti opzioni: ");
            System.out.println("\t1. Calcolare la circonferenza");
            System.out.println("\t2. Calcolare l'area");
            System.out.println("\t3. Cambiare il raggio");
            x=Integer.parseInt(miaTastiera.readLine());
            switch (x){
                case 1:
                    System.out.println("La circonferenza è: "+c.circonferenza());
                    break;
                case 2:
                    System.out.println("L'area è: "+c.area());
                    break;
                case 3:
                    System.out.print("Inserisci il nuovo raggio: ");
                    r=Float.parseFloat(miaTastiera.readLine());
                    c.setRaggio(r);
                    System.out.println("Il nuovo raggio è: "+c.getRaggio());
            }
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }
    
    private static void calcolaRombo(){
        float d1,d2;
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci la prima diagonale: ");
            d1=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci la seconda diagonale: ");
            d2=Float.parseFloat(miaTastiera.readLine());
            Rombo r=new Rombo(d1,d2);
            System.out.println("Il lato è: "+r.lato());
            System.out.println("Il perimetro è: "+r.perimetro());
            System.out.println("L'area è: "+r.area());
            System.out.println("");
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }
    
    private static void calcolaEqui(){
        float l;
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci il lato: ");
            l=Integer.parseInt(miaTastiera.readLine());
            Triangoli t;
            t=new Triangoli(l);
            System.out.println("Il perimetro è: "+t.perimetro());
            System.out.println("L'area è: "+t.area());
            System.out.println("");
        }catch(Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }
    
    private static void calcolaIso(){
        float l,b;
        InputStreamReader mioInput= new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci il lato: ");
            l=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci la base: ");
            b=Float.parseFloat(miaTastiera.readLine());
            Triangoli t;
            t=new Triangoli(b,l);
            System.out.println("Il perimetro è: "+t.perimetro());
            System.out.println("L'area è: "+t.area());
            System.out.println("");
            
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }
    
    private static void calcolaSca(){
        float l1,l2,a,b;
        InputStreamReader mioInput= new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        try{
            System.out.print("Inserisci il cateto minore: ");
            l1=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci il cateto maggiore: ");
            l2=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci l'ipotenusa: ");
            b=Float.parseFloat(miaTastiera.readLine());
            System.out.print("Inserisci l'altezza: ");
            a=Float.parseFloat(miaTastiera.readLine());
            Triangoli t;
            t=new Triangoli(b,l1,l2,a);
            System.out.println("Il perimetro è: "+t.perimetro());
            System.out.println("L'area è: "+t.area());
            System.out.println("");
        }catch (Exception e){
            System.out.println("Hai inserito un valore non valido");
        }
    }

}