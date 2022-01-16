package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest extends TestCase {

    @Test
    public void Filter() {
        Filter firstTest = new Filter();
        firstTest.allFilter(0, "^H.*");
        Assert.assertEquals("Hallo", firstTest.allFilter(0, "^A.*"));
    }
}
