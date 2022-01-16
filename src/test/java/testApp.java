
import org.example.Filter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test of class App.
 */

public class testApp {
    @Test
    public void testApp() {
        Filter firstTest = new Filter();
        Assert.assertEquals("Lisa", firstTest.allFilter(0, "^L.*"));
        Assert.assertEquals("Samuel", firstTest.allFilter(0, "^S.*"));
    }
}