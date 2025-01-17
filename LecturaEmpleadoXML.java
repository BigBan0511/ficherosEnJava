package conXML;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LecturaEmpleadoXML {

	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder= factory.newDocumentBuilder();
			Document documento = builder.parse(new File("Empleados.xml"));
			documento.getDocumentElement().normalize();
			System.out.printf("Elemento raiz: %s %n", documento.getDocumentElement().getNodeName());
			//creamos una lista con los nodos "empleado"
			NodeList empleados = documento.getElementsByTagName("empleado");
			System.out.println("Nº de empleados: " + empleados.getLength());
			//recorrer la lista
			for (int x = 0; x < empleados.getLength(); x++) {
				Node emp = empleados.item(x);
				if(emp.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) emp;
					System.out.println("ID: " + elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("Apellido: " + elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.println("Dep: " + elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.println("Salario: " + elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
