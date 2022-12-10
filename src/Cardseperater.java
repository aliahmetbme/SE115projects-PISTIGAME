//public class Cardseperater {
//    private int[] arr;
//
//    public Cardseperater(int[] arr){
//        this.setArr(arr);
//    }
//
//    public int[] getArr() {
//        return arr;
//    }
//    public void setArr(int[] arr) {
//        this.arr = arr;
//    }
//
//    public  int[] main_el1 = new int[4];
//    public  int[] main_el2 = new int[4];
//
//    public  int[] cardseperate(){
//
//        int[] el1 = new int[4];
//        int[] el2 = new int[4];
//        int amountofcardinboard = 0;
//        if (getArr().length < 8 ){
//            amountofcardinboard = getArr().length;
//        } else {
//            amountofcardinboard = getArr().length - 8;
//        }
//        int[] board = new int[amountofcardinboard];
//        for (int i = 0 ; i < 4; i++){
//            el1[i] = getArr()[i];
//        }
//
//        for (int i = 0 ; i < 4 ; i++){
//            el2[i] = getArr()[i + 4];
//        }
//        for (int i = 0 ; i < 8 ; i++){
//            getArr()[i] = 0;
//        }
//        for (int i = 0; i < getArr().length - 8; i ++){
//            board[i] = getArr()[8 + i];
//        }
//        for (int i = 0 ; i< 4 ; i++){
//            System.out.println(el2[i]);
//        }
//        System.out.println("************");
//        for (int i = 0 ; i<4 ; i++){
//            System.out.println(el1[i]);
//        }
//        System.out.println("************");
//        for (int i = 0 ; i < board.length ; i ++){
//            System.out.println(board[i]);
//        }
//        main_el1 = el1;
//        main_el2 = el2;
//        return board;
//
//
//    }
//
//    public  int[] getEl1(){
//        return main_el1;
//    }
//
//    public  int[] getEl2(){
//        return main_el2;
//    }
//}

