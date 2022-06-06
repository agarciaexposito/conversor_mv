package modelo;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class ConversorEurosDolares extends ConversorEuros {
    public ConversorEurosDolares() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
        super("//Cube[@currency='USD']/@rate");
    }
}
