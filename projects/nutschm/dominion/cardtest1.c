/*******************************************************************
* Name: cardtest1.c
* Author: Matt Nutsch
* Date: 2-4-2018
* Description:
* This code tests the function smithy_card().
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
	
    printf ("TESTING smithy_card():\n");
	
	handCount = maxHandCount;
	
	memset(&G, 23, sizeof(struct gameState));   // clear the game state
    r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
	
	G.handCount[0] = 2;
	G.hand[0][0] = smithy;  
	G.hand[0][1] = estate;  

	
	printf("Player 0's handcount == %d.\n", G.handCount[0]);
	
	//test the value
	returnValue = smithy_card(0, 0, 0, 0, &G, 0, 0); //int smithy_card(int currentPlayer, int choice1, int choice2, int choice3, struct gameState *state, int handPos, int *bonus)
	printf("The return value == %d.\n", returnValue); 
	
	//check if the value is what is expected
	printf("Player 0's handcount == %d.\n", G.handCount[0]);
	assert(G.handCount[0] == 4);
	
    printf("All tests passed!\n");

    return 0;
}