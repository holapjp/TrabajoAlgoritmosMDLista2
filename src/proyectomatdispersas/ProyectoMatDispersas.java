
package proyectomatdispersas;

import javax.swing.JOptionPane;

public class ProyectoMatDispersas {

    
    public static void main(String[] args) 
    {
        MDlistaF2 ListaPrueba = new MDlistaF2(2, 3);
        ListaPrueba.almacenarDato(0, 0, 1);
        ListaPrueba.almacenarDato(0, 1, -2);
        ListaPrueba.almacenarDato(0, 2, 3);
        ListaPrueba.almacenarDato(1, 0, 1);
        ListaPrueba.almacenarDato(1, 1, 0);
        ListaPrueba.almacenarDato(1, 2, -1);


        
        MDlistaF2 ListaPrueba2 = new MDlistaF2(3, 1);
        ListaPrueba2.almacenarDato(0, 0, 4);
        ListaPrueba2.almacenarDato(1, 0, 5);
        ListaPrueba2.almacenarDato(2, 0, 6);
        ListaPrueba.Multiplicar(ListaPrueba,ListaPrueba2).mostrar1();






        
        
//        Esto para probar matriz en tripletas
//       MDTripletas mdt;
//       int nf, nc, cd;
//       nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas de la matriz"));
//       nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas de la matriz"));
//       cd=Integer.parseInt(JOptionPane.showInputDialog("Cuantos datos diferentes de cero tiene la matriz"));
   
//       mdt=new MDTripletas(4,4,12);
//       mdt.almacenarTrip(0, 0, 2);
//       mdt.almacenarTrip(0, 1, 16);
//       mdt.almacenarTrip(0, 2, 4);
//       mdt.almacenarTrip(0, 3, 4);
//       mdt.almacenarTrip(1, 0, 10);
//       mdt.almacenarTrip(1, 1, 8);
//       mdt.almacenarTrip(1, 2, 4);
//       mdt.almacenarTrip(1, 3, 10);
//       mdt.almacenarTrip(2, 0, 8);
//       mdt.almacenarTrip(2, 1, 4);
//       mdt.almacenarTrip(2, 2, 4);
//       mdt.almacenarTrip(2, 3, 10);
//       mdt.ingresarDatos(cd);
//       mdt.mostrarv1();
//       mdt.mostrarDatoMenorColumna();
//       mdt.PromedioMayorFila();
//       mdt.mostrarv3();
//        
//        Esto para probar matriz en listas forma 1
//        MDlistaF1 mdf1;
//        int nf, nc, cd;
//        nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas de la matriz"));
//        nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas de la matriz"));
//        mdf1=new MDlistaF1(nf,nc);
//        
//        mdf1.ingresarDatos();
//        mdf1.mostrar();
//        mdf1.mostrar1();
//        mdf1.menor();
     
        
////        Esto para probar matriz en listas forma 2
//        MDlistaF2 mdf2;
//        int nf, nc, cd;
//        nf=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de filas de la matriz"));
//        nc=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de columnas de la matriz"));
//        
//        mdf2=new MDlistaF2(nf,nc);
//        
//        mdf2.ingresarDatos();
//        
//        mdf2.mostrar();
//        mdf2.mostrar1();
//        
    }
    
}
