public class cardseparatetest {
    public static void main(String[] args) {
        Gamers dealer = new Gamers("name",new String[4] , 0);
        Gamers computer = new Gamers("Computer" , new  String[4] ,0);

        String[] deck = {"#1","#2","#3","#4","#5","#6","#7","#8","#9","#10","#11","#12","#13",
                "$1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11","$12","$13",
                "%1","%2","%3","%4","%5","%6","%7","%8","%9","%10","%11","%12","%13",
                "&1","&2","&3","&4","&5","&6","&7","&8","&9","&10","&11","&12","&13"};

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

        int tura = 1 ;

        for (int tur = tura ;tur < 6 ; tur ++){
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
            deck = dealer.UpdateCurrentCards(deck);
        }
    }
}
