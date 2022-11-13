/**
 * Implementation of the card type
 * 
 * @author St20155999
 * 
 */
package cis5027blackjack;

public class Card {
     private Suit suit;
     private Value value;
     
     public Card(Suit suit, Value value) {
    	 this.value = value;
    	 this.suit= suit;
   //contructor for the deck class.
     } 
     
     public String toString() {
    	 return this.suit.toString() + "-" + this.value.toString();
   //prints out the Suit and Value in a nicely formatted string.
     }
     
     public Value getValue(){
    	 return this.value;
    	 //checks the value of the deck class.
     }
     
     
}
