package by.grouptopprogers.parsers;

import by.grouptopprogers.entity.Category;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface Parseable {
    String DIRECTORY = "D:\\JavaProjects\\officestore\\src"
            + "\\main\\java\\by\\grouptopprogers\\files\\office.xml";

    ArrayList<Category> parseFile()
            throws IOException,
            SAXException,
            ParserConfigurationException;
}
