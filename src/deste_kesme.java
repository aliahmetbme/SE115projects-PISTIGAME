public class deste_kesme {
/**
 * ilk gün deste kesme algoritması yapıldı
 */
    public static int[] arr ;

    public deste_kesme(int[] arr){
        this.arr = arr;
    }


    public static int[] desteyikes() {

        int[] control1 = new int[arr.length / 2];
        int[] control2 = new int[arr.length / 2];
        int[] kesilmis_deste = new int[arr.length];

        for (int i = 0; i <= arr.length / 2 - 1; i++) {
            control1[i] = arr[arr.length - 1 - i];
            control2[i] = arr[i];
        }

        for (int i = 0; i < control1.length; i++) {
            kesilmis_deste[i] = control1[i];
            kesilmis_deste[i + control1.length] = control2[i];
        }

        for (int i = 0; i < kesilmis_deste.length; i++) {
            System.out.println(kesilmis_deste[i]);
       }
        return kesilmis_deste;
    }

}

