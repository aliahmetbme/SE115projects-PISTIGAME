import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        // Classes of Random and Scanner
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();

        // Creating Gamers

        Gamers dealer = new Gamers("name",new String[4] , 0,0);
        Gamers computer = new Gamers("Computer" , new  String[4] ,0,0);

        String[] deck = {"#J","#2","#3","#4","#5","#6","#7","#8","#9","#10","#11","#12","#13",
                         "$J","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12","$13",
                         "%J","%2","%3","%4","%5","%6","%7","%8","%9","%10","%11","%12","%13",
                         "&J","&2","&3","&4","&5","&6","&7","&8","&9","&10","&11","&12","&13"};

        System.out.println("WELCOME THE GAME YOUR COMPETITOR WILL BE COMPUTER PLEASE ENTER YOUR NAME :");

        String dealersName = scan.nextLine();
        dealer.setName(dealersName);

        // dealer mixes the deck
        deck = dealer.mixDeck(deck);

        // Computer cut the deck
        int x = rd.nextInt(52); // Computer chooses where to cut the deck
        deck  = computer.cutDeck(deck,x);

        // Players' Hands
        String[] dealersHand = dealer.getCards();
        String[] computerHand = computer.getCards();

        // Players' Points
        int dealersPoint = dealer.getPoint();
        int computerPoint = computer.getPoint();

        // Cards on the board

        int cardsontheboard = 4;

        // Number of cards players take

//        int dealercardstake = dealer.getAmount_card_taken();
//        int computercarstake = computer.getAmount_card_taken();

        // dealer separates cards
        dealer.separateCards(dealersHand,computerHand,deck);

        // after separating cards 4 cards are putted to board
        String[] cardsOnBoard = dealer.putCards_toBoard(deck);

        // first card on the board are determined
        String FirstCard = dealer.showFirstCard(cardsOnBoard);

        deck = dealer.UpdateCurrentCardsBeforeStart(deck);

        System.out.println("Game starts with " + dealer.getName() );

        //int tur = 1;

//        System.out.println("Length of deck " + deck.length);
//        System.out.println("length of dealers hand " + 4);
//        System.out.println("length of computers hand " + 4);
//        System.out.println("Cards on the board " + cardsontheboard);
//        System.out.println("Computer take" + computer.getAmount_card_taken());
//        System.out.println(dealer.getName() + "take " + dealer.getAmount_card_taken());

        // Game loop
        while (true){

            // First card on the Board
            System.out.println( "------------------\n" +
                                "------- " + FirstCard + " ------- \n" +
                                "------------------"  );

//            System.out.println("Please type the card you want to play that is one of the your hand \n " +
//                    "If you do not choose cards in the deck, the game is finish");
            System.out.println();
            System.out.println(dealer.getName() + "'s hand ");


            System.out.println("************");
            dealer.showHand(dealersHand);
            System.out.println("************");

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
                break;
            }

            // chosen card is same with card on the board
            if (dealer.isSame(chosenCard,FirstCard)){
                dealersPoint += 10; // dealer gain 3 points
                dealer.setPoint(dealersPoint); // current point are assigned to dealers point
                FirstCard = null;
                cardsontheboard ++ ;
                dealer.setAmount_card_taken(cardsontheboard + dealer.getAmount_card_taken());
                cardsontheboard = 0;

            } else {
                FirstCard = chosenCard;
                cardsontheboard ++;
            }

            if (FirstCard == (null)){
                System.out.println( "------------------\n" +
                        "------- " + "  " + " ------- \n" +
                        "------------------"  );
            } else {
                System.out.println("------------------\n" +
                        "------- " + FirstCard + " ------- \n" +
                        "------------------");
            }

            System.out.println(" AFTER PLAY DEALER ");
            //System.out.print(FirstCard); // Computer must see card on the board
            System.out.println();
//            if (FirstCard == null){
//                System.out.println("....");
//            }

            // this loop make null index that is same with chosenCard of Hand so next turns same cards does not be chosen.
            for (int i = 0 ; i < dealersHand.length ; i++){
                if (dealersHand[i] == null){ //if it is already null , this prevents any error
                    continue;
                }
                if(dealersHand[i].equals(chosenCard)){
                    dealersHand[i] = null;
                }
            }

            System.out.println(computer.getName() + "' turn ");
            System.out.println();
            System.out.println(FirstCard + " AFTER PLAY DEALER ");

            int index; // the card which is in the place in the deck.

            // this loop check whether the same card or index chosen more than one time or not
            // if not chosen before , loop complete it works.

            boolean doesHaveSameCard = false;
            boolean doesHaveJ = false;

            int a = 0;
            int b = 0;

            for (String s : computerHand) {
                System.out.print(s + " ");
            }
            System.out.println();

            for (int i = 0 ; i < computerHand.length ; i++){
                if (computerHand[i] == null){
                    continue;
                }
                if(("J" + "").equals(computerHand[i].charAt(1) + "")){
                    doesHaveJ = true;
                    b = i ;
                    break;
                }
                if (computer.isSame(computerHand[i],FirstCard)){
                    doesHaveSameCard = true;
                    a = i ;
                    break;
                }
            }
            if (doesHaveJ){ //Firstly it is checked which is J or not, if it is J ; J is played.
                index = b;
            }
            else if (doesHaveSameCard){
                index = a; // if computer has already same card that is same with FirstCard this

            } else { // else Normal process continue
                while (true) {

                    index = rd.nextInt(4); // an index is chosen randomly

                    if (computerHand[index] != null) {
                        // if the index is not null process can be finish , but it is not null process continue
                        //System.out.println("Yes this did not be chosen go on ");
                        break;
                    }

                    // this protects the code to go infinite

                    boolean isAll_null = false;

                    for (int i = 0; i < 4; i++) {
                        if (computerHand[i] != null) {
                            // if one index of the hand is not null, the loop still can continue
                            isAll_null = true;
                            //break; // BİLGİSAYAR EKLEDİ
                        }
                    }
                    if (!isAll_null) {
                        break;
                    }
                }
            }
