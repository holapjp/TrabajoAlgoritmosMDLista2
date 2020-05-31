
package proyectomatdispersas;

public class NodoF2 
{
    int fila,col;
    float dato;
    NodoF2 ligafila,ligacol;

    public NodoF2(int fila, int col, float dato) {
        this.fila = fila;
        this.col = col;
        this.dato = dato;
        ligafila=null;
        ligacol=null;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public NodoF2 getLigafila() {
        return ligafila;
    }

    public void setLigafila(NodoF2 ligafila) {
        this.ligafila = ligafila;
    }

    public NodoF2 getLigacol() {
        return ligacol;
    }

    public void setLigacol(NodoF2 ligacol) {
        this.ligacol = ligacol;
    }

    NodoF1 getLiga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
}
