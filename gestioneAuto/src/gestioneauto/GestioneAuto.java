/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneauto;

/**
 *
 * @author aless
 */

import java.io.*;

public class GestioneAuto {

    /**
     * @param args the command line arguments
     */
    
    private static Auto1 a;
    
    public static void main(String[] args) {
        CreaAuto();
        int s;
        float acc;
        char m='f';
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        
        do{
            s=menu();
            switch (s){
                case 1://Accendi
                    a.accenzione();
                    break;
                case 2://Accelera
                        if(a.chiave){
                            try{
                                System.out.print("Di quanto vuoi accelerare? ");
                                acc=Float.parseFloat(miaTastiera.readLine());
                                a.accelera(acc);
                            }catch(IOException | NumberFormatException e){
                                System.out.println("Hai inserito un valore non valido");
                            }
                            m='1';
                        }
                        else 
                            System.out.println("La macchina è ancora spenta");
                        break;
                case 3://decelera
                    if(a.chiave){
                        try{
                            System.out.print("Di quanto vuoi decelerare? ");
                            acc=Float.parseFloat(miaTastiera.readLine());
                            a.decelera(acc);
                        }catch (IOException | NumberFormatException e){
                            System.out.println("Hai inserito un valore non accettabile");
                        }
                    }
                    else
                        System.out.println("La macchina è ancora spenta");
                    break;
                case 4://retromarcia
                    a.cambia_marcia(m);
                    break;
                case 5://Visualizza velocità
                    System.out.println("Velocità: "+a.velocita);
                    break;
                case 6://Visualizza auto
                    vis_auto();
                    break;
                case 7:
                    CreaAuto();
                    break;
                case 8:
                    a.spengi();
                case 9:
                    if("" == a.getTarga()){
                        immatricola();
                    }
                    break;

            }
        }while(s!=0);
    }
    
    private static void CreaAuto(){
        int porte=0;
        float velmax=0;
        String colore="";
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Benvenuto nella officina CreaLaTuaAuto:");
        try{
            do{
                System.out.print("N* porte (da 3 a 5): ");
                porte=Integer.parseInt(miaTastiera.readLine());
            }while(porte<3||porte>5);
            do{
                System.out.print("Velocità massima (da 150 km/h a 350 km/h): ");
                velmax=Float.parseFloat(miaTastiera.readLine());
            }while(velmax<150 || velmax>350);
            System.out.print("Colore: ");
            colore=miaTastiera.readLine();
        }catch (IOException | NumberFormatException e){
            System.out.println("Inserimento errato");
        }
        a=new Auto1(colore, porte, velmax);
        System.out.println("Auto creata! ");
    }
    
    private static int menu(){
        int sc=0;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\n\n**********MENU**********\n\n");
        System.out.println("\t1. Accendi macchina");
        System.out.println("\t2. Premi acceleratore");
        System.out.println("\t3. Rilascia acceleratore");
        System.out.println("\t4. Cambia verso");
        System.out.println("\t5. Visualizza velocità");
        System.out.println("\t6. Visualizza caratteristiche auto");
        System.out.println("\t7. Cambia macchina");
        System.out.println("\t8. Spegni auto");
        System.out.println("\t9. Immatricola auto");
        System.out.println("\t0. ESCI");
        try{
            do{
                System.out.print("Inserisci la scelta: ");
                sc=Integer.parseInt(miaTastiera.readLine());
            }while(sc<0||sc>9);
        }catch(IOException | NumberFormatException e){
            System.out.println("Valori non accettabili!");
        }
        return sc;
    }
    
    public static void vis_auto(){
        System.out.println("Colore: "+a.colore);
        System.out.println("Targa: "+a.getTarga());
        System.out.println("N° porte: "+a.porte);
        System.out.println("Marcia: "+a.marcia);
        System.out.println("Velocità: "+a.velocita);
        System.out.println("Velocità massima: "+a.maxVel);
        System.out.println("Chiave (si/no): "+a.chiave);
    }
    
    public static void immatricola(){
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        String targa = null;
        int c=0;
        
        do{
            try{
                System.out.print("Inserisci la targa: ");
                targa=miaTastiera.readLine();
            }catch(IOException e){
                System.out.println("Hai inserito un valore non accettabile");
                c=1;
            }
        }while(c==1);
        a.setTarga(targa);
    }
}
