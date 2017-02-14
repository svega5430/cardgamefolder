/**
 * A standard playing card.
 */
public class Card {
	
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    private final int rank;

    private final int suit;

    /**
     * Constructs a card of the given rank and suit.
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns a negative integer if this card comes before
     * the given card, zero if the two cards are equal, or
     * a positive integer if this card comes after the card.
     */
    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank==1&&that.rank!=1){
        	return 1;
        }
        if (that.rank==1&&this.rank!=1){
        	return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    /**
     * Returns true if the given card has the same
     * rank AND same suit; otherwise returns false.
     */
    public boolean equals(Card that) {
        return this.rank == that.rank
            && this.suit == that.suit;
    }

    /**
     * Gets the card's rank.
     */
    public int getRank() {
        return this.rank;
    }

    /**
     * Gets the card's suit.
     */
    public int getSuit() {
        return this.suit;
    }

    /**
     * Returns the card's index in a sorted deck of 52 cards.
     */
    public int position() {
        return this.suit * 13 + this.rank - 1;
    }

    /**
     * Returns a string representation of the card.
     */
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
    public static Card[] makeDeck(){
    	Card[] deck = new Card[52];
    	for(int k = 0; k <=3; k++){
    		for(int i = 1; i<=13;i++){
    			deck[((k*13)+i)-1] = new Card(i,k);
    		}
    	}
		return deck;
    	
    }
    public static int[] suitHist(Card[]i){
		int clubs = 0;
		int diamonds = 0;
		int spades = 0;
		int hearts = 0;
		int[] histagram = new int[4];
		for(int a = 0; a<i.length; a++){
			if(i[a].getSuit() == 0){
				clubs++;
			}
			if(i[a].getSuit() == 1){
				diamonds++;
			}
			if(i[a].getSuit() == 2){
				spades++;
			}
			if(i[a].getSuit() == 3){
				hearts++;
			}
		}
    	histagram[0] = clubs;
    	histagram[1] = diamonds;
    	histagram[2] = spades;
    	histagram[3] = hearts;
    	return histagram;
    	
    }
    public static Boolean hasFlush(Card[] i){
		int[] histagram = suitHist(i);
		for(int b = 0; b <=3; b++){
			if(histagram[b]>=5){
				return true;
			}
		}
    	return false;
    }

}