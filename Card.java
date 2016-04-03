/**
 * Created by patricklai on 2015-11-19.
 */
public class Card {
    private Suit suit;
    private Value value;
    public Card(Suit theSuit, Value theValue){
        this.suit = theSuit;
        this.value = theValue;
    }
    public Suit getSuit(){
        return suit;
    }
    public Value getValue(){
        return value;
    }
//    public void setValue(Value newValue){
//        value = newValue;
//    }
    public String toString() {
        return getValue() + " of " + getSuit();
    }
    public static void main(String [] args){
    }
}
