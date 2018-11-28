import by.grouptopprogers.entity.Cost;
import by.grouptopprogers.entity.Product;
import org.junit.*;


public class TestData {

    private static Product product;
    private static Cost cost;

    @BeforeClass
    public static void createObject() {
        product = new Product();
        cost = new Cost();
    }

    @AfterClass
    public static void clearAllData() {
        product = null;
        cost = null;
    }

    @Before
    public void setUpData() {
        product.setId(1);
        product.setType("Typical");
        product.setCompany("Company");
        product.setCountry("Belarus");
        product.setPurpose("Selling");

        cost.setCurrency("RMB");
        cost.setValue(0.33);

        product.setCost(cost);
    }

    @After
    public void clearData() { //?
        product.setId(0);
        product.setType("");
        product.setCompany("");
        product.setCountry("");
        product.setPurpose("");

        cost.setCurrency("");
        cost.setValue(0.0);

        product.setCost(cost);
    }

    @Test
    public void testGetCorrectValues() {
        Assert.assertEquals("Company", product.getCompany());
        Assert.assertEquals("Belarus", product.getCountry());
        Assert.assertEquals("Selling", product.getPurpose());
        Assert.assertEquals("Typical", product.getType());
        Assert.assertEquals(1, product.getId(), 0);
    }

    @Test
    public void testToStringArray() {

        String[] testArray = {
                "1",
                "Selling",
                "Company",
                "Typical",
                "Belarus",
                "RMB",
                "0.33"
        };

        Assert.assertArrayEquals(testArray, product.toStringArray());
    }
}
