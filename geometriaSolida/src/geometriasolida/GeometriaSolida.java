/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geometriasolida;
import cilindro.*;
import cono.*;
import cubo.*;
import parallelepipedo.*;
import piramide.*;
import piramide_ret.*;
import piramide_tr.*;
import sfera.*;
import java.io.*;
/**
 *
 * @author aless
 */
public class GeometriaSolida {

    public static void main(String[] args) {
        int s;
        
        do{
            s=menu();
            switch(s){
                case 1:
                    calc_cilindro();
                    break;
                case 2:
                    calc_cono();
                    break;
                case 3:
                    calc_cubo();
                    break;
                case 4:
                    calc_parallelepipedo();
                    break;
                case 5:
                    calc_piramide();
                    break;
                case 6:
                    calc_piramideRet();
                    break;
                case 7:
                    calc_piramideTr();
                    break;
                case 8:
                    calc_sfera();
            }
        }while(s!=0);
    }
    
    private static int menu(){
        int s = 0;
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        
        System.out.println("\n\n**********GEOMETRIA SOLIDA**********\n\n\n");
        System.out.println("Tra le seguenti figure geometriche: ");
        System.out.println("\t1. Cilindro");
        System.out.println("\t2. Cono");
        System.out.println("\t3. Cubo");
        System.out.println("\t4. Parallelepipedo");
        System.out.println("\t5. Piramide a base quadrata");
        System.out.println("\t6. Piramide a base rettangolare");
        System.out.println("\t7. Piramide a base triangolare");
        System.out.println("\t8. Sfera");
        System.out.println("\t0. ESCI\n\n");
        try{
            do{
                System.out.println("Con quale vuoi lavorare? ");
                s=Integer.parseInt(miaTastiera.readLine());
            }while(s<0||s>8);
        }catch (IOException | NumberFormatException e){
            System.out.println("Hai inserito un valore non accettabile");
        }
        return s;
    }
    
    public static void calc_cilindro(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        float r=0, h=0;
        int p=0;
        
        do{
            try{
                System.out.print("Inserire il valore del raggio: ");
                r=Float.parseFloat(miaTastiera.readLine());
                System.out.println("Inserisci il valore dell'altezza: ");
                h=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                p=1;
            }
        }while(p==1);
        if (h<0)
            h=h*-1;
        if (r<0)
            r=r*-1;
        Cilindro c = new Cilindro (h,r);
        System.out.println("Superficie totale: "+c.sup_tot());
        System.out.println("Volume: "+c.volume()+"\n");
    }
    
    public static void calc_cono(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        float r=0, h=0;
        int p=0;
        
        do{
            try{
                System.out.println("Inserisci il valore del raggio: ");
                r=Float.parseFloat(miaTastiera.readLine());
                System.out.println("Inserisci il valore dell'altezza: ");
                h=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                p=1;
            }
        }while(p==1);
        if (h<0)
            h=h*-1;
        if (r<0)
            r=r*-1;
        Cono c = new Cono (r,h);
        System.out.println("Superficie totale: "+c.superficie());
        System.out.println("Volume: "+c.volume()+"\n");
    }
    
    public static void calc_cubo(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int p=0;
        float l=0;
        
        do{
            try{
                System.out.print("Inserisci il valore del lato: ");
                l=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                p=1;
            }
        }while(p==1);
        if(l<0)
            l=l*-1;
        Cubo c = new Cubo(l);
        System.out.println("Superficie totale: "+c.superficie());
        System.out.println("Volume: "+c.volume()+"\n");
    }
    
   public static void calc_parallelepipedo(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int c=0;
        float h=0,b=0,l=0;
        
        do{
            try{
                System.out.print("Inserisci l'altezza: ");
                h=Float.parseFloat(miaTastiera.readLine());
                System.out.print("Inserisci il lato maggiore della base: ");
                b=Float.parseFloat(miaTastiera.readLine());
                System.out.print("Inserisci il lato minore della base: ");
                l=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                c=1;
            }
        }while(c==1);
        if(h<0)
            h=h*-1;
        if(b<0)
            b=b*-1;
        if(l<0)
            l=l*-1;
        Parallelepipedo p=new Parallelepipedo(h,l,b);
        System.out.println("Superficie totale: "+p.superficie());
        System.out.println("Volume: "+p.volume());
   } 
   
   public static void calc_piramide(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int c=0;
        float l=0, h=0;
        
        do{
            try{
                System.out.print("Inserisci l'altezza: ");
                h=Float.parseFloat(miaTastiera.readLine());
                System.out.print("Inserisci il lato di base: ");
                l=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                c=1;
            }
        }while(c==1);
        if(h<0)
            h=h*-1;
        if(l<0)
            l=l*-1;
        Piramide p=new Piramide(l,h);
        System.out.println("Superficie totale: "+p.superficie());
        System.out.println("Volume: "+p.volume()+"\n");
   }
   
   public static void calc_piramideRet(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int c=0; 
        double h=0,b=0,l=0;
        
        do{
            try{
                System.out.print("Inserisci l'altezza: ");
                h=Float.parseFloat(miaTastiera.readLine());
                System.out.print("Inserisci il lato maggiore del rettangolo: ");
                b=Float.parseFloat(miaTastiera.readLine());
                System.out.print("Inserisci il lato minore del rettangolo: ");
                l=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                c=1;
            }
        }while(c==1);
        if(h<0)
            h=h*-1;
        if(b<0)
            b=b*-1;
        if(l<0)
            l=l*-1;
        PiramideRet p=new PiramideRet(h,b,l);
        System.out.println("Superficie totale: "+p.superficie());
        System.out.println("Volume: "+p.volume()+"\n");
   }
   
   public static void calc_piramideTr(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int c=0;
        double h=0,l=0;
        
        do{
            try{
                System.out.print("Inserisci l'altezza: ");
                h=Double.parseDouble(miaTastiera.readLine());
                System.out.print("Inserisci il lato della base");
                l=Double.parseDouble(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                c=1;
            }
        }while(c==1);
        if(h<0)
            h=h*-1;
        if(l<0)
            l=l*-1;
        PiramideTr p=new PiramideTr(h,l);
        System.out.println("Superficie totale: "+p.superficie());
        System.out.println("Volume: "+p.volume()+"\n");
   }
   
   public static void calc_sfera(){
        InputStreamReader mioInput=new InputStreamReader (System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int c=0;
        double r=0;
        
        do{
            try{
                System.out.print("Inserisci il raggio: ");
                r=Double.parseDouble(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                c=1;
            }
        }while(c==1);
        if (r<0)
            r=r*-1;
        Sfera s=new Sfera(r);
        System.out.println("Superficie totale: "+s.superficie());
        System.out.println("Volume: "+s.volume()+"\n");
   }
}
