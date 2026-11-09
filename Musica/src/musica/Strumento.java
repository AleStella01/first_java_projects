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
public class Strumento implements Serializable{
    public String tipo, marca, modello, qualita, codice;
    public int pezzi;
    public float prezzo;
    
    public Strumento(String tipo, String marca, String modello, String qualita, String codice, int pezzi, float prezzo){
        this.tipo=tipo;
        this.marca=marca;
        this.modello=modello;
        this.qualita=qualita;
        this.codice=codice;
        this.pezzi=pezzi;
        this.prezzo=prezzo;
    }
}
