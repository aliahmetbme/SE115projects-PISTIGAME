public class testputFirstCard {
    public static void main(String[] args) {
        int[] arra = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};
        Oyuncu gamer1 = new Oyuncu("Ali", new int[4], 0);
        Oyuncu gamer2 = new Oyuncu("Computer",new int[4],0);
        Cardseperatetest cardseperater = new Cardseperatetest(arra);
        cardseperater.putFirstCard();
        //System.out.println(cardseperater.putFirstCard());
        int tur = 1 ;
        while (true) {
            gamer1.setEl(cardseperater.getEl1());
            System.out.println("//////// el1  " + tur);
            gamer1.showEl();

            gamer2.setEl(cardseperater.getEl2());
            System.out.println("//////// el2  " + tur);
            gamer2.showEl();

            int[] board = cardseperater.getborad();

            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i]);
            }
            System.out.println("////////" + tur);
            tur ++ ;
            if(board.length < 8){
                break;
            }
        }
    }
}
