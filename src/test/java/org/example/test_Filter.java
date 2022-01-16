package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import java.util.ArrayList;

public class test_Filter extends TestCase {

    public void test_Filter() {
        //datei leeren
        //Personen hinzufügen die zutreffen und nicht zutreffen
        //Schleife um rückgabe durchzugehen
        //überprüfen ob rückgabe string dem name entspricht
        ArrayList<String> expectedOutput = new ArrayList<String>();
        expectedOutput.add("Lisa");
        Filter firstTest = new Filter();
        Assert.assertEquals("Lisa", firstTest.allFilter(0, "^L.*"));
    }
}