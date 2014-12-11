/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Freddy
 */
public class XMLParser {

//making a list with the object Containers
List<Container> ZeeContainers = new ArrayList<Container>();
List<Container> BinnenContainers = new ArrayList<Container>();
List<Container> TreinContainers = new ArrayList<Container>();
List<Container> VrachtContainers = new ArrayList<Container>();
int error;


public XMLParser(String File)
{
    
try {
//opening the xml file
    
    File fXmlFile = new File(File);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);

//normalizing document (all on one line)
    doc.getDocumentElement().normalize();

//printing first name of the xml file
//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

//making a nodelist on tag record = container
    NodeList nList = doc.getElementsByTagName("record");

//looping through te node list
    for (int temp = 0; temp < nList.getLength(); temp++) {
//making a node of index of the list
        Node nNode = nList.item(temp);
    
//System.out.println("\nCurrent Element :" + nNode.getNodeName());
//if the type == ELEMENT_NODE
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//making an Element
            Element aElement = (Element) nNode;
            
//making a new container
            Container aContainer = new Container();
            
//making a string of the total tag vertrek, because the tags of date and time of departure are equal to arrival
            String vertrektotaal = aElement.getElementsByTagName("vertrek").item(0).getTextContent();
//splitting the string into an string array on newline
            String[] v = vertrektotaal.split("\\n");
            
//since there are a few empty lines there are some empty indexess
            String vdatumD = v[2];
            String vdatumM = v[3];
            String vdatumJ = v[4];
            String testvertrekvan = v[7];
            String testvertrektot = v[8];
            String vsoortvervoer = v[10];
            String vvervoerbedrijf = v[11];

//Adding the diffrent values of the xml file to their respective Container variables
            aContainer.containerID = aElement.getAttribute("id");
            aContainer.adatumD = Integer.parseInt(aElement.getElementsByTagName("d").item(0).getTextContent());
            aContainer.adatumM = Integer.parseInt(aElement.getElementsByTagName("m").item(0).getTextContent());
            aContainer.adatumJ = Integer.parseInt(aElement.getElementsByTagName("j").item(0).getTextContent());
            aContainer.aVan = Double.parseDouble(aElement.getElementsByTagName("van").item(0).getTextContent());
            aContainer.aTot = Double.parseDouble(aElement.getElementsByTagName("tot").item(0).getTextContent());
            aContainer.asoortvervoer = aElement.getElementsByTagName("soort_vervoer").item(0).getTextContent();
            aContainer.avervoerbedrijf = aElement.getElementsByTagName("bedrijf").item(0).getTextContent();
            aContainer.eigenaar = aElement.getElementsByTagName("naam").item(0).getTextContent();
            aContainer.containerNr = Integer.parseInt(aElement.getElementsByTagName("containernr").item(0).getTextContent());
            aContainer.vVan = Double.parseDouble(testvertrekvan);
            aContainer.vTot = Double.parseDouble(testvertrektot);
            aContainer.vdatumD = Integer.parseInt(vdatumD);
            aContainer.vdatumM = Integer.parseInt(vdatumM);
            aContainer.vdatumJ = Integer.parseInt(vdatumJ);
            aContainer.vsoortvervoer = vsoortvervoer;
            aContainer.vvervoerbedrijf = vvervoerbedrijf;
            aContainer.x = Float.parseFloat(aElement.getElementsByTagName("x").item(0).getTextContent());
            aContainer.y = Float.parseFloat(aElement.getElementsByTagName("y").item(0).getTextContent());
            aContainer.z = Float.parseFloat(aElement.getElementsByTagName("z").item(0).getTextContent());

            if ("trein".equals(aContainer.asoortvervoer))
            {
                TreinContainers.add(aContainer);
            }
            else if ("zeeschip".equals(aContainer.asoortvervoer))
            {
                ZeeContainers.add(aContainer);
            }
            else if ("vrachtauto".equals(aContainer.asoortvervoer))
            {
                VrachtContainers.add(aContainer);
            }
            else if ("binnenschip".equals(aContainer.asoortvervoer))
            {
                BinnenContainers.add(aContainer);
            }
            else
            {
                System.out.println(aContainer.asoortvervoer);
                error++;
            }
            }
        }
    }
catch (Exception e) {
    e.printStackTrace();
                    }
}
}