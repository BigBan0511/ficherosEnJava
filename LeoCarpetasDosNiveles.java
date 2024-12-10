package accesoficheros;

import java.io.File;

public class LeoCarpetasDosNiveles {
    public static void main(String[] args) {
        File ruta=new File("C:\\Users\\alejandro\\Documents\\NetBeansProjects");
        if(ruta.isDirectory()){
            //Solo listamos si lo que encuentro en el 1ºnivel es una carpeta
            String [] contenido=ruta.list();
            for(String actual : contenido){
                //Muestro la carpeta actual
                System.out.println(actual);
                //Lo convierto en un File para saber si es un directorio o no
                //Esta rutaN2 es la suma de la ruta con su sucarptea o archivo
                File rutaN2=new File(ruta, actual);
                //Si lo que encuentro es una carpeta debo listar su contenido
                if(rutaN2.isDirectory()){
                    String [] contenidoN2=rutaN2.list();
                    //Como solo me pide 2 niveles, ya listo el contenido
                    for(String actualN2:contenidoN2)
                        System.out.println("\t" + actualN2);
                }
            }
        }else{
            System.out.println(ruta.getAbsoluteFile() + " es un archivo y no tiene subcarpetas");
        }
        
    }

}
