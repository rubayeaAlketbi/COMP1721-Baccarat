// TODO: Implement the BaccaratHand class in the file

public class BaccaratHand extends CardCollection {
    // constructor of the baccarat hand
    public BaccaratHand() {
        return;
    }

    // returns the number of cards in the hand
    public int size() {
        return super.size();
    }

    // adding the card to the hand
    public void add(Card card) {
        super.add(card);
        return;
    }

    // returns the value of the hand
    @Override
    public int value() {
        int handValue = super.value();
        if (handValue >= 10) {
            handValue = handValue % 10;
        }
        return handValue;
    }
    // check if the hand is a natural

    public boolean isNatural() {
        boolean naturalHand = false;

        if (super.size() == 2 && (super.value() == 8 || super.value() == 9)) {
            naturalHand = true;
        }
        return naturalHand;
    }

    // returns the string representation of the hand
    @Override
    public String toString() {
        String handString = "";

        for (Card card : cards) {
            handString += card.toString() + " ";
        }
        return handString.trim();
    }
}