package com.company;

/**
 * RationalTest - A class that tests the Rational class.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class RationalTest
{
    public static void main (String args[])
    {
        testConstructor();
        testNegate();
        testInvert();
        testAddSubtract();
        testMultiplyDivide();
    }
    
    
    public static void testConstructor()
    {
        System.out.println("TESTING the constructor, getNumerator, getDenominator");

        System.out.println("Trying default constructor");
        Rational r0 = new Rational();
        
        if(r0.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 1");
        }

        if(r0.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }        
        
        System.out.println("Constructing 2/5");
        try{
            Rational r1 = new Rational(2, 5);
            System.out.println("     Passes");
            
            if(r1.getNumerator() == 2)
            {
                System.out.println("     Passes");
            }
            else
            {
                System.out.println("**** Fails - numerator not 2");
            }


            if(r1.getDenominator() == 5)
            {
                System.out.println("     Passes");
            }
            else
            {
                System.out.println("**** Fails - denominator not 5");
            }
        }
        catch(ZeroDenominatorException e)
        {
            System.out.println("**** Fails - exception thrown");
        }


        System.out.println("Trying 2/0");
        try{
            Rational r1 = new Rational(2, 0);
            System.out.println("**** Fails - no exception thrown");
        }
        catch(ZeroDenominatorException e)
        {
            System.out.println("     Passes");
        }


        System.out.println("Trying 42/30");
        Rational r2 = new Rational(42, 30);
        
        if(r2.getNumerator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 7");
        }

        if(r2.getDenominator() == 5)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 5");
        }
        
        

        System.out.println("Trying 6/-3");
        Rational r3 = new Rational(6, -3);
        
        if(r3.getNumerator() == -2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not -2");
        }

        if(r3.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }


        System.out.println("Trying -6/-3");
        Rational r4 = new Rational(-6, -3);
        
        if(r4.getNumerator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 2");
        }

        if(r4.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }

        System.out.println("Trying -6/3");
        Rational r5 = new Rational(-6, 3);
        
        if(r5.getNumerator() == -2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not -2");
        }

        if(r5.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }

        System.out.println("Trying 0/3");
        Rational r6 = new Rational(0, 3);
        
        if(r6.getNumerator() == 0)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 0");
        }

        if(r6.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }
    System.out.println("Constructor tests finished");

    }
    
    
    public static void testNegate()
    {
        System.out.println();
        System.out.println();
        System.out.println("TESTING the negate method");
        
        System.out.println("Negate 1/2");
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.negate();
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of negate argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of negate argument");
        }
        
        if(r2.getNumerator() == -1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not -1");
        }

        if(r2.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 2");
        }


        System.out.println("Negate -2/3");
        r1 = new Rational(-2, 3);
        r2 = r1.negate();
        
        if(r1.getNumerator() == -2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of negate argument");
        }

        if(r1.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of negate argument");
        }
        
        if(r2.getNumerator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 2");
        }

        if(r2.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 3");
        }
        System.out.println("Negate tests finished");
    }
    


    public static void testInvert()
    {
        System.out.println();
        System.out.println();
        System.out.println("TESTING the invert method");
        
        System.out.println("Invert 1/2");
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.invert();
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of negate argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of negate argument");
        }
        
        if(r2.getNumerator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 2");
        }

        if(r2.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }


        System.out.println("Invert -2/3");
        r1 = new Rational(-2, 3);
        r2 = r1.invert();
        
        if(r1.getNumerator() == -2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of negate argument");
        }

        if(r1.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of negate argument");
        }
        
        if(r2.getNumerator() == -3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not -3");
        }

        if(r2.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 2");
        }

        System.out.println("Invert 0/5");
        r1 = new Rational(0, 5);
        try
        {
            r2 = r1.invert();
            System.out.println("**** Fails - did not throw zero denominator exception");
        }
        catch(ZeroDenominatorException e)
        {
            System.out.println("     Passes");
        }
        System.out.println("Invert tests finished");           
    }    
    
    public static void testAddSubtract()
    {
        System.out.println();
        System.out.println();
        System.out.println("TESTING the add and subtract methods");
        
        System.out.println("Adding 1/2 and 1/2");
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.add(r1);
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of add argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of add argument");
        }
        
        if(r2.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 1");
        }

        if(r2.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }


        System.out.println("Adding 4/7 and 3/5");
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 5);
        Rational r3 = r1.add(r2);
        
        if(r1.getNumerator() == 4)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of first add argument");
        }

        if(r1.getDenominator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of first add argument");
        }


        if(r2.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of second add argument");
        }

        if(r2.getDenominator() == 5)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of second add argument");
        }
        
        if(r3.getNumerator() == 41)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 41");
        }

        if(r3.getDenominator() == 35)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 35");
        }
        
        System.out.println("Adding 1/2 and 1/6");
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.add(r2);
        
        if(r3.getNumerator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 2");
        }

        if(r3.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 3");
        }
        


        System.out.println("Subtracting 1/2 and 1/2");
        r1 = new Rational(1, 2);
        r2 = r1.subtract(r1);
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of subtract argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of subtract argument");
        }
        
        if(r2.getNumerator() == 0)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 0");
        }

        if(r2.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }


        System.out.println("Subtracting 4/7 and 3/5");
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 5);
        r3 = r1.subtract(r2);
        
        if(r1.getNumerator() == 4)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of first subtract argument");
        }

        if(r1.getDenominator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of first subtract argument");
        }


        if(r2.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of second subtract argument");
        }

        if(r2.getDenominator() == 5)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of second subtract argument");
        }
        
        if(r3.getNumerator() == -1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not -1");
        }

        if(r3.getDenominator() == 35)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 35");
        }
        
        System.out.println("Subtracting 1/2 and 1/6");
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.subtract(r2);
        
        if(r3.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 1");
        }

        if(r3.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 3");
        }
        System.out.println("Add/Subtract tests finished");          
    }
    
    
    public static void testMultiplyDivide()
    {
        System.out.println();
        System.out.println();
        System.out.println("TESTING the multiply and divide methods");
        
        System.out.println("Multiply 1/2 and 1/2");
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.multiply(r1);
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of add argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of add argument");
        }
        
        if(r2.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 1");
        }

        if(r2.getDenominator() == 4)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 4");
        }


        System.out.println("Multiply 5/7 and 3/5");
        r1 = new Rational(5, 7);
        r2 = new Rational(3, 5);
        Rational r3 = r1.multiply(r2);
        
        if(r1.getNumerator() == 5)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of first add argument");
        }

        if(r1.getDenominator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of first add argument");
        }


        if(r2.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of second add argument");
        }

        if(r2.getDenominator() == 5)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of second add argument");
        }
        
        if(r3.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 3");
        }

        if(r3.getDenominator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 7");
        }
        
        System.out.println("Multiply 1/2 and 0/1");
        r1 = new Rational(1, 2);
        r2 = new Rational(0, 1);
        r3 = r1.multiply(r2);
        
        if(r3.getNumerator() == 0)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 0");
        }

        if(r3.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }
        


        System.out.println("Dividing 1/2 by 1/2");
        r1 = new Rational(1, 2);
        r2 = r1.divide(r1);
        
        if(r1.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of subtract argument");
        }

        if(r1.getDenominator() == 2)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of subtract argument");
        }
        
        if(r2.getNumerator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 1");
        }

        if(r2.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }


        System.out.println("Dividing 4/7 by 3/28");
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 28);
        r3 = r1.divide(r2);
        
        if(r1.getNumerator() == 4)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of first subtract argument");
        }

        if(r1.getDenominator() == 7)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of first subtract argument");
        }


        if(r2.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed numerator of second subtract argument");
        }

        if(r2.getDenominator() == 28)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - changed denominator of second subtract argument");
        }
        
        if(r3.getNumerator() == 16)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 16");
        }

        if(r3.getDenominator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 3");
        }
        
        System.out.println("Dividing 1/2 by 1/6");
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.divide(r2);
        
        if(r3.getNumerator() == 3)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - numerator not 3");
        }

        if(r3.getDenominator() == 1)
        {
            System.out.println("     Passes");
        }
        else
        {
            System.out.println("**** Fails - denominator not 1");
        }
        
        
        System.out.println("Dividing 1/2 by 0/1");
        r1 = new Rational(1, 2);
        r2 = new Rational(0, 1);
        try
        {
            r3 = r1.divide(r2);
            System.out.println("**** Fails - did not throw zero denominator exception");
        }
        catch(ZeroDenominatorException e)
        {
            System.out.println("     Passes");
        }
        System.out.println("Multiply/Divide tests finished");
    }
    
}

    
