import view.Reader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Reader med = new Reader("XML");
        med.setVisible(true);
        med.setLocationRelativeTo(null);
    }
}
