package accesoaficherosiii;

import java.io.File;

public class AccesoAFicherosIII3 {
    
    public static File factorial(File nuevaRuta){
        if(nuevaRuta.isDirectory()){
            String [] contenido = nuevaRuta.list();
            for (String actual : contenido) {
                System.out.println(actual);
                File nivel2 = new File(nuevaRuta, actual);
                String contenidoMas[] = nivel2.list();
                System.out.println("\t");
                factorial(nivel2);
            }
        }else{
        }
        return nuevaRuta;
    }

    public static void main(String[] args) {
        File ruta = new File("F:\\PROYECTOS");
        if(ruta.exists()){
            factorial(ruta);
        }else{
            System.out.println("El directorio no existe");
        }
        
    }
    
}
