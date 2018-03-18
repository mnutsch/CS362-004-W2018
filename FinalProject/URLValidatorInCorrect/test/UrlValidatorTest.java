

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
//You can use this function to implement your manual testing	   
	   
   }
   
   public boolean segmentTest(UrlValidator urlVal, String url) { return urlVal.isValid(url); }

   public void testYourFirstPartition()
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
       System.out.println("**********************");
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
       System.out.println("**********************\n");

       for (int i = 0; i < invalidPartitionSet.length; i++) {
           testnumber++;
           url = invalidPartitionSet[i] + authority;

           if (!segmentTest(urlVal, url)) {
               passes++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - PASSED\n", i+1, invalidPartitionSet[i], url);
           }

           else {
               fails++;
               System.out.printf("Test #%d: scheme - %s | url - %s | Result - FAILED\n", i+1, invalidPartitionSet[i], url);
           }
       }
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
