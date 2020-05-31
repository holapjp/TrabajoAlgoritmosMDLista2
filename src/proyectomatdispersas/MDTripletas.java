package proyectomatdispersas;

import javax.swing.JOptionPane;

public class MDTripletas {

    int Nfilas;
    int Ncol;
    int Nt;
    float ListaTrip[][];

    //Metodo constructor
    public MDTripletas(int Nfilas, int Ncol, int cd) {
        this.Nfilas = Nfilas;
        this.Ncol = Ncol;
        Nt = cd + 1;
        ListaTrip = new float[Nt][3];
        ListaTrip[0][0] = Nfilas;
        ListaTrip[0][1] = Ncol;
        ListaTrip[0][2] = cd;
    }

    //metodo para mostrar
    public void mostrarv1() {
        String salida = "";
        for (int k = 1; k < ListaTrip[0][2] + 1; k++) {
            salida = salida + (int) ListaTrip[k][0] + "      " + (int) ListaTrip[k][1] + "       " + ListaTrip[k][2] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Datos de la lista de tripletas\nFila  Col dato\n" + salida);
    }
//
//    public void mostrarv3() {
//        String salida = "";
//        for (int k = 1; k < Ncol; k++) {
//            for (int i = 1; i < Nfilas; i++) {
//                salida = salida + (int) ListaTrip[k][0] + "    " + (int) ListaTrip[k][1] + "  " + (int) ListaTrip[k][2];
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Datos de la lista de tripletas\nFila  Col dato\n" + salida);
//    }

    //metodo para mostrar el menor dato de cada una de las columnas
    public void mostrarDatoMenorColumna() {
        String salida = "";
        for (int c = 0; c < ListaTrip[0][1]; c++) {
            float DatoMenor = 9999999;
            for (int k = 1; k < ListaTrip[0][2] + 1; k++) {
                if (c == ListaTrip[k][1]) {
                    if (DatoMenor > ListaTrip[k][2]) {
                        DatoMenor = ListaTrip[k][2];
                    }
                }
            }
            salida = salida + DatoMenor + "\n";
        }
        JOptionPane.showMessageDialog(null, "Datos menores de cada columna: \n" + salida);
    }

    //Método para mostrar el mayor promedio por fila
    public void PromedioMayorFila() {
        String salida = "";
        float mayor = 0;
        for (int filas = 0; filas < ListaTrip[0][0]; filas++) {
            float promedio = 0;
            for (int datos = 1; datos < ListaTrip[0][2] + 1; datos++) {
                if (filas == ListaTrip[datos][0]) {
                    promedio = promedio + ListaTrip[datos][2];
                }
            }
            promedio = (promedio / ListaTrip[0][2]);
            salida = salida + promedio + "\n";
            if (promedio > mayor) {
                mayor = promedio;
            }
        }
        JOptionPane.showMessageDialog(null, "El promedio de cada fila: \n" + salida + "\n El promedio mayor es: " + mayor);
    }

    //Metodo para almacenar una tripleta
    public boolean almacenarTrip(int f, int c, float d) {
        int k = 1, j;
        boolean sw = true;
        while (k < ListaTrip[0][2] + 1 && ListaTrip[k][0] < f && ListaTrip[k][2] != 0) {
            k++;
        }
        while (k < ListaTrip[0][2] + 1 && ListaTrip[k][0] <= f && ListaTrip[k][1] < c && ListaTrip[k][2] != 0) {
            k++;
        }
        if (k < ListaTrip[0][2] + 1 && ListaTrip[k][0] == f && ListaTrip[k][1] == c && ListaTrip[k][2] != 0) {
            JOptionPane.showMessageDialog(null, "Ya existe un dato en esa posicion");
            sw = false;
        } else {
            for (j = (int) ListaTrip[0][2]; j > k; j--) {
                ListaTrip[j][0] = ListaTrip[j - 1][0];
                ListaTrip[j][1] = ListaTrip[j - 1][1];
                ListaTrip[j][2] = ListaTrip[j - 1][2];
            }
            ListaTrip[k][0] = f;
            ListaTrip[k][1] = c;
            ListaTrip[k][2] = d;
        }
        return (sw);
    }

    //Metodo para ingresar los datos de la matriz dispersa
    public void ingresarDatos(int cd) {
        int f, c;
        float d;
        boolean resp;
        for (int k = 1; k <= cd; k++) {
            f = Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
            if (f >= 0 && f <= Nfilas && c >= 0 && c <= Ncol) {
                d = Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
                resp = this.almacenarTrip(f, c, d);
                if (resp == false) {
                    k--;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Los indices no corresponden a la matriz");
                k--;
            }
        }
    }
}
