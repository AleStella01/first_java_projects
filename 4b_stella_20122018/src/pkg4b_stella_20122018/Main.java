/**
 * Compito di informatica
 * 
 * Stella Alessandro
 * 
 * 4B
 */

package pkg4b_stella_20122018;

import java.io.*;

public class Main {
    
    private static Tessera t;
    private static TesseraOro to;
    private static TesseraPlatino tp;
    
    public static void main(String[] args) {
        int s;
        boolean x=false;
        
        do{
            s=menu();
            switch(s){
                case 1:
                    crea_tessera();
                    x=true;
                    break;
                case 2:
                    if(x)
                        regalo();
                    else
                        System.out.println("Non è stata creata alcuna tessera");
                    break;
                case 3:
                    if(x)
                        acquista();
                    else
                        System.out.println("Non è stata creata alcuna tessera");
                    break;
                case 4:
                    if(x)
                        mostra();
                    else
                        System.out.println("Non è stata creata alcuna tessera");
            }
        }while(s!=0);
    }
    
    public static int menu(){
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int s=0;
        boolean x=false;
        
        do{
            try{
                System.out.println("\n\n**********MENU'**********\n\n\n");
                System.out.println("Tra le seguenti operazioni: \n\n");
                System.out.println("\t1. Assegnare una tessera");
                System.out.println("\t2. Consegnare il regalo scelto");
                System.out.println("\t3. Aggiornare il numero dei punti");
                System.out.println("\t4. Visualizzare i punti del cliente");
                System.out.println("\t0. ESCI\n\n");
                do{
                    System.out.print("Cosa vuoi fare? ");
                    s=Integer.parseInt(miaTastiera.readLine());
                }while(s<0 || s>4);
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile!");
                x=true;
            }
        }while(x);
        return s;
    }
    
    public static void crea_tessera(){
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int s=0;
        boolean x=false;
        String cod_f="";
        String nome="";
        String cognome="";
        char sesso=0;
        String via="";
        String num_c="";
        String residenza="";
        String data_n="";
        
        System.out.println("\n\n**********CREA TESSERA**********\n\n\n");
        do{
            try{
                System.out.print("Inserire il codice fiscale: ");
                cod_f=miaTastiera.readLine();
                System.out.print("Inserire il nome: ");
                nome=miaTastiera.readLine();
                System.out.print("Inserire il cognome: ");
                cognome=miaTastiera.readLine();
                System.out.print("Inserire il sesso: ");
                sesso=miaTastiera.readLine().charAt(0);
                System.out.print("Inserire la via: ");
                via=miaTastiera.readLine();
                System.out.print("Inserire il numero civico: ");
                num_c=miaTastiera.readLine();
                System.out.print("Inserire la residenza: ");
                residenza=miaTastiera.readLine();
                System.out.print("Inserire la data di nascita: ");
                data_n=miaTastiera.readLine();
                do{
                    System.out.println("Che tessera vuoi creare?\n");
                    System.out.println("\t1. Tessera normale");
                    System.out.println("\t2. Tessera oro");
                    System.out.println("\t3. Tessera platino\n");
                    s=Integer.parseInt(miaTastiera.readLine());
                }while(s<1||s>3);
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        switch(s){
            case 1:
                t=new Tessera(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n);
                break;
            case 2:
                to=new TesseraOro(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n);
                break;
            case 3:
                tp=new TesseraPlatino(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n);
        }
        System.out.println("Tessera creata!");
    }
    
    public static void regalo(){
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int s=0,p=0;
        boolean x=false;
        
        System.out.println("\n\n**********RITIRA REGALO**********\n\n\n");
        do{
            try{
                do{
                    System.out.println("Quale regalo scegli? \n\n");
                    System.out.println("\t1. Moca del caffè (50 pt)");
                    System.out.println("\t2. Set di tazze per latte e caffè(100 pt)");
                    System.out.println("\t3. Batteria di pentole (150 pt)");
                    s=Integer.parseInt(miaTastiera.readLine());
                }while(s<1||s>3);
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        switch(s){
            case 1:
                p=50;
                break;
            case 2:
                p=100;
                break;
            case 3:
                p=150;
        }
        if(t!=null)
            if(t.getPunti()-p<0)
                System.out.println("Non è possibile ritirare il premio: pochi punti a disposizione!");
            else
                t.ritira_premio(p);
        else
            if(to!=null)
                if(to.getPunti()-p<0)
                    System.out.println("Non è possibile ritirare il premio: pochi punti a disposizione!");
                else
                    to.ritira_premio(p);
            else
                if(tp!=null)
                    if(tp.getPunti()-p<0)
                        System.out.println("Non è possibile ritirare il premio: pochi punti a disposizione!");
                    else
                        tp.ritira_premio(p);
    }
    
    public static void acquista(){
        InputStreamReader mioInput=new InputStreamReader(System.in);
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        float spesa=0;
        boolean x=false;
        
        System.out.println("\n\n**********SPESA**********\n\n\n");
        do{
            try{
                System.out.println("Inserire l'importo della spesa: ");
                spesa=Float.parseFloat(miaTastiera.readLine());
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        if(spesa<0)
            spesa=spesa*-1;
        if(t!=null)
            t.acquisto(spesa);
        else
            if(to!=null)
                to.acquisto(spesa);
            else
                if(tp!=null)
                    tp.acquisto(spesa);
    }
    
    public static void mostra(){
        System.out.println("\n\n**********VISUALIZZA**********\n\n\n");
        if(t!=null)
            t.mostra();
        else
            if(to!=null)
                to.mostra();
            else
                if(tp!=null)
                    tp.mostra();
    }
}
