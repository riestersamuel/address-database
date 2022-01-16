package org.example;
import org.example.Filter;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test of class App.
 */

public class test_Filter {

    @Test
    public void addPerson() {
        ReaderWriter.removeEntries();
        List<String> test = ReaderWriter.read();
        Assert.assertEquals(0, test.size());

        // Add person
        ReaderWriter.write(new Person("Laura","Müller","lauramülller@web.de","76565455"));

        test = ReaderWriter.read();
        Assert.assertEquals(1, test.size());

        // Add 2 person entries
        ReaderWriter.write(new Person("Laura","Müller","lauramülller@web.de","76565455"));
        ReaderWriter.write(new Person("Lisa","Mölllii","lisa.mölllii@web.de","0170646773"));

        test = ReaderWriter.read();
        Assert.assertEquals(3, test.size());
    }

    @Test
    public void filterTest() {
        ReaderWriter.removeEntries();
        Person a= new Person("Laura","Müller","lauramülller@web.de","76565455");
        Person b= new Person("Lisa","Mölllii","lisa.mölllii@web.de","0170646773");
        Person c= new Person("Samuel","Maier","samuel.maier@gmail.com","017656545");
        ReaderWriter.write(a);
        ReaderWriter.write(b);
        ReaderWriter.write(c);

        Filter firstTest = new Filter(0);
        List<String> test= firstTest.allFilter(0, "^L.*");
        Assert.assertEquals("Laura Müller, mail: lauramülller@web.de, number: 76565455", test.get(0));
        Assert.assertEquals("Lisa Mölllii, mail: lisa.mölllii@web.de, number: 0170646773",test.get(1));
    }
}