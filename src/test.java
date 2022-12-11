public class test {
    public static void main(String[] args){
    int[] arra = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52};
    /*
        karıstır mix = new karıstır(arra);
        arra = mix.desteyi_karısıtr(); // arra become returned arrau so that updated

//        for (int i = 0 ; i < arra.length ; i ++){
//            System.out.println(i + "--- " + arra[i]);     To check whether mixed or not
//        }
//        System.out.println("After mix before cut !!!");
        deste_kesme deste = new deste_kesme(arra);
        arra = deste.desteyikes(); // arra become returned arrau so that updated

        separetingcard separetingcard = new separetingcard(arra);
        arra = separetingcard.cardseperate();

//        for (int i = 0 ; i < arra.length ; i ++){
//            System.out.println(i + "--- " + arra[i]);     //To check whether cut the mixed array or not
//        }
//
//        System.out.println("After mix after cut !!!");



        Oyuncu1 oyuncu1 = new Oyuncu1("Ali ",separetingcard.getEl1(),0);
        Oyuncu1 oyuncu2 = new Oyuncu1("Computer ", separetingcard.getEl2(),0);

        oyuncu1.showEl();




         /* it is done to chechk seperating works or not
    separetingcard separetingcard = new separetingcard(arra);
    arra = separetingcard.cardseperate();
//        System.out.println("////////////////////");
//        separetingcard separetingcard2 = new separetingcard(arra);
//        arra = separetingcard.cardseperate();

          */
    Oyuncu gamer1 = new Oyuncu("Ali", new int[4], 0);
    Oyuncu gamer2 = new Oyuncu("Computer",new int[4],0);

    curpiyer object = new curpiyer(arra);
    arra = object.mixdeste();
    arra = object.desteyikes();
    Cardseperatetest cardseperater = new Cardseperatetest(arra);
     /*
     * kartlar dağıtılırken önce her zaman kartlar dağıtılır sonra board oluşturulur
     */

    System.out.println(cardseperater.putFirstCard());
    int tur = 1 ;

        while (true) {
        gamer1.setEl(cardseperater.getEl1());
        System.out.println("//////// el1  " + tur);
        gamer1.showEl();

        gamer2.setEl(cardseperater.getEl2());
        System.out.println("//////// el2  " + tur);       //cardların belli bir düzende dağıtılabildiği test edildi !!
        gamer2.showEl();

        int[] board = cardseperater.getborad();

        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
        System.out.println("////////" + tur);
        tur ++ ;
        if(board.length < 8){
            break;
        }
    }




    //    for (int i = 0 ; i < object.mixdeste().length ; i ++){     //// object.mixdeste();
//                                                                  arra = object.desteyikes();
//        System.out.println(object.mixdeste()[i]);                             they are working
//    }
//        System.out.println("///////");
//    for (int i = 0 ; i < arra.length ; i ++){
//            System.out.println(arra[i]);
//    }





  }
}
