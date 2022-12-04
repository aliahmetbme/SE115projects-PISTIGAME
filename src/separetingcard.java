public class separetingcard {

    public static int[] array;

    public separetingcard(int[] arr){
        array = arr;
    }
    public static int[] main_el1 = new int[4];
    public static int[] mainel2 = new int[4];

    public static int[] cardseperate(){
        int[] el1 = new int[4];
        int[] el2 = new int[4];
        int amountofcardinboard = 0;
        if (array.length < 8 ){
             amountofcardinboard = array.length;
        } else {
             amountofcardinboard = array.length - 8;
        }
        int[] board = new int[amountofcardinboard];
        for (int i = 0 ; i < 4; i++){
            el1[i] = array[i];
        }

        for (int i = 0 ; i < 4 ; i++){
            el2[i] = array[i + 4];
        }
        for (int i = 0 ; i < 8 ; i++){
            array[i] = 0;
        }
        for (int i = 0 ; i < array.length - 8; i ++){
            board[i] = array[8 + i];
        }
        for (int i = 0 ; i< 4 ; i++){
            System.out.println(el2[i]);
        }
        System.out.println("************");
        for (int i = 0 ; i<4 ; i++){
            System.out.println(el1[i]);
        }
        System.out.println("************");
        for (int i = 0 ; i < board.length ; i ++){
            System.out.println(board[i]);
        }
        main_el1 = el1;
        mainel2 = el2;
        return board;


    }
    public static int[] getEl1(){
        return main_el1;
    }

    public static int[] getEl2(){
        return mainel2;
    }
}