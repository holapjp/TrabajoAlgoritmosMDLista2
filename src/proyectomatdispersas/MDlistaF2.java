package proyectomatdispersas;


import javax.swing.JOptionPane;

public class MDlistaF2 {

    NodoF2 cab;

    public MDlistaF2(int nf, int nc) {
        cab = new NodoF2(nf, nc, 0);
        cab.setLigafila(cab);
        cab.setLigacol(cab);
    }

    //Metodo para mostrar
    public void mostrar() {
        NodoF2 p = cab.getLigafila();
        String salida = "";
        while (p != cab) {
            salida += p.getDato() + "  ";
            p = p.getLigafila();
        }
        JOptionPane.showMessageDialog(null, "Datos de la matriz dispersa\n" + salida);
    }

    //Metodo para mostrar la matriz con ceros
    public void mostrar1() {

        NodoF2 p = cab.getLigafila();
        String salida = "";
        for (int k = 0; k < cab.getFila(); k++) {
            for (int j = 0; j < cab.getCol(); j++) {
                if (p != cab && p.getFila() == k && p.getCol() == j) {
                    salida += p.getDato() + "     ";
                    p = p.getLigafila();
                } else {
                    salida += "0.0     ";
                }
            }
            salida += "\n";
        }
        JOptionPane.showMessageDialog(null, "Datos de la matriz dispersa\n" + salida);
    }

    //Metodo para ingresar los datos de la matriz dispersa
    public void ingresarDatos() {
        int f, c;
        float d;
        String rpa;
        rpa = JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        while (rpa.equals("s")) {
            f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));

            if (f >= 0 && f < cab.getFila() && c >= 0 && c < cab.getCol()) {
                d = Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
                this.almacenarDato(f, c, d);
            } else {
                JOptionPane.showMessageDialog(null, "No es una posicion valida");
            }
            rpa = JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        }
    }

    //Metodo para insertar Dato
    public void insertarDato(int f, int c, float d) {
        NodoF2 p, antf = cab, antc = cab;
        p = cab.getLigafila();
        while (p != cab && p.getFila() < f) {
            antf = p;
            p = p.getLigafila();
        }

        while (p != cab && p.getFila() <= f && p.getCol() < c) {
            antf = p;
            p = p.getLigafila();
        }

        p = cab.getLigacol();
        while (p != cab && p.getCol() < c) {
            antc = p;
            p = p.getLigacol();
        }

        while (p != cab && p.getCol() <= c && p.getFila() < f) {
            antc = p;
            p = p.getLigacol();
        }
        if (p != cab && p.getFila() == f && p.getCol() == c) {
            if (p.getDato() + d != 0) {
                p.setDato(p.getDato() + d);
            } else {
                antf.setLigafila(p.getLigafila());
                antc.setLigacol(p.getLigacol());
                //delete(p) aca se elimina el nodo
            }
        } else {
            NodoF2 x = new NodoF2(f, c, d);
            x.setLigafila(antf.getLigafila());
            antf.setLigafila(x);
            x.setLigacol(antc.getLigacol());
            antc.setLigacol(x);
        }
    }

    //Metodo para almacenar un un Dato
    public void almacenarDato(int f, int c, float d) {
        NodoF2 p, antf = cab, antc = cab;
        p = cab.getLigafila();
        while (p != cab && p.getFila() < f) {
            antf = p;
            p = p.getLigafila();
        }

        while (p != cab && p.getFila() <= f && p.getCol() < c) {
            antf = p;
            p = p.getLigafila();
        }

        p = cab.getLigacol();
        while (p != cab && p.getCol() < c) {
            antc = p;
            p = p.getLigacol();
        }

        while (p != cab && p.getCol() <= c && p.getFila() < f) {
            antc = p;
            p = p.getLigacol();
        }
        if (p != cab && p.getFila() == f && p.getCol() == c) {
            JOptionPane.showMessageDialog(null, "Ya existe un dato en esa posicion");
        } else {
            NodoF2 x = new NodoF2(f, c, d);
            x.setLigafila(antf.getLigafila());
            antf.setLigafila(x);
            x.setLigacol(antc.getLigacol());
            antc.setLigacol(x);
        }
    }

    public MDlistaF2 Traspuesta() {
        NodoF2 p;
        p = cab.getLigafila();
        MDlistaF2 resultado = new MDlistaF2(cab.getCol(), cab.getFila());
        while (p != cab) {
            System.out.println(p.getDato());
            resultado.insertarDato(p.getCol(), p.getFila(), p.getDato());
            p = p.getLigafila();
        }
        return resultado;
    }

    public MDlistaF2 Sumas(MDlistaF2 a, MDlistaF2 b) {
        if (a.cab.getCol() == b.cab.getCol() && a.cab.getFila() == b.cab.getFila()) {
            NodoF2 p;
            p = a.cab.getLigafila();
            while (p != a.cab) {
                NodoF2 q = b.cab.getLigafila();
                System.out.println(p.getDato());
                b.insertarDato(p.getFila(), p.getCol(), p.getDato());
                p = p.getLigafila();
            }
            b.mostrar1();
            return b;

        } else {
            JOptionPane.showMessageDialog(null, "No es posible realizar la operación, matrices de dimensiones distinstas.");
            return null;
        }
    }

    public MDlistaF2 Multiplicar(MDlistaF2 a, MDlistaF2 b){

        if(a.cab.getCol() == b.cab.getFila()){
            NodoF2 p,q;
            MDlistaF2 resultado =  new MDlistaF2(a.cab.getFila(), b.cab.getCol());
            p = a.cab.getLigacol();
            int indexFila;
            for (int k = 0; k < a.cab.getFila() ; k++) {
                indexFila = 0;
                q = b.cab.getLigacol();
                for(int i = 0; i < b.cab.getCol();i++){
                    NodoF2 valor = p;
                    indexFila = q.getCol();
                    while(valor != a.cab && (q != b.cab && q.getCol() == indexFila)){
                        System.out.println(valor.getDato() * q.getDato());
                        resultado.insertarDato(valor.fila,q.col,(valor.getDato() * q.getDato()));
                        valor = valor.getLigafila();
                        q = q.getLigacol();
                    }
                }
                p = p.getLigacol();
            }
            return  resultado;
        }else{
            JOptionPane.showConfirmDialog(null,"Las matrices no son validas para llevar a cabo esta operación");
            return null;
        }
    }



    public void Promedio(MDlistaF2 a) {
        NodoF2 p;
        p = a.cab.getLigacol();
        String rpa  =  "";
        while (p != a.cab) {
            float valor = 0;
            int index = p.getCol();
            while (p != a.cab && index == p.getCol()) {
                if (p.getCol() == index){
                    valor = valor  + p.getDato();
                }
                p = p.getLigacol();
            }
            rpa =  rpa + "El promedio de la ooluman#" + index + " es: " + (valor/a.cab.getFila()) + "\n";
            index = p.getCol();
        }
        System.out.println(rpa);
    }

}
