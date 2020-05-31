
package proyectomatdispersas;

public class NodoF1 
{
    int fila,col;
    float dato;
    NodoF1 ligafila,ligacol,liga;

    public NodoF1(int fila, int col, float dato) {
        this.fila = fila;
        this.col = col;
        this.dato = dato;
        liga=null;
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

    public NodoF1 getLigafila() {
        return ligafila;
    }

    public void setLigafila(NodoF1 ligafila) {
        this.ligafila = ligafila;
    }

    public NodoF1 getLigacol() {
        return ligacol;
    }

    public void setLigacol(NodoF1 ligacol) {
        this.ligacol = ligacol;
    }

    public NodoF1 getLiga() {
        return liga;
    }

    public void setLiga(NodoF1 liga) {
        this.liga = liga;
    }
}
