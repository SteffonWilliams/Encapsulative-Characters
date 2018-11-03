package io.zipcoder;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;

public class ParenCheckerTest {
    ParenChecker parenChecker = new ParenChecker();

    @Test
    public void testIsParenPaired (){
        //Given
        String phrase = "((1234567))";
        boolean expectedOutput = true;
        //When
        boolean actualOutput = parenChecker.isParenPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testIsParenPaired2() {
        //Given
        String phrase = "Hello :)";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isParenPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testIsParenPaired3() {
        //Given
        String phrase = ")((()(((";
        boolean expectedOutput = false;
        // When
        boolean actualOutput = parenChecker.isParenPaired(phrase);
        //Then
         Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testIsParenPaired4(){
        //Given
        String phrase = "((this is a test())()";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isParenPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testIsSingleQuoteAndPair() {
        //Given
        String phrase = "'''''";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isSingleQuoteAndPair(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testIsSingleQuoteAndPair2 () {
        // Given
        String phrase = "''''";
        boolean expectedOutput = true;

        // When
        boolean actualOutput = parenChecker.isSingleQuoteAndPair(phrase);

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testIsDoubleQuoteaPair() {
        //Given
        String phrase = "\"\"";
        boolean expectedOutput = true;
        //When
        boolean actualOutput = parenChecker.isDoubleQuoteaPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testIsDoubleQuoteaPair2() {
        //Given
        String phrase = "\"";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isDoubleQuoteaPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);

    }

    @Test
    public void testIsAllPaired(){
        //Given
        String phrase = "{test}";
        boolean expectedOutput = true;
        //When
        boolean actualOutput = parenChecker.isAllPaired(phrase);
        //
        Assert.assertEquals(expectedOutput, actualOutput);


    }

    @Test
    public void testIsAllPaired2() {
        //Given
        String phrase = "{[This is a test}]";
        boolean expectedOutput= true;
        // When
        boolean actualOutput = parenChecker.isAllPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testIsAllPaired3(){
        //Given
        String phrase = "{This is a test}]";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isAllPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testIsAllPaired4() {
        //Given
        String phrase = "{{{(}()[])";
        boolean expectedOutput = false;
        //When
        boolean actualOutput = parenChecker.isAllPaired(phrase);
        //Then
        Assert.assertEquals(expectedOutput, actualOutput);
    }


}