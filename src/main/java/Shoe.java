import java.util.LinkedList;
import java.util.List;

// TODO: Implement the Shoe class in this file
public class Shoe extends CardCollection{
    // constructor of the shoe 
    protected List <BaccaratCard> decks;

    public Shoe(int numDecks) {
        int deckIndex = 0;
        if(numDecks == 8 || numDecks == 6){
            // Create a new linked list of cards 
            decks = new LinkedList<>();
            while(deckIndex != numDecks){
                for(Card.Suit s : Card.Suit.values()){
                    for(Card.Rank r : Card.Rank.values()){
                        decks.add(new BaccaratCard(r, s));
                    }
                }
                deckIndex++;
            }
        }else{
            throw new CardException("Invalid number of decks");
        }
    }
    // returns the number of cards in the shoe
    public int size() {
        return 0;
    }
    // shuffles the shoe
    public void shuffle() {
        return;
    }
    // deal the card 
    public Card deal() {
        return null;
    }
}