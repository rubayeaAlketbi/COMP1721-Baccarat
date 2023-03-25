// TODO: Implement the BaccaratCard class in this file

public class BaccaratCard extends Card {
    // Baccarat class constructor
    public BaccaratCard(Card.Rank rank, Card.Suit suit) {
        super(rank, suit);
    }

    // returns the rank of the card
    public Card.Rank getRank() {
        return super.getRank();
    }

    // returns the suit of the card
    public Card.Suit getSuit() {
        return super.getSuit();
    }

    // returns a string representation of the card
    public String toString() {
        return super.toString();
    }

    // check if the baccarat card and the card are equal
    public boolean equals(Object other) {
        return super.equals(other);
    }

    // compares the baccarat card to the card
    public int compareTo(Card other) {
        return super.compareTo(other);
    }

    // returns the value of the card
    @Override
    public int value() {
        // The face cards (Jack, Queen, King) & 10 are worth zero points.
        if (super.getRank() == Card.Rank.JACK || super.getRank() == Card.Rank.QUEEN || super.getRank() == Card.Rank.KING
                || super.getRank() == Card.Rank.TEN) {
            return 0;
        } else {
            // The other card worth their face value.
            return super.getRank().ordinal() + 1;
        }

    }
}