import java.util.Random;
import java.util.Scanner;

public class Oyuncu_kurpiyer_kesici_test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rd = new Random();
        Oyuncu_kurpiyer_kesici kurpiyer = new Oyuncu_kurpiyer_kesici("Kurpiye",new int[4],0);
        Oyuncu_kurpiyer_kesici Computer = new Oyuncu_kurpiyer_kesici("Computer",new int[4],0);

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};

        arr = kurpiyer.mixdeste(arr);
        int x = rd.nextInt(52);
        arr = Computer.desteyikes(arr,x);

        int[] kurpiyereli = kurpiyer.getEl();
        int[] computereli = Computer.getEl();

        int kurpiyerpuan = kurpiyer.getPuan();
        int computerpuan = Computer.getPuan();

        kurpiyer.kartlaridagit(kurpiyereli, computereli, arr);
        int[] tahtadakikartlar = kurpiyer.tahtayakartkoy(arr);
        int FirstCard = Computer.showFirstCard(tahtadakikartlar);
        System.out.println(FirstCard);
        arr = Computer.createSavedCards(arr);
//        System.out.println("Deste");
//        for (int i = 0 ; i < 52 ; i++){
//            System.out.println(arr[i]);
//        }
//        System.out.println("Kurpiyerin eli");
//        for (int i = 0 ; i < 4 ; i ++){
//            System.out.println(kurpiyereli[i]);
//        }
//        System.out.println("Computerin eli ");
//        for (int i = 0 ; i < 4 ; i ++ ){
//            System.out.println(computereli[i]);
//        }
//        System.out.println("Tahtadakiler ");
//        for (int i = 0 ; i < 4 ; i ++ ){
//            System.out.println(kurpiyer.tahtayakartkoy(arr)[i]);
//        }
//        System.out.println("First Card");
//        System.out.println(Computer.showFirstCard(kurpiyer.tahtayakartkoy(arr)));
//
//
//        System.out.println("Kartlar dağıtıldıktan sonra kalan arr");
//        for (int i = 0 ; i < arr.length ; i ++){
//            System.out.println(arr[i]);
//        }
        System.out.println("Welcome start with kurpiyer");
        while (true){
            System.out.println("Kurpiyer eli ");
            kurpiyer.showEl(kurpiyereli);
            int choosenCard = scan.nextInt();
            boolean DogruyuSectimi = true;
            for (int i = 0 ; i <kurpiyereli.length ; i ++){
                if (kurpiyereli[i] == choosenCard){
                    DogruyuSectimi = false;
                }
            }
            if (DogruyuSectimi){
                System.out.println("You did not choose correct card");
                break;
            }
            if (FirstCard - choosenCard == 0 || FirstCard - choosenCard == 13 || FirstCard - choosenCard == 26 || FirstCard - choosenCard == 39 || FirstCard - choosenCard == -13 || FirstCard - choosenCard == -26 || FirstCard - choosenCard == -39){
                kurpiyerpuan = kurpiyerpuan + 3;
                kurpiyer.setPuan(kurpiyerpuan);
                FirstCard = 0;
            }else {
                FirstCard = choosenCard;
            }

            System.out.println(FirstCard + "After play kurpiyer");

            for (int i = 0 ; i < kurpiyereli.length ; i ++){
                if (kurpiyereli[i]  == choosenCard){
                    kurpiyereli[i] = 0;
                }
            }

            System.out.println(Computer.getName() + " turn ");

            boolean alabilecekmi = false;
            int index;

            while (true ) {
                index = rd.nextInt(4);

                if (computereli[index] != 0) {
                    System.out.println("okay");
                    break;
                }
                boolean hepsisifirmi3 = false;
                for (int i = 0 ; i < 4 ; i ++){
                    if (computereli[i] != 0){
                        hepsisifirmi3 = true;
                    }

                }
                if (!hepsisifirmi3){
                    break;
                }
            }
            if (FirstCard - computereli[index] == 0 || FirstCard - computereli[index] == 13 || FirstCard - computereli[index] == 26 || FirstCard - computereli[index] == 39 || FirstCard - computereli[index] == -13 || FirstCard - computereli[index] == -26 || FirstCard - computereli[index] == -39){
                    alabilecekmi = true;
            }

            if (alabilecekmi) {
                computerpuan += 3;
                Computer.setPuan(computerpuan);
                FirstCard = 0;
            } else {
                FirstCard = computereli[index];
            }

            computereli[index] = 0;

            boolean hepsisifirmi = false;

            for (int i = 0 ; i < 4 ; i ++){
                if (kurpiyereli[i] != 0){
                    hepsisifirmi = true;
                }

            }
            boolean hepsisifirmi2 = false;
            for (int i = 0 ; i < 4 ; i ++){
                if (computereli[i] != 0){
                    hepsisifirmi2 = true;
                }

            }
            System.out.println(arr.length + " uzunluk ");
            if (arr.length < 5){
                System.out.println("The Game is finished ");
                if(Computer.getPuan() > kurpiyer.getPuan()){
                    System.out.println(Computer.getName() + "Won");
                } else if (kurpiyer.getPuan() > Computer.getPuan()){
                    System.out.println(kurpiyer.getName() + "Won");
                } else {
                    System.out.println("berabere");
                }
                break;
            }
            if ( !hepsisifirmi && !hepsisifirmi2){
                kurpiyer.kartlaridagit(kurpiyereli,computereli,arr);
                arr = kurpiyer.createSavedCards(arr);
            }



        }

    }

}
