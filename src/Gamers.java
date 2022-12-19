import java.util.Random;

public class Gamers {
    private String name;
    private String[] cards;
    private int point;

    // CONSTRUCTIOR//

    public Gamers(String NAME, String[] CARDS, int POINT){
        setName(NAME);
        setCards(CARDS);
        setPoint(POINT);
    }

    // GETTER-SETTER //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    // METHODS //

    public String[] mixDeck(String[] deck){
        Random rd = new Random();
//        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        While this class was created, this array was used as example

        String[] mixedDeck = new String[deck.length];
        int i = 0;
        while (i < deck.length){
            int new_index = rd.nextInt(deck.length);
            if(mixedDeck[new_index] == null){ // if the index is not null do not put anything here
                mixedDeck[new_index] = deck[i];
                i++; // Each index fulled i increases and when i became deck.length - 1 the looped is finished
            }
        }
        return mixedDeck; // it returns current deck
    }

    public String[] cutDeck(String[] deck, int x){
        String[] firstPart = new String[x]; // first part before cutted
        String[] secondPart = new String[deck.length - x]; // second part before cutted
        String[] cuttedDeck = new String[deck.length]; // current deck after cutted

        for (int i = 0 ; i < x ; i ++){ // first part is fulled to firstPart array
            firstPart[i] = deck[i];
        }
        for (int i = 0 ; i < deck.length - x ; i++) { // second part is fulled to secondPart array
            secondPart[i] = deck[i + x];
        }
        for (int i = 0 ; i < x ; i ++) { // first part is fulled to cuttedDeck array
            cuttedDeck[i + secondPart.length] = firstPart[i];
        }
        for (int i = 0 ; i < deck.length - x ; i ++){ // second part is fulled to cuttedDeck array
            cuttedDeck[i] = secondPart[i];
        }
        return cuttedDeck; // it returns current deck

    }

    public void separateCards(String[] gamer1, String[] gamer2 , String[] deck){
        // The cards are dealt to a first player and dealt to a second player until the hands are full.
        gamer1[0] = deck[0];
        gamer2[0] = deck[1];
        gamer1[1] = deck[2];
        gamer2[1] = deck[3];
        gamer1[2] = deck[4];
        gamer2[2] = deck[5];
        gamer1[3] = deck[6];
        gamer2[3] = deck[7];

    }

    public String[] putCards_toBoard(String[] deck){
        String[] cardsOnBoard = new String[4];

        for (int i = 0 ; i < 4 ; i ++){
            cardsOnBoard[i] = deck[i + 8];
            // because we separate cards to players before this method firs 8 index will be null
        }
        return cardsOnBoard; // it returns current deck
    }

    public String showFirstCard(String[] puttedCards_toBoard){
        return puttedCards_toBoard[0]; // in the game first card of cards that on the board is shown.
    }

    public String[] UpdateCurrentCards(String[] deck){ // this method updates the deck after cards are separated.
        int amountOfCurrentCards ;

        if (deck.length < 8){
            amountOfCurrentCards = deck.length;
        } else {
            amountOfCurrentCards = deck.length - 8;
        }
        String[] CurrentCards = new String[amountOfCurrentCards];

        for (int i = 0 ; i < deck.length - 9 ; i ++){
            CurrentCards[i] = deck[9 + i];
        }

        return CurrentCards;
    }

    public void showHand(String[] hand){ // it shows cards that are on the hand of player
        for (int i = 0 ; i < hand.length ; i ++){
            System.out.println(hand[i]);
        }
    }

    public boolean isSame(String cardHand , String card_on_board){
        if (card_on_board == null || cardHand == null){
            return false;
        } else {

            return (cardHand.charAt(1) + "").equals(card_on_board.charAt(1) + "");
        }

    }
}
