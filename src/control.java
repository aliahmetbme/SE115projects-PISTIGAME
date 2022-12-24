import java.util.Random;
//public class control {
////   public static void main(String[] args) {
////       Gamers gamers = new Gamers("ali ", new String[4],0,0);
////       String[] myboard = {"1","2","3","4","5","6","7","8","9"};
////
////       String [] controlarrayı = new String[52];
////       String choosen = "ali";
////       System.out.println(choosen);
////
////       System.out.println();
////       gamers.showboard(myboard);
////       System.out.println();
////       myboard = gamers.updateBoard(myboard,choosen);
////       System.out.println("----------");
////       System.out.println();
////       gamers.showboard(myboard);
////       System.out.println("---------------------");
////
////       String choosen1 = "ayşe";
////       System.out.println(choosen1);
////       System.out.println();
////       gamers.showboard(myboard);
////       System.out.println();
////       myboard = gamers.updateBoard(myboard,choosen1);
////       gamers.showboard(myboard);
////
////       String choosen2 = null;
////       System.out.println(" ");
////       System.out.println();
////       gamers.showboard(myboard);
////       System.out.println();
////       myboard = gamers.updateBoard(myboard,null);
////       System.out.println("after write null");
////       gamers.showboard(myboard);
////       System.out.println("//////");
////       System.out.println(myboard.length);
////       String choosen3 = "anne";
////       System.out.println(choosen3);
////       System.out.println();
////       gamers.showboard(myboard);
////       System.out.println();
////       myboard = gamers.updateBoard(myboard,choosen3);
////       gamers.showboard(myboard);
//
//
////        Random rd = new Random(System.currentTimeMillis());
////        int[] deste = {1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12,13,14};
//////        int[] control = new int[8];
//////        int b = 0;
//////        for (int i = 0 ; i < deste.length ; i ++) {
//////            int a = rd.nextInt(8);
//////            control[i] = a;
//////            /*if (i == 0){                            sıkıntılı
//////                 b = a;
//////            }
//////            else {
//////                if (b == a){
//////                    System.out.println("Aynı");
//////                    continue;
//////                }
//////            }*/                                     // sıkıntılı
//////            //System.out.println(a);
//////            /*
//////            * böyle bir algoritma aynı ürünü tekrar döndürme sıkıntısı yaşatır !!*/
//////            deste[a] = deste[i];
//////
//////        }
//////        System.out.println("***********");
//////        for (int i = 0 ; i < deste.length ; i ++){
//////            System.out.println(deste[i]);
////// }
////        int[] control1 = new int[deste.length / 2];
////        int[] control2 = new int[deste.length / 2];
////        int[] kesilmis_deste = new int[deste.length];
////
//////        for (int i = 0 ; i < deste.length ; i ++){
//////            int a = rd.nextInt(8);
//////
//////                if (control[a] == 0) {
//////                    control[a] = deste[i];
//////                    System.out.println(control[a] + " " + a + " " + i);
//////                } else {
//////                   // System.out.println(control[a] + " " + a + " " + i);
//////                    continue;
//////                }
//////
//////
//////        }
//////        System.out.println(" ********************* ");
//////        for (int i = 0 ; i < deste.length ; i ++){
//////            System.out.println(control[i] + " " + i);
////
////
////        for (int i = 0 ; i <= deste.length / 2 - 1; i ++){
////            control1[i] = deste[deste.length - 1 - i];
////        }
////        for (int i = 0 ; i <= deste.length / 2 - 1 ; i++)
////            control2[i] = deste[i];
////
////
////       // for (int i = deste.length / 2 + 1 ; i <= deste.length -1 ; i ++){
////            //control[i] = deste[deste.length - 1 - i];
////        //}
////
////
////        for(int i = 0 ; i < control1.length; i++){
////            kesilmis_deste[i] = control1[i];
////        }
////        for(int i = 0 ; i < control2.length; i++){
////            kesilmis_deste[i + control1.length] = control2[i];
////        }
////        for (int i = 0 ; i < kesilmis_deste.length ; i ++){
////            System.out.println(kesilmis_deste[i]);
////        }
////
//////        for (int i = 0 ; i < deste.length / 2 ; i ++) {
//////                System.out.println(control1[i] + " " + i);
//////
//////        }
//////        for (int i = 0 ; i < deste.length / 2 ; i ++) {
//////            System.out.println(control2[i] + " " + i);
//////
//////
//////        }
//
//
//
//
//
//
//
//
//
//
//
