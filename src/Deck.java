public class Deck {
    private String[] suits;
    private String[] numbers;

    public Deck(String[] SUITS, String[] NUMBERS ){
        setSuits(SUITS);
        setNumbers(NUMBERS);
    }
/// GETTER SETTER ///
    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getNumbers() {
        return numbers;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }
/// METHOD ///
    public String[] createDeck(){ // it crates the deck
        int x = 0;
        String[] deck = new String[52];
        for(int i = 0 ; i < getSuits().length ; i ++) {
            for (int y = 0 ; y < getNumbers().length ; y ++){
                deck[x] = getSuits()[i] + getNumbers()[y];
                if (x == 51){
                    break;
                }
                x ++;
            }
        }
        return deck;
    }



}
