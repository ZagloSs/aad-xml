package lectura;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerXML {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		DocumentBuilder db;
		File file;
		Document document;
		XPath xPath;
		NodeList nodeList;
		String path;
		
		try {
			db = dbf.newDocumentBuilder();
			file = new File("personas.xml");
			document = db.parse(file);
			
			document.normalizeDocument();
			
			xPath = XPathFactory.newInstance().newXPath();
			
			path = "//persona[nombre='Julián']";
			
			nodeList = (NodeList) xPath.compile(path).evaluate(document, XPathConstants.NODESET);
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				Element elemento = (Element) nodeList.item(i);
				
				System.out.println(elemento.getTextContent());
			}
			
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
		

	}

}
