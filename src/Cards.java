import java.util.Random;

public class Cards {
    private int number;
    private int rank;
    private String suite;



    private String RankName;
    private String alreadyCards = "";
    Random rand1 = new Random();

    public Cards(){
    }

    public String getSuite() {
        return suite;
    }

    public int getRank() {
        return rank;
    }

    public String getRankName() {
        return RankName;
    }

    public String makeSuite(){
        String type = "";
        switch(number%4){
            case 0: type = "Clubs";
                break;

            case 1: type = "Hearts";
                break;

            case 2: type = "Spades";
                break;

            case 3: type = "Diamonds";
                break;
        }

        return type;
    }

    public String makeRank(){
        String type = "";
        switch(number%13){
            case 0: type = "Ace";
                break;

            case 1: type = "Two";
                break;

            case 2: type = "Three";
                break;

            case 3: type = "Four";
                break;

            case 4: type = "Five";
                break;

            case 5: type = "Six";
                break;

            case 6: type = "Seven";
                break;

            case 7: type = "Eight";
                break;

            case 8: type = "Nine";
                break;

            case 9: type = "Ten";
                break;

            case 10: type = "Jack";
                break;

            case 11: type = "Queen";
                break;

            case 12: type = "King";
                break;
        }

        return type;
    }

    public void nextCard(){
        number = rand1.nextInt(52);
        while(alreadyCards.indexOf(number) != -1){
            number = rand1.nextInt(52);
        }

        alreadyCards = alreadyCards + number;
        suite = makeSuite();
        rank = (number % 13) + 1;
        RankName = makeRank();

        if(rank == 11 || rank == 12 || rank == 13){
            rank = 10;
        }
    }

}
