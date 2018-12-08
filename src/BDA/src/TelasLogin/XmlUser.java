package TelasLogin;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUser {
	
	/**
	 * @author Grupo31
	 */

	private static Document doc;
	private int userCount = 0;
	private Element e = null;

	public static void main(String[] args) {

		try {
			new XmlUser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public XmlUser() throws Exception {
		super();
		configure();
	}
/**
 * Configura o ficheiro xml
 * @throws Exception
 */
	public void configure() throws Exception {
		File inputFile = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(inputFile);
		doc.getDocumentElement().normalize();
		Node gen = doc.getDocumentElement();
		Node genc = doc.getElementsByTagName("User").item(0);
		if (genc == null) {
			Element ele = doc.createElement("User");
			gen.appendChild(ele);
			System.out.println("\n----- Search the XML document with xpath queries -----");
			// Query 1
			System.out.println("Query 1: ");
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("/XML/Service/@*");
			NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.print(nl.item(i).getNodeName() + ": ");
				System.out.println(nl.item(i).getFirstChild().getNodeValue());
			}
			// Query 2
			System.out.println("\nQuery 2: ");
			expr = xpath.compile("/XML/Paths/docPath");
			String str = (String) expr.evaluate(doc, XPathConstants.STRING);

			System.out.println("docPath: " + str);
			Node n = doc.getElementsByTagName("User").item(0);
			if (!n.hasChildNodes()) {
				Element newElement1 = doc.createElement("Facebook");
				Element newElement2 = doc.createElement("Twitter");
				Element newElement3 = doc.createElement("Email");
				// Element newElement4=doc.getDocumentElement()
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				n.appendChild(newElement1);
				n.appendChild(newElement2);
				n.appendChild(newElement3);
			}
			// Save XML document
			System.out.println("\nSave XML document.");
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);

		}
	}
/**
 * Adiciona o Utilizador no ficheiro xml no ficheiro correto
 * @param user
 * @param plat
 */
	public void addAttribute(String user, String plat) {
		userCount++;
		try {
			if (plat.equals("Facebook"))
				e = (Element) doc.getElementsByTagName("Facebook").item(0);
			if (plat.equals("Twitter"))
				e = (Element) doc.getElementsByTagName("Twitter").item(0);
			if (plat.equals("Email"))
				e = (Element) doc.getElementsByTagName("Email").item(0);
			if (!e.hasAttribute(user)) {
				e.setAttribute("User" + userCount, user);
				System.out.println("\nSaved XML document.");
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
				DOMSource source = new DOMSource(doc);
				transformer.transform(source, result);

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}