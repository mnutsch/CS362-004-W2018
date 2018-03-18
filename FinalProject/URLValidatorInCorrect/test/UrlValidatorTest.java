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

   public boolean segmentTest(UrlValidator urlVal, String url) { return urlVal.isValid(url); }

   public void testSchemePartition()
   {
       // can't test other valid schemes due to a bug in RegexValidator that throws an IllegalArgumentException for valid schemes other than "http://"
       String validPartitionSet[] = {"http://", ""};
       String invalidPartitionSet[] = {"http:/", "http:", "http/", "://"};
       int passes = 0;
       int fails = 0;
       int testnumber = 0;
       String authority = "www.google.com";
       String url = "";
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       // valid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Valid Schemes");
       System.out.println("**********************\n");

       for (int i = 0; i < validPartitionSet.length; i++) {
           testnumber++;
           url = validPartitionSet[i] + authority;
           /*
           boolean valid;
           try{
               valid = segmentTest(urlVal, url);
           } catch (IllegalArgumentException e) {
               fails++;
           }
           */
           if (segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - PASSED\n", i+1, validPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - FAILED\n", i+1, validPartitionSet[i], url);
           }

       }

       // invalid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Invalid Schemes");
       System.out.println("note: failed test indicates isValid() returned true for an invalid partition segment");
       System.out.println("**********************\n");

       for (int i = 0; i < invalidPartitionSet.length; i++) {
           testnumber++;
           url = invalidPartitionSet[i] + authority;

           if (!segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - PASSED\n", i + 1, invalidPartitionSet[i], url);
           } else {
               fails++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - FAILED\n", i + 1, invalidPartitionSet[i], url);
           }
       }
   }
   
   public void testAuthorityPartition(){
       String validPartitionSet[] = {"www.google.com", "go.com", "go.au", "0.0.0.0", "255.255.255.255", "255.com"};
       String invalidPartitionSet[] = {"256.256.256.256", "1.2.3.4.5", "1.2.3.4", "1.2.3", ".1.2.3.4", "go.a"};
       int passes = 0;
       int fails = 0;
       int testnumber = 0;
       String scheme = "http://";
       String url = "";
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       // valid authorities test
       System.out.println("\n**********************");
       System.out.println("Testing Valid Authorities");
       System.out.println("**********************\n");

       for (int i = 0; i < validPartitionSet.length; i++) {
           testnumber++;
           url = scheme + validPartitionSet[i];

           if (segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: authority - %s | url - %s | Result - PASSED\n", i+1, validPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: authority - %s | url - %s | Result - FAILED\n", i+1, validPartitionSet[i], url);
           }
       }

       // invalid authorities test
       System.out.println("\n**********************");
       System.out.println("Testing Invalid Authorities");
       System.out.println("note: failed test indicates isValid() returned true for an invalid partition segment");
       System.out.println("**********************\n");

       for (int i = 0; i < invalidPartitionSet.length; i++) {
           testnumber++;
           url = scheme + invalidPartitionSet[i];

           if (!segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: authority - %s | url - %s | Result - PASSED\n", i+1, invalidPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: authority - %s | url - %s | Result - FAILED\n", i+1, invalidPartitionSet[i], url);
           }
       }
   }

    public void testPortPartition(){
        String validPartitionSet[] = {":80", ":65535", ":0", ""};
        String invalidPartitionSet[] = {":-1", ":65536", ":65a"};
        int passes = 0;
        int fails = 0;
        int testnumber = 0;
        String scheme = "http://";
        String authority = "www.google.com";
        String url = "";
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        // valid ports test
        System.out.println("\n**********************");
        System.out.println("Testing Valid Ports");
        System.out.println("**********************\n");

        for (int i = 0; i < validPartitionSet.length; i++) {
            testnumber++;
            url = scheme + authority + validPartitionSet[i];

            if (segmentTest(urlVal, url)) {
                passes++;
                System.out.printf("Test #%d: port - %s | url - %s | Result - PASSED\n", i+1, validPartitionSet[i], url);
            }

            else {
                fails++;
                System.out.printf("Test #%d: port - %s | url - %s | Result - FAILED\n", i+1, validPartitionSet[i], url);
            }
        }

        // invalid ports test
        System.out.println("\n**********************");
        System.out.println("Testing Invalid Ports");
        System.out.println("note: failed test indicates isValid() returned true for an invalid partition segment");
        System.out.println("**********************\n");

        for (int i = 0; i < invalidPartitionSet.length; i++) {
            testnumber++;
            url = scheme + invalidPartitionSet[i];

            if (!segmentTest(urlVal, url)) {
                passes++;
                System.out.printf("Test #%d: port - %s | url - %s | Result - PASSED\n", i+1, invalidPartitionSet[i], url);
            }

            else {
                fails++;
                System.out.printf("Test #%d: port - %s | url - %s | Result - FAILED\n", i+1, invalidPartitionSet[i], url);
            }
        }
    }
   
   public void testQueryStringPartition() {
       String validPartitionSet[] = {"?key=value",
    		   "?key1=1&key2=2",
    		   ""
    		   };
       String invalidPartitionSet[] = {"? key=value"
    		   };
       int passes = 0;
       int fails = 0;
       int testnumber = 0;
       String scheme = "http://";
       String authority = "www.google.com";
       String path = "/path";
       String url = "";
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       // valid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Valid Queries");
       System.out.println("**********************\n");

       for (int i = 0; i < validPartitionSet.length; i++) {
           testnumber++;
           url = scheme + authority + path + validPartitionSet[i];
           if (segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: query - %s | url - %s | Result - PASSED\n", i+1, validPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: query - %s | url - %s | Result - FAILED\n", i+1, validPartitionSet[i], url);
           }

       }

       // invalid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Invalid Queries");
       System.out.println("**********************\n");

       for (int i = 0; i < invalidPartitionSet.length; i++) {
           testnumber++;
           url = scheme + authority + path + invalidPartitionSet[i];

           if (!segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: query - %s | url - %s | Result - PASSED\n", i+1, invalidPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: query - %s | url - %s | Result - FAILED\n", i+1, invalidPartitionSet[i], url);
           }
       }
   }
   
   public void testPathPartition() {
       String validPartitionSet[] = {"/test1",
    		   "/test1/test2",
    		   "/test1/2/3",
    		   "/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789",
    		   "/asdf-asdf",
    		   "/$asdf$asdfd=asdf-dsfd",
    		   "/abc.pdf"
    		   };
       String invalidPartitionSet[] = {"/..", 
    		   "/../", 
    		   "/..//file", 
    		   "/test1//file",
    		   "/ /"
    		   };
       int passes = 0;
       int fails = 0;
       int testnumber = 0;
       String scheme = "http://";
       String authority = "www.google.com";
       String url = "";
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       // valid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Valid Paths");
       System.out.println("**********************\n");

       for (int i = 0; i < validPartitionSet.length; i++) {
           testnumber++;
           url = scheme + authority + validPartitionSet[i];
           if (segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: path - %s | url - %s | Result - PASSED\n", i+1, validPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: path - %s | url - %s | Result - FAILED\n", i+1, validPartitionSet[i], url);
           }

       }

       // invalid schemes test
       System.out.println("\n**********************");
       System.out.println("Testing Invalid Paths");
       System.out.println("**********************\n");

       for (int i = 0; i < invalidPartitionSet.length; i++) {
           testnumber++;
           url = scheme + authority + invalidPartitionSet[i];

           if (!segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: path - %s | url - %s | Result - PASSED\n", i+1, invalidPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: path - %s | url - %s | Result - FAILED\n", i+1, invalidPartitionSet[i], url);
           }
       }
   }
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
