/*******************************************************************
* Name: unittest1.c
* Author: Matt Nutsch
* Date: 2-4-2018
* Description:
* This code tests the function getCost().
* This code is based in part on the testUpdateCoins.c example from class.
********************************************************************/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main() 
{
	
	int returnValue = NULL;

    printf ("TESTING getCost():\n");
	
	//test the value
	returnValue = getCost(3);
	printf("The return value == %d.\n", returnValue); 
	
	//check if the value is what is expected
	assert(returnValue == 8);
	

    printf("All tests passed!\n");

    return 0;
}
