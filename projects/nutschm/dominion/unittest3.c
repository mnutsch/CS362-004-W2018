/*******************************************************************
* Name: unittest3.c
* Author: Matt Nutsch
* Date: 2-4-2018
* Description:
* This code tests the function isGameOver().
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
	
	int i;
    int seed = 1000;
    int numPlayer = 2;
    struct gameState G;
	
	int k[10] = {adventurer, council_room, feast, gardens, mine
               , remodel, smithy, village, baron, great_hall};
	
	int p, r, handCount;
    int bonus;

    printf ("TESTING isGameOver():\n");
	
	memset(&G, 23, sizeof(struct gameState));   // clear the game state
    r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
	
	//test that the game is over, because the provinces are gone
	G.supplyCount[province] = 0; //set the number of Provinces to 0
	//test the value
	returnValue = isGameOver(&G);
	printf("The return value == %d.\n", returnValue); 
	//check if the value is what is expected
	assert(returnValue == 1);
	
	//test that the game is not over, because the provinces are not gone
	G.supplyCount[province] = 3; //set the number of Provinces to ! 0
	//test the value
	returnValue = isGameOver(&G);
	printf("The return value == %d.\n", returnValue); 
	//check if the value is what 
	assert(returnValue == 0);
	
	//test that the game is over, because 3 supply counts are 0.
	//set three supply counts to 0
	G.supplyCount[0] = 0; 
	G.supplyCount[1] = 0;
	G.supplyCount[2] = 0;
	//test the value
	returnValue = isGameOver(&G);
	printf("The return value == %d.\n", returnValue); 
	//check if the value is what 
	assert(returnValue == 1);

    printf("All tests passed!\n");

    return 0;
}