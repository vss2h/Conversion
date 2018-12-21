package edu.mtsu.csci3033;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import com.sun.prism.null3d.NULL3DPipeline;

import javax.lang.model.type.ArrayType;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.*;
import java.util.Collections;

/**
 * Student code goes below here!
 *
 * <Vanessa Serao>
 *  Project 2 - Fall18
 *
 *  Complete each method below so all test cases pass
 *  Do not hard code results. Will be graded with different test cases.
 *  Build your own test cases and add them to MyBrokenStringTest.
 *  (especially on those items below which do not already have test cases)
 *
 *  Note:
 *  Do not import third party libraries
 *
 */
public class MyBrokenString implements MyBrokenStringInterface {

    private String myBrokenString;
   /* String [] ones= { "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine"};

    String [] teens= {"eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};

    String [] tens= { "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}; */

    ArrayList<String>  ones=  new ArrayList<String> (Arrays.asList("", "one", "two", "three", "four",
                                                        "five", "six", "seven", "eight", "nine"));

    ArrayList<String>  teens=  new ArrayList<String> (Arrays.asList("ten", "eleven", "twelve", "thirteen",
                            "forteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"));

    ArrayList<String>  tens=  new ArrayList<String> (Arrays.asList("twenty", "thirty", "forty",
                                                "fifty", "sixty", "seventy", "eighty", "ninety"));

   int []  onesDigit=  {0, 1, 2, 3, 4, 5, 6, 7 , 8, 9};

   int []  teensDigit=  {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};

   int []  tensDigit=  {20, 30, 40, 50, 60, 70, 80, 90};


    /**
     * Resets myBrokenString before each test with -> @BeforeEach
     */
    @Override
    public void setBrokenString(String inputString) {
        this.myBrokenString = inputString;
    }

    @Override
    public String getBrokenString() {
        return this.myBrokenString;
    }

    /**
     * Returns just the even items from a string
     */
    @Override
    public StringBuilder getEvenCharacters() throws NullPointerException {
        StringBuilder mySB = new StringBuilder();
        char BrokenStringArray[] = myBrokenString.toCharArray();

        for (int i = 0; i < BrokenStringArray.length; i++) {
            if (i % 2 == 1)
                mySB.append(BrokenStringArray[i]);
            else
                continue;
        }


        if (myBrokenString == null) {
            throw new NullPointerException("No even character");
        }

        //System.out.print(mySB);
        return mySB;

    }

    /**
     * Returns just the odd items from a string
     */
    @Override
    public StringBuilder getOddCharacters() throws NullPointerException {
        StringBuilder mySB = new StringBuilder();
        char BrokenStringArray[] = myBrokenString.toCharArray();

        for (int i = 0; i < BrokenStringArray.length; i++) {
            if (i % 2 == 0)
                mySB.append(BrokenStringArray[i]);
            else
                continue;
        }


        if (myBrokenString == null) {
            throw new NullPointerException("No odd character");
        }

        //System.out.print(mySB);
        return mySB;
    }

    /**
     * Returns total count of individual digits in a String
     */
    @Override
    public int countDigits() throws NullPointerException {
        int count = 0;

        for (int i = 0; i < myBrokenString.length(); i++) {
            if (Character.isDigit(myBrokenString.charAt(i))) {
                count++;
            } else
                continue;
        }

        if (myBrokenString == null) {
            throw new NullPointerException("no digits exist");
        }
        System.out.print(count);
        return count;
    }

