package accesoaficherosiii;

import java.io.File;

public class AccesoAFicherosIII2 {

    public static void main(String[] args) {
        File ruta = new File("F:\\PROYECTOS\\PROGRAMACION");
        if(ruta.isDirectory()){
            String [] contenido = ruta.list();
            for (String actual : contenido) {
                System.out.println(actual);
                File nivel2 = new File(ruta, actual);
                if(nivel2.isDirectory()){
                    String [] contenidoN2 = nivel2.list();
                    for (String actualN2 : contenidoN2) {
                        System.out.println("\t" + actualN2);
                    }
                }
            }
        }else{
            System.out.println(ruta.getAbsolutePath() + " es un archivo y no tiene carpetas");
        }
    }
}
