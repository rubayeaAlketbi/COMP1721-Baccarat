// TODO: Implement the BaccaratHand class in the file

public class BaccaratHand extends CardCollection  {
    //constructor of the baccarat hand
    public BaccaratHand() {
        return;
    }
    //returns the number of cards in the hand
    public int size() {
        return super.size();
    }
    // adding the card to the hand
    public void add(Card card) {
        super.add(card);
        return;
    }
    // returns the value of the hand 
    public int value() {
        return 0;
    }
    // check if the hand is a natural
    public boolean isNatural() {
        return false;
    }
    // returns the string representation of the hand
    public String toString() {
        return null;
    }
}