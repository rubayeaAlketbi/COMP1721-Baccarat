import java.util.Scanner;

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

  // Enum for the user input
  public enum YES {
    YES, Y, y, yes
  };

  public enum NO {
    NO, N, n, no
  };

  // Initialize the game by creating hands and initializing the shoes assuming
  // that the game is non interactive
  public static void initializeGame() {
    playerHand = new BaccaratHand();
    bankerHand = new BaccaratHand();
    baccaratShoe = new Shoe(6);
  }

  // Method which is used to clear hand on start every round of Baccarat
  public static void cleanHands() {
    rounds++;
    if (!playerHand.isEmpty() || !bankerHand.isEmpty()) {
      playerHand.discard();
      bankerHand.discard();
    }
  }

  // Method which deals a card to the player and the banker
  public static void dealCards() {
    baccaratShoe.shuffle();
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());
    playerHand.add(baccaratShoe.deal());
    bankerHand.add(baccaratShoe.deal());
  }

  // Method which displays the content of the card and the value of the hand 
  public static void displayCard() {
    System.out.println("Round " + rounds);
    System.out.println("Player hand: " + playerHand.toString() + " = " + playerHand.value());
    System.out.println("Banker hand: " + bankerHand.toString() + " = " + bankerHand.value());
  }

  // Method which checks if one of the hands has a natural hand
  public static int checkNatural() {
    if (playerHand.isNatural() && !bankerHand.isNatural()) {
      return 1;
    } else if (bankerHand.isNatural() && !playerHand.isNatural()) {
      return 2;
    } else if (playerHand.isNatural() && bankerHand.isNatural()) {
      return 3;
    } else {
      return 0;
    }
  }

  // Method which check if the player is eligible for a third card
  public static int checkPlayerThirdCard() {
    if (playerHand.value() <= 5) {
      return 1;
    } else {
      return 0;
    }
  }

  // Method which check if the banker is eligible for a third card
  public static int checkBankerThirdCard() {
    int playerThirdCard = checkPlayerThirdCard();
    if (playerThirdCard == 0) {
      if (bankerHand.value() <= 5) {
        return 2;
      } else {
        return 0;
      }
    } else {
      if (bankerHand.value() <= 2) {
        return 2;
      } else if (bankerHand.value() == 3 && playerHand.value() != 8) {
        return 2;
      } else if (bankerHand.value() == 4 && playerHand.value() >= 2 && playerHand.value() <= 7) {
        return 2;
      } else if (bankerHand.value() == 5 && playerHand.value() >= 4 && playerHand.value() <= 7) {
        return 2;
      } else if (bankerHand.value() == 6 && playerHand.value() >= 6 && playerHand.value() <= 7) {
        return 2;
      } else {
        return 0;
      }
    }
  }

  // Method which deals the third card to the player 
  public static void playerThirdCard() {
    int naturalHand = checkNatural();
    int thirdCardCondition = checkPlayerThirdCard();

    if (naturalHand == 0 && thirdCardCondition == 1 && playerHand.size() <= 3) {
      System.out.println("Dealing third card to player...");
      playerHand.add(baccaratShoe.deal());
      System.out.println("Player hand: " + playerHand.toString() + " = " + playerHand.value());
      System.out.println("Banker hand: " + bankerHand.toString() + " = " + bankerHand.value());
    }
  }
  // Method which deals the third card to the banker 
  public static void bankerThirdCard() {
    int naturalHand = checkNatural();
    int thirdCardCondition = checkBankerThirdCard();

    if (naturalHand == 0 && thirdCardCondition == 2 && bankerHand.size() <= 3) {
      System.out.println("Dealing third card to banker...");
      bankerHand.add(baccaratShoe.deal());
      System.out.println("Player hand: " + playerHand.toString() + " = " + playerHand.value());
      System.out.println("Banker hand: " + bankerHand.toString() + " = " + bankerHand.value());
    }
  }

  // Method which deals the third card to the player and the banker
  public static void dealThirdCard() {
    playerThirdCard();
    bankerThirdCard();
  }

  // Method which determines the winner of the round
  public static void determineWinner() {
    int naturalHand = checkNatural();
    if (naturalHand == 1) {
      System.out.println("Player has a natural hand");
      System.out.println("Player wins");
      playerWin++;
    } else if (naturalHand == 2) {
      System.out.println("Banker has a natural hand");
      System.out.println("Banker wins");
      bankerWin++;
    } else if (naturalHand == 3) {
      if (bankerHand.value() == playerHand.value()) {
        System.out.println("Tie");
        tie++;
      } else if (bankerHand.value() > playerHand.value()) {
        System.out.println("Banker wins!");
        bankerWin++;
      } else {
        System.out.println("Player wins!");
        playerWin++;
      }
    } else if (bankerHand.value() == playerHand.value()) {
      System.out.println("Tie");
      tie++;
    } else if (bankerHand.value() > playerHand.value()) {
      System.out.println("Banker wins!");
      bankerWin++;
    } else {
      System.out.println("Player wins!");
      playerWin++;
    }
  }

  // Method which displays the number of rounds played, the number of wins for the
  // player, the number of wins for the banker and the number of ties
  public static void displayLog() {
    System.out.println(rounds + " rounds played");
    System.out.println(playerWin + " player wins");
    System.out.println(bankerWin + " banker wins");
    System.out.println(tie + " ties");
  }

  // Method which asks for the user input , if the user input starts with Y or y
  // then the game continues by returning one
  // else the game stops by returning zero
  public static int nextRound() {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Another round? (y/n): ");
    String userAnswer = userInput.next();
    // Take the first character of the user input
    char firstChar = userAnswer.toUpperCase().charAt(0);
    if (firstChar == 'Y') {
      return 1;
    } else if (firstChar == 'N') {
      return 0;
    } else {
      return 0;
    }
  }

  // Method which check the cmd line arguments
  public static int checkCmdLineArgs(String[] args) {
    if (args.length == 0) {
      return 0;
    } else if (args.length == 1) {
      if (args[0].equals("-i")) {
        return 1;
      } else if (args[0].equals("--interactive")) {
        return 1;
      } else {
        return 0;
      }
    } else {
      return 0;
    }
  }

  // Method which plays the game in non-interactive mode
  public static void playNonInteractiveGame() {
    initializeGame();
    // The game continues until there is at least 6 cards left in the shoe
    do {
      cleanHands();
      dealCards();
      displayCard();
      dealThirdCard();
      determineWinner();
      System.out.println("");
    } while (baccaratShoe.size() >= 6);
    displayLog();
  }

  // Method which plays the game in interactive mode
  public static void playInteractiveGame() {
    int playNextRound = 1;
    initializeGame();
    // The game continues until there is at least 6 cards left in the shoe or the
    // user wants to stop playing
    do {
      if (playNextRound == 1) {
        cleanHands();
        dealCards();
        displayCard();
        dealThirdCard();
        determineWinner();
        playNextRound = nextRound();
        System.out.println("");
      } else if (playNextRound == 0) {
        break;
      }
    } while (baccaratShoe.size() >= 6);
    displayLog();
  }

  public static void main(String[] args) {
    // Check the cmd line arguments
    int cmdLineArgs = checkCmdLineArgs(args);
    // If the user wants to play in interactive mode\
    if (cmdLineArgs == 1) {
      playInteractiveGame();
    } else {
      playNonInteractiveGame();
    }
  }

}
