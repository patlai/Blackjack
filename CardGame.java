import java.util.ArrayList;

/**
 * Created by patricklai on 2015-11-19.
 */
public class CardGame {
    public static void main(String[] args) {
        //make a randomized deck of 52 cards
        CardPile startingDeck = CardPile.makeFullDeck();
        ArrayList<Card> cards = startingDeck.getCards();
        //take as command line input the number of players
        int numPlayers = Integer.parseInt(args[0]);
        //0 = top, 51 = bottom of deck
        CardPile[] playerPiles = new CardPile[numPlayers];
        for (int x = 0; x < numPlayers; x++){
            playerPiles[x] = new CardPile();
        }
        int y = 0;
        //run loop until original deck is empty
        while (y < 420) {
            if(cards.get(0) == null){
                break;
            }
            playerPiles[y].addToBottom(cards.get(0));
            startingDeck.remove(0);
             if(y < numPlayers - 1){
                y++;
            } else {
                y = 0;
            }
        }
        for (int q = 0; q < numPlayers; q++){
            System.out.println("Player " + (q+1) + ": " + playerPiles[q].toString());
        }
        for (int z = 0; z < numPlayers; z++){

            for(int i = 0; i< playerPiles[z].getNum(); i++){
                if(playerPiles[z].get(i).getSuit() == Suit.SPADES && playerPiles[z].get(i).getValue() == Value.ACE){
                    System.out.println("Player " + (z+1) + " has the Ace of Spades and therefore wins the game.");
                }
            }
        }
    }
}
