public class deste_kesme {
/**
 * ilk gün deste kesme algoritması yapıldı
 */


    public static int[] desteyikes() {
        int[] deste = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        int[] control1 = new int[deste.length / 2];
        int[] control2 = new int[deste.length / 2];
        int[] kesilmis_deste = new int[deste.length];

        for (int i = 0; i <= deste.length / 2 - 1; i++) {
            control1[i] = deste[deste.length - 1 - i];
            control2[i] = deste[i];
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

