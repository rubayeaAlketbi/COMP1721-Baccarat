
public class Baccarat {
  // TODO: Implement your Baccarat simulation program here

  // Create the two hands for the player and the banker
  private static BaccaratHand playerHand;
  private static BaccaratHand bankerHand;

  // Create a baccarat Shoes
  private static Shoe baccaratShoe;

  // Create a log which will record the cards that are dealt and the winning log
  // of each round
  private static int rounds = 0;
  private static int playerWin = 0;
  private static int bankerWin = 0;
  private static int tie = 0;
  private static int cardsLeft = baccaratShoe.size();

  // Initialize the game by creating hands and initializing the shoes assuming
  // that the game is non interactive
  public static void initializeGame() {
    playerHand = new BaccaratHand();
    bankerHand = new BaccaratHand();
    baccaratShoe = new Shoe(6);
  }

  // Create a method which is used to clear hand on start every round of Baccarat
  public static void cleanHands() {
    rounds++;
    if (!playerHand.isEmpty()) {
      playerHand.discard();
    } else if (!bankerHand.isEmpty()) {
      bankerHand.discard();
    }
  }

  // Method which deals a card to the player and the banker starting from the
  // player
  public static void dealCards() {
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());
  }

  // Method which displays the content of the card and the value of the hand ans
  // store the values of hand
  public static void displayCard() {
    System.out.println("Round " + rounds);
    System.out.println("Player hand: " + playerHand.toString() + "=" + playerHand.value());
    System.out.println("Banker hand: " + bankerHand.toString() + "=" + bankerHand.value());
  }

  // Method which checks if one of the hands has a natural hand
  // Returns 1 if the player has a natural hand and 2 if the banker has a natural
  // and if both have a natural hand then it returns 3
  public static int checkNatural() {
    if ((playerHand.isNatural()) && (!bankerHand.isNatural())) {
      System.out.println("Player has a natural hand");
      return 1;
    } else if ((bankerHand.isNatural()) && (!playerHand.isNatural())) {
      System.out.println("Banker has a natural hand");
      return 2;
    } else if ((playerHand.isNatural()) && (bankerHand.isNatural())) {
      return 3;
    } else {
      return 0;
    }
  }

  // Method which check if the player is eligible for a third card
  // Returns 1 if the player is eligible for a third card and 0 if the player is
  // not eligible for a third card
  public static int checkPlayerThirdCard() {
    if (playerHand.value() <= 5) {
      return 1;
    } else {
      return 0;
    }
  }

  // Method which check if the banker is eligible for a third card
  // Returns 2 if the banker is eligible for a third card and 0 if the banker is
  // not eligible for a third card
  public static int checkBankerThirdCard() {
    // The banker will follow the condition of the player if the player is not
    // eligible for the third card
    int playerThirdCard = checkPlayerThirdCard();
    if (playerThirdCard == 0) {
      // if the banker value is less than five then deal thrid card else return 0
      if (bankerHand.value() <= 5) {
        return 2;
      } else {
        return 0;
      }
    } else {
      // if the player value is less than 6 and the banker value is less than 6 then
      // deal third card else return 0
      if (bankerHand.value() <= 2) {
        return 2;
      } else if ((bankerHand.value() == 3) && (playerHand.value() != 8)) {
        return 2;
      } else if (((bankerHand.value() == 4)) && ((playerHand.value() >= 2) && (playerHand.value() <= 7))) {
        return 2;
      } else if (((bankerHand.value() == 5)) && ((playerHand.value() >= 4) && (playerHand.value() <= 7))) {
        return 2;
      } else if (((bankerHand.value() == 6)) && ((playerHand.value() >= 6) && (playerHand.value() <= 7))) {
        return 2;
      } else {
        return 0;
      }
    }
  }

  // Method which deals the third card to the player and the banker
  public static void dealThirdCard(){
    // The third card condition starts with the following condition : NO NATURAL HAND
    int naturalHand = checkNatural();
    int playerThirdCard = checkPlayerThirdCard();
    int bankerThirdCard = checkBankerThirdCard();

    if(naturalHand == 0){
      if(playerThirdCard == 1){
        System.out.println("Dealing third card to player...");
        playerHand.add(baccaratShoe.deal());
        System.out.println("Player hand: " + playerHand.toString() + "=" + playerHand.value());
        System.out.println("Banker hand: " + bankerHand.toString() + "=" + bankerHand.value());
      }
      else if(bankerThirdCard == 2){
        System.out.println("Dealing third card to banker...");
        bankerHand.add(baccaratShoe.deal());
        System.out.println("Player hand: " + playerHand.toString() + "=" + playerHand.value());
        System.out.println("Banker hand: " + bankerHand.toString() + "=" + bankerHand.value());
      }
    }
  }

  // Method which determines the winner of the round 
  public static void determineWinner(){
    int naturalHand = checkNatural();
    if(naturalHand == 1){
      System.out.println("Player wins");
      playerWin++;
    }
    else if(naturalHand == 2){
      System.out.println("Banker wins");
      bankerWin++;
    }
    else if(naturalHand == 3){
      if(bankerHand.value() == playerHand.value()){
        System.out.println("Tie");
        tie++;
      } else if (bankerHand.value() > playerHand.value()){
        System.out.println("Banker wins!");
        bankerWin++;
      } else {
        System.out.println("Player wins!");
        playerWin++;
      }
    } else if (bankerHand.value() == playerHand.value()){
      System.out.println("Tie");
      tie++;
    } else if (bankerHand.value() > playerHand.value()){
      System.out.println("Banker wins!");
      bankerWin++;
    } else {
      System.out.println("Player wins!");
      playerWin++;
    }
  }

  public static void main(String[] args) {
    
  }
}
