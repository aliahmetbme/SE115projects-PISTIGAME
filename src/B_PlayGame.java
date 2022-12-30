/*
CREATED BY ALİ AHMET ERDOĞDU
DECEMBER 2022
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class B_PlayGame {
    public static String[] scorelist = new String[20];
    public static String[] myarray = new String[10];
    public static String[] myarrayisimler = new String[10];
    public static void main(String[] args) {

        // Classes of Random and Scanner
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();

        // Creating Gamers
        A_Gamers dealer = new A_Gamers("name",new String[4] , 0,0,new String[52]);
        A_Gamers computer = new A_Gamers("Computer" , new  String[4] ,0,0,new String[52]);

        // Creating deck
        String[] suits = {"#","$","%","&"};
        String[] number = {"J","2","3","4","5","6","7","8","9","10","11","12","13"};
        Deck Deck = new Deck(suits,number);

        String[] deck = Deck.createDeck();

        System.out.println("WELCOME THE GAME YOUR COMPETITOR WILL BE COMPUTER PLEASE ENTER YOUR NAME :");

        String dealersName = scan.nextLine(); // The dealer enter his/her name.
        dealer.setName(dealersName);
        readFile();
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
        int Amount_of_cards_on_the_board = 4; //before start 4cards putted the board

        // Cards are taken by gamers
        String[] dealer_take =  dealer.getCards_taken_from_board();
        String[] computer_take =  computer.getCards_taken_from_board();

        // dealer separates cards
        dealer.separateCards(dealersHand,computerHand,deck);

        // after separating cards 4 cards are putted to board
        String[] cardsOnBoard = dealer.putCards_toBoard(deck);

        // first card on the board are determined
        String FirstCard_ontheboard = dealer.showFirstCard(cardsOnBoard);

        deck = dealer.UpdateCurrentCardsBeforeStart(deck); // After cards are separated before the game

        System.out.println("Game starts with " + dealer.getName() );

        boolean isDealer_took_cards = false; // this check dealer make pişti or not
        boolean isComputer_took_cards = false; // this check dealer make pişti or no
            System.out.println("Please type the card you want to play that is one of the hand \n " +
                                "If you do not choose cards in the deck, the game is finish \n " +
                                "While you typing choose one card on the hand type it you played, your card that played shown above the board then next players turn updated board is shown");
        // Game loop
        while (true){


            boolean who_take_final = true;
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

                break;
            }

            // chosen card is same with card on the board
            if (isSame(chosenCard,FirstCard_ontheboard)){ // if they are same the function returns true
                if (FirstCard_ontheboard.equals("&10")) {
                    dealersPoint += 3;
                }  else if (FirstCard_ontheboard.equals("$2")) {
                    dealersPoint += 2;
                }
                dealersPoint += 10; // dealer gain 10 points
                dealer.setPoint(dealersPoint); // current point are assigned to dealers point
                FirstCard_ontheboard = null;
                Amount_of_cards_on_the_board++ ; // you put card the board them make pişti
                dealer.setAmount_card_taken(Amount_of_cards_on_the_board + dealer.getAmount_card_taken());
                Amount_of_cards_on_the_board = 0; // After pişti there are not any card on the board
                isDealer_took_cards = true; // to understand dealer took cards

            } else {
                FirstCard_ontheboard = chosenCard; // card above on the board become chosen card
                Amount_of_cards_on_the_board++; // you put card the board
            }

            if (isDealer_took_cards){  // If the gamer took cards this loop works
//                System.out.println("Dealer take before update");
//                showboard(dealer_take);
//                System.out.println("****");
//                System.out.println();
                int z = 0;
                for (int i = 0 ; i < dealer_take.length ; i  ++){
                    //Despite the possibility of players getting all the cards,
                    // an array of 52 is created and starts to be filled from the "null" place each cycle.
                    if (dealer_take[i] == null){ // It detects from which index it is empty.
                        z = i;
                        break;
                    }
                }
                dealer_take[z] = chosenCard;                                /* cards are moved to dealer taken cards array*/
                for (int i = 0; i + z + 1< cardsOnBoard.length ; i ++){      /* cards are moved to dealer taken cards array*/
                    dealer_take[z + i + 1] = cardsOnBoard[i];                /* cards are moved to dealer taken cards array*/
                }
                isDealer_took_cards = false;    // in the next turn if the dealer won't cards, he/she cannot take cards this prevents that
                who_take_final = false;
                System.out.println("Dealer take");
                showboard(dealer_take);
                System.out.println();
                System.out.println("****");
                System.out.println();
            }

            System.out.println("------------------- BOARD ----------------------");
            System.out.println(chosenCard);
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            cardsOnBoard = updateBoard(cardsOnBoard,FirstCard_ontheboard); // After each card putted on the board, the board are updated
            System.out.println();


            for (int i = 0 ; i < dealersHand.length ; i++){
                if (dealersHand[i] == null){ //if it is already null , this prevents any error
                    continue;
                }
                if(dealersHand[i].equals(chosenCard)){ //  To prevent to play same card, the index are made null
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


            System.out.println("Computers' hand");
            for (String s : computerHand) {
                System.out.print(s + " ");
            }
            System.out.println();

            String computer_played = determineComputerWhich_cardPlay( computerHand, FirstCard_ontheboard,  cardsOnBoard);

            if (isSame(computer_played,FirstCard_ontheboard)){  // if computers' card is same with boarded card
                if (FirstCard_ontheboard.equals("&10")) {
                    computerPoint += 3;
                }  else if (FirstCard_ontheboard.equals("$2")) {
                    computerPoint += 2;
                }
                computerPoint += 10; // 10 points gains
                computer.setPoint(computerPoint); // points are updated
                FirstCard_ontheboard = null; // any cards on the board
                Amount_of_cards_on_the_board++; // add card played
                computer.setAmount_card_taken(Amount_of_cards_on_the_board + computer.getAmount_card_taken()); // update amount of cards
                Amount_of_cards_on_the_board = 0; // make it zero
                isComputer_took_cards = true;

            } else {

                FirstCard_ontheboard = computer_played;
                Amount_of_cards_on_the_board++;
            }

            if (isComputer_took_cards){
//                System.out.println("computer take before update");
//                showboard(computer_take);
//                System.out.println("****");
//                System.out.println();
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
//                System.out.println("computer take");
//                showboard(computer_take);
//                System.out.println("****");
//                System.out.println();
            }

            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            System.out.println(computer_played);
            showboard(cardsOnBoard);
            System.out.println();
            System.out.println("------------------- BOARD ----------------------");
            cardsOnBoard =updateBoard(cardsOnBoard,FirstCard_ontheboard);
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
                if (cardsOnBoard[0] != null) {
                    if (!who_take_final) {
                        int last = 0;
                        for (int i = 0; i < dealer_take.length; i++) {
                            if (dealer_take[i] == null) {
                                last = i;
                                break;
                            }
                        }
                        System.out.println("dealer alırkenki tahta");
                        showboard(cardsOnBoard);
                        for (int i = 0; i + last + 1 < cardsOnBoard.length; i++) {
                            dealer_take[last + i + 1] = cardsOnBoard[i];
                        }
                        computer.setAmount_card_taken(computer.getAmount_card_taken() + Amount_of_cards_on_the_board);
                        cardsOnBoard = updateBoard(cardsOnBoard, null);
                        System.out.println("sonuncuyu dealer aldı");
                        Amount_of_cards_on_the_board = 0;

                    } else {
                        int s = 0;
                        for (int i = 0; i < computer_take.length; i++) {
                            if (computer_take[i] == null) {
                                s = i;
                                break;
                            }
                        }
                        System.out.println("computer alırkenki tahta");
                        showboard(cardsOnBoard);
                        computer_take[s] = computer_played;
                        for (int i = 0; i + s + 1 < cardsOnBoard.length; i++) {
                            computer_take[s + i + 1] = cardsOnBoard[i + 1];
                        }
                        System.out.println("sonuncuyu computer aldı");
                        dealer.setAmount_card_taken(dealer.getAmount_card_taken() + Amount_of_cards_on_the_board);
                        cardsOnBoard = updateBoard(cardsOnBoard, null);
                        Amount_of_cards_on_the_board = 0;
                    }
                }

                System.out.println("The Game is over ");
                System.out.println("Information about statement of cards");
                System.out.println("Length of deck " + deck.length);
                System.out.println("length of dealers hand " + 0);
                System.out.println("length of computers hand " + 0);
                System.out.println("Cards on the board " + Amount_of_cards_on_the_board);
                System.out.println("Computer take" + computer.getAmount_card_taken());
                System.out.println(dealer.getName() + "take " + dealer.getAmount_card_taken());
                System.out.println();
                System.out.println("//////////////////////////////////////////////");



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

                System.out.println("Cards on the board");
                showboard(cardsOnBoard);
                System.out.println();

                System.out.println("computers point is " + computer.getPoint());
                System.out.println(dealer.getName() + " point is " + dealer.getPoint());

                int mama = 9;

                cleanlist();
                firselemanlist(dealer.getName(), Integer.toString(dealer.getPoint()));
                while (true) {
                    writeFilelast(mama);
                    mama -= 1;
                    if (mama == 0) {
                        break;
                    }
                }



                if(computer.getPoint() > dealer.getPoint()){
                    System.out.println("**************Computer won ***************");
                } else if (computer.getPoint() < dealer.getPoint()) {
                    System.out.println("************** " + dealer.getName() + " won ***************");
                }else {
                    System.out.println("Everyone won");
                }
                showTable();
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
        if (new_array[0] == null){ // if the board are is empty all indezes are null sothat to check 0. index is enough
            System.out.print("Empty");
        }
        for (int i = 0 ; i < new_array.length; i++){
            if (new_array[i] == null){ // Detects where null indexes start to suppress until the null part comes
                break;
            }
            System.out.print(new_array[i] + " ");
        }
    }
    public static String[] updateBoard(String[] array, String top_card_ontheboard) {
        String[] new_array = new String[52];
        if (top_card_ontheboard == null) { // it means cards on the board are taken so that the board has to become empty
            for (int i = 0; i < array.length; i++) {
                new_array[i] = null; // all index become null 
            }

        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) { // detect that where is the starts be null 
                    break;
                }
                new_array[i + 1] = array[i]; 
            }
            new_array[0] = top_card_ontheboard; // Firsly choose

        }
        return new_array;
    }
    public static String determineComputerWhich_cardPlay(String[] computerHand,String FirstCard, String[] cardsOnBoard) {
        Random rd = new Random();
        boolean doesHaveSameCard = false; // chechk that same card with board or not
        boolean doesHaveJ = false; // chechk that J of any group in the computers hand or not

        int a = 0;
        int b = 0;
        int index; // the card which is in the place in the deck.

        for (int i = 0; i < computerHand.length; i++) {
            if (computerHand[i] == null) { // if the card have been played, continue to check
                continue;
            }
            if (("J" + "").equals(computerHand[i].charAt(1) + "")) {
                if (cardsOnBoard[0] == null) {  // this prevents that when the board is empty , do not play "J"
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
                    // this loop check whether the same card or index chosen more than one time or not
                    // if the index is not null process can be finish , but it is not null process continue
                    //System.out.println("Yes this did not be chosen go on ");
                    break;
                }

                // this protects the code to go infinite

                boolean is_not_All_null = false;

                for (int i = 0; i < 4; i++) {
                    if (computerHand[i] != null) {
                        // if one index of the hand is not null, the loop still can continue
                        is_not_All_null = true;
                        break;
                    }
                }
                if (!is_not_All_null) {
                    break;
                }
            }
            // it returns the index are chosen
        } return computerHand[index] ;
    }
    public static boolean isSame(String cardHand, String card_on_board) {
        if (card_on_board == null || cardHand == null) { // to prevent to get any error about null string 
            return false;
        } else if ((cardHand.charAt(1) + "").equals("J" + "")){ // To check card is J or not
            return true;
        } else if (cardHand.length() == 3 && card_on_board.length() == 3){ // if the length is 3 (&10,%10) these are evaluated in this part
            return (cardHand.charAt(1) + cardHand.charAt(2) + "").equals(card_on_board.charAt(1) + card_on_board.charAt(2) + "");
        } else if (cardHand.length() == 2 && card_on_board.length() == 2){ // if the length is 3 (&10,%10) these are evaluated in this part
            return (cardHand.charAt(1) + "").equals(card_on_board.charAt(1) + "");
        } else {
            return false; 
        }

    }

