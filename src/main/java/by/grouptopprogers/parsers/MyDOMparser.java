package by.grouptopprogers.parsers;


import by.grouptopprogers.entity.Category;
import by.grouptopprogers.entity.Product;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MyDOMparser implements Parseable {

    private static MyDOMparser instance;

    public static MyDOMparser getInstance() {
        if (instance == null) {
            instance = new MyDOMparser();
        }
        return instance;
    }

    String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<Category> parseFile() throws IOException, SAXException, ParserConfigurationException {
        /**
         * xml file with data
         */

        File file = new File(DIRECTORY);

        /**
         * building document for parsing
         */
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        /**
         * root element
         */

        Element root = document.getDocumentElement();
        String officeName = root.getAttribute("name");

        NodeList nodeList = document.getElementsByTagName("category");

        ArrayList<Category> categoryList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Category category = new Category();
                Element element = (Element) nodeList.item(i);

                category.setNameCategory(element.getAttribute("name"));

                NodeList childList = element.getChildNodes();

                for (int j = 0; j < childList.getLength(); j++) {

                    if (childList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childList.item(j);

                        Product product = new Product();
                        product.setId(Integer.valueOf(childElement.getAttribute("id")));

                        NodeList productTagsList = childElement.getChildNodes();

                        for (int k = 0; k < productTagsList.getLength(); k++) {
                            if (productTagsList.item(k).getNodeType() == Node.ELEMENT_NODE) {

                                Element attribute = (Element) productTagsList.item(k);

                                switch (attribute.getNodeName()) {
                                    case "type": {
                                        product.setType(attribute.getTextContent());
                                        break;
                                    }
                                    case "company": {
                                        product.setCompany(attribute.getTextContent());
                                        break;
                                    }
                                    case "country": {
                                        product.setCountry(attribute.getTextContent());
                                        break;
                                    }
                                    case "purpose": {
                                        product.setPurpose(attribute.getTextContent());
                                        break;
                                    }
                                    case "cost": {
                                        product.getCost().setValue(Double.valueOf(attribute.getTextContent()));
                                        product.getCost().setCurrency(attribute.getAttribute("currency"));
                                        break;
                                    }

                                }
                            }

                        }
                        category.getListProducts().add(product);

                    }

                }
                categoryList.add(category);
            }
        }
        return categoryList;
    }
}


