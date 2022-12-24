import java.util.Random;
import java.util.Scanner;

public class B_PlayGame {
    public static void main(String[] args) {
        // Classes of Random and Scanner
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();

        // Creating Gamers
        A_Gamers dealer = new A_Gamers("name",new String[4] , 0,0,new String[52]);
        A_Gamers computer = new A_Gamers("Computer" , new  String[4] ,0,0,new String[52]);

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

        // Amount of Cards on the board
        int cardsontheboard = 4;
        // Cards are taken by gamers
        String[] dealer_take =  dealer.getCards_taken_from_board();
        String[] computer_take =  computer.getCards_taken_from_board();
        //        Number of cards players take
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

        System.out.println(FirstCard);
        //System.out.println("Cards on the board");

        //System.out.println();
        boolean isDealer_took_cards = false;
        boolean isComputer_took_cards = false;
        boolean who_take_final = true;

        //int tur = 1;

//        System.out.println("Length of deck " + deck.length);
//        System.out.println("length of dealers hand " + 4);
//        System.out.println("length of computers hand " + 4);
//        System.out.println("Cards on the board " + cardsontheboard);
//        System.out.println("Computer take" + computer.getAmount_card_taken());
//        System.out.println(dealer.getName() + "take " + dealer.getAmount_card_taken());

        // Game loop
        while (true){
//            System.out.println("Please type the card you want to play that is one of the hand \n " +
//                    "If you do not choose cards in the deck, the game is finish");

            System.out.println("**********************************" + dealer.getName() + "**********************************");

            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
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
            if (isSame(chosenCard,FirstCard)){
                if (FirstCard.equals("&10")) {
                    dealersPoint += 3;
                }  else if (FirstCard.equals("$2")) {
                    dealersPoint += 2;
                }
                dealersPoint += 10; // dealer gain 3 points
                dealer.setPoint(dealersPoint); // current point are assigned to dealers point
                FirstCard = null;
                cardsontheboard ++ ;
                dealer.setAmount_card_taken(cardsontheboard + dealer.getAmount_card_taken());
                cardsontheboard = 0;
                isDealer_took_cards = true; // to understand dealer  took cards

            } else {
                FirstCard = chosenCard;
                cardsontheboard ++;
            }

            if (isDealer_took_cards){
                System.out.println("Dealer take before update");
                showboard(dealer_take);
                System.out.println("****");
                System.out.println();
                int z = 0;
                for (int i = 0 ; i < dealer_take.length ; i  ++){
                    if (dealer_take[i] == null){
                        z = i;
                        break;
                    }
                }
                dealer_take[z] = chosenCard;
                for (int i = 0; i + z + 1< cardsOnBoard.length ; i ++){
                    dealer_take[z + i + 1] = cardsOnBoard[i];
                }
                isDealer_took_cards = false;
                who_take_final = false;
                System.out.println("Dealer take");
                showboard(dealer_take);
                System.out.println("****");
                System.out.println();
            }

            System.out.println("------------------- BOARD ----------------------");
            System.out.println(chosenCard);
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            cardsOnBoard = updateBoard(cardsOnBoard,FirstCard);
            System.out.println();


            for (int i = 0 ; i < dealersHand.length ; i++){
                if (dealersHand[i] == null){ //if it is already null , this prevents any error
                    continue;
                }
                if(dealersHand[i].equals(chosenCard)){
                    dealersHand[i] = null;
                }
            }

            System.out.println("**********************************" + computer.getName() + "**********************************");
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            System.out.println();

            //int index; // the card which is in the place in the deck.

            // this loop check whether the same card or index chosen more than one time or not
            // if not chosen before , loop complete it works.

            System.out.println("Computers' hand");
            for (String s : computerHand) {
                System.out.print(s + " ");
            }
            System.out.println();

            String computer_played = determineComputerWhich_cardPlay( computerHand, FirstCard,  cardsOnBoard);

//            for (int i = 0 ; i < computerHand.length ; i++){
//                if (computerHand[i] == null){
//                    continue;
//                }
//                if(("J" + "").equals(computerHand[i].charAt(1) + "")){
//                    if (cardsOnBoard[0] == null){  // this prevents that when the board is empty , play "J"
//                        continue;
//                    }
//                    doesHaveJ = true; // if J available in the hand it becomes true
//                    b = i ; // where is J
//                    break;
//                }
//                if (computer.isSame(computerHand[i],FirstCard)){
//                    doesHaveSameCard = true; // If same card in the hand, it becomes true
//                    a = i ; // where is same card
//                    break;
//                }
//            }
//            if (doesHaveJ){ //Firstly it is checked which is J or not, if it is J ; J is played.
//                index = b;
//            }
//            else if (doesHaveSameCard){
//                index = a; // if computer has already same card that is same with FirstCard this
//
//            } else { // else Normal process continue
//                while (true) {
//
//                    index = rd.nextInt(4); // an index is chosen randomly
//
//                    if (computerHand[index] != null) {
//                        // if the index is not null process can be finish , but it is not null process continue
//                        //System.out.println("Yes this did not be chosen go on ");
//                        break;
//                    }
//
//                    // this protects the code to go infinite
//
//                    boolean isAll_null = false;
//
//                    for (int i = 0; i < 4; i++) {
//                        if (computerHand[i] != null) {
//                            // if one index of the hand is not null, the loop still can continue
//                            isAll_null = true;
//                            //break; // BİLGİSAYAR EKLEDİ
//                        }
//                    }
//                    if (!isAll_null) {
//                        break;
//                    }
//                }
//            }

            if (isSame(computer_played,FirstCard)){  // if computers' card is same with boarded card
                if (FirstCard.equals("&10")) {
                    computerPoint += 3;
                }  else if (FirstCard.equals("$2")) {
                    computerPoint += 2;
                }
                computerPoint += 10; // 10 points gains
                computer.setPoint(computerPoint); // points are updated
                FirstCard = null; // any cards on the board
                cardsontheboard ++; // add card played
                computer.setAmount_card_taken(cardsontheboard + computer.getAmount_card_taken()); // update amount of cards
                cardsontheboard = 0; // make it zero
                isComputer_took_cards = true;

            } else {

                FirstCard = computer_played;
                cardsontheboard++;
            }

            if (isComputer_took_cards){
                System.out.println("computer take before update");
                showboard(computer_take);
                System.out.println("****");
                System.out.println();
                int q = 0;
                for (int i = 0 ; i < computer_take.length ; i  ++){
                    if (computer_take[i] == null){
                        q = i;
                        break;
                    }
                }
                computer_take[q] = computer_played;
                for (int i = 0; i + q + 1< cardsOnBoard.length ; i ++){
                    computer_take[q + i + 1]  = cardsOnBoard[i];
                }

                isComputer_took_cards = false;
                System.out.println("computer take");
                showboard(computer_take);
                System.out.println("****");
                System.out.println();
            }

            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            System.out.println(computer_played);
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            cardsOnBoard =updateBoard(cardsOnBoard,FirstCard);
            System.out.println();

            for (int i = 0 ; i < computerHand.length ; i++){
                if (computerHand[i] == null){ //if it is already null , this prevents any error
                    continue;
                }
                if(computerHand[i].equals(computer_played)){
                    computerHand[i] = null;
                }
            } // chosen index will be null to prevent same card is chosen again

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

            //cards are finished, it means the game has to finished
            // when every card is separated, length of deck become zero
            if (deck.length == 0 && isAll_null_computer && isAll_null_dealer){ // this control all cards are played and separated
                System.out.println("//////////////////////////////////////////////");
//                System.out.println();
//                System.out.println("alis hand");
//                for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                    System.out.print(dealersHand[i] + " ");
//                }
//                System.out.println();
//                System.out.println("Computers hand");
//                for (int i = 0 ; i < dealersHand.length ; i ++ ){
//                    System.out.print(computerHand[i] + " ");
//                }
//                System.out.println();
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

                if (!who_take_final){
                    int last = 0;
                    for (int i = 0 ; i < dealer_take.length ; i  ++){
                        if (dealer_take[i] == null){
                            last = i;
                            break;
                        }
                    }
                    for (int i = 0; i + last + 1 < cardsOnBoard.length ; i ++){
                        dealer_take[last + i + 1] = cardsOnBoard[i];
                    }
                    System.out.println("sonuncuyu dealer aldı");
                } else {
                    int s = 0;
                    for (int i = 0 ; i < computer_take.length ; i  ++){
                        if (computer_take[i] == null){
                            s = i;
                            break;
                        }
                    }
                    computer_take[s] = computer_played;
                    for (int i = 0; i + s + 1< cardsOnBoard.length ; i ++){
                        computer_take[s + i + 1]  = cardsOnBoard[i];
                    }
                    System.out.println("sonuncuyu computer aldı");
                }
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
                System.out.println("Computer take");
                showboard(computer_take);
                System.out.println();
                System.out.println("Dealer take");
                showboard(dealer_take);
                System.out.println();
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

            // if game is still continue, and all index are null; new cards has to be separated
            if (isAll_null_computer && isAll_null_dealer){

                dealer.separateCards(dealersHand,computerHand,deck); // cards are separated

                System.out.println("card separated");
                deck = dealer.UpdateCurrentCards(deck); // deck is updated

            }
        }
    }

    public static void showboard(String[] new_array){
        if (new_array[0] == null){
            System.out.print("Empty");
        }
        for (int i = 0 ; i < new_array.length; i++){
            if (new_array[i] == null){
                break;
            }
            System.out.print(new_array[i] + " ");
        }
    }
    public static String[] updateBoard(String[] array, String choosen_card) {
        String[] new_array = new String[52];
        if (choosen_card == null) {
            for (int i = 0; i < array.length; i++) {
                new_array[i] = null;
            }

        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    break;
                }
                new_array[i + 1] = array[i];
            }
            new_array[0] = choosen_card;

        }
        return new_array;
    }
    public static String determineComputerWhich_cardPlay(String[] computerHand,String FirstCard, String[] cardsOnBoard) {
        Random rd = new Random();
        boolean doesHaveSameCard = false; // chechk that same card with board or not
        boolean doesHaveJ = false; // chechk that J of any group in the computers hand or not

        int a = 0;
        int b = 0;
        int index;

        for (int i = 0; i < computerHand.length; i++) {
            if (computerHand[i] == null) {
                continue;
            }
            if (("J" + "").equals(computerHand[i].charAt(1) + "")) {
                if (cardsOnBoard[0] == null) {  // this prevents that when the board is empty , play "J"
                    continue;
                }
                doesHaveJ = true; // if J available in the hand it becomes true
                b = i; // where is J
                break;
            }
            if (isSame(computerHand[i], FirstCard)) {
                doesHaveSameCard = true; // If same card in the hand, it becomes true
                a = i; // where is same card
                break;
            }
        }
        if (doesHaveJ) { //Firstly it is checked which is J or not, if it is J ; J is played.
            index = b;
        } else if (doesHaveSameCard) {
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


                    }
                }
                if (!isAll_null) {
                    break;
                }
            }

        } return computerHand[index];
    }
    public static boolean isSame(String cardHand, String card_on_board) {
        if (card_on_board == null || cardHand == null) {
            return false;
        } else if ((cardHand.charAt(1) + "").equals("J" + "")){
            return true;
        } else if (cardHand.length() == 3 && card_on_board.length() == 3){
            return (cardHand.charAt(1) + cardHand.charAt(2) + "").equals(card_on_board.charAt(1) + card_on_board.charAt(2) + "");
        } else if (cardHand.length() == 2 && card_on_board.length() == 2){
            return (cardHand.charAt(1) + "").equals(card_on_board.charAt(1) + "");
        } else {
            return false;
        }

    }


}
