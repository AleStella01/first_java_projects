/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tastiera;

public class ControlliConv {
    
    //////////////////////////////////////////////////////////////
    //                          CONTROLLI                       //
    //////////////////////////////////////////////////////////////
    
    //Funzione booleana per verificare se il nome è composto da sole lettere, apostrofi o spazi e che non ci siano due
    //apostrifi o spazi consecutivi
    public static boolean controllanome(String nome) {

	int i, l, c=0;
	boolean illecito=false;
        
        if (nome==null || "".equals(nome))
            return true;
        
        nome=nome.toLowerCase();
        l=nome.length();
        for(i=0; i<l && !illecito; i++) {
            //39=Codice ASCII apostrofo
            if (!((nome.charAt(i)>='a' && nome.charAt(i)<='z') || nome.charAt(i)==' ' || nome.charAt(i)==39))
                illecito=true;
            else {
                if (nome.charAt(i)==' ' || nome.charAt(i)==39) {
                    if (i==0) {
                        illecito=true;
                        return illecito;
                    }
                    c++;
                    if(c==2) {
                       illecito=true;
                       return illecito; 
                    }
                }
                else
                    c=0;
            }
        }
        return illecito;
    }
    
    //Funzione booleana per controllare che la data sia esistente e sia nel formato GG/MM/AAAA
    public static boolean controlladata(String data) {
        
        int i, anno, m, g;
        boolean illecito=false;
        String giorno, mese, annoS;
        
        if(data.length()!=10)
            return true;
        
        if(data.charAt(2)!='/' || data.charAt(5)!='/')
            return true;
        
        for(i=0; i<2; i++) {
            if(!(data.charAt(i)>='0' && data.charAt(i)<='9'))
                return true;
        }
        
        for(i=3; i<5; i++) {
            if(!(data.charAt(i)>='0' && data.charAt(i)<='9'))
                return true;
        }
        
        for(i=6; i<10; i++) {
            if(!(data.charAt(i)>='0' && data.charAt(i)<='9'))
                return true;
        }
        
        //substring estrae da una stringa un pezzo che va dal primo carattere che si scrive a quello dopo la virgola
        //Per quello dopo la virgola bisogna iniziare a contare da 1, per l'altro da 0
        //Riga 73 estrae da data la stringa che va dal primo carattere (0) al secondo (2), quindi estrae il giorno
        giorno=data.substring(0, 2);
        //Si converte la stringa del giorno in intero in modo da poterlo poi controllare
        g=Integer.parseInt(giorno);
        mese=data.substring(3, 5);
        m=Integer.parseInt(mese);
        annoS=data.substring(6, 10);
        anno=Integer.parseInt(annoS); 
        
            
        if(m<1 || m>12)
            return true;
        
        if (m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
            if (g<1 || g>31)
                illecito=true;
	}
        else {
            if (m==4 || m==6 || m==9 || m==11) {
                if (g<1 || g>30)
                    illecito=true;
            }
            else {
                if (anno%4==0) {
                    if (g<1 || g>29) 
                        illecito=true;	
                }
                else {
                    if (g<1 || g>28) 
                        illecito=true;
                }
            }
        }
        return illecito;
    }
    
    //Funzione booleana che controlla il formato del codice fiscale 
    //Prima di usare il controlla assicurarsi di aver effettuato l'uppercase sulla stringa passsata
    public static boolean controllacodice(String c) {
        
        int i, l;
	boolean illecito=false;
        
        l=c.length();
        if(l!=16)
            return true;

	for(i=0; i<6 && !illecito; i++){
            if(!(c.charAt(i)>='A' && c.charAt(i)<='Z')){
                illecito=true;
                return illecito;
            }
	}
        for(i=6; i<8 && !illecito; i++){
            if(!(c.charAt(i)>='0' && c.charAt(i)<='9')){
                illecito=true;
                return illecito;
            }
        }
        if(!(c.charAt(8)>='A' && c.charAt(8)<='Z')){
            illecito=true;
            return illecito;
        }
        for(i=9; i<11 && !illecito; i++){
            if(!(c.charAt(i)>='0' && c.charAt(i)<='9')){
                illecito=true;
                return illecito;
            }
        }
        if(!(c.charAt(11)>='A' && c.charAt(11)<='Z')){
            illecito=true;
            return illecito;
        }
        for(i=12; i<15 && !illecito; i++){
            if(!(c.charAt(i)>='0' && c.charAt(i)<='9')){
               illecito=true;
               return illecito;
            }
        }
        if(!(c.charAt(15)>='A' && c.charAt(15)<='Z')){
            illecito=true;
            return illecito;
        }
        return illecito;
    }
    
    //Funzione booleana che accetta un numero civico composto da numeri ed eventualmente da una sola lettera finale
    //Prima di usare il controlla assicurarsi di aver effettuato l'uppercase sulla stringa passsata
    public static boolean controllacivico(String nc) {
        
        int i, l;
        boolean illecito=false;
        
        if(nc==null || "".equals(nc))
            return true;
       
        l=nc.length();
        if(l==1) {
            if(nc.charAt(0)<'1' || nc.charAt(0)>'9')
                illecito=true;
        }
        else { 
            if(nc.charAt(0)=='0')
                illecito=true;
            else {
                for(i=1; i<l-1 && !illecito; i++) {
                    if(nc.charAt(i)<'0' || nc.charAt(i)>'9')
                        illecito=true;
                }
                
                if(!((nc.charAt(l-1)>='A' && nc.charAt(l-1)<='Z') || (nc.charAt(l-1)>='0' && nc.charAt(l-1)<='9')))
                    illecito=true;
            }
        }
        return illecito;
    }
    
    //Funzione booleana che controlla che la matricola sia composta da soli numeri e lettere
    public static boolean controllamatricola(String m) {
        
        int i, l;
        boolean illecito=false;
        
        if(m==null || "".equals(m))
            return true;
        
        l=m.length();
        for(i=0; i<l && !illecito; i++) {
            if(!((m.charAt(i)>='a' && m.charAt(i)<='z')||(m.charAt(i)>='A' && m.charAt(i)<='Z') || (m.charAt(i)>='0' && m.charAt(i)<='9')))
                illecito=true;
        }
        return illecito;
    }
    
    //////////////////////////////////////////////////////////////
    //                          CONVERSIONI                     //
    //////////////////////////////////////////////////////////////
    
    //Funzione che restituisce la stringa passata con la prima lettera maiuscola e le altre minuscole
    //Viene messa maiuscola anche la lettera dopo uno spazio o un apostrofo
    public static String convertinome(String nome){
        int i, l;
        //Conversione del nome in tutto minuscolo
        nome=nome.toLowerCase();
        
        l=nome.length();
        //raplaceFirst sostituisce alla prima stringa indicata quella dopo la virgola
        //Viene quindi fatto l'uppercase su stringa vuota+primo carattere, cioè di fatto sul primo carattere
        nome=nome.replaceFirst(""+nome.charAt(0), ""+nome.toUpperCase().charAt(0));
        for(i=1; i<l; i++) {
            //Se il carattere in esame è uno spazio o un apostrofo e non si tratta dell'ultimo carattere, il successivo
            //vine messo in maiuscolo (Per replaceFirst vedere nota precedente)
            if (nome.charAt(i)==' ' || nome.charAt(i)==39){
                if(i!=l-1){
                    i++;
                    nome=nome.replaceFirst("" + nome.charAt(i-1) + nome.charAt(i), "" + nome.charAt(i-1) + nome.toUpperCase().charAt(i));
                }
            }
        }
        return nome;
    } 
}