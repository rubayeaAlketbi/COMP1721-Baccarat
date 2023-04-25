// TODO: Implement the BaccaratCard class in this file

public class BaccaratCard extends Card {
    // Method to create a baccarat card
    public BaccaratCard(Card.Rank rank, Card.Suit suit) {
        super(rank, suit);
    }

    // Method to get the rank of the card
    public Card.Rank getRank() {
        return super.getRank();
    }

    // Method to get the suit of the card
    public Card.Suit getSuit() {
        return super.getSuit();
    }

    // Method to get the string representation of the card
    public String toString() {
        return super.toString();
    }

    // Method to check if the object is equal
    public boolean equals(Object other) {
        return super.equals(other);
    }

    // Method to compare the baccarat card to the card
    public int compareTo(Card other) {
        return super.compareTo(other);
    }

    // Method to return the value of the card
    @Override
    public int value() {
        // The face cards (Jack, Queen, King) & 10 are worth zero points.
        if (super.getRank() == Card.Rank.JACK
                || super.getRank() == Card.Rank.QUEEN
                || super.getRank() == Card.Rank.KING
                || super.getRank() == Card.Rank.TEN) {
            return 0;
        } else {
            // The other card worth their face value.
            return super.getRank().ordinal() + 1;
        }
    }
}