package accesoficheros;

import java.io.File;
import java.io.IOException;


public class AccesoFicheroRecursivamente {

    public static void muestraCarpetasRecu(String ruta){
        //PASO 1: Crear el archivo de laruta
        File miRuta1=new File(ruta);
        System.out.println("Mostrando el contenido de " + miRuta1);
        System.out.println("-------------------------");
        //PASO 2: Sacamos el listado de la ruta a un array
        String [] contenido=miRuta1.list();
        //PASO 3: Mostramos todo
        for(String actual:contenido){
            System.out.println(actual);
        }for(String actual:contenido){
            //PASO 4: Vamos a recorrer de nuevo en busca de los direcotorios, una 
            //vez encontrmos el directorio nos metemos dentro y mostramos su contenido
            File miRuta2=new File(miRuta1, actual);
            if(miRuta2.isDirectory()){
                //PASO 5: Como es un directorio me vuelvo a llamar de nuevo
                muestraCarpetasRecu(miRuta2.getAbsolutePath());
            }
        }
    }
    
    public static boolean generarDirectorio(String ruta){
        File f1=new File(ruta);
        return f1.mkdir();
    }
    
    public static boolean crearArchivo(String ruta) throws IOException{
        File f1=new File(ruta);
        return f1.createNewFile();
    }
   
    public static void main(String[] args) {
        //muestraCarpetasRecu("C:\\Users\\alejandro\\Desktop\\LM ejericcios XML");
        System.out.println(generarDirectorio("C:\\inventado"));
        try{
            System.out.println(crearArchivo("C:\\Users\\alejandro\\Desktop\\prueba25\\ejemplo.rar"));
        }catch(IOException e){
            System.out.println("WARNING!!!!" + e.getMessage());
        }
    }

}
