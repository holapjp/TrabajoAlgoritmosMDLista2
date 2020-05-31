
package proyectomatdispersas;

import javax.swing.JOptionPane;

public class MDlistaF1 
{
    NodoF1 cab;
    public MDlistaF1(int nf,int nc)
    {
        cab=crearCabezas(nf,nc);
    }
    
    
    public NodoF1 crearCabezas(int nf, int nc)
    { 
        NodoF1 p, x,ult;
        int k, n;
        if(nf>nc)
        {
            n=nf;
        }
        else
        {
            n=nc;
        }
        p=new NodoF1(nf,nc,0);
        p.setLigafila(p);
        p.setLigacol(p);
        ult=p;
        for(k=0;k<n;k++)
        {
            x=new NodoF1(k,k,0); 
            x.setLigafila(x);
            x.setLigacol(x);
            ult.setLiga(x);
            ult=x;
        }
        ult.setLiga(p);
        return(p);
    }   
    
    public void menor(){
        NodoF1 p, columna;
        String respuesta = "";
        int indexColumna = 0;
        p = cab.getLiga();
        while(p != cab){
            columna =  p.getLigacol();
            float menordato = 999999999;
            while(columna != p){
                if(columna.getDato() < menordato){
                    menordato = columna.getDato();
                    indexColumna = columna.getCol();
                }
                System.out.println("columna.dato = " + columna.dato);
                columna = columna.getLigacol();
            }
            if(columna.getCol() != indexColumna){
                indexColumna = columna.getCol();
                menordato = columna.getDato();
            }

            respuesta = respuesta + "Columna#" + indexColumna + ": " + menordato + "\n";
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null,respuesta);
    }
    
    //Metodo para mostrar los datos de la lista
    public void mostrar()
    {
        NodoF1 p,q;
        String salida="";
        p=cab.getLiga();
        while(p!=cab)
        {
            q=p.getLigafila();
            while(q!=p)
            {
                salida=salida+q.getDato()+"  ";
                q=q.getLigafila();
            }
            p=p.getLiga();
        }
        JOptionPane.showMessageDialog(null,"Datos dre la matriz\n"+salida);
    }
    
    //Metodo para mostrar la matriz dispersa incluyendo los ceros
     public void mostrar1(){
            NodoF1 p=cab.getLiga(),q;
            String salida="";
            int k,j;
            for(k=0;k<cab.getFila();k++)
            {
                q = p.getLigafila();
                for(j=0;j<cab.getCol();j++)
                {     
                    if(q.getFila()==k&&q.getCol()==j&&q!=p)
                    {
                        salida+=q.getDato()+"   ";
                        q = q.getLigafila();
                    }
                    else
                    {
                        salida+="0.0   ";
                    }
                    
                }
                salida+="\n";
               p=p.getLiga();
            }
          JOptionPane.showMessageDialog(null,"Datos de la matriz\n"+salida);
    }
     //Metodo para ingresar los datos de la matriz dispersa
    public void ingresarDatos()
    {
        int f, c;
        float d;
        String rpa;
        rpa=JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        while(rpa.equals("s"))
        {
            f=Integer.parseInt(JOptionPane.showInputDialog("Ingrese fila"));
            c=Integer.parseInt(JOptionPane.showInputDialog("Ingrese columna"));
         
            if(f>=0&&f<cab.getFila()&&c>=0&&c<cab.getCol())
            {
                   d=Float.parseFloat(JOptionPane.showInputDialog("Ingrese dato"));
                   this.almacenarDato(f,c,d);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No es una posicion valida");
            }
           rpa=JOptionPane.showInputDialog("desea ingresar un dato? s/n");
        }
    }
    /////////
    public void almacenarDato(int f, int c, float d)
    {
        NodoF1 p,q,antf, antc,x;
        p=cab.getLiga();
        //Para encontrar la posicion en la lista de la fila
        while(p!=cab&&p.getFila()<f)
        {
            p=p.getLiga();
        }
        antf=p;
        q=p.getLigafila();
        while(q!=p&&p.getCol()<c)
        {
            antf=q;
            q=q.getLigafila();
        }   
        
        //Para encontrar la posicion en la lista de la columna
        p=cab.getLiga();
        while(p!=cab&&p.getCol()<c)
        {
            p=p.getLiga();
        }
        antc=p;
        q=p.getLigacol();
        while(q!=p&&p.getFila()<f)
        {
            antc=q;
            q=q.getLigacol();
        }   
        if(q!=p&& q.getFila()==f && q.getCol()==c)
        {
            JOptionPane.showMessageDialog(null,"Ya existe un dato en esa posicion");
        }
        else
        {
            x=new NodoF1(f,c,d);
            x.setLigafila(antf.getLigafila());
            antf.setLigafila(x);
            x.setLigacol(antc.getLigacol());
            antc.setLigacol(x);
        }
    }
    public void insertarDato(int f, int c, float d)
    {
        NodoF1 p=cab.getLiga(),q,antF, antC;
        while(p!=cab&&p.getFila()<f)
        {
            p=p.getLiga();
        }
        antF=p;
        q=p.getLigafila();
        while(q!=p&&q.getCol()<c)
        {
            antF=q;
            q=q.getLigafila();
        }
        
        p=cab.getLiga();
        while(p!=cab&&p.getCol()<c)
        {
            p=p.getLiga();
        }
        antC=p;
        q=p.getLigacol();
        while(q!=p&&q.getFila()<f)
        {
            antC=q;
            q=q.getLigacol();
        }
        
        if(q!=p&&q.getFila()==f&&q.getCol()==c)
        {
            if((q.getDato()+d)!=0)
            {
                q.setDato(q.getDato()+d);
            }
            else
            {
               antF.setLigafila(q.getLigafila());
               antC.setLigacol(q.getLigacol());
               //delete(q) aqui se libera el nodo
            }
        }
        else
        {
            q=new NodoF1(f,c,d);
            q.setLigafila(antF.getLigafila());
            antF.setLigafila(q);
            q.setLigacol(antC.getLigacol());
            antC.setLigacol(q);
        }
    }
}
