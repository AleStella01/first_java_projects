/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionealunni;

import java.io.*;
import java.util.*;
/**
 *
 * @author aless
 */
public class GestioneAlunni {

    private static ArrayList a;
    
    public static void main(String[] args) {
        int s=0, i=-1;//i=indice posizione dell'alunno chiamato in causa
        do{
            s=menu();
            switch(s){
                case 1:
                    creaAlunno();
                    break;
                case 2:
                    if(a!=null){
                        controlla_matricola(i);
                        if(i==-1)
                            System.out.println("Non ho trovato alcun alunno!!!");
                        else
                            scrutina_alunno(i);
                    }else
                        System.out.println("Non è presente alcun alunno!!!");
                    break;
                case 3:
                    if(a!=null){
                        controlla_matricola(i);
                        if(i==-1)
                            System.out.println("Non ho trovato alcun alunno!!!");
                        else
                            visualizza_alunno(i);
                    }else
                        System.out.println("Non è presente alcun alunno!!!");
                    break;
                    
                    
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
        Alunno al = null;
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
                        al = new Alunno(cod_f, nome, cognome, sesso, via, num_c, residenza, data_n, matricola, cred_1 ,classe, sez);
                        break;
                    case 2:
                        System.out.println("Inserisci il credito del terzo anno: ");
                        cred_1=Integer.parseInt(miaTastiera.readLine());
                        System.out.println("Inserisci il credito del quarto anno: ");
                        cred_2=Integer.parseInt(miaTastiera.readLine());
                        al = new Alunno(cod_f, nome, cognome, sesso, via, num_c, residenza, data_n, matricola, cred_1, cred_2, classe, sez);
                        break;
                    default:
                        al =new Alunno(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n,matricola,classe,sez);
                }
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non valido");
                x=true;
            }
        }while(x);
        if(a==null)
            a=new ArrayList(1);
        a.add(al);
    }
    
    public static void scrutina_alunno(int i){
        String matricola=null;
        Alunno al=null;
        boolean x=false,h=false;
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        int n=0;
        char debiti =' ', aiuto = ' ';
        float media=0;
        
        al=(Alunno)a.get(i);
        do{
            x=false;
            try{
                do{
                    System.out.println(al.cognome+" "+al.nome+" ha avuto debiti? (S/N)");
                    debiti=miaTastiera.readLine().charAt(0);
                }while(debiti!='s' && debiti!='S' && debiti!='n' && debiti!='N');
                if(debiti=='s'||debiti=='S'){
                    System.out.println("Quanti debiti ha avuto "+al.cognome+" "+al.nome+"?");
                    n=Integer.parseInt(miaTastiera.readLine());
                    if(n<=3)
                        System.out.println(al.cognome+" "+al.nome+" è stato rimandato!");
                    else
                        System.out.println(al.cognome+" "+al.nome+" è stato bocciato");
                }
                else{
                    System.out.print("Inserisci la media: ");
                    media=Float.parseFloat(miaTastiera.readLine());
                    do {
                        System.out.println(al.cognome+" "+al.nome+" ha avuto aiuti? (s/n)");
                        aiuto=miaTastiera.readLine().charAt(0);
                    }while(aiuto!='s' && aiuto!='S' && aiuto!='n' && aiuto!='N');
                    if(aiuto!='s' || aiuto!='S')
                        h=true;
                    al.crediti[al.classe-3]=al.calcolaCredito(media, h);
                    System.out.println(al.cognome+" "+al.nome+" ha avuto "+al.crediti[al.classe-3]+" crediti");
                }
            }catch(IOException | NumberFormatException e){
                System.out.println("Hai inserito un valore non accettabile");
                x=true;
            }
        }while(x);
        a.remove(i);//Rimuove l'oggetto nella posizione i
        a.add(i, al);//Aggiunge l'oggetto nella posizione i
    }
    
    public static void visualizza_alunno(int i){
        Alunno al=null;
        
        al=(Alunno)a.get(i);
        al.mostra();
    }
    
    public static int controlla_matricola(int i){
        String matricola=null;
        Alunno al=null;
        boolean x=false, c=false;
        InputStreamReader mioInput=new InputStreamReader(System.in); 
        BufferedReader miaTastiera=new BufferedReader(mioInput);
        
        do{
            c=false;
            try{
                System.out.print("Inserisci la matricola dell'alunno: ");
                matricola=miaTastiera.readLine();
            }catch(IOException e){
                System.out.println("Hai inserito un valore non accettabile");
                c=true;
            }
        }while(c);
        for(i=0;i<a.size() && !x;i++){
            al=(Alunno)a.get(i);
            if(matricola.equals(al.matricola))
                x=true;
        }
        if(i==a.size())
            i=0;
        return (i-1);//anche se ha trovato l'alunno, il ciclo for prima incrementa e dopo controlla
    }
}
