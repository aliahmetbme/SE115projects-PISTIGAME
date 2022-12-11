import java.util.Scanner;
import java.util.Random;

public class gametest {
    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};
        Scanner scan = new Scanner(System.in);
        Random rd = new Random(System.currentTimeMillis());
        System.out.print("Welcome to game please enter your name: ");
        String name = scan.nextLine();

        Oyuncu gamer1 = new Oyuncu(name, new int[4], 0);
        Oyuncu gamer2 = new Oyuncu("Computer",new int[4],0);


        curpiyer object = new curpiyer(arr);
        arr = object.mixdeste(); // cards are mixed
        arr = object.desteyikes(); // mixed cards are kesilir
        Cardseperatetest cardseperater = new Cardseperatetest(arr);

        cardseperater.putFirstCard(); // the method create the card that putted to the board
        int FirstCard = cardseperater.showFirstCard(); // it shows at the bottom card on the board

        int gamer1_puan = gamer1.getPuan();
        int gamer2_puan = gamer2.getPuan();
        int[] board = cardseperater.getborad();

        System.out.println("GAME START WITH GAMER ONE" + gamer1.getName());
        System.out.println("******************************************");
        System.out.println(FirstCard);
        System.out.println("******************************************");

        gamer1.setEl(cardseperater.getEl1());
        int[] gamer1eli = gamer1.getEl();
        gamer2.setEl(cardseperater.getEl2());
        int[] gamer2eli = gamer2.getEl();

        while (true){
            System.out.println(gamer1.getName() + " your turn hoose and play a card ");
            showEl(gamer1eli);
            int choosencard = scan.nextInt();
            if (FirstCard - choosencard == 0 || FirstCard - choosencard == 13 || FirstCard - choosencard == 26 || FirstCard - choosencard == 39 || FirstCard - choosencard == -13 || FirstCard - choosencard == -26 || FirstCard - choosencard == -39){
                gamer1_puan = gamer1_puan + 3 ;
                gamer1.setPuan(gamer1_puan);
                FirstCard = 0 ;
            } else {
                FirstCard = choosencard;
            }

            System.out.println( FirstCard + "After play ali");

            for (int i = 0 ; i < gamer1eli.length ; i ++){
                if (gamer1eli[i]  == choosencard){
                    gamer1eli[i] = 0;
                }
            }

            System.out.println(gamer2.getName() + " turn ");

            boolean alabilecekmi = false;
            int index = 0;
            for (int i = 0 ; i < gamer2eli.length ; i ++ ){
                index  = rd.nextInt(4);
                
                if (gamer2eli[index] == 0){
                    System.out.println("Oh nooo" );
                    continue;
                }
                if (FirstCard - gamer2eli[i] == 0 || FirstCard - gamer2.getEl()[i] == 13 || FirstCard - gamer2.getEl()[i] == 26 || FirstCard - gamer2.getEl()[i] == 39 || FirstCard - gamer2.getEl()[i] == -13 || FirstCard - gamer2.getEl()[i] == -26 || FirstCard - gamer2.getEl()[i] == -39){
                    alabilecekmi = true;
                    index = i;
                }
            }
            if (alabilecekmi){
                gamer2_puan = gamer2_puan + 3 ;
                gamer2.setPuan(gamer2_puan);
                FirstCard = 0 ;

            } else {
                FirstCard = gamer2eli[index];
            }

            System.out.println("Computer eli before zero yap");
            showEl(gamer2eli);
            gamer2eli[index] = 0;
            System.out.println("Computer eli");
            showEl(gamer2eli);
            System.out.println( FirstCard + "After play comp");

//            for (int i = 0 ; i < gamer2eli.length ; i ++){
//                if (gamer2eli[i]  == choosencard){
//                    gamer2eli[i] = 0;
//                }
//            }
            boolean hepsisifirmi = false;

            for (int i = 0 ; i < 4 ; i ++){
                if (gamer1eli[i] != 0){
                    hepsisifirmi = true;
                }

            }
            boolean hepsisifirmi2 = false;
            for (int i = 0 ; i < 4 ; i ++){
                if (gamer2eli[i] != 0){
                    hepsisifirmi2 = true;
                }

            }
            if ( !hepsisifirmi && !hepsisifirmi2){
                gamer1eli = gamer1.setEl(cardseperater.getEl1());
                gamer2eli = gamer2.setEl(cardseperater.getEl2());
            }
            if (board.length == 0){
                System.out.println("The Game is finished ");
                if(gamer2_puan > gamer1_puan){
                    System.out.println(gamer2.getName() + "Won");
                } else if (gamer1_puan > gamer2_puan){
                    System.out.println(gamer1.getName() + "Won");
                }
                break;
            }

        }
    }
    public static void showEl(int[] arr){

        for(int i = 0; i < arr.length  ; i++ ){
            System.out.println(arr[i]);
        }

    }
}
