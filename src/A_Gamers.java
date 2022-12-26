import java.util.Random;

public class A_Gamers {
    private String name;
    private String[] cards;
    private int point;
    private int Amount_card_taken;
    private String[] cardstaken_from_board;


    // CONSTRUCTIOR//
    public A_Gamers(String NAME, String[] CARDS, int POINT, int AMOUNTCARDTAKEN, String[]  Cardstaken_from_board) {
        setName(NAME);
        setCards(CARDS);
        setPoint(POINT);
        setAmount_card_taken(AMOUNTCARDTAKEN);
        setCards_taken_from_board(Cardstaken_from_board);
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

    public int getAmount_card_taken() {
        return Amount_card_taken;
    }

    public void setAmount_card_taken(int amount_card_taken) {
        Amount_card_taken = amount_card_taken;
    }

    public void setCards_taken_from_board(String[] cards_taken_from_board) {
        cardstaken_from_board = cards_taken_from_board;
    }
    public String[] getCards_taken_from_board() {
        return cardstaken_from_board;
    }

    // METHODS //
    public String[] mixDeck(String[] deck) {
        Random rd = new Random();
//        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        While this class was created, this array was used as example

        String[] mixedDeck = new String[deck.length];
        int i = 0;
        while (i < deck.length) {
            int new_index = rd.nextInt(deck.length);
            if (mixedDeck[new_index] == null) { // if the index is not null do not put anything here
                mixedDeck[new_index] = deck[i];
                i++; // Each index fulled i increases and when i became deck.length - 1 the looped is finished
            }
        }
        return mixedDeck; // it returns current deck
    }

    public String[] cutDeck(String[] deck, int x) {
        String[] firstPart = new String[x]; // first part before cutted
        String[] secondPart = new String[deck.length - x]; // second part before cutted
        String[] cuttedDeck = new String[deck.length]; // current deck after cutted

        for (int i = 0; i < x; i++) { // first part is fulled to firstPart array
            firstPart[i] = deck[i];
        }
        for (int i = 0; i < deck.length - x; i++) { // second part is fulled to secondPart array
            secondPart[i] = deck[i + x];
        }
        for (int i = 0; i < x; i++) { // first part is fulled to cuttedDeck array
            cuttedDeck[i + secondPart.length] = firstPart[i];
        }
        for (int i = 0; i < deck.length - x; i++) { // second part is fulled to cuttedDeck array
            cuttedDeck[i] = secondPart[i];
        }
        return cuttedDeck; // it returns current deck

    }

    public void separateCards(String[] gamer1, String[] gamer2, String[] deck) {
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

    public String[] putCards_toBoard(String[] deck) {
        String[] cardsOnBoard = new String[4];

        for (int i = 0; i < 4; i++) {
            cardsOnBoard[i] = deck[i + 8];
            // because we separate cards to players before this method firs 8 index will be null
        }
        return cardsOnBoard; // it returns current deck
    }

    public String showFirstCard(String[] puttedCards_toBoard) {
        return puttedCards_toBoard[0]; // in the game first card of cards that on the board is shown.
    }
//    public void showboard(String[] new_array){
//        for (int i = 0 ; i < new_array.length; i++){
//            if (new_array[i] == null){
//                break;
//            }
//            System.out.print(new_array[i] + " ");
//        }
//    }
//    public String[] updateBoard(String[] array, String choosen_card){
//        String[] new_array = new String[52];
//        if (choosen_card == null){
//            for (int i = 0; i < array.length; i++) {
//                new_array[i] = null;
//            }
//            System.out.println("     ");
//
//        } else {
//            for (int i = 0; i < array.length; i++) {
//                if (array[i] == null) {
//                    break;
//                }
//                new_array[i + 1] = array[i];
//            }
//            new_array[0] = choosen_card;
//
//        }
//        return new_array;
//
//    }

    public String[] UpdateCurrentCards(String[] deck) { // this method updates the deck after cards are separated.
        int amountOfCurrentCards;

        if (deck.length < 8) {
            amountOfCurrentCards = deck.length;
        } else {
            amountOfCurrentCards = deck.length - 8;
        }
        String[] CurrentCards = new String[amountOfCurrentCards];

        for (int i = 0; i < deck.length - 8; i++) {
            CurrentCards[i] = deck[8 + i];
        }

        return CurrentCards;
    }

    public String[] UpdateCurrentCardsBeforeStart(String[] deck) { // this method updates the deck after cards are separated.
        int amountOfCurrentCards = deck.length - 12;

        String[] CurrentCards = new String[amountOfCurrentCards];

        for (int i = 0; i < deck.length - 12; i++) {
            CurrentCards[i] = deck[12 + i];
        }

        return CurrentCards;
    }

    public void showHand(String[] hand) { // it shows cards that are on the hand of player
        for (int i = 0; i < hand.length; i++) {
            System.out.print(hand[i] + " ");
        }
        System.out.println();
    }




//    public boolean isSame(String cardHand, String card_on_board) {
//        if (card_on_board == null || cardHand == null) {
//            return false;
//        } else if ((cardHand.charAt(1) + "").equals("J" + "")){
//            return true;
//        } else if (cardHand.length() == 3 && card_on_board.length() == 3){
//            return (cardHand.charAt(1) + cardHand.charAt(2) + "").equals(card_on_board.charAt(1) + card_on_board.charAt(2) + "");
//        } else if (cardHand.length() == 2 && card_on_board.length() == 2){
//            return (cardHand.charAt(1) + "").equals(card_on_board.charAt(1) + "");
//        } else {
//            return false;
//        }
//
//    }
}


