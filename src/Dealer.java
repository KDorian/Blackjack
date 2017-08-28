
public class Dealer {
    boolean soft = false;
    int total = 0;
    Cards card1 = new Cards();

    public Dealer(){
        setTotal();
    }

    public void setTotal(){
        card1.nextCard();
        int value = card1.getRank();
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
        return card1.getSuite();
    }

    public int getRank(){
        return card1.getRank();
    }

    public String getRankName(){
        return card1.getRankName();
    }

    public int  getTotal(){
        return total;
    }

    public void reset(){
        soft = false;
        total = 0;
        card1 = new Cards();
    }
}
