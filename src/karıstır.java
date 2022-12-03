import java.util.Random;
public class karıstır {
    public static int[] arr ;

    public karıstır(int[] arr){
        this.arr = arr;
    }
    public static void main(String[] args){
        Random rd = new Random(System.currentTimeMillis());

        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};

        int[] karıstırılmisarray = new int[14];
//        for(int i = 0 ; i < examplearrayim.length ; i ++) {
//            int new_index = rd.nextInt(examplearrayim.length);
//            if (karıstırılmisarray[new_index] == 0) {
//                karıstırılmisarray[new_index] = examplearrayim[i];
//}
// }
        int i = 0;
        while (i < examplearrayim.length){
            int new_index = rd.nextInt(examplearrayim.length);
            if (karıstırılmisarray[new_index] == 0) {
                karıstırılmisarray[new_index] = examplearrayim[i];
                i ++;
            }else {
                continue;
            }
        }
        int toplam = 0;
        for (int a = 0 ; a < examplearrayim.length ; a ++){
            System.out.println( karıstırılmisarray[a] );
            toplam += karıstırılmisarray[a];
        }
    }
}
