package enumeration;

import java.util.*;

enum Suit {
	 HEARTS, SPADES, DIAMONDS, CLUBS
	}
	enum Value {
	 ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
	 EIGHT, NINE, TEN, JACK, QUEEN, KING
	}
	class Card {
	 public Suit suit;
	 public Value value;

	 public Card(Suit suit, Value value) {
	 this.suit = suit;
	 this.value = value;
	 }
	 public String toString() {
		 return value + " of " + suit;
		 }
	}
	class Deck {
		 public Card deck[][];
		 public static final int numsuits = Suit.values().length;
		 public static final int numvalues =Value.values().length;
		 public Deck() {
		 deck = new Card[numsuits][numvalues];
		 Suit suits[] = Suit.values();
		 Value values[] = Value.values();
		 for (int s = 0; s < numsuits; s++) {
		 Suit suit = suits[s];
		 for (int t = 0; t < numvalues; t++) {
		 Value value = values[t];
		 deck[s][t] = new Card(suit, value);
		 }
		 }
		 }

		 public Card drawrandomcard() {
		 Random random = new Random();
		 int randoms = random.nextInt(numsuits);
		 System.out.println();
		 int randomt = random.nextInt(numvalues);
		 return deck[randoms][randomt];
		 }
		}
public class Enumexample {
	 public static void main(String[] args) {
		 Deck deck = new Deck();
		 boolean l=true;
		 while(l) {		 
		 System.out.println("press 1 for selection of random card\n");
		 System.out.println("press 0 for exit()");
		 Scanner s=new Scanner(System.in);
		 int i=s.nextInt();
		 if(i==1) {
		 Card randomcard = deck.drawrandomcard();
		 System.out.println(randomcard);
		 System.out.println();
		 l=true;
		 }
		 else if(i==0)
			 l=false;
		 else
			 System.out.println("please enter either 1 or 0");
		 } 
	
		 }

}
