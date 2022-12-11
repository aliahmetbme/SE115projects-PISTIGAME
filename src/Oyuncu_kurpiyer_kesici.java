import java.util.Random;

public class Oyuncu_kurpiyer_kesici {
    private String name;
    private int[] el;
    private int puan;
    // CONSTRUCTOR //
    public Oyuncu_kurpiyer_kesici(String name, int[] el, int puan){
        this.name = name;
        this.el = el;
        this.puan = puan;
    }
    // GETTER/SETTER ///
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int[] getEl() {
        return el;
    }
    public void setEl(int[] el) {
        this.el = el;
    }
    public int getPuan() {
        return puan;
    }
    public void setPuan(int puan) {
        this.puan = puan;
    }
    // GETTER/SETTER ///

    // METHODS //
    public  int[] mixdeste(int[] arr) {
        Random rd = new Random();

//        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        While this class was created, this array was used as example

        int[] mixedarray = new int[arr.length];


        int i = 0;
        while (i < arr.length) {
            int new_index = rd.nextInt(arr.length);
            if (mixedarray[new_index] == 0) {
                mixedarray[new_index] = arr[i];
                i++;
            }
        }
        return mixedarray;

    }
    public  int[] desteyikes(int[] arr, int x) {

        int[] control1 = new int[x];
        int[] control2 = new int[arr.length - x];
        int[] kesilmis_deste = new int[arr.length];

        for (int i = 0; i < x ; i++) {
            control1[i] = arr[i];
        }
        for (int i = 0 ; i < arr.length - x ;i ++){
            control2[i] = arr[i + x];
        }

        for (int i = 0; i < x; i++) {
            kesilmis_deste[i + control2.length] = control1[i];
        }
        for (int i = 0 ; i < arr.length - x ; i++ ){
            kesilmis_deste[i] = control2[i];
        }

//        for (int i = 0; i < kesilmis_deste.length; i++) { to chechk new array
//            System.out.println(kesilmis_deste[i]);
//       }

        return kesilmis_deste;
    }
    public void kartlaridagit(int[] gamer1, int[] gamer2 , int[] deste){
        gamer1[0] = deste[0];
        gamer2[0] = deste[1];
        gamer1[1] = deste[2];
        gamer2[1] = deste[3];
        gamer1[2] = deste[4];
        gamer2[2] = deste[5];
        gamer1[3] = deste[6];
        gamer2[3] = deste[7];

    }
    public int[] tahtayakartkoy(int[] deste){
        int [] tahtadakikartlar = new int[4];
        for (int i = 0 ; i < 4 ; i ++){
            tahtadakikartlar[i] = deste[i + 8];
        }
        return tahtadakikartlar;
    }
    public int showFirstCard(int[] arr){
        return arr[0];
    }
    public int[] createSavedCards(int[] arr){
        int amountofcardSaved ;

        if (arr.length < 8 ){
            amountofcardSaved = arr.length;
        } else {
            amountofcardSaved = arr.length - 8;
        }
        int[] SavedCards = new int[amountofcardSaved];

        for (int i = 0; i < arr.length - 9; i ++){
            SavedCards[i] = arr[9 + i];
        }

        return SavedCards;
    }

    public void showEl(int[] arr){
        for (int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }


}
