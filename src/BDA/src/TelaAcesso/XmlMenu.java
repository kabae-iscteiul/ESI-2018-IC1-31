package TelaAcesso;

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

public class XmlMenu {
	/**
	 * @author Grupo31
	 */

	private static Document doc;
	private int userCount = 0;
	private Element e = null;
	private Element conteudo = null;
	private Element subject = null;
	private Element remetente = null;

	public static void main(String[] args) {

		try {
			new XmlMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public XmlMenu() throws Exception {
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
		Node genq = doc.getElementsByTagName("Posts").item(0);

		if (genq == null) {
			Element ele = doc.createElement("Posts");
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
			Element newElement1 = doc.createElement("FacebookPost");
			Element newElement2 = doc.createElement("TwitterPost");
			Element newElement3 = doc.createElement("EmailPost");
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			Node n = doc.getElementsByTagName("Posts").item(0);
			if (!n.hasChildNodes()) {
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
 * Devolve o documento do ficheiro xml	
 * @return Document
 */
	public Document getDoc() {
		return doc;
	}
/**
 * Adicionar o Post no ficheiro xml no elemento correto
 * @param user
 * @param message
 * @param plat
 */
	public void addPost(String user, String message, String plat) {
		userCount++;
		try {
			if (plat.equals("FacebookPost"))
				e = (Element) doc.getElementsByTagName("FacebookPost").item(0);
			if (plat.equals("TwitterPost"))
				e = (Element) doc.getElementsByTagName("TwitterPost").item(0);
			if (plat.equals("EmailPost"))
				e = (Element) doc.getElementsByTagName("EmailPost").item(0);
			String[] s = user.split(" ");
			if (!e.hasAttribute(message)) {
			if (s.length == 1) {
				e.setAttribute(s[0] + userCount, message);
			} else {
				e.setAttribute(s[0] + s[1] + userCount, message);
			}	
					System.out.println("\nSave XML document.");
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
/**
 * Adiciona o email no ficheiro xml no elemento correto	
 * @param subj
 * @param rem
 * @param message
 */
	public void addEmail(String subj,String rem,String message) {
		userCount++;
		try {
		e = (Element) doc.getElementsByTagName("EmailPost").item(0);
		if(!e.hasChildNodes()) {
		Element subject=doc.createElement("Subject");
		Element remetente=doc.createElement("Remetente");
		Element conteudo=doc.createElement("Conteudo");
		e.appendChild(subject);
		e.appendChild(remetente);
		e.appendChild(conteudo);
		}
		conteudo = (Element) doc.getElementsByTagName("Conteudo").item(0);
		if(!conteudo.hasAttribute(message)){
		System.out.println(rem + userCount);
		subject = (Element) doc.getElementsByTagName("Subject").item(0);
		remetente = (Element) doc.getElementsByTagName("Remetente").item(0);
		conteudo.setAttribute("Conteudo"+userCount,message);
		subject.setAttribute("Assunto"+userCount, subj);
		remetente.setAttribute("Remetente"+userCount, rem);
		System.out.println("\nSave XML document.");
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
		
			}
		}catch (Exception e1) { e1.printStackTrace(); 
		}
	}

}
