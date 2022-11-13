package cis5027BlackJack;
/**
 * Implementation of the card type
 * 
 * @author St20155999
 * 
 */

/*
* The following section of code was taken and adapted for the purpose of the assignment, from::
* MaxieTheHatter (2016) Blackjack Java OOP SchoolProject
*  . https://github.com/MaxieTheHatter/Blackjack-Java-OOP-schoolproject [4/12/21].
*/
public class Card {
     private Suit suit;
     private Value value;
	public Object rank;
     
     public Card(Suit suit, Value value) {
    	 this.value = value;
    	 this.suit= suit;
   //constructor for the deck class.
     } 
     
     public String toString() {
    	 return this.suit.toString() + "-" + this.value.toString();
   //prints out the Suit and Value in a nicely formatted string.
     }
     
     public Value getValue(){
    	 return this.value;
    	 //checks the value of the deck class.
     }

	public void setValue(int nextInt) {
		// Sets the Cards Value
		
	}



	
     
     
}