//    public static void readFile(String gamername, int point){
//        Scanner scan = null;
//        String[] fields = {"Name","Point"};
//        try {
//            int j = 0;
//            int k =0;
//            scan = new Scanner(Paths.get("Scorelist.txt"));
//            while (scan.hasNextLine()){
//                String[] information = scan.nextLine().split(",");
//                for (int i = 0 ; i < fields.length  ; i ++){
//                    System.out.println(fields[i] + information[k] );
//                    k ++ ;
//                    if (k == 2){
//                        k = 0;
//                    }
//                }
//                System.out.println("---------------");
//                String s = Integer.toString(point);
//                scorelist[j] = gamername ;
//                scorelist[j + 1] = s;
//                j += 2;
//                if(j==20){
//                    break;
//                }
//            }
//            showboard(scorelist);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scan != null){
//                scan.close();
//            }
//        }
//    }

    public static void showTable(){
        for (int i = 0 ; i  < myarray.length - 1; i += 2){
            System.out.println( " name : " + myarrayisimler[i] + " Score: " + myarray[i] );
        }
    }
    public static void readFile(){
        Scanner scan = null;
        String[] fields = {"Name --> ","Point --> "};
        try {
            int j = 0;
            int k = 0;
            int index = 0;
            scan = new Scanner(Paths.get("Scorelist.txt"));
            while (scan.hasNextLine()){
                String[] information = scan.nextLine().split(",");

                for (int i = 0 ; i < fields.length  ; i ++){
                    System.out.println(fields[i] + information[k] );
                    if (k == 0) {
                        myarray[index] = information[1];
                        myarrayisimler[index] = information[0];
                        index++;
                    }
                    k ++ ;
                    if (k == 2){
                        k = 0;
                    }
                }
                System.out.println("---------------");

                scorelist[2 * j] = myarrayisimler[j];
                //System.out.println(myarrayisimler[j] + "immm");
                scorelist[2 * j + 1] = myarray[j];
                //System.out.println(myarray[j] + "daat");

                j += 1;
                if (j == 10) {
                    break;
                }
            }
            int temppoint = 0;
            String tempnames = null;
            for(int i = 0 ; i < myarray.length ; i ++) {
                int J = i;
                while (J > 0) {
                    if (myarray[J] == null) {
                        for (int a = 0; i < myarray.length; a++) {
                            System.out.print(myarray[a] + " ");
                        }
                        System.out.println("problem");
                        ;
                    }
                    if (Integer.parseInt(myarray[J - 1].trim()) > Integer.parseInt(myarray[J].trim())) {
                        temppoint = Integer.parseInt(myarray[J - 1].trim());
                        myarray[J - 1] = myarray[J];
                        myarray[J] = Integer.toString(temppoint);

                        tempnames = myarrayisimler[J - 1];
                        myarrayisimler[J - 1] = myarrayisimler[J];
                        myarrayisimler[J] = tempnames;
                    }
                    J--;
                }
            }


            int y = 0;
            while (true) {

                scorelist[2 * y] = myarrayisimler[y];
                scorelist[2 * y + 1] = myarray[y];


                y += 1;
                if (y == 10) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scan != null){
                scan.close();
            }
        }
    }
    public static void writeFilelast(int index ){
        Formatter f  = null ;
        FileWriter fw = null;
        int temppoint = 0;
        String tempnames = null;
        for(int i = 0 ; i < myarray.length ; i ++) {
            int J = i;
            while (J > 0) {
                if (myarray[J] == null) {
                    for (int a = 0; i < myarray.length; a++) {
                        System.out.print(myarray[a] + " ");
                    }
                    System.out.println("problem");
                    ;
                }
                if (Integer.parseInt(myarray[J - 1].trim()) > Integer.parseInt(myarray[J].trim())) {
                    temppoint = Integer.parseInt(myarray[J - 1].trim());
                    myarray[J - 1] = myarray[J];
                    myarray[J] = Integer.toString(temppoint);

                    tempnames = myarrayisimler[J - 1];
                    myarrayisimler[J - 1] = myarrayisimler[J];
                    myarrayisimler[J] = tempnames;
                }
                J--;
            }
        }
        try {

            fw = new FileWriter("Scorelist.txt",true);
            f = new Formatter(fw);
            f.format(" %s, %s\n ", myarrayisimler[index].trim(), myarray[index].trim());


        } catch (Exception e){
            System.err.println("Something went wrong");
        }finally {
            if (f != null){
                f.close();
            }
        }

    }
    public static void cleanlist() {
        Formatter f = null;
        //FileWriter fw = null;
        try {

            // fw = new FileWriter("Scorelist.txt",true);
            f = new Formatter("Scorelist.txt");
            f.format(" %s, %s\n ", null, null);


        } catch (Exception e) {
            System.err.println("Something went wrong");
        } finally {
            if (f != null) {
                f.close();
            }
        }
    }
    public static void firselemanlist(String name, String point){


        Formatter f  = null ;
//
//        int temppoint = 0;
//        String tempnames = null;
//        for(int i = 0 ; i < myarray.length ; i ++) {
//            int J = i;
//            while (J > 0) {
//                if (myarray[J] == null) {
//                    for (int a = 0; i < myarray.length; a++) {
//                        System.out.print(myarray[a] + " ");
//                    }
//                    System.out.println("problem");
//                    ;
//                }
//                if (Integer.parseInt(myarray[J - 1].trim()) > Integer.parseInt(myarray[J].trim())) {
//                    temppoint = Integer.parseInt(myarray[J - 1].trim());
//                    myarray[J - 1] = myarray[J];
//                    myarray[J] = Integer.toString(temppoint);
//
//                    tempnames = myarrayisimler[J - 1];
//                    myarrayisimler[J - 1] = myarrayisimler[J];
//                    myarrayisimler[J] = tempnames;
//                }
//                J--;
//            }
//        }
//
//        if (Integer.parseInt(myarray[9].trim()) < Integer.parseInt(point.trim())){
//            myarray[9] = (point);
//            myarrayisimler[9] = name;
//        }
        try {


            f = new Formatter("Scorelist.txt");
            f.format(" %s, %s\n ", name, point);


        } catch (Exception e){
            System.err.println("Something went wrong");
        }finally {
            if (f != null){
                f.close();
            }
        }

    }}



