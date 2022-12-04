public class Oyuncu1 {
    public static String name;
    public static int[] el ;
    public static int puan;

    public Oyuncu1(String name, int[] el , int puan){
        this.name = name;
        this.el = el;
        this.puan = puan;

    }

    public static void showEl(){

        for(int i = 0 ; i < el.length  ; i++ ){
            System.out.println(el[i]);
        }

    }


}
