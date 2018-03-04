/*******************************************************************
* Name: unittest4.c
* Author: Matt Nutsch
* Date: 2-4-2018
* Description:
* This code tests the function scoreFor().
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
	
    printf ("TESTING scoreFor():\n");
	
	handCount = maxHandCount;
	
	memset(&G, 23, sizeof(struct gameState));   // clear the game state
    r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
	
	//set up player's hand
	G.handCount[0] = 5;
	G.hand[0][0] = estate; //+1 
	G.hand[0][1] = estate; //+1 
	G.hand[0][2] = estate; //+1 
	G.hand[0][3] = estate; //+1 
	G.hand[0][4] = estate; //+1 
	
	//set up player's discard
	G.discardCount[0] = 2;
	G.discard[0][0] = curse; //-1
	G.discard[0][2] = curse; //-1
	
	//set up player's deck
	G.deckCount[0] = 1;
	G.deck[0][0] == great_hall; //+1
	
	//test the value
	returnValue = scoreFor(0, &G);
	printf("The return value == %d.\n", returnValue); 
	
	//check if the value is what is expected
	assert(returnValue == 4); //5 - 2 + 1 = 4
	
    printf("All tests passed!\n");

    return 0;
}