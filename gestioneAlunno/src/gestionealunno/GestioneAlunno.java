/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionealunno;
import java.io.*;
/**
 *
 * @author aless
 */
public class GestioneAlunno {
    public static Alunno a;
    
    public static void main(String[] args) {
        boolean x=true;
        int s=0;
        
        do{
            switch(s=menu()){
                case 1:
                    creaAlunno();
                    System.out.println(a.cognome+" "+a.nome+" è stato iscritto!");
                    break;
                case 2:
                    if(a!=null){
                        scrutina_alunno();
                        x=false;
                    }
                    else
                        System.out.println("Non è stato iscritto alcun alunno!");
                    break;
                case 3:
                    if(a!=null)
                        a.mostra();
                    else
                        System.out.println("Non è stato iscritto alcun alunno");
                    break;
                case 4:
                    if(a!=null)
                        if(x)
                            scrutinio_est();
                        else
                            System.out.println("L'alunno è gia stato scrutinato");
                    else
                        System.out.println("Non è stato iscritto alcun alunno");
            }
        }while(s!=0);
    }
    
    public static int menu(){
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        boolean x=false;
        int s=0;
        do{
            x=false;
            try{
                System.out.println("**********MENU'**********\n\n");
                System.out.println("Tra le seguenti funzioni: \n");
                System.out.println("\t1. Iscrivi alunno");
                System.out.println("\t2. Scrutina alunno");
                System.out.println("\t3. Visualizza alunno");
                System.out.println("\t4. Scrutinio estivo");
                System.out.println("\t0. ESCI\n\n\n");
                do{
                    System.out.print("Quale vuoi eseguire? ");
                    s=Integer.parseInt(miaTastiera.readLine());
                }while(s<0||s>4);    
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                x=true;
            }
        }while(x);
        return s;
    }
    
    public static void creaAlunno(){
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        boolean x=false;
        String cod_f;
        String nome;
        String cognome;
        char sesso;
        String via;
        String num_c;//in caso di palazzi
        String residenza;//intesa come il paese di provenienza
        String data_n;
        String matricola;
        int classe;
        char sez;
        int cred_1, cred_2;
        
        do{
            x=false;
            try{
                System.out.print("Inserisci il codice fiscale: ");
                cod_f=miaTastiera.readLine();
                System.out.print("Inserisci il nome: ");
                nome=miaTastiera.readLine();
                System.out.print("Inserisci il cognome: ");
                cognome=miaTastiera.readLine();
                System.out.print("Inserisci il sesso: ");
                sesso=miaTastiera.readLine().charAt(0);
                System.out.print("Inserisci la via: ");
                via=miaTastiera.readLine();
                System.out.print("Inserisci il numero civico: ");
                num_c=miaTastiera.readLine();
                System.out.print("Inserisci il paese di residenza: ");
                residenza=miaTastiera.readLine();
                System.out.print("Inserisci la data di nascita: ");
                data_n=miaTastiera.readLine();
                System.out.print("Inserisci la matricola: ");
                matricola=miaTastiera.readLine();
                do{
                    System.out.print("Inserisci la classe: ");
                    classe=Integer.parseInt(miaTastiera.readLine());
                }while(classe<1 || classe>5);
                System.out.print("Inserisci la sezione: ");
                sez=miaTastiera.readLine().charAt(0);
                switch(classe-3){
                    case 1:
                        System.out.println("Inserisci il credito del terzo anno: ");
                        cred_1=Integer.parseInt(miaTastiera.readLine());
                        a = new Alunno(cod_f, nome, cognome, sesso, via, num_c, residenza, data_n, matricola, cred_1 ,classe, sez);
                        break;
                    case 2:
                        System.out.println("Inserisci il credito del terzo anno: ");
                        cred_1=Integer.parseInt(miaTastiera.readLine());
                        System.out.println("Inserisci il credito del quarto anno: ");
                        cred_2=Integer.parseInt(miaTastiera.readLine());
                        a = new Alunno(cod_f, nome, cognome, sesso, via, num_c, residenza, data_n, matricola, cred_1, cred_2, classe, sez);
                        break;
                    default:
                        a=new Alunno(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n,matricola,classe,sez);
                }
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                x=true;
            }
        }while(x);
    }
    
    public static void scrutina_alunno(){
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        boolean x=false, h=false;
        float media;
        char aiuto,debiti;
        int n;
        
        do{
            try{
                do{
                    System.out.println(a.cognome+" "+a.nome+" ha avuto debiti? (S/N)");
                    debiti=miaTastiera.readLine().charAt(0);
                }while(debiti!='s' && debiti!='S' && debiti!='n' && debiti!='N');
                if(debiti=='s'||debiti=='S'){
                    System.out.println("Quanti debiti ha avuto "+a.cognome+" "+a.nome+"?");
                    n=Integer.parseInt(miaTastiera.readLine());
                    if(n<=3)
                        System.out.println(a.cognome+" "+a.nome+" è stato rimandato!");
                    else
                        System.out.println(a.cognome+" "+a.nome+" è stato bocciato");
                }
                else{
                    System.out.print("Inserisci la media: ");
                    media=Float.parseFloat(miaTastiera.readLine());
                    do {
                        System.out.println(a.cognome+" "+a.nome+" ha avuto aiuti? (s/n)");
                        aiuto=miaTastiera.readLine().charAt(0);
                    }while(aiuto!='s' && aiuto!='S' && aiuto!='n' && aiuto!='N');
                    if(aiuto!='s' || aiuto!='S')
                        h=true;
                    a.crediti[a.classe-3]=a.calcolaCredito(media, h);
                    System.out.println(a.cognome+" "+a.nome+" ha avuto "+a.crediti[a.classe-3]+" crediti");
                }
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
    }
    
    public static void scrutinio_est(){
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        boolean x=false, h=false;
        char debiti = 0, aiuto=0;
        float media=0;
        do{
            try{
                do{
                    System.out.print(a.cognome+" "+a.nome+" ha superato le carenze estive? (s/n)");
                    debiti=miaTastiera.readLine().charAt(0);
                }while(debiti!='s' && debiti!='S' && debiti!='n' && debiti!='N');
                if(debiti=='s' || debiti=='S'){
            System.out.println("Inserisci la media: ");
            media=Float.parseFloat(miaTastiera.readLine());
            do {
                System.out.println(a.cognome+" "+a.nome+" ha avuto aiuti? (s/n)");
                aiuto=miaTastiera.readLine().charAt(0);
            }while(aiuto!='s' && aiuto!='S' && aiuto!='n' && aiuto!='N');
                if(aiuto!='s' || aiuto!='S')
                    h=true;
            a.crediti[a.classe-3]=a.calcolaCredito(media, h);
            System.out.println(a.cognome+" "+a.nome+" ha avuto "+a.crediti[a.classe-3]+" crediti");
            System.out.println(a.cognome+" "+a.nome+" è stato promosso!");
            
        }    
        else
            System.out.println(a.cognome+" "+a.nome+" è stato bocciato!");
            }catch(IOException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        
    }
}
