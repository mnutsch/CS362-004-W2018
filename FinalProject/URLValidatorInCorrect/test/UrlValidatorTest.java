/******************************************************
 * Name: UrlValidatorTest.java
 * Date Last Modified: 3-17-2018
 * Description:
 * A skeleton version of this file was provided by
 * Oregon State University CS362.
 * Code for testing was added eby:
 * Matt Nutsch
 * Alex Li
 * Valerie Chapple
 *
 ******************************************************/

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
        //this function performs manual testing
        System.out.println("Performing manual tests...");

        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        String urlToTest = "";

        System.out.println("Test # 1");
        urlToTest = "http://www.oregonstate.edu";
        System.out.println("Testing if the following URL is valid: " + urlToTest);
        if (urlValidator.isValid(urlToTest)) {
        System.out.println("url is valid");
        } else {
            System.out.println("url is invalid");
        }

       System.out.println("Test # 2");
       urlToTest = "oregonstate.edu";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("Test # 3");
       urlToTest = "123.456.789.0";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("Test # 4");
       urlToTest = "abc.def.ghi.jkl";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }

       System.out.println("Test # 5");
       urlToTest = "www.apache.org";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
           System.out.println("url is valid");
       } else {
           System.out.println("url is invalid");
       }
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
