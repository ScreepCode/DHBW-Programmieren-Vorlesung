package de.niklas.exercise.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;

/**
 * <strong>Google-Maps-Gazetteer-Service</strong><br>
 * Auslesen einer XML File für spezifische Parameter
 * (Dies ist keine Optimale Lösung. Alternativ könnten XPath Expressions genutzt werden)
 *
 * @see "29_XML_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Gazetteer {

    Element rootElement, result;

    public Gazetteer(){
        rootElement = getXMLFile("https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml");
        System.out.printf("Adresse: %s\n", getFormattedAddress());
        System.out.printf("Long Name: %s\n", getLongName());
        System.out.printf("Location: %s\n", getLocation());
        System.out.printf("Bounds: %s\n", getBounds());
    }

    /**
     * Gibt die XML-Datei von der übergebenen URL als Dokument zurück
     * @param url URL der XML-Datei
     * @return Document der XML Datei
     */
    public Element getXMLFile(String url){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = factory.newDocumentBuilder();
            // Name des Wurzelelements ausgeben
            Document doc =  parser.parse(url);
            return doc.getDocumentElement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Ließt das Element 'formatted_address' aus der XML aus
     * @return Formatierte Adresse
     */
    public String getFormattedAddress(){
        Node formatted_address = this.rootElement.getElementsByTagName("formatted_address").item(0);
        return formatted_address.getTextContent();
    }

    /**
     * Ließt das Element 'long_name' aus der XML aus
     * @return Stadtname
     */
    public String getLongName(){
        NodeList address_component = this.rootElement.getElementsByTagName("long_name").item(0).getChildNodes();
        return address_component.item(0).getTextContent();
    }

    /**
     * Ließt das Element 'location' aus dem XML aus und gibt sowohl Längen- als auch Breitengrad
     * @return Längen- und Breitengrad
     */
    public String getLocation(){
        NodeList location = this.rootElement.getElementsByTagName("location").item(0).getChildNodes();
        String lat = "", lng = "";
        for(int i = 0; i < location.getLength(); i++){
            if(location.item(i).getNodeName().equals("lat")){
                lat = location.item(i).getTextContent();
            }
            else if(location.item(i).getNodeName().equals("lng")){
                lng = location.item(i).getTextContent();
            }
        }
        return String.format("(latitude = %s, longitude = %s)", lat, lng);
    }

    /**
     * Ließt das Element 'bounds' aus dem XML aus und alle Begrenzungen mit Himmelsrichtung aus
     * @return Begrenzungen mit Himmelsrichtung
     */
    public String getBounds(){
        NodeList location = this.rootElement.getElementsByTagName("bounds").item(0).getChildNodes();

        String north = "", east = "", south = "", west = "";
        for(int i = 0; i < location.getLength(); i++){
            if(location.item(i).getNodeName().equals("southwest")){
                NodeList southwest = location.item(i).getChildNodes();
                for(int j = 0; j < southwest.getLength(); j++){
                    if(southwest.item(j).getNodeName().equals("lat")){
                        south = southwest.item(j).getTextContent();
                    }
                    else if(southwest.item(j).getNodeName().equals("lng")){
                        west = southwest.item(j).getTextContent();
                    }
                }
            }
            else if(location.item(i).getNodeName().equals("northeast")){
                NodeList northeast = location.item(i).getChildNodes();
                for(int j = 0; j < northeast.getLength(); j++){
                    if(northeast.item(j).getNodeName().equals("lat")){
                        north = northeast.item(j).getTextContent();
                    }
                    else if(northeast.item(j).getNodeName().equals("lng")){
                        east = northeast.item(j).getTextContent();
                    }
                }
            }
        }

        return String.format("(north = %s, east = %s, south = %s, west = %s)", north, east, south, west);
    }

    /**
     * Liefert das erste Kind-Element von Elternelement n mit Namen name
     * @param n Elternelement
     * @param name Name des zu suchenden Elements
     * @return Gesuchte Element
     */
    public static Element getNamedChildElement(Node n, String name) {
        return getNamedChildElement(n, name, 0);
    }
    // Liefert das n-te Kind-Element von n mit Namen name, Zählung beginnt bei 0
    /**
     * Liefert das n-te Kind-Element von Elternelement n mit Namen name
     * @param n Elternelement
     * @param name Name des zu suchenden Elements
     * @param count welches n-te Element es ist
     * @return Gesuchte Element
     */
    public static Element getNamedChildElement(Node n, String name, int count) {
        for (int i = 0; i < n.getChildNodes().getLength(); i++) {
            Node ithChild = n.getChildNodes().item(i);
            if (ithChild.getNodeType() == Node.ELEMENT_NODE &&
                    ithChild.getNodeName().equals(name)) {
                if (count == 0) {
                    return (Element) ithChild;
                }
                count--;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        new Gazetteer();
    }
}
