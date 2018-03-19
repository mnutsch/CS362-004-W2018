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
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 1: MANUAL TESTS\n");

	   int passes = 0;
       int fails = 0;
       int testnumber = 0;
       
//        String[] schemes = {"http","https"};
//        UrlValidator urlValidator = new UrlValidator(schemes);
        UrlValidator urlValidator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        String urlToTest = "";
        testnumber++;
        System.out.println("Test #" + testnumber);
        urlToTest = "http://www.oregonstate.edu";
        System.out.println("Testing if the following URL is valid: " + urlToTest);
        if (urlValidator.isValid(urlToTest)) {
        		passes++;
        		System.out.println("url is valid");
        } else {
        		fails++;
            System.out.println("url is invalid");
        }
        
        testnumber++;
        System.out.println("Test #" + testnumber);
        urlToTest = "oregonstate.edu";
        System.out.println("Testing if the following URL is valid: " + urlToTest);
        if (urlValidator.isValid(urlToTest)) {
        		passes++;
        		System.out.println("url is valid");
        } else {
        		fails++;
        		System.out.println("url is invalid");
        }

        testnumber++;
        System.out.println("Test #" + testnumber);
       urlToTest = "123.456.789.0";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		fails++;
       		System.out.println("url is valid");
       } else {
       		passes++;
       		System.out.println("url is invalid");
       }

       testnumber++;
       System.out.println("Test #" + testnumber);
       urlToTest = "abc.def.ghi.jkl";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		fails++;
       		System.out.println("url is valid");
       } else {
       		passes++;
       		System.out.println("url is invalid");
       }

       testnumber++;
       System.out.println("Test #" + testnumber);
       urlToTest = "www.apache.org";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		passes++;
       		System.out.println("url is valid");
       } else {
       		fails++;
       		System.out.println("url is invalid");
       }
       
       testnumber++;
       System.out.println("Test #" + testnumber);
       urlToTest = "http://oregonstate.edu";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		passes++;
       		System.out.println("url is valid");
       } else {
       		fails++;
       		System.out.println("url is invalid");
       }
       
       testnumber++;
       System.out.println("Test #" + testnumber);
       urlToTest = "http://www.google.com";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		passes++;
       		System.out.println("url is valid");
       } else {
       		fails++;
       		System.out.println("url is invalid");
       }
       
       testnumber++;
       System.out.println("Test #" + testnumber);
       urlToTest = "http://www.google.com/path";
       System.out.println("Testing if the following URL is valid: " + urlToTest);
       if (urlValidator.isValid(urlToTest)) {
       		passes++;
       		System.out.println("url is valid");
       } else {
       		fails++;
       		System.out.println("url is invalid");
       }
	   
       System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }

   public boolean segmentTest(UrlValidator urlVal, String url) { return urlVal.isValid(url); }

   public void testSchemePartition()
   {
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 2: PARTITION TESTS - scheme\n");
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
       System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }
   
   public void testAuthorityPartition(){
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 2: PARTITION TESTS - authority\n");
       String validPartitionSet[] = {"www.google.com", "go.com", "go.au", "0.0.0.0", "255.255.255.255", "255.com"};
       String invalidPartitionSet[] = {"256.256.256.256", "1.2.3.4.5", "1.2.3.4.", "1.2.3", ".1.2.3.4", "go.a"};
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
       System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }

    public void testPortPartition(){
    		System.out.println("\n\n====================================================================");
    		System.out.println("PART 2: PARTITION TESTS - port\n");
 	   
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
        System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
    }
   
   public void testQueryStringPartition() {
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 2: PARTITION TESTS - query string\n");
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

       // valid queries test
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

       // invalid queries test
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
       System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }
   
   public void testPathPartition() {
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 2: PARTITION TESTS - path\n");
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

       // valid paths test
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

       // invalid paths test
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
       System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }
   
   
   public void testIsValid()
   {
	   System.out.println("\n\n====================================================================");
	   System.out.println("PART 3: PROGRAM TESTS\n");
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   int passes = 0;
       int fails = 0;
       int testnumber = 0;
       
	// Input Data
       String schemes[] = {"http://", "", "http:/", "http:", "http/", "://"};
	   String validSchemes[] = {"http://", ""};
	   String invalidSchemes[] = {"http:/", "http:", "http/", "://"};
	   
	   String authorities[] = {"www.google.com", "go.com", "go.au", "0.0.0.0", "255.255.255.255", "255.com", "256.256.256.256", "1.2.3.4.5", "1.2.3.4", "1.2.3", ".1.2.3.4", "go.a"};
	   String validAuthorities[] = {"www.google.com", "go.com", "go.au", "0.0.0.0", "255.255.255.255", "255.com"};
	   String invalidAuthorities[] = {"256.256.256.256", "1.2.3.4.5", "1.2.3.4", "1.2.3", ".1.2.3.4", "go.a"};
	   
	   String ports[] = {":80", ":65535", ":0", "", ":-1", ":65536", ":65a"};
	   String validPorts[] = {":80", ":65535", ":0", ""};
	   String invalidPorts[] = {":-1", ":65536", ":65a"};
	   
	   String paths[] = {"/test1", "/test1/test2", "/test1/2/3", "/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", "/asdf-asdf","/$asdf$asdfd=asdf-dsfd","/abc.pdf","/..", "/../", "/..//file", "/test1//file","/ /"}; 
	   String validPaths[] = {"/test1", "/test1/test2", "/test1/2/3", "/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", "/asdf-asdf","/$asdf$asdfd=asdf-dsfd","/abc.pdf"};
	   String invalidPaths[] = {"/..", "/../", "/..//file", "/test1//file","/ /"};
	   
	   String queries[] = {"?key=value", "?key1=1&key2=2","", "? key=value"};
	   String validQueryStrings[] = {"?key=value", "?key1=1&key2=2",""};
	   String invalidQueryStrings[] = {"? key=value"};
	   
	   // valid URL test
       System.out.println("\n**********************");
       System.out.println("Testing Valid URLs");
       System.out.println("**********************\n");
       
	   // Create Valid URLs
	   String validUrl = "";
	   int i = 0;
	   for (i =0; i < validSchemes.length; i++ ) {
		   for (int j =0; j < validAuthorities.length; j++ ) {
			   for (int k =0; k < validPorts.length; k++ ) {
				   for (int l =0; l < validPaths.length; l++ ) {
					   for (int m =0; m < validQueryStrings.length; m++ ) {
						   testnumber++;
						   validUrl = validSchemes[i];
						   validUrl += validAuthorities[j];
						   validUrl += validPorts[k];
						   validUrl += validPaths[l];
						   validUrl += validQueryStrings[m];
						   if (urlVal.isValid(validUrl)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, validUrl);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, validUrl);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   // valid URL test
       System.out.println("\n**********************");
       System.out.println("Testing Invalid URLs");
       System.out.println("**********************\n");
       
       
	   // Create Invalid URLs
       // Wrong Scheme
       String url = "";
	   for (i =0; i < invalidSchemes.length; i++ ) {
		   for (int j =0; j < authorities.length; j++ ) {
			   for (int k =0; k < ports.length; k++ ) {
				   for (int l =0; l < paths.length; l++ ) {
					   for (int m =0; m < queries.length; m++ ) {
						   testnumber++;
						   url = invalidSchemes[i];
						   url += authorities[j];
						   url += ports[k];
						   url += paths[l];
						   url += queries[m];
						   if (!urlVal.isValid(url)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, url);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, url);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   // Wrong Authorities
	   url = "";
	   for (i =0; i < schemes.length; i++ ) {
		   for (int j =0; j < invalidAuthorities.length; j++ ) {
			   for (int k =0; k < ports.length; k++ ) {
				   for (int l =0; l < paths.length; l++ ) {
					   for (int m =0; m < queries.length; m++ ) {
						   testnumber++;
						   url = schemes[i];
						   url += invalidAuthorities[j];
						   url += ports[k];
						   url += paths[l];
						   url += queries[m];
						   if (!urlVal.isValid(url)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, url);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, url);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   // Wrong ports
	   url = "";
	   for (i =0; i < schemes.length; i++ ) {
		   for (int j =0; j < authorities.length; j++ ) {
			   for (int k =0; k < invalidPorts.length; k++ ) {
				   for (int l =0; l < paths.length; l++ ) {
					   for (int m =0; m < queries.length; m++ ) {
						   testnumber++;
						   url = schemes[i];
						   url += authorities[j];
						   url += invalidPorts[k];
						   url += paths[l];
						   url += queries[m];
						   if (!urlVal.isValid(url)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, url);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, url);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   // Wrong paths
	   url = "";
	   for (i =0; i < schemes.length; i++ ) {
		   for (int j =0; j < authorities.length; j++ ) {
			   for (int k =0; k < ports.length; k++ ) {
				   for (int l =0; l < invalidPaths.length; l++ ) {
					   for (int m =0; m < queries.length; m++ ) {
						   testnumber++;
						   url = schemes[i];
						   url += authorities[j];
						   url += ports[k];
						   url += invalidPaths[l];
						   url += queries[m];
						   if (!urlVal.isValid(url)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, url);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, url);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   // Wrong queries
	   url = "";
	   for (i =0; i < schemes.length; i++ ) {
		   for (int j =0; j < authorities.length; j++ ) {
			   for (int k =0; k < ports.length; k++ ) {
				   for (int l =0; l < paths.length; l++ ) {
					   for (int m =0; m < invalidQueryStrings.length; m++ ) {
						   testnumber++;
						   url = schemes[i];
						   url += authorities[j];
						   url += ports[k];
						   url += paths[l];
						   url += invalidQueryStrings[m];
						   if (!urlVal.isValid(url)) {
				               passes++;
//				               System.out.printf("Test #%d: url - %s | Result - PASSED\n", testnumber, url);
				           }
				           else {
				               fails++;
				               System.out.printf("Test #%d: url - %s | Result - FAILED\n",  testnumber, url);
				           }
					   }
				   }
			   }
		   }
	   }
	   
	   System.out.printf("\nTotal Tests: %d: PASSED - %d | FAILED - %d\n", testnumber, passes, fails);
   }
}
