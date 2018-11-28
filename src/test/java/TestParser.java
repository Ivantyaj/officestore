
import by.grouptopprogers.parsers.MyDOMparser;
import org.junit.*;

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

    @Test(timeout=10)
    public void testParse(){
      //  Assert.assertNotNull(MyDOMparser.getInstance().parseFile());
    }

    @Ignore("not ready yet")
    @Test
    public void testDataParse(){
        //Assert.assertEquals(categoryArrayList, MyDOMparser.getInstance().parseFile());
    }

}
