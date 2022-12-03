public class deste_kesme_main {
    public static void main(String[] args){
        int[] arra = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        karıstır mix = new karıstır(arra);
        arra = mix.desteyi_karısıtr(); // arra become returned arrau so that updated

//        for (int i = 0 ; i < arra.length ; i ++){
//            System.out.println(i + "--- " + arra[i]);     To check whether mixed or not
//        }
//        System.out.println("After mix before cut !!!");

        deste_kesme deste = new deste_kesme(arra);
        arra = deste.desteyikes(); // arra become returned arrau so that updated

//        for (int i = 0 ; i < arra.length ; i ++){
//            System.out.println(i + "--- " + arra[i]);     //To check whether cut the mixed array or not
//        }
//
//        System.out.println("After mix after cut !!!");

    }
}
