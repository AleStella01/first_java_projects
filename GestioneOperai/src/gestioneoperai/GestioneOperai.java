package gestioneoperai;

import java.io.*;
import java.util.*;
import tastiera.*;

/**
 *
 * @author aless
 */

public class GestioneOperai {
    
    private static Operaio op;
    private static ArrayList a;
    private static float imp_figli; 
    private static float imp_straordinario;
    private static Tastiera t = new Tastiera();

    
    public static void main(String[] args) {
        int s;
        BufferedReader miaTastiera=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Importo per ogni figlio: ");
        try{
            imp_figli=Float.parseFloat(miaTastiera.readLine());
        }catch(IOException | NumberFormatException e){
            System.out.println("Errore, hai inserito un valore non accettabile");
        }
        do{
            s=menu();
            switch(s){
                case 1:
                    assumi_dipendente();
                    break;
                case 2:
                    if(a!=null){
                        visualizza_dipendenti();
                    }
                    else{
                        System.out.println("Non sono stati assunti ancora dipendenti!");
                    }
                    break;
                case 3:
                    if(a!=null)
                        visualizza_stipendi();
                    else
                        System.out.println("Non sono stati assunti ancora dipendenti!");
                    break;
                case 4:
                    if(a!=null)
                        visualizza_dati_dipendente();
                    else
                        System.out.println("Non sono stati assunti ancora dipendenti!");
                    break;
                case 5:
                    if(a!=null)
                        aggiornamento_straordinario();
                    else
                        System.out.println("Non sono stati assunti ancora dipendenti!");
                    break;
            }
        }while(s!=0);
    }
    
    private static int menu(){
        int sc=0;
        
        System.out.println("\n\n**********MENU**********\n\n");
        System.out.println("\t1. Assumi dipendente");
        System.out.println("\t2. Stampa dati dipendenti");
        System.out.println("\t3. Stampa stipendi complessivi dipendenti");
        System.out.println("\t4. Visualizza dati dipendente");
        System.out.println("\t5. Aggiornamento ore straordinario dipendente");
        System.out.println("\t0. ESCI");
        do{
            sc=t.getInt();
            if(sc<0 || sc>5)
                System.out.println("Errore nell'inserimento dei dati!");
        }while (sc<0 || sc>5);
        return sc;
    }
    
    private static void assumi_dipendente(){
        String cod_f;
        String nome;
        String cognome;
        char sesso;
        String via;
        String num_c;//in caso di palazzi
        String residenza;//intesa come il paese di provenienza
        String data_n;
        int num_f;
        float stip;
        int p;
        
        if(a==null)
            a=new ArrayList(1);
        do{
            System.out.print("Inserisci il codice fiscale: ");
            cod_f=t.getString();
            p=ricerca_dipendente(cod_f);
            if(p!=-1)
                System.out.println("Il dipendente è già stato inserito!");
        } while(p!=-1);
        System.out.print("Inserisci il nome: ");
        nome=t.getString();
        System.out.print("Inserisci il cognome: ");
        cognome=t.getString();
        System.out.print("Inserisci il sesso: ");
        sesso=t.getChar();
        System.out.print("Inserisci la via: ");
        via=t.getString();
        System.out.print("Inserisci il numero civico: ");
        num_c=t.getString();
        System.out.print("Inserisci il paese di residenza: ");
        residenza=t.getString();
        System.out.print("Inserisci la data di nascita: ");
        data_n=t.getString();
        System.out.print("Inserisci il numero di figli: ");
        num_f=t.getInt();
        do{
            System.out.print("Inserisci lo stipendio base: ");
            stip=t.getFloat();
            if(stip <= 0)
                System.out.println("Inserisci uno stipendio valido!");
        }while(stip <= 0);
        op=new Operaio(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n, num_f, stip);
        a.add(op);
    }
    
    private static void visualizza_dipendenti(){
        
        for(int i=0; i>a.size();i++){
            op=(Operaio) a.get(i);
            op.mostra();
        }
    }
    
    private static void visualizza_stipendi(){
        int i;
        for(i=0;i<a.size();i++){
            op=(Operaio)a.get(i);
            System.out.println("Codice fiscale: "+op.cod_f);
            System.out.println("Nome: "+op.nome);
            System.out.println("Cognome: "+op.cognome);
            System.out.println("Ore straordinario: "+op.ore_straordinario);
            System.out.println(" Stipendio complessivo: "+op.calc_stipendio(imp_figli, imp_straordinario));
        }
    }
    
    private static int ricerca_dipendente(String cod_f){
        int pos = -1;
        int i;
        for(i=0; i<a.size() && pos==-1; i++){
            op=(Operaio)a.get(i);
            if(op.cod_f.equals(cod_f))
                pos=i;
        }
        return pos;
    }
    
    private static void visualizza_dati_dipendente(){
        int pos;
        String cod_f;
        
        System.out.print("Inserisci il codice fiscale: ");
        cod_f=t.getString();
        pos=ricerca_dipendente(cod_f);
        if(pos==-1)
            System.out.println("Non ho trovato alcun dipendente!");
        else{
            op=(Operaio)a.get(pos);
            op.mostra();
            System.out.println("Stipendio complessivo: "+op.calc_stipendio(imp_figli, imp_straordinario));
        }
    }
    
    private static void aggiornamento_straordinario(){
        String cod_f;
        
        visualizza_dati_dipendente();
        System.out.println("E' L'OPERAIO GIUSTO?");
        char risp=t.getChar();
        if(risp=='S' || risp=='s'){
            System.out.print("Inserisci le ore di straordinario mensili: ");
            op.ore_straordinario=t.getInt();
        }
        
    }
}
