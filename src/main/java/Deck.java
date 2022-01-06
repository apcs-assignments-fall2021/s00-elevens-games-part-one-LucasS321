import java.util.ArrayList;

// The Deck class represents a shuffled deck of cards.
// It provides several operations including
// initialize, shuffle, deal, and check if empty.
public class Deck {
	// cards is an ArrayList of all the Card objects in our deck
	private ArrayList<Card> cardsList;

	// size is the number of not-yet-dealt cards.
	// Cards are dealt from the top (highest index) down.
	// The next card to be dealt is at size - 1.
	private int size;

	// Creates a new Deck instance given arrays of ranks, suits, and values
	// You will need to initialize both the cardsList and size instance variables
	// You should go through and make all possible pairs of suits and ranks
	public Deck(String[] ranks, String[] suits, int[] values) {
		cardsList = new ArrayList<Card>();
		for(String x: suits) {
			for (int y = 0; y < ranks.length; y++) {
				cardsList.add(new Card(ranks[y],x,values[y]));
			}
		}
		size = cardsList.size();
		// YOUR CODE HERE
		// // Remember, in a constructor you need to first create the ArrayList for the instance variable!
	}
	// Deals a card from this deck.
	// return the card just dealt, or null if all the cards have been dealt already
	// Recall that the cards are dealt from top (highest-index) down
	// Updates the size as well
	public Card deal() {
		// YOUR CODE HERE
		if (size != 0) {
			Card card = cardsList.get(size - 1);
			size -= 1;
			return card;
		} else {
			return null;
		}
	}

	// Determines if this deck is empty (there are no undealt cards).
	// returns true if this deck is empty, false otherwise.
	public boolean isEmpty() {
		// YOUR CODE HERE
		return size == 0;
	}

	// Returns the size (number of undealt cards) in this deck.
	public int getSize() {
		// YOUR CODE HERE
		return size;
	}

	// Shuffles the deck by repeatedly randomly swapping pairs of cards
	// This method should change the order of the cards in cardsList
	// Shuffling should also reset the size variable to its original value
	public void shuffle() {
		ArrayList<Card> cardsList2 = new ArrayList<Card>();
		for (Card x: cardsList) {
			cardsList2.add((int) (Math.random()*(cardsList2.size())), x);
		}
		cardsList = cardsList2;
		size = cardsList.size();
		// YOUR CODE HERE
	}

	// OPTIONAL: Write code that carries out a "perfect" shuffle
	// that perfectly interweaves the two halves of the deck
	public void perfectShuffle() {
		// YOUR CODE HERE
	}








	// CODE BELOW HERE IS ALREADY WRITTEN:

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		if (cardsList == null) {
			return "";
		}

		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cardsList.size() - 1; k >= size; k--) {
			rtn = rtn + cardsList.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cardsList.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}

	// Returns the card at the given index of the deck
	// This method should only be used in testing code
	public Card getCardAtIndex(int idx) {
		return cardsList.get(idx);
	}

	// This version of equals() is used in the testing code
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		else {
			return cardsList.equals(((Deck) o).cardsList);
		}
	}
}
