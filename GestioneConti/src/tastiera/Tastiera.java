/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tastiera;

import java.io.*;

public class Tastiera {
    
 
    private static boolean x=false;
    
    
    public static int getInt(){
        int intero=0;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        do{
            x=false;
            try{
                intero=Integer.parseInt(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (intero);
    }
    private Object miaTastiera;
    
    public static float getFloat(){
        float fl=0;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        do{
            x=false;
            try{
                fl=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (fl);
    }
    
    public static double getDouble(){
        double db = 0;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        do{
            x=false;
            try{
                db=Double.parseDouble(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (db);
    }
    
    public static String getString(){
        String str = null;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        do{
            x=false;
            try{
                str=miaTastiera.readLine();
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (str);
    }
    
    public static char getChar(){
        char chr=0;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        do{
            x=false;
            try{
                chr=miaTastiera.readLine().charAt(0);
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (chr);
    }

}