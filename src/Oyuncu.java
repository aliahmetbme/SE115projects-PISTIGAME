public class Oyuncu {
    private  String name;
    private  int[] el ;
    private  int puan;

    public Oyuncu(String name, int[] el , int puan){
        this.setName(name);
        this.setEl(el);
        this.setPuan(puan);

    }
    public  void showEl(){

        for(int i = 0; i < getEl().length  ; i++ ){
            System.out.println(getEl()[i]);
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getEl() {
        return el;
    }

    public void setEl(int[] el) {
        this.el = el;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }


}
