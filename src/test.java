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
    curpiyer object = new curpiyer(arra);
    Oyuncu gamer1 = new Oyuncu("Ali", new int[4], 0);
    Oyuncu gamer2 = new Oyuncu("Computer",new int[4],0);

     arra = object.mixdeste();
     gamer1.setEl(arra);
     gamer1.showEl();
     arra = object.desteyikes();
        System.out.println("/********");
     gamer1.setEl(arra);
     gamer1.showEl();
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
