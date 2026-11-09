/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionealunni;


/**
 *
 * @author aless
 */
public class Alunno extends Persona{
       
    public String matricola;
    public int crediti[] = {0,0,0};
    public int classe;
    public char sez;
    
    //costruttore da utilizzare per gli alunni frequenranti la 1-2-3
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.classe=cl;
        this.sez=sez;
    }
    
    //costruttore da usare per gli alunni frequentanti la quarta
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cred_3, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.crediti[0]=cred_3;
        this.classe=cl;
        this.sez=sez;
    }
    
    //costruttore da usare per gli alunni frequentanti la quinta
    public Alunno(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String mat, int cred_3, int cred_4, int cl, char sez){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.matricola=mat;
        this.crediti[0]=cred_3;
        this.crediti[1]=cred_4;
        this.classe=cl;
        this.sez=sez;
    }
    
    public int visualizzaCrediti(int a){
        return this.crediti[a];
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Matricola "+this.matricola);
        System.out.print("Classe"+this.classe+"\t");
        System.out.println("Sezione: "+this.sez);
    }
    
    public int calcolaCredito(float media, boolean aiuto){
        int cr=0;
        
        switch(classe-2){
            case 1:
                if(media==6)
                    if(aiuto)
                        cr=7;
                    else
                        cr=8;
                else
                    if(media>6 && media<6.5)
                        cr=8;
                    else
                        if(media>=6.5 && media<=7)
                            cr=9;
                        else
                            if(media>7 && media<7.5)
                                cr=9;
                            else 
                                if (media>= 7.5 && media<=8)
                                    cr=10;
                                else
                                    if(media>8 && media<8.5)
                                        cr=10;
                                    else
                                        if(media>=8.5 && media<=9)
                                            cr=11;
                                        else
                                            if(media>9 && media<9.5)
                                                cr=11;
                                            else
                                                cr=12;
                break;
            case 2:
                if(media==6)
                    if(aiuto)
                        cr=8;
                    else
                        cr=9;
                else
                    if(media>6 && media<6.5)
                        cr=9;
                    else
                        if(media>=6.5 && media<=7)
                            cr=10;
                        else
                            if(media>7 && media<7.5)
                                cr=10;
                            else 
                                if (media>= 7.5 && media<=8)
                                    cr=11;
                                else
                                    if(media>8 && media<8.5)
                                        cr=11;
                                    else
                                        if(media>=8.5 && media<=9)
                                            cr=12;
                                        else
                                            if(media>9 && media<9.5)
                                                cr=12;
                                            else
                                                cr=13;
                break;
            case 3:
                if(media<6)
                    if(aiuto)
                        cr=7;
                    else
                        cr=8;
                else
                    if(media==6)
                        if(aiuto)
                            cr=9;
                        else
                            cr=10;
                    else
                        if(media>6 && media<6.5)
                            cr=10;
                        else
                            if(media>=6.5 && media<=7)
                                cr=11;
                            else
                                if(media>7 && media<7.5)
                                    cr=11;
                                else 
                                    if (media>= 7.5 && media<=8)
                                        cr=12;
                                    else
                                        if(media>8 && media<8.5)
                                            cr=13;
                                        else
                                            if(media>=8.5 && media<=9)
                                                cr=14;
                                            else
                                                if(media>9 && media<9.5)
                                                    cr=14;
                                                else
                                                    cr=15;
                    
        }
        return cr;
    }
}
