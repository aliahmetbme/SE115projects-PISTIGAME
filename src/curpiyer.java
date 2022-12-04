import java.util.Random;

public class curpiyer {
    private int[] arr ;

    public curpiyer(int[] arr){
        this.arr = arr;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }


    public  int[] mixdeste(){
        Random rd = new Random(System.currentTimeMillis());

//        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        While this class was created, this array was used as example

        int[] mixedarray = new int[arr.length];


        int i = 0;
        while (i < arr.length){
            int new_index = rd.nextInt(arr.length);
            if (mixedarray[new_index] == 0) {
                mixedarray[new_index] = arr[i];
                i ++;
            }else {
                continue;
            }
        }
        //int toplam = 0;

        //for (int a = 0 ; a < arr.length ; a ++){ this for loop is used check karısıtırlmıs array
        //System.out.println( mixedarray[a] );
        //toplam += mixedarray[a];
        // this checks that all numbers is used one time "toplam " is found
        //
        arr =  mixedarray;
        return arr;
    }

    public  int[] desteyikes() {

        int[] control1 = new int[arr.length / 2]; // ilk yarı
        int[] control2 = new int[arr.length / 2]; // ikinci yarı
        int[] kesilmis_deste = new int[arr.length];

        for (int i = 0; i < arr.length / 2 ; i++) {
            control1[i] = arr[arr.length / 2  + i];
            control2[i] = arr[i];
        }

        for (int i = 0; i < control1.length; i++) {
            kesilmis_deste[i] = control1[i];
            kesilmis_deste[i + control1.length] = control2[i];
        }

//        for (int i = 0; i < kesilmis_deste.length; i++) { to chechk new array
//            System.out.println(kesilmis_deste[i]);
//       }
        arr = kesilmis_deste;
        return arr;
    }


    public  int[] main_el1 = new int[4];
    public  int[] main_el2 = new int[4];

    public  int[] cardseperate(){

        int[] el1 = new int[4];
        int[] el2 = new int[4];
        int amountofcardinboard = 0;
        if (arr.length < 8 ){
            amountofcardinboard = arr.length;
        } else {
            amountofcardinboard = arr.length - 8;
        }
        int[] board = new int[amountofcardinboard];
        for (int i = 0 ; i < 4; i++){
            el1[i] = arr[i];
        }

        for (int i = 0 ; i < 4 ; i++){
            el2[i] = arr[i + 4];
        }
        for (int i = 0 ; i < 8 ; i++){
            arr[i] = 0;
        }
        for (int i = 0 ; i < arr.length - 8; i ++){
            board[i] = arr[8 + i];
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
        main_el2 = el2;
        return board;


    }

    public  int[] getEl1(){
        return main_el1;
    }

    public  int[] getEl2(){
        return main_el2;
    }

}
