import java.util.Random;
public class control {
   public static void main(String[] args) {
       Gamers gamers = new Gamers("ali ", new String[4],0,0);

       String x ="c22";
       String y = "v2";
       System.out.println(gamers.isSame(x,y));



//        Random rd = new Random(System.currentTimeMillis());
//        int[] deste = {1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13,14};
////        int[] control = new int[8];
////        int b = 0;
////        for (int i = 0 ; i < deste.length ; i ++) {
////            int a = rd.nextInt(8);
////            control[i] = a;
////            /*if (i == 0){                            sıkıntılı
////                 b = a;
////            }
////            else {
////                if (b == a){
////                    System.out.println("Aynı");
////                    continue;
////                }
////            }*/                                     // sıkıntılı
////            //System.out.println(a);
////            /*
////            * böyle bir algoritma aynı ürünü tekrar döndürme sıkıntısı yaşatır !!*/
////            deste[a] = deste[i];
////
////        }
////        System.out.println("***********");
////        for (int i = 0 ; i < deste.length ; i ++){
////            System.out.println(deste[i]);
//// }
//        int[] control1 = new int[deste.length / 2];
//        int[] control2 = new int[deste.length / 2];
//        int[] kesilmis_deste = new int[deste.length];
//
////        for (int i = 0 ; i < deste.length ; i ++){
////            int a = rd.nextInt(8);
////
////                if (control[a] == 0) {
////                    control[a] = deste[i];
////                    System.out.println(control[a] + " " + a + " " + i);
////                } else {
////                   // System.out.println(control[a] + " " + a + " " + i);
////                    continue;
////                }
////
////
////        }
////        System.out.println(" ********************* ");
////        for (int i = 0 ; i < deste.length ; i ++){
////            System.out.println(control[i] + " " + i);
//
//
//        for (int i = 0 ; i <= deste.length / 2 - 1; i ++){
//            control1[i] = deste[deste.length - 1 - i];
//        }
//        for (int i = 0 ; i <= deste.length / 2 - 1 ; i++)
//            control2[i] = deste[i];
//
//
//       // for (int i = deste.length / 2 + 1 ; i <= deste.length -1 ; i ++){
//            //control[i] = deste[deste.length - 1 - i];
//        //}
//
//
//        for(int i = 0 ; i < control1.length; i++){
//            kesilmis_deste[i] = control1[i];
//        }
//        for(int i = 0 ; i < control2.length; i++){
//            kesilmis_deste[i + control1.length] = control2[i];
//        }
//        for (int i = 0 ; i < kesilmis_deste.length ; i ++){
//            System.out.println(kesilmis_deste[i]);
//        }
//
////        for (int i = 0 ; i < deste.length / 2 ; i ++) {
////                System.out.println(control1[i] + " " + i);
////
////        }
////        for (int i = 0 ; i < deste.length / 2 ; i ++) {
////            System.out.println(control2[i] + " " + i);
////
////
////        }

    }
}










