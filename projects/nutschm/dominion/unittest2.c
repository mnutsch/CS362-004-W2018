/*******************************************************************
* Name: unittest2.c
* Author: Matt Nutsch
* Date: 2-4-2018
* Description:
* This code tests the function fullDeckCount().
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
	
	int p, r, handCount;
    int bonus;
	
	int k[10] = {adventurer, council_room, feast, gardens, mine
               , remodel, smithy, village, baron, great_hall};
	
	int maxHandCount = 5;
    // arrays of all coppers, silvers, and golds
    int coppers[MAX_HAND];
    for (i = 0; i < MAX_HAND; i++)
    {
        coppers[i] = copper;
    }
	
    printf ("TESTING fullDeckCount():\n");
	
	handCount = maxHandCount;
	deckCount = 5;
	
	memset(&G, 23, sizeof(struct gameState));   // clear the game state
    r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
    G.handCount[p] = handCount;                 // set the number of cards on hand
    memcpy(G.hand[p], coppers, sizeof(int) * handCount); // set all the cards to copper
    updateCoins(p, &G, bonus);
	
	//test the value
	returnValue = fullDeckCount(0, 3, &G);
	printf("The return value == %d.\n", returnValue); 
	
	//check if the value is what is expected
	assert(returnValue == 5);
	
    printf("All tests passed!\n");

    return 0;
}
