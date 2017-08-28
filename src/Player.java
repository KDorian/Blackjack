
public class Player {
    boolean soft = false;
    int total = 0;
    Cards card2 = new Cards();

    public Player(){
        setTotal();
    }

    public void setTotal(){
        card2.nextCard();
        int value = card2.getRank();
        if(value == 1){
            value = 11;
            soft = false;
        }
        if(value == 11 && (total + value) > 21){
            value = 1;
            soft = true;
        }

        total = total + value;
    }

    public String getSuite(){
        return card2.getSuite();
    }

    public int getRank(){
        return card2.getRank();
    }

    public String getRankName(){
        return card2.getRankName();
    }

    public int getTotal() {
        return total;
    }

    public void reset(){
        soft = false;
        total = 0;
        card2 = new Cards();
    }
}
