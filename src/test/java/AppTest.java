import org.example.App;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test of class App.
 */
public class AppTest {
    /**
     * Test for correct sum of two arguments.
     */
    @Test
    public void testApp() {
        Filter.showFilterInstructions();
        Assert.assertEquals( 33, App.add(30, 3));
    }

    //Ab hier kommen unsere eigenen Tests
   }