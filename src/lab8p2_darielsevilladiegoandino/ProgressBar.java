/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab8p2_darielsevilladiegoandino;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JProgressBar;

/**
 *
 * @author HP
 */
public class ProgressBar extends Thread{
    private JProgressBar barra;
    private Universo uni;
    private DefaultListModel modelo;
    
    public ProgressBar() {
    }

    public ProgressBar(JProgressBar barra, Universo uni, DefaultListModel modelo) {
        this.barra = barra;
        this.uni = uni;
        this.modelo = modelo;
        
        
    }

    public void run(){
        try {
            barra.setMaximum(uni.getRegistrado().size());
            
            for (Seres s : uni.getRegistrado()) {
                try {
                    barra.setValue(barra.getValue() + 1);
                    modelo.addElement(s);
                    Thread.sleep(1000);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex); 
                }
            }
            Thread.sleep(3000);
            barra.setValue(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProgressBar.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       }
    }
    @Override
    public String toString() {
        return " barra ->"+ barra;
    }
    
}
