import java.util.Random;

public class Cardseperatetest {
    private int[] arr;

    public Cardseperatetest(int[] arr){
        this.setArr(arr);
    }

    public int[] getArr() {
        return arr;
    }
    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int putFirstCard(){
        Random rd = new Random();
        int index = rd.nextInt(52);
        int FirstCard = getArr()[index];
        int[] arrAfterFirstCardPutted = new int[getArr().length - 1];
        int x = getArr().length - 1 ;
        while (x > 0){
            if (getArr()[x] != 0){
                arrAfterFirstCardPutted[x] = getArr()[x];
                x ++ ;
            }
        }
        setArr(arrAfterFirstCardPutted);
        return FirstCard;

    }

    public int[] setboard(){
        int amountofcardinboard = 0;

        if (getArr().length < 8 ){
            amountofcardinboard = getArr().length;
        } else {
            amountofcardinboard = getArr().length - 8;
        }
        int[] board = new int[amountofcardinboard];

        for (int i = 0 ; i < 8 ; i++){
            getArr()[i] = 0;
        }
        for (int i = 0; i < getArr().length - 8; i ++){
            board[i] = getArr()[8 + i];
        }
//        System.out.println("************");
//        for (int i = 0 ; i < board.length ; i ++){
//            System.out.println(board[i]);
//        }
        arr = board;
        return board;
    }
    public int[] getborad(){return setboard();}
    public int[] setEl1(){
        int[] el1 = new int[4];
        for (int i = 0 ; i < 4; i++){
            el1[i] = getArr()[i];
        }
        System.out.println("************");
//        for (int i = 0 ; i<4 ; i++){
//            System.out.println(el1[i]);
//        } Chechk it works or not
        return  el1;

    }

    public int[] getEl1(){
        return setEl1();
    }

    public int[] setEl2(){
        int[] el2 = new int[4];
        for (int i = 0 ; i < 4 ; i++){
            el2[i] = getArr()[i + 4];
        }
//        for (int i = 0 ; i< 4 ; i++){
//            System.out.println(el2[i]);
//        }
        return el2;

    }

    public int[] getEl2(){
        return setEl2();
    }
}