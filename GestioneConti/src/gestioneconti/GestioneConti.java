/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneconti;

/**
 *
 * @author aless
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tastiera.*;
import java.util.*;

public class GestioneConti {

    private static ArrayList conti;
    private static ContoCorrente cc;
    
    public static void main(String[] args) {
        int s;
        do{
            s=menu();
            switch(s){
                case 1:
                    assumi_dipendente();
                    break;
                case 2:
                    if(conti!=null)
                        visualizza_conti();
                    else
                        System.out.println("Non sono stati creati conti correnti!");
                    break;
                case 3:
                    if(conti!=null)
                        visualizza_conto_cf();
                    else
                        System.out.println("Non sono stati creati conti correnti!");
                    break;
                case 4:
                    if(conti!=null)
                        visualizza_conto_nc();
                    else
                        System.out.println("Non sono stati creati conti correnti!");
                    break;
                case 5:
                    if(conti!=null)
                        preleva();
                    else
                        System.out.println("Non sono stati creati conti correnti!");
                    break;
                case 6:
                    if(conti!=null)
                        deposita();
                    else
                        System.out.println("Non sono stati creati conti correnti");
                    break;
                case 7:
                    if(conti!=null)
                        if(conti.size()>1)
                            trasferimento();
                        else
                            System.out.println("Conti non sufficienti per eseguire il trasferimento!");
                    else
                        System.out.println("Non sono stati creati conti correnti");
            }
        }while(s!=0);
    }
    
    private static int menu(){
        int sc=0;
        
        System.out.println("\n\n**********MENU**********\n\n");
        System.out.println("\t1. Accensione conto corrente");
        System.out.println("\t2. Visualizza conti correnti");
        System.out.println("\t3. Visualizza conto corrente per codice fiscale");
        System.out.println("\t4. Visualizza conto corrente per cognome e nome");
        System.out.println("\t5. Preleva");
        System.out.println("\t6. Deposita");
        System.out.println("\t7. Trasferimento importo");
        System.out.println("\t0. ESCI");
        do{
            sc=Tastiera.getInt();
            if(sc<0 || sc>7)
                System.out.println("Errore nell'inserimento dei dati!");
        }while (sc<0 || sc>7);
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
        float saldo;
        int p;
        boolean illecito;
        
        if(conti==null)
            conti=new ArrayList(1);
        do{
            do{
                illecito=false;
                System.out.print("Inserisci il codice fiscale: ");
                cod_f=Tastiera.getString().toUpperCase();
                illecito=ControlliConv.controllacodice(cod_f);
                if(illecito)
                    System.out.println("Inserisci un codice fiscale valido!");
            }while(illecito);
            p=ricerca_conto(cod_f);
            if(p!=-1)
                System.out.println("Il dipendente è già stato inserito!");
        } while(p!=-1);
        do{
            illecito=false;
            System.out.print("Inserisci il nome: ");
            nome=Tastiera.getString();
            nome=ControlliConv.convertinome(nome);
            illecito=ControlliConv.controllanome(nome);
            if(illecito)
                System.out.println("Inserisci un nome valido!");
        }while(illecito);
        do{
            illecito=false;
            System.out.print("Inserisci il cognome: ");
            cognome=Tastiera.getString();
            cognome=ControlliConv.convertinome(cognome);
            illecito=ControlliConv.controllanome(cognome);
        }while (illecito);
        do{
            System.out.print("Inserisci il sesso (M/F): ");
            sesso=Tastiera.getChar();
        }while(sesso!='m' && sesso!='M' && sesso != 'f' && sesso != 'F');
        System.out.print("Inserisci la via: ");
        via=Tastiera.getString();
        do{
            illecito=false;
            System.out.print("Inserisci il numero civico: ");
            num_c=Tastiera.getString();
            illecito=ControlliConv.controllacivico(num_c);
        }while(illecito);
        System.out.print("Inserisci il paese di residenza: ");
        residenza=Tastiera.getString();
        do{
            illecito=false;
            System.out.print("Inserisci la data di nascita (GG/MM/AAAA): ");
            data_n=Tastiera.getString();
            illecito=ControlliConv.controllacivico(num_c);
        }while(illecito);
        do{
            System.out.print("Inserisci il saldo iniziale: ");
            saldo=Tastiera.getFloat();
            if (saldo<-1)
                System.out.println("Errore: Saldo non valido");
        }while(saldo<-1);
        cc=new ContoCorrente(cod_f,nome,cognome,sesso,via,num_c,residenza,data_n,saldo);
        conti.add(cc);
    }
    
    private static void visualizza_conti(){
        for(int i=0; i<conti.size();i++){
            cc=(ContoCorrente) conti.get(i);
            System.out.println("Codice fiscale: "+cc.cod_f);
            System.out.println("Cognome: "+cc.cognome);
            System.out.println("Nome: "+cc.nome);
            System.out.println("Saldo: "+cc.richiesta_saldo()+"€");
        }
    }
    
    private static int ricerca_conto(String cod_f){
        int pos= -1;
        int i;
        for(i=0; i<conti.size() && pos==-1; i++){
            cc=(ContoCorrente)conti.get(i);
            if(cc.cod_f.equals(cod_f))
                pos=i;
        }
        return pos;
    }
    
    private static void visualizza_conto_cf(){
        int pos;
        String cod_f;
        boolean illecito;
        do{
            illecito=false;
            System.out.print("Inserisci il codice fiscale: ");
            cod_f=Tastiera.getString().toUpperCase();
            illecito=ControlliConv.controllacodice(cod_f);
            if(illecito)
                System.out.println("Inserisci un codice fiscale valido!");
        }while(illecito);
        pos=ricerca_conto(cod_f);
        if(pos==-1)
            System.out.println("Non ho trovato alcun conto corrente!");
        else{
            cc=(ContoCorrente)conti.get(pos);
            cc.mostra();
        }
    }
    
    private static void visualizza_conto_nc(){
        String nome, cognome;
        int pos=-1;
        int i;
        boolean illecito;
        do{
            illecito=false;
            System.out.print("Inserisci il cognome: ");
            cognome=Tastiera.getString();
            cognome=ControlliConv.convertinome(cognome);
            illecito=ControlliConv.controllanome(cognome);
        }while (illecito);
        do{
            illecito=false;
            System.out.print("Inserisci il nome: ");
            nome=Tastiera.getString();
            nome=ControlliConv.convertinome(nome);
            illecito=ControlliConv.controllanome(nome);
            if(illecito)
                System.out.println("Inserisci un nome valido!");
        }while(illecito);
        for(i=0; i<conti.size() && pos==-1; i++){
            cc=(ContoCorrente)conti.get(i);
            if(cc.cognome.equals(cognome) && cc.nome.equals(nome)){
                pos=i;
                cc.mostra();
            }
        }
    }
    
    private static void preleva(){
        float prelievo;
        char risp;
        
        do{
            visualizza_conto_cf();
            System.out.println("E' IL CONTO GIUSTO? (S/N)");
            risp=Tastiera.getChar();
            if(risp=='S' || risp=='s'){
                do{
                    System.out.print("Inserisci l'importo da prelevare: ");
                    prelievo=Tastiera.getFloat();
                    if(prelievo<0)
                        System.out.println("Inserire un importo valido!");
                    else
                        cc.preleva(prelievo);
                }while(prelievo<0);
            }
        }while(risp=='N' || risp=='n');
    }
    
    private static void deposita(){
        float deposito;
        char risp;
        
        do{
            visualizza_conto_cf();
            System.out.println("E' IL CONTO GIUSTO? (S/N)");
            risp=Tastiera.getChar();
            if(risp=='S' || risp=='s'){
                do{
                    System.out.print("Inserisci l'importo da depositare: ");
                    deposito=Tastiera.getFloat();
                    if(deposito<0)
                        System.out.println("Inserire un importo valido!");
                }while(deposito<0);
            }
        }while(risp=='N' || risp=='n');
    }
    
    private static void trasferimento(){
        char risp;
        float transf = 0;
        do{
            visualizza_conto_cf();
            System.out.println("E' IL CONTO GIUSTO? (S/N)");
            risp=Tastiera.getChar();
            if(risp=='S' || risp=='s'){
                do{
                    System.out.print("Inserisci l'importo da trasferire: ");
                    transf=Tastiera.getFloat();
                    if(transf<0)
                        System.out.println("Inserire un importo valido!");
                    else
                        cc.preleva(transf);
                }while(transf<0);
            }
        }while(risp=='N' || risp=='n');
        System.out.println("Su quale conto vuoi trasefire?");
        do{
            visualizza_conto_cf();
            System.out.println("E' IL CONTO GIUSTO? (S/N)");
            risp=Tastiera.getChar();
            if(risp=='S' || risp=='s')
                cc.deposita(transf);
        }while(risp=='N' || risp=='n');
    }
}