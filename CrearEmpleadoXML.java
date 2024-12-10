package conXML;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CrearEmpleadoXML {

	public static void main(String[] args) throws IOException, TransformerFactoryConfigurationError, TransformerException {
		
		File fichero = new File("FicheroAleatorio.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");
		
		
		int id, dep, posicion = 0;
		Double salario;
		char apellido[] = new char[10], aux;
		
		/*
		 *DocumentBuilder constructor de mi elemento
		 *Factory permite utilizar librerias y crear metodos de ese tipo 
		 */
		
		// Crear la factoría, para utilizar sus metodos
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			//Construir el parser, constructor de documentos que esta en la factoria
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Usamos la interfaz DOM, se necesita la libreria dom para poder crear el documento para su estructura
			DOMImplementation implementation = builder.getDOMImplementation();
			//Creamos el documento que estara dentro de java pero que no es el xml 
			Document documento = implementation.createDocument(null, "Empleados", null);
			//Para meter la version del xml
			documento.setXmlVersion("1.0");
			
			//Con este for leemos lo que tenemos el archivo .dat que contiene los datos
			for(;;) {
				file.seek(posicion);
				id=file.readInt();
				//recuperar el string completo caracter a caracter
				for(int i = 0; i<apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
					
				}
				String apellidoN = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();
				//Escribir en el XML 
				if(id>0) {
					//Crear un elementos raiz llamado empleado que almacenara toda la informacion 
					Element raiz = documento.createElement("empleado");
					
					//Agregar nodo a la raiz, aqui aun esta vacio la etiqueta empleado
					documento.getDocumentElement().appendChild(raiz);
					
					//Agregar los elementos de cada empleado, agrega tanto la etiqueta como el valor 
					crearElemento("id", Integer.toString(id), raiz, documento );
					crearElemento("apellido", apellidoN.trim(), raiz, documento );//trim para quitar los espcacios del principio y final 
					crearElemento("dep", Integer.toString(dep), raiz, documento );
					crearElemento("salario", Double.toString(salario), raiz, documento );
				}
				System.out.println("id: " + id + " Apellido: " + apellidoN);
				System.out.println(" Departamento: " + dep + " Salario: " +  salario);
				posicion = posicion + 36;
				if(file.getFilePointer() == file.length()) {
					break;
				}
				
			}
			file.close();
			
			
			DOMSource source = new DOMSource(documento);
			StreamResult result = new StreamResult(new java.io.File("Empleados.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		}
				
		
	}

	//Metodo para insertar las etiquetas de empleado
	private static void crearElemento(String datoEmpleado, String valor, Element raiz, Document documento) {
		
		Element elem = documento.createElement(datoEmpleado);
		Text texto = documento.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(texto);
		
	}

}
