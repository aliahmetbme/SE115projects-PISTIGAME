import java.util.Scanner;

public class cardseparatetest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gamers dealer = new Gamers("name",new String[4] ,0, 0,new String[52]);
        Gamers computer = new Gamers("Computer" , new  String[4] ,0,0, new String[52]);

        String[] deck = {"#1","#2","#3","#4","#5","#6","#7","#8","#9","#10","#11","#12","#13",
                "$1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12","$13",
                "%1","%2","%3","%4","%5","%6","%7","%8","%9","%10","%11","%12","%13",
                "&1","&2","&3","&4","&5","&6","&7","&8","&9","&10","&11","&12","&13"};

        String[] dealersHand = {null,"#2","#3","#4"};
        String[] computerHand = computer.getCards();

//        // Players' Points
//        int dealersPoint = dealer.getPoint();
//        int computerPoint = computer.getPoint();
//
//        System.out.println("lenght before first dağıtım " + deck.length);
//        // dealer separates cards
//        dealer.separateCards(dealersHand,computerHand,deck);
//        System.out.println("lenght before first dağıtım " + deck.length);
//
//        // after separating cards 4 cards are putted to board
//        String[] cardsOnBoard = dealer.putCards_toBoard(deck);
//        System.out.println("lenght before first dağıtım " + deck.length);
//
//        // first card on the board
//        String FirstCard = dealer.showFirstCard(cardsOnBoard);
//
//        // First card on the Board
//        //System.out.println(FirstCard);
//        deck = dealer.UpdateCurrentCardsBeforeStart(deck);
//
//        System.out.println("lenght after first dağıtım " + deck.length);
//
//        int tur = 1;
//
//        while (deck.length >4){
//
//            dealer.separateCards(dealersHand,computerHand,deck); // cards are separated
//            System.out.println("lenght  " + tur + ".tur " + deck.length);
//            tur ++ ;
//            System.out.println("card separated");
//
//            System.out.println("alis hand");
//            for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                System.out.println(dealersHand[i]);
//            }
//            System.out.println("Computers hand");
//            for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                System.out.println(computerHand[i]);
//            }
//            deck = dealer.UpdateCurrentCards(deck);
//            System.out.println("deck");
//            if (deck.length == 0){
//                System.out.println("yes bitti" );
//                break;
//            }
//            for (int i = 0 ; i < deck.length ; i ++ ){
//                System.out.println(deck[i]);
//            }
//        }
//        dealer.separateCards(dealersHand,computerHand,deck);
//        System.out.println("alis hand");
//        for (int i = 0 ; i < dealersHand.length ; i ++ ){
//            System.out.println(dealersHand[i]);
//        }
//        System.out.println("Computers hand");
//        for (int i = 0 ; i < dealersHand.length ; i ++ ){
//            System.out.println(computerHand[i]);
//        }
        String chosenCard = scan.nextLine(); // Gamer chooses card
        boolean chosenCard_not_exist = true;

        // this loop checks that is chosen card available in the hand or not
        for (int i = 0 ; i < dealersHand.length ; i ++){
            // if card is available in the hand statement will be false and do not go if statement
            if (dealersHand[i] == null) {
                // 9 10 11 12
                // 10
                continue;
            } else if (dealersHand[i].equals(chosenCard)) {
                chosenCard_not_exist = false;
                break;
            }
        }
        // if it still true the card is not available on the hand
        if (chosenCard_not_exist){
            System.out.println("You did not choose correct card");
            // the game will be finish
            // new method can be developed
            //break;
        }














    }
}
