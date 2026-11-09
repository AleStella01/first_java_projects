/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author aless
 */
public class Etichetta extends JLabel{
    private Font font = new Font ("Tahoma",1,9);
    private Color colore=Color.BLACK;
    
    public Etichetta(String label){
        super(label);
        setForeground(colore);
        setFont(font);
    }
}
