/**
 * 
 * 
 * @author  St20155999
 * 
 */
package cis5027BlackJack;

import java.util.Scanner;

public class BlackJack {

	private static Scanner userInput;
	private static Scanner keyboard = new Scanner(System.in);
	private static int numPlayers=0;
	
	public static void main(String[] args) {
		
		//Welcoming Message to User
		System.out.println("Welcome to BlackJack!");
		
		//Creating the new playing deck for game
		 Deck playingDeck = new Deck();
	     playingDeck.createFullDeck();
	     playingDeck.shuffle();
	     
	     //Creating player's deck and dealer's deck
	     Deck playerDeck = new Deck();
	     
	     Deck dealerDeck = new Deck();
	     
	          
	     userInput = new Scanner(System.in);
	     
	     //Game Loop
	     //Get the Number of Players
	     System.out.println("Please enter the number players?");
			numPlayers = keyboard.nextInt();
			keyboard.nextLine();
			while (numPlayers<1 || numPlayers>5){
				System.out.println("Please enter a number of decks between 1 and 5.");
				numPlayers = keyboard.nextInt();
				keyboard.nextLine();
			}
			// Creaing Players
			for (int i=0; i<numPlayers; i++){
				System.out.print("Please give a name for player "+(i+1)+": ");
				System.out.println("");
				String pName = keyboard.nextLine();
				if (pName.toLowerCase().equals("dealer")){
					System.out.print("That name is reserved, please enter a new name: ");
					pName = keyboard.nextLine();
				}
				Player newPlayer = new Player(pName,i);
				Player.add(newPlayer);
			}
	     
	     //Variable to keep track of the round
	      boolean endRound = false;      
	            
	     //Start Dealing
	     //Player gets 2 cards at the start of the game
	     playerDeck.draw(playingDeck);
	     playerDeck.draw(playingDeck);
	     
	     //Dealer gets 2 cards at the start of the game
	     dealerDeck.draw(playingDeck);
	     dealerDeck.draw(playingDeck);
	     
	     //while-loop to keep drawing cards
	     while (true) 
         {
             System.out.println("Your hand:");
             System.out.print(playerDeck.toString());
             System.out.println("Your hand value is currently at: " + playerDeck.cardsValue());
             
             //Display the Dealer's Hand 
             System.out.println("Dealer Hand: " +dealerDeck.getCard(0).toString() + " and [Hidden]");
             
             //What does the player want to do?
             System.out.println("Do you want to (1)Deal or (2)Hold?");
             int response = userInput.nextInt();
             
             //If player Hits
             if (response == 1) {
                 playerDeck.draw(playingDeck);
                 System.out.println("You drew a: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());
                 //If Bust > 21
                 if (playerDeck.cardsValue() > 21) {
                     System.out.println("Bust. Your current value is: "
                             + playerDeck.cardsValue());
                    
                     endRound = true;
                     break;
                 }
             }
             if (response == 2) {
            	 break;
             } 
             
         }

	     //Reveal The Dealers Cards
	     System.out.println("Dealers hand: " + dealerDeck.toString());
	    //Check if dealer has more points than player
	     if ((dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false){
             System.out.println("Dealer wins!");
            
             endRound = true;
	     }
	     //Dealer hits at 16 or lower
	     while ((dealerDeck.cardsValue() < 17) && endRound == false) {
             dealerDeck.draw(playingDeck);
             System.out.println("Dealer drew: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
         }
	     //Display the Total Value for Dealer 
	     System.out.println("Dealer's current hand  value is at: " + dealerDeck.cardsValue());
	     //Determine if dealer has a busted hand, You win
	     if ((dealerDeck.cardsValue() > 21) && endRound == false) {
             System.out.println("Dealer is bust, you win!");
            
             endRound = true;
             
         }

	     //Determine if pushed into a draw
	     if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
             System.out.println("It's a draw!, Push?");
             endRound = true;
	     }
	     //If Player wins
	     if ((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false) {
             System.out.println("You win!");
            
             endRound = true;
	     }
	     else if (endRound == false) {
             System.out.println("You lose the round.");
           
             endRound = true;
         }
	     
	     playerDeck.moveAllToDeck(playingDeck);
         dealerDeck.moveAllToDeck(playingDeck);
         System.out.println("End of Hand.");
	}
	    
	}

