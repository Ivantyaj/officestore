
import by.grouptopprogers.entity.Category;
import by.grouptopprogers.entity.Office;
import by.grouptopprogers.parsers.MyDOMparser;
import by.grouptopprogers.parsers.MyHandler;
import org.junit.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class TestParser {
    //private static ArrayList<Category> categoryArrayList;
    private static MyDOMparser domParser;

    @BeforeClass
    public static void initAction() {
        domParser = MyDOMparser.getInstance();
    }

    @AfterClass
    public static void clearAction(){
        domParser = null;
    }

    @Ignore ("not ready yet")
    @Test
    public void testHandler() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Category> categoryArrayList = null;
        //*****//
        //*****//
        //*****//
        Assert.assertEquals(categoryArrayList,MyDOMparser.getInstance().parseFile());
    }

    @Test(timeout=100)
    public void testParseTime() throws ParserConfigurationException, SAXException, IOException {
        Assert.assertNotNull(MyDOMparser.getInstance().parseFile());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetValue() throws ParserConfigurationException, SAXException, IOException {
        Assert.assertEquals(MyDOMparser.getInstance().parseFile().get(100).getNameCategory(), "Category");
    }

}
