import java.util.Collection;

public class Baccarat {
  // TODO: Implement your Baccarat simulation program here
  /* 
   Basic Main Prgoram ( a single round of Baccarat)
    Step 1 : Create a shoe with 6 decks --done--
    Step 2 : Shuffle the shoe
    Step 3 : Create two baccarat hands for the player and the banker --done--
    Step 4 : Deal a card to the player and then the banker until both have two cards
    Step 5: Display the content of the card and the value of the hand
    Step 6 : Inform whether one of them has a natural hand.
  */

  // Create a shoe of 6 decks
  private static Shoe baccaratShoe = new Shoe(6);

  // Create the two hands for the player and the banker
  private static BaccaratHand playerHand = new BaccaratHand();
  private static BaccaratHand bankerHand = new BaccaratHand();

  // Create a main method 
  public static void main(String[] args) {
    // Step 2 : Shuffle the shoe
    baccaratShoe.shuffle();

    // Step 4 : Deal a card to the player and then the banker until both have two cards
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());

    // Step 5: Display the content of the card and the value of the hand
    System.out.println("Player hand: " + playerHand.toString() + " (" + playerHand.value() + ")");
    System.out.println("Banker hand: " + bankerHand.toString() + " (" + bankerHand.value() + ")");

    // Step 6 : Inform whether one of them has a natural hand.
    if(playerHand.isNatural()){
      System.out.println("Player has a natural hand");
    } else if(bankerHand.isNatural()){
      System.out.println("Banker has a natural hand");
    } else{
      System.out.println("No natural hand");
    }
  }


  


}
