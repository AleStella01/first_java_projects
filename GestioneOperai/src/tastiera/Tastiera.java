/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tastiera;

import java.io.*;

public class Tastiera {
    
    private int intero;
    private float fl;
    private double db;
    private String str;
    private char chr;
    private boolean x=false;
    BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
    
    public int getInt(){
        do{
            x=false;
            try{
                this.intero=Integer.parseInt(this.miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (this.intero);
    }
    
    public float getFloat(){
        do{
            x=false;
            try{
                this.fl=Float.parseFloat(this.miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (this.fl);
    }
    
    public double getDouble(){
        do{
            x=false;
            try{
                this.db=Double.parseDouble(this.miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (this.db);
    }
    
    public String getString(){
        do{
            x=false;
            try{
                this.str=this.miaTastiera.readLine();
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (this.str);
    }
    
    public char getChar(){
        do{
            x=false;
            try{
                this.chr=this.miaTastiera.readLine().charAt(0);
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        return (this.chr);
    }
}
