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
public class Utente extends Persona implements Serializable{
    public String utente,pass,ruolo;
    
    public Utente(String user, String pass, String ruolo, String cod_f, String n, String c, char s, String via, String num_c, String r, String d){
        super(cod_f, n, c, s, via, num_c, r, d);
        this.utente=user;
        this.pass=pass;
        this.ruolo=ruolo;
    }
}
