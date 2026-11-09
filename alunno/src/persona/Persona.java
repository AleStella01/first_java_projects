/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

/**
 *
 * @author aless
 */
public class Persona {
    
    //Caratteristiche o parametri
    
    public String cod_f;
    public String nome;
    public String cognome;
    public char sesso;
    public String via;
    public String num_c;//in caso di palazzi
    public String residenza;//intesa come il paese di provenienza
    public String data_n;
    
    //Costruttore
    
    public Persona(String cod_f, String n, String c, char s, String via, String num_c, String r, String d){
        this.cod_f=cod_f;
        this.nome=n;
        this.cognome=c;
        this.sesso=s;
        this.via=via;
        this.num_c=num_c;
        this.residenza=r;
        this.data_n=d;
    }
    //Metodi
    
    public void mostra(){
        System.out.println("Codice fiscale: "+this.cod_f);
        System.out.println("Nome: "+this.nome);
        System.out.println("Cognome: "+this.cognome);
        System.out.println("Sesso: "+this.sesso);
        System.out.println("Via: "+this.via);
        System.out.println("Numero civico: "+this.num_c);
        System.out.println("Residenza: "+this.residenza);
        System.out.println("Data di nascita: "+this.data_n);
    }
}
