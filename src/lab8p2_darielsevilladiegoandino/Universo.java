
package lab8p2_darielsevilladiegoandino;

import java.util.ArrayList;

public class Universo {
     private String Nombre;
    private int CantSeres;
    private ArrayList<Seres> Registrado = new ArrayList();
    private int id;

    public Universo() {
    }

    public Universo(String Nombre, int CantSeres, int id) {
        this.Nombre = Nombre;
        this.CantSeres = CantSeres;
        this.id = id;
    }

   

    public Universo(String Nombre, int id) {
        this.Nombre = Nombre;
        this.id = id;
    }

    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Nombre;
    }
    
    public String toString2(){
        return "<html>" + "Nombre->" + Nombre + "<br>Cantidad de seres ->" + CantSeres + "</html>";
    }
}
