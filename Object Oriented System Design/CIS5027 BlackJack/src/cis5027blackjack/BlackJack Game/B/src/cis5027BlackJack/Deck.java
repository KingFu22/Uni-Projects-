package cis5027BlackJack;
/**
 * Implementation of Deck type
 * 
 * @author St20155999
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/*
* The following section of code was taken and adapted for the purpose of the assignment, from::
* MaxieTheHatter (2016) Blackjack Java OOP SchoolProject
*  . https://github.com/MaxieTheHatter/Blackjack-Java-OOP-schoolproject [4/12/21].
*/
public class Deck {
    public static int index;
	//Instance Vars
	private ArrayList<Card> cards;
	public Object cardList;
	public List<Card> cardList1;
	
	//Constructor for Deck
	public Deck() {
		this.cards = new ArrayList<Card>();
		
	}
	
	public void createFullDeck() {
		//Generating the cards
		for(Suit cardSuit : Suit.values()) {
			for(Value cardValue : Value.values()) {
				//Adding new cards into the shuffle
				this.cards.add(new Card(cardSuit,cardValue));
				
		}
	  }
	}
	//Temporary Deck
	public void shuffle() {
		ArrayList <Card> tmpDeck = new ArrayList <Card> ();
        //Random use of functions to shuffle the deck
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size ();
       for (int i = 0; i <originalSize; i ++) {
    	   //Generating the Random Index
    	   randomCardIndex = random.nextInt((this.cards.size()-1 -0) + 1) + 0;
    	   tmpDeck.add(this.cards.get(randomCardIndex));
    	   //Remove from the original deck
    	   this.cards.remove(randomCardIndex);
       }
       
       this.cards = tmpDeck;
	}
	
	//Method for printing the String
	public String toString() {
		String cardListOutput = "";
		for(Card aCard : this.cards) {
			cardListOutput += "\n " + aCard.toString(); 
			
		}
		return cardListOutput; 
		
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
		
	} 
	
	public Card getCard(int i){
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard){
		this.cards.add(addCard);
	}
	
	//Drawing from the deck
	public void draw(Deck comingFrom) {
		this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
	}
	public int deckSize(){
        return this.cards.size();
    }
	
	public void moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();
        
        //Put Cards into moveTo deck
        for(int i=0; i < thisDeckSize; i++){
            moveTo.addCard(this.getCard(i));
        }
       
        for(int i=0; i < thisDeckSize; i++){
            this.removeCard(0); 
        }
	}
	
	//Returning the total value of cards in the deck
	public int cardsValue() {
		int totalValue = 0;
		int aces = 0; 
		
		for(Card aCard : this.cards) {
			switch(aCard.getValue()) {
			   
			case TWO: totalValue += 2; break;
            case THREE: totalValue += 3; break;
            case FOUR: totalValue += 4; break;
            case FIVE: totalValue += 5; break;
            case SIX: totalValue += 6; break;
            case SEVEN: totalValue += 7; break;
            case EIGHT: totalValue += 8; break;
            case NINE: totalValue += 9; break;
            case TEN: totalValue += 10; break;
            case JACK: totalValue += 10; break;
            case QUEEN: totalValue += 10; break;
            case KING: totalValue += 10; break;
            case ACE: totalValue += 1; break; 
			
			}
		}
		
		for(int i = 0; i < aces; i++) {
			 if(totalValue > 10){
				 totalValue += 1; 
			 }
			 else {
				 totalValue += 11;
			 }
			
		}
		
		return totalValue;
	}
	
	
}