//                        boolean canIt_take_cards = false;
//            if (computer.isSame(computerHand[index],FirstCard)){
//                canIt_take_cards = true;
//            }
//            if(canIt_take_cards){
//                computerPoint += 3;
//                computer.setPoint(computerPoint);
//                FirstCard = null;
//            }else {
//                FirstCard = computerHand[index];
//            }
            if (computer.isSame(computerHand[index],FirstCard)){ // if computers' card is same with boarded card

                computerPoint += 10; // 10 points gains
                computer.setPoint(computerPoint); // points are updated
                FirstCard = null; // any cards on the board
                cardsontheboard ++; // add card played
                computer.setAmount_card_taken(cardsontheboard + computer.getAmount_card_taken()); // update amount of cards
                cardsontheboard = 0; // make it zero

            } else {

                FirstCard = computerHand[index];
                cardsontheboard++;
            }

            System.out.println();
            System.out.println(FirstCard + " After computer play " + computerHand[index] + " played it") ;

            computerHand[index] = null; // chosen index will be null to prevent same card is chosen again

            System.out.println();

            /*if (FirstCard == (null)){*/
                System.out.println( "------------------\n" +
                        "------- " + "  " + " ------- \n" +
                        "------------------"  );
//            } else {
//                System.out.println("------------------\n" +
//                        "------- " + FirstCard + " ------- \n" +
//                        "------------------");
//            }

            boolean isAll_null_dealer = true;
            boolean isAll_null_computer = true;

            // this loop checks that whether all index are null or not
            for (int i = 0 ; i < 4 ; i ++){
                if (dealersHand[i] != null){
                    isAll_null_dealer = false;
                    break;
                }
                if (computerHand[i] != null){
                    isAll_null_computer = false;
                    break;

                }
            }
            //System.out.println(deck.length + " uzunluk " + tur + " Tur "  );
            //tur ++;

            //cards are less than 8, it means the game has to finished
            if (deck.length == 0 && isAll_null_computer && isAll_null_dealer){
                System.out.println("//////////////////////////////////////////////");
                System.out.println();
                System.out.println("alis hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.print(dealersHand[i] + "");
                }
                System.out.println();
                System.out.println("Computers hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.print(computerHand[i] + "");
                }
                System.out.println();
                System.out.println("Information about statement of cards");
                System.out.println("Length of deck " + deck.length);
                System.out.println("length of dealers hand " + 0);
                System.out.println("length of computers hand " + 0);
                System.out.println("Cards on the board " + cardsontheboard);
                System.out.println("Computer take" + computer.getAmount_card_taken());
                System.out.println(dealer.getName() + "take " + dealer.getAmount_card_taken());
                System.out.println();
                System.out.println("//////////////////////////////////////////////");

                System.out.println("The Game is over ");

//              System.out.println("computers point is " + computer.getPoint());
//              System.out.println(dealer.getName() + " point is " + dealer.getPoint());

                if (computer.getAmount_card_taken() > dealer.getAmount_card_taken()){
                    computerPoint += 3;
                    computer.setPoint(computerPoint);
                    System.out.println("THREE POINT CAME HERE " + computer.getName());
                } else if (dealer.getAmount_card_taken() > computer.getAmount_card_taken()) {
                    dealersPoint += 3;
                    dealer.setPoint(dealersPoint);
                    System.out.println("THREE POINT CAME HERE " + dealer.getName());
                }

                System.out.println("computers point is " + computer.getPoint());
                System.out.println(dealer.getName() + " point is " + dealer.getPoint());

                if(computer.getPoint() > dealer.getPoint()){
                    System.out.println("**************Computer won ***************");
                } else if (computer.getPoint() < dealer.getPoint()) {
                    System.out.println("************** " + dealer.getName() + " won ***************");
                }else {
                    System.out.println("Everyone won");
                }
                break;
            }

            // if game is still continue, and all indexs are null; new cards has to be separated
            if (isAll_null_computer && isAll_null_dealer){

                dealer.separateCards(dealersHand,computerHand,deck); // cards are separated
//                System.out.println("alis hand");
//                for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                    System.out.println(dealersHand[i]);
//                }
//                System.out.println("Computers hand");
//                for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                    System.out.println(computerHand[i]);
//                }
                System.out.println("card separated");
                deck = dealer.UpdateCurrentCards(deck); // deck is updated
//                System.out.println(deck.length + " uzunluk " + tur + " Tur "  );
//                tur ++;
            }
        }
    }
}
