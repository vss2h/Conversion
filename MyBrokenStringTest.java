package edu.mtsu.csci3033;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Add as many test cases as you wish, this page will NOT be submitted upon completion.
 */
class MyBrokenStringTest {

    private MyBrokenStringInterface myBrokenString;

    @BeforeEach
    void setUp() {
        myBrokenString = new MyBrokenString();
    }

    @AfterEach
    void tearDown() {
        myBrokenString = null;
    }

    @Test
    public void testCountDigits1() {
        myBrokenString.setBrokenString("Now is the time for 30 good students to come to the aid of their instructor.");
        assertEquals(2, myBrokenString.countDigits());
    }

    @Test
    public void testCountDigits2() {
        assertThrows(NullPointerException.class,
                ()->{
                    myBrokenString.countDigits();
                });
    }

    @Test
    public void testGetEvenCharacters1() {
        myBrokenString.setBrokenString("Now is the time for ALL good students to come to the aid of their instructor.");
        assertEquals("o stetm o L odsuet ocm oteado hi ntutr", myBrokenString.getEvenCharacters().toString());
    }

    @Test
    public void testGetEvenCharacters2() {
        assertThrows(NullPointerException.class,
                ()->{
                    myBrokenString.getEvenCharacters();
                });
    }

    @Test
    public void testGetOddCharacters1() {
        myBrokenString.setBrokenString("Now is the time for ALL good students to come to the aid of their instructor.");
        assertEquals("Nwi h iefrALgo tdnst oet h i fterisrco.", myBrokenString.getOddCharacters().toString());
    }

    @Test
    public void testGetOddCharacters2() {
        assertThrows(NullPointerException.class,
                ()->{
                    myBrokenString.getOddCharacters().toString();
                });
    }

    @Test
    public void testNumbersDroppedString() {
        myBrokenString.setBrokenString("Now is the time for 30 good students to come to the aid of their instructor.");
        assertEquals("Now is the time for  good students to come to the aid of their instructor.", myBrokenString.numbersDroppedString().toString());
    }
    @Test
    public void testCommasDroppedString() {
        myBrokenString.setBrokenString("Now, is the time for ALL good students, to come to the aid of their instructor.");
        assertEquals("Now is the time for ALL good students to come to the aid of their instructor.", myBrokenString.commasDroppedString().toString());
    }
    @Test
    public void testSpacesDroppedString() {
        myBrokenString.setBrokenString("Now is the time for ALL good students to come to the aid of their instructor.");
        assertEquals("NowisthetimeforALLgoodstudentstocometotheaidoftheirinstructor.", myBrokenString.spacesDroppedString().toString());
    }
    @Test
    public void testSortedAscendingString() {
        myBrokenString.setBrokenString("abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", myBrokenString.sortedAscendingString());
    }
    @Test
    public void testSortedDescendingString() {
        myBrokenString.setBrokenString("abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals("zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA9876543210", myBrokenString.sortedDescendingString());
    }

    @Test
    public void testGetReverseString() {
        myBrokenString.setBrokenString("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        assertEquals("zyxwvutsrqponmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA9876543210", myBrokenString.getReverseString());
    }

    @Test
    public void testGetReverseString2() {
        myBrokenString.setBrokenString("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmn");
        assertEquals("nmlkjihgfedcbaZYXWVUTSRQPONMLKJIHGFEDCBA9876543210", myBrokenString.getReverseString());
    }
}