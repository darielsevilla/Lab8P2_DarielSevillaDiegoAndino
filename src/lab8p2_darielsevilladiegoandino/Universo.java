
package lab8p2_darielsevilladiegoandino;

import java.util.ArrayList;

public class Universo {
     private String Nombre;
    private int CantSeres;
    private ArrayList<Seres> Registrado = new ArrayList();

    public Universo() {
    }

    public Universo(String Nombre, int CantSeres) {
        this.Nombre = Nombre;
        this.CantSeres = CantSeres;
    }

    public Universo(String Nombre) {
        this.Nombre = Nombre;
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantSeres() {
        return CantSeres;
    }

    public void setCantSeres(int CantSeres) {
        this.CantSeres = CantSeres;
    }

    public ArrayList<Seres> getRegistrado() {
        return Registrado;
    }

    public void setRegistrado(ArrayList<Seres> registrado) {
        this.Registrado = registrado;
    }

    @Override
    public String toString() {
        return "Universo" + "Nombre->" + Nombre + "\nCantidad de seres ->" + CantSeres;
    }
    
    
}
