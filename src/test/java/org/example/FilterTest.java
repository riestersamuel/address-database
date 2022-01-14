package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FilterTest extends TestCase {

    @Test
    public void Filter() {
        Filter firstTest = new Filter();
        firstTest.filterFirstLetter(0, "^H.*");
        Assert.assertEquals("Hallo", firstTest.filterFirstLetter(0, "^A.*"));
    }
}
