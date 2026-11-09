/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestioneviaggio;

/**
 *
 * @author aless
 */
public class Viaggi {
    
    public String cognome;
    public String nome;
    public String destinazione;
    public String mezzo;
    public char sesso;
    public String tipo_pagamento;
    public String num_carta;
    
    public Viaggi(String cognome, String nome, String destinazione, String mezzo, char sesso, String tp, String nc){
        this.cognome=cognome;
        this.nome=nome;
        this.destinazione=destinazione;
        this.mezzo=mezzo;
        this.sesso=sesso;
        this.tipo_pagamento=tp;
        this.num_carta=nc;
    }
}
