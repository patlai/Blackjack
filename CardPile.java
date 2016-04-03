/**
 * Created by patricklai on 2015-11-19.
 */
import java.util.ArrayList;
import java.util.Collections;
public class CardPile {
    public static void main(String[] args){
        makeFullDeck();
        makeFullDeck(3);
    }
    //private Card[] cards = new Card[52];
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int numCards = 0;
    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getNum() {
        return numCards;
    }

//constructor for CardPile:
    public CardPile() {
        this.cards = new ArrayList<Card>();
        numCards = 0;
    }

    public void addToBottom(Card c) {
        for (int i = 0; i < 52; i++) {
            if (cards.get(i) == null) {
                //cards[i] = c;
                cards.add(i, c);
                numCards++;
                break;
            }
        }
    }
    public Card get(int i) {
        return cards.get(i);
    }
    public Card remove(int i) {
        cards.remove(i);
        return cards.get(i);
    }
    public boolean isEmpty() {
        return this.numCards == 0;
    }
    public int find(Suit s, Value v) {
        int i;
        int x = -1;
        for (i = 0; i < numCards; i++) {
            if (cards.get(i).getSuit() == s && cards.get(i).getValue() == v) {
                x = i;
                break;
            } else {
                x = -1;
            }
        }
        return x;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i) == null){
                s += i+ ". " + "null ";
            } else {
                s += i + ". "+ cards.get(i).toString() + " ";
            }
        }
        return s;
    }

    public static CardPile makeFullDeck() {
        CardPile fullDeck = new CardPile();
        fullDeck.numCards = 52;
        Suit[] suits = {Suit.SPADES, Suit.DIAMONDS, Suit.HEARTS, Suit.CLUBS};
        Value[] values = {Value.TWO, Value.THREE, Value.FOUR, Value.FIVE, Value.SIX, Value.SEVEN, Value.EIGHT, Value.NINE, Value.TEN, Value.JACK, Value.QUEEN, Value.KING, Value.ACE};
       int x = 0;
        fullDeck.cards = new ArrayList<>();
            // j = suits index, i = values index
            for (int j = 0; j < 4 && x <52; j++) {
                for (int i = 0; i < 13 && x<52; i++) {
                    //fullDeck.cards(i) = new Card(suits[j], values[i]);

                    fullDeck.cards.add(new Card(suits[j], values[i]));
                    x++;
                }
            }
        Collections.shuffle(fullDeck.cards);
            return fullDeck;
    }
    public static CardPile makeFullDeck(int n){
        CardPile fullDecks = new CardPile();
        fullDecks.cards = new ArrayList<>();
        ArrayList<Card> cards = makeFullDeck().getCards();
        for(int i = 0; i < n; i++){
            fullDecks.cards.addAll(52*i, cards);
        }
        Collections.shuffle(fullDecks.cards);
        return fullDecks;
    }
    public int getNumCards() {
        return this.cards.size();
    }
}
