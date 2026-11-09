package gestionetessere;

public class TesseraOro extends Persona{
    private int punti;
    public String tessera;
    public String codice;
    
    public TesseraOro(String cod_f, String n, String c, char s, String via, String num_c, String r, String d, String codice){
        super(cod_f,n,c,s,via,num_c,r,d);
        this.punti=0;
        this.tessera="to";
        this.codice=codice;
    }
    
    public int getPunti(){
        return(this.punti);
    }
    
    public void setPunti(int punti){
        this.punti=punti;
    }
    
    public void acquisto(float spesa){
        int p;
        
        p=(int)((spesa/10)-9)*2;
        if(p>1){
            setPunti(p);
        }
    }
    
    public void ritira_premio(int premio){
        int p;
        
        p=getPunti()-premio;
        setPunti(p);
    }
    
    public void mostra(){
        super.mostra();
        System.out.println("Punti accumulati: "+getPunti());
    }
}
