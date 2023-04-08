import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// TODO: Implement the Shoe class in this file
public class Shoe extends CardCollection{
    // constructor of the shoe 
    protected List <BaccaratCard> decks;

    public Shoe(int numDecks) {
        // check if the number of decks is valid
        if(numDecks  == 6 || numDecks == 8){
            // Create a list of decks
            decks = new LinkedList<BaccaratCard>();
            for(int i = 0; i < numDecks; i++){
                for(Card.Suit cardSuit: Card.Suit.values()){
                    for(Card.Rank cardRank: Card.Rank.values()){
                        decks.add(new BaccaratCard(cardRank, cardSuit));
                    }
                }
            }
        } else{
            throw new CardException("Invalid number of decks");
        }
        return;
    }
    // returns the number of cards in the shoe
    public int size() {
        return decks.size();
    }
    
    public void shuffle() {
        Collections.shuffle(decks);
        return;
    }
    // deal the card 
    public Card deal() {
        if(decks.isEmpty()){
            throw new CardException("No more cards in the shoe");
        }
        return decks.remove(0);
    }
}