/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;

import java.io.Serializable;

/**
 *
 * @author aless
 */
public class Spartito implements Serializable{
    public String marca,tipo,autore,titolo,codice;
    public int pezzi;
    public float prezzo;
    
    public Spartito(String marca, String tipo, String autore, String titolo, String codice, int pezzi, float prezzo){
        this.marca=marca;
        this.tipo=tipo;
        this.autore=autore;
        this.titolo=titolo;
        this.codice=codice;
        this.pezzi=pezzi;
        this.prezzo=prezzo;
    }
}