    /**
     * Removes digits from String
     */
    @Override
    public StringBuilder numbersDroppedString() {
        StringBuilder sb = new StringBuilder(myBrokenString);

        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i--);

            } else
                continue;

        }
        return sb;
    }

    /**
     * Removes commas from String
     */
    @Override
    public StringBuffer commasDroppedString() {

        String newString = " ";
        for (int i = 0; i < myBrokenString.length(); i++) {
            newString = myBrokenString.replaceAll(",", "");

        }

        StringBuffer sb = new StringBuffer(newString);
        //System.out.print(sb);
        return sb;
    }

    /**
     * Removes spaces from String
     */
    @Override
    public StringBuilder spacesDroppedString() {

        String newString = "";
        for (int i = 0; i < myBrokenString.length(); i++) {
            newString = myBrokenString.replaceAll(" ", "");

        }

        StringBuilder sb = new StringBuilder(newString);
        //System.out.print(sb);
        return sb;
    }

    /**
     * Sorts String in ascending order
     */
    @Override
    public String sortedAscendingString() {
        // convert string into array of characters
        char BrokenStringArray[] = myBrokenString.toCharArray();
        // sort array
        Arrays.sort(BrokenStringArray);
        // convert array to string
        String sortedBrokenString = new String(BrokenStringArray);

        // convert to string builder
        StringBuilder sb = new StringBuilder();
        sb.append(sortedBrokenString);

        // reverse the string in descending order
        StringBuilder descStringBuilder = sb.reverse();
        // reverse the string to ascending order
        StringBuilder ascStringBuilder = descStringBuilder.reverse();
        //convert back to string
        String myAscendingString = ascStringBuilder.toString();

        //System.out.print(myAscendingString);
        return myAscendingString;
    }

    /**
     * Sorts String in descending order
     */
    @Override
    public String sortedDescendingString() {
        // convert string into array of characters
        char BrokenStringArray[] = myBrokenString.toCharArray();
        // sort array
        Arrays.sort(BrokenStringArray);
        // convert array to string
        String sortedBrokenString = new String(BrokenStringArray);

        // convert to string builder
        StringBuilder sb = new StringBuilder();
        sb.append(sortedBrokenString);

        // reverse the string in descending order
        StringBuilder descStringBuilder = sb.reverse();

        //convert back to string
        String myDescendingString = descStringBuilder.toString();

        //System.out.print(myDescendingString);
        return myDescendingString;
    }

    /**
     * Reverses a String
     */
    @Override
    public String getReverseString() {
        String rev = "";
        for (int i = myBrokenString.length() - 1; i >= 0; i--) {
            rev = rev + myBrokenString.charAt(i);
        }
        //System.out.print(rev);
        return rev;
    }

    /**
     * Converts digits in a s,tring to words, 9 converts to nine or 90 to ninety.,,,
     * These may occur in a sentence or by themselves.
     * Write your own test cases.
     */
    @Override
    public StringBuilder convertDigitsToStrings()
    {
        String [] onesarr= { "","one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine","ten" ,"eleven", "twelve", "thirteen", "forteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};

        String [] tensarr= { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};


        StringBuilder convertedString = new StringBuilder();
        String [] newString= myBrokenString.split("\\s+");
        int digit;

        for(int i=0; i< newString.length; i++) {
            try
            {
                digit = Integer.parseInt(newString[i]);

                if (digit == 0)
                {
                    convertedString.append("zero");
                }
                else if (digit < 20)
                {
                    convertedString.append(onesarr[digit]);
                }

                else if (digit < 100)
                {
                    convertedString.append(tensarr[digit / 10]);

                    if ((digit % 10) != 0)
                    {
                        convertedString.append(" " + onesarr[digit % 10]);
                    }
                }
            }
            catch (NumberFormatException e)
            {
                char [] charString= newString[i].toCharArray();
                for (int j=0; j< charString.length; j++)
                {
                    try
                    {

                        digit = Integer.parseInt(String.valueOf(charString[j]));

                        if (digit < 20)
                        {
                            convertedString.append(onesarr[digit]);
                        }

                    }
                    catch (NumberFormatException ex) {
                        convertedString.append(charString[j]);

                    }
                }
            }

            if (i < newString.length - 1)
            {
                convertedString.append(" ");
            }
        }
        return convertedString;
    }

    /**
     * Converts word representations of numbers, like nine to 9, or ninety to 90
     * These may occur in a sentence or by themselves.
     * 	Write your own test cases.
     */
    @Override
    public StringBuilder convertWordNumbersToDigits() {

        StringBuilder convertedString = new StringBuilder();
        String[] newString = myBrokenString.split("\\s+");
        int digit;

        // scan through the array of words and look for a word number.
        for (int i = 0; i < newString.length; i++)
        {
            // if the array of ones contains the value in the newString,
                String temp = newString[i].toLowerCase();
                String temp2= temp.replaceAll("-c", "");

                if (ones.contains(temp2))
                {
                    digit = ones.indexOf(temp2);
                    if (digit == 0)
                    {
                        convertedString.append("");
                    }
                    else {
                        //System.out.println((digit+("-c")));
                        System.out.println(temp.matches(digit+("-c")));
                        if(temp.matches(digit+("-c")))
                            convertedString.append(onesDigit[digit] + "-C");
                        else
                            convertedString.append(onesDigit[digit] + " ");

                    }
                }
                else if (teens.contains(temp))
                {
                    digit = teens.indexOf(newString[i]);
                    convertedString.append(teensDigit[digit] + " ");
                }
                else if (tens.contains(temp))
                {
                    digit = tens.indexOf(newString[i]);
                    int value = tensDigit[digit];

                    if (ones.contains(newString[i + 1].toLowerCase())) {
                        digit = ones.indexOf(newString[i + 1]);
                        int finalValue = onesDigit[digit] + value;
                        convertedString.append(finalValue + " ");

                        newString[i + 1] = "";
                    }
                    else
                        convertedString.append(value + " ");

                }

            else {
                convertedString.append(newString[i]);

                if (i < newString.length - 1)
                {
                    convertedString.append(" ");
                }

            }
        }
        return convertedString;
    }




    /**  BONUS
     * Converts numbers in a string to Roman Numerals,
     * 25 converts to XXV and 1025 converts to MXXV
     * These may occur in a sentence or by themselves.
     * Write your own test cases
     */
    @Override
    public StringBuilder convertDigitsToRomans()
    {
        String [] IRomans= { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX"};
        String [] XRomans= { "","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String [] CRomans= { "","C","CC", "CCC", "CD", "D", "DC","DCC","DCCC", "CM"};


        StringBuilder convertedString = new StringBuilder();
        String[] newString = myBrokenString.split("\\s+");
        int digit;
        int number;

        for (int i=0; i< newString.length; i++)
        {
            try {

                String test= newString[i];
                StringBuilder holder= new StringBuilder();
                StringBuilder end= new StringBuilder("");

                for (int j=0; j< test.length(); j++)
                {
                    if (Character.isDigit(test.charAt(j)))
                    {
                        holder.append(test);
                    }
                    else
                    {
                        end.append(test);
                    }
                }

                digit = Integer.parseInt(newString[i]);
                // one digit
                if (digit < 10) {
                    digit = digit % 10;
                    convertedString.append(IRomans[digit]);
                }
                // two digits
                if (digit >= 10 && digit < 100) {
                    number = digit % 100;
                    number /= 10;
                    convertedString.append(XRomans[number]);
                    digit = digit % 10;
                    convertedString.append(IRomans[digit]);

                }
                // three digits
                if (digit >=100 && digit < 1000)
                {
                    number = digit % 1000;
                    number /= 100;
                    convertedString.append(CRomans[number]);

                    number = digit % 100;
                    number /= 10;
                    convertedString.append(XRomans[number]);

                    digit = digit % 10;
                    convertedString.append(IRomans[digit]);

                }

            }
            catch (NumberFormatException e)
            {

                char [] charString= newString[i].toCharArray();
                for (int j=0; j< charString.length; j++) {
                    try
                    {

                        digit = Integer.parseInt(String.valueOf(charString[j]));

                        if (digit < 20)
                        {
                            convertedString.append(IRomans[digit]);
                        }

                    }
                    catch (NumberFormatException ex) {
                        convertedString.append(charString[j]);

                    }
                }

            }
            if (i< newString.length-1)
            {
                convertedString.append(" ");
            }
        }
        return convertedString;
    }

    /**  SUPER BONUS
     * Converts English words to Klingon language (https://en.wikipedia.org/wiki/Klingon_language)
     * These may occur in a sentence or by themselves.
     * Write your own test cases
     */
    @Override
    public StringBuilder convertWordsToKlingon() {
        return new StringBuilder();
    }
}