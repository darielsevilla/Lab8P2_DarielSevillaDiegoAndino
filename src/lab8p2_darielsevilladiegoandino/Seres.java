
package lab8p2_darielsevilladiegoandino;

public class Seres {
    private String Nombre;
    private int ID;
    private int Poder;
    private int Años;
    private Universo Universo;
    private boolean Humano;

    public Seres(String Nombre, int ID, int Poder, int Años, Universo Universo, boolean Humano) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.Poder = Poder;
        this.Años = Años;
        this.Universo = Universo;
        this.Humano = Humano;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPoder() {
        if(Poder >= 1 && Poder <= 10){
        return Poder;
        }
        return 0;
    }

    public void setPoder(int Poder) {
        this.Poder = Poder;
    }

    public int getAños() {
        return Años;
    }

    public void setAños(int Años) {
        this.Años = Años;
    }

    public Universo getUniverso() {
        return Universo;
    }

    public void setUniverso(Universo Universo) {
        this.Universo = Universo;
    }

    public boolean getHumano() {
        return Humano;
    }

    public void setHumano(boolean Humano) {
        this.Humano = Humano;
    }

    public boolean isHumano() {
        return Humano;
    }
    
    
    @Override
    public String toString() {
        String temp = "";
        if(Humano){
            temp = "humano";
        }else{
            temp = "amanto";
        }
        return  "Nombre->" + Nombre + "\nID=" + ID + "\nPoder->" + Poder + "\nyears->" + Años + "\nraza->" + temp;
    }
    
    
}
