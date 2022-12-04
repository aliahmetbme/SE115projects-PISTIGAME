import java.util.Random;
public class karıstır {
    public static int[] arr ;

    public karıstır(int[] arr){
        this.arr = arr;
    }
    public static int[] desteyi_karısıtr(){
        Random rd = new Random(System.currentTimeMillis());

//        int[] examplearrayim = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        While this class was created, this array was used as example

        int[] karıstırılmisarray = new int[arr.length];


        int i = 0;
        while (i < arr.length){
            int new_index = rd.nextInt(arr.length);
            if (karıstırılmisarray[new_index] == 0) {
                karıstırılmisarray[new_index] = arr[i];
                i ++;
            }else {
                continue;
            }
        }
        int toplam = 0;

        //for (int a = 0 ; a < arr.length ; a ++){ this for loop is used check karısıtırlmıs array
            //System.out.println( karıstırılmisarray[a] );
            //toplam += karıstırılmisarray[a];
            // this checks that all numbers is used one time "toplam " is found
       //
        arr =  karıstırılmisarray;
        return arr;
    }
}
