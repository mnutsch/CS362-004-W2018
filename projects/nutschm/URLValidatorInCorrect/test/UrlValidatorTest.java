

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!


public class UrlValidatorTest extends TestCase {

   public UrlValidatorTest(String testName) {
      super(testName);
   }

 
   
   public void testManualTest()
   {		//You can use this function to implement your manual testing
	   
//	   String[] schemes = {"http","https"};
//	   UrlValidator urlVal = new UrlValidator(schemes, 0);
	   UrlValidator urlVal = new UrlValidator();
	   // Test Data
	   String[] testURLFalse = {
			   "fake:/oregonstate.edu/",
			   "bad://www.google.com/",
			   "htttp://soc/",
			   "bad://www.google.com/asdf/as/fd/",
			   "htttp://soc/1.",
			   "htttp://1.2.2./path?.com."
			   
	   };
	   String[] testURLTrue = {
			   "http://oregonstate.edu/",
			   "https://www.google.com/",
			   "http://ecampus.oregonstate.edu/forms/degree-comparison.htm"
	   };
	   
	   int i ;
	   for (i = 0; i < testURLFalse.length; i++ ) {
		   boolean result = urlVal.isValid( testURLFalse[i]);
		   if (result == false) {
			   System.out.print('.');
		   } else {
			   System.out.print('X');
		   }
	   }
	   
	   for (i = 0; i < testURLTrue.length; i++ ) {
		   boolean result = urlVal.isValid( testURLTrue[i]);
		   if (result == true) {
			   System.out.print('.');
		   } else {
			   System.out.print('X');
		   }
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
