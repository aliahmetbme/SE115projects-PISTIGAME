import java.util.Random;
import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        // Classes of Random and Scanner
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();

        // Creating Gamers

        Gamers dealer = new Gamers("name",new String[4] , 0);
        Gamers computer = new Gamers("Computer" , new  String[4] ,0);

        String[] deck = {"#1","#2","#3","#4","#5","#6","#7","#8","#9","#10","#11","#12","#13",
                         "$1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12","$13",
                         "%1","%2","%3","%4","%5","%6","%7","%8","%9","%10","%11","%12","%13",
                         "&1","&2","&3","&4","&5","&6","&7","&8","&9","&10","&11","&12","&13"};
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

        // dealer separates cards
        dealer.separateCards(dealersHand,computerHand,deck);

        // after separating cards 4 cards are putted to board
        String[] cardsOnBoard = dealer.putCards_toBoard(deck);

        // first card on the board
        String FirstCard = dealer.showFirstCard(cardsOnBoard);

        // First card on the Board
        System.out.println(FirstCard);
        deck = dealer.UpdateCurrentCards(deck);

        System.out.println("GAME STARTS WITH " + dealer.getName() );

        int tur = 1;

        // Game loop
        while (true){
            System.out.println(dealer.getName() + "'s hand ");
            dealer.showHand(dealersHand);

            String chosenCard = scan.nextLine(); // Gamer chooses card
            boolean chosenCard_exist = true;

            // this loop checks that is chosen card available in the hand or not
            for (int i = 0 ; i < dealersHand.length ; i ++){
                // if card is available in the hand statement will be false and do not go if statement
                if (dealersHand[i] == chosenCard){
                    // 9 10 11 12
                    // 10
                    chosenCard_exist = false;
                    break;

                }
            }
            // if it still true the card is not available on the hand
            if (!chosenCard_exist){
                System.out.println("You did not choose correct card");
                // the game will be finish
                // new method can be developed
                break;
            }

            // chosen card is same with card on the board
            if (dealer.isSame(chosenCard,FirstCard)){
                dealersPoint += 3; // dealer gain 3 points
                dealer.setPoint(dealersPoint); // current point are assigned to dealers point
                FirstCard = null;

            } else {
                FirstCard = chosenCard;
            }

            System.out.println(FirstCard + "aFTER PLAY KUROİYER"); // Computer must see card on the board
            if (FirstCard == null){
                System.out.println("....");
            }

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

            boolean canIt_take_cards = false;
            int index;

            // this loop check whether the same card or index chosen more than one time or not
            // if not chosen before , loop complete it works.
            while (true){
                index = rd.nextInt(4);
                if (computerHand[index] != null) {
                    System.out.println("Yes this did not be chosen go on ");
                    break;
                }
                // this protects the code to go infinite
                boolean isAll_null = false;

                for (int i = 0 ; i < 4 ; i ++){
                    if (computerHand[i] != null){
                        // if one index of the hand is not null, the loop still can continue
                        isAll_null = true;
                    }
                }
                if (!isAll_null){
                    break;
                }
            }
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
            if (computer.isSame(computerHand[index],FirstCard)){
                computerPoint += 3;
                computer.setPoint(computerPoint);
                FirstCard = null;
            } else {
                FirstCard = computerHand[index];
            }

            computerHand[index] = null; // chosen index will be null to prevent same card is chosen again

            System.out.println(FirstCard);
            if (FirstCard == null){
                System.out.println("....");
            }


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
            System.out.println(deck.length + " uzunluk " + " Tur " + tur);
            tur ++;

            //cards are less than 8, it means the game has to finished
            if (deck.length < 5 ){
                System.out.println("The Game is over ");
                if(computer.getPoint() > dealer.getPoint()){
                    System.out.println("computers point is " + computer.getPoint());
                    System.out.println(dealer.getName() + " point is " + computer.getPoint());
                    System.out.println("**************Computer won ***************");
                } else if (computer.getPoint() < dealer.getPoint()) {
                    System.out.println("computers point is " + computer.getPoint());
                    System.out.println(dealer.getName() + " point is " + computer.getPoint());
                    System.out.println("**************" + dealer.getName() + " !! You won ***************");

                }else {
                    System.out.println("computers point is " + computer.getPoint());
                    System.out.println(dealer.getName() + " point is " + computer.getPoint());
                    System.out.println("Everyone won");
                }
                break;
            }

            // if game is still continue, and all indexes are null; new cards has to be separated
            if (isAll_null_computer && isAll_null_dealer){
                System.out.println("alis hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.println(dealersHand[i]);
                }
                System.out.println("Computers hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.println(computerHand[i]);
                }
                dealer.separateCards(dealersHand,computerHand,deck); // cards are separated
                System.out.println("alis hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.println(dealersHand[i]);
                }
                System.out.println("Computers hand");
                for (int i = 0 ; i < dealersHand.length ; i ++ ){
                    System.out.println(computerHand[i]);
                }
                System.out.println("card separated");
                deck = dealer.UpdateCurrentCards(deck); // deck is updated
            }
        }
    }
}
