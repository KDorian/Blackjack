import javax.swing.*;
import BreezySwing.*;

public class BlackjackDriver extends GBFrame{
    private JButton hit;
    private JButton stand;
    private JButton end;
    private JButton restart;
    private JLabel dealer;
    private JLabel player;
    private JTextArea DealerCards;
    private JTextArea UserCards;
    private JTextField TotalPlayer;
    private JTextField TotalDealer;
    Player play1 = new Player();
    Dealer deal1 = new Dealer();
    private String secondCard = "";

    public BlackjackDriver(){
        dealer = addLabel("Dealer", 1,1,1,1);
        player = addLabel("Player", 1,3,1,1);
        DealerCards = addTextArea("",2,1,1,1);
        TotalDealer = addTextField("",3,1,1,1);
        TotalDealer.setEditable(false);
        DealerCards.setEditable(false);
        TotalPlayer = addTextField("",3,3,1,1);
        UserCards = addTextArea("",2,3,1,1);
        TotalPlayer.setEditable(false);
        UserCards.setEditable(false);
        TotalDealer.setVisible(false);
        hit = addButton("Hit Player", 4,3,1,1);
        stand = addButton("Stand", 5,3,1,1);
        end = addButton("Quit",7,2,1,1);
        restart = addButton("Restart", 6,2,1,1);
        restart.setVisible(false);
        UserCards.setText(play1.getRankName() + " of " + play1.getSuite());
        play1.setTotal();
        UserCards.setText(UserCards.getText() + "\n" + play1.getRankName() + " of " + play1.getSuite());
        DealerCards.setText(deal1.getRankName() + " of " + deal1.getSuite());
        DealerCards.setText(DealerCards.getText() + "\nPRIVATE");
        deal1.setTotal();
        secondCard = deal1.getRankName() + " of " + deal1.getSuite();
        TotalPlayer.setText("Total is " + Integer.toString(play1.getTotal()));
        if(deal1.getTotal() == 21){
            this.messageBox("LOSER, DEALER BLACKJACK");
            TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
            String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
            DealerCards.setText(str);
            restart.setVisible(true);
            TotalDealer.setVisible(true);
        }
        else if(play1.getTotal() == 21){
            this.messageBox("WINNER, USER BLACKJACK");
            TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
            String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
            DealerCards.setText(str);
            restart.setVisible(true);
            TotalDealer.setVisible(true);

        }

        resize(999,499);
    }

    public void buttonClicked(JButton buttonObj){
        if(buttonObj == end){
            System.exit(1);
        }

        if(buttonObj == restart){
            play1.reset();
            deal1.reset();
            play1.setTotal();
            deal1.setTotal();
            UserCards.setText(play1.getRankName() + " of " + play1.getSuite());
            play1.setTotal();
            UserCards.setText(UserCards.getText() + "\n" + play1.getRankName() + " of " + play1.getSuite());
            DealerCards.setText(deal1.getRankName() + " of " + deal1.getSuite());
            DealerCards.setText(DealerCards.getText() + "\nPRIVATE");
            deal1.setTotal();
            secondCard = deal1.getRankName() + " of " + deal1.getSuite();
            TotalPlayer.setText("Total is " + Integer.toString(play1.getTotal()));
            TotalDealer.setVisible(false);
            hit.setVisible(true);
            stand.setVisible(true);
        }

        if(buttonObj == hit){
            play1.setTotal();
            UserCards.setText(UserCards.getText() + "\n" + play1.getRankName() + " of " + play1.getSuite());
            TotalPlayer.setText("Total is " + Integer.toString(play1.getTotal()));
            if(deal1.getTotal() > 21){
                if(DealerCards.getText().indexOf(' ') == -1);
                deal1.setTotal();
            }

            if(play1.getTotal() == 21){
                this.messageBox("WINNER, USER BLACKJACK");
                TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                DealerCards.setText(str);
                TotalDealer.setVisible(true);
                restart.setVisible(true);
                hit.setVisible(false);
                stand.setVisible(false);
            }

            else if(play1.getTotal() > 21){
                this.messageBox("LOSER. BUST");
                TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                DealerCards.setText(str);
                TotalDealer.setVisible(true);
                restart.setVisible(true);
                hit.setVisible(false);
                stand.setVisible(false);
            }
        }

        if(buttonObj == stand){
            while(deal1.getTotal() <= 16){
                deal1.setTotal();
                DealerCards.setText(DealerCards.getText() + "\n" + deal1.getRankName() + " of " + deal1.getSuite());
            }
            if(deal1.getTotal() > 21){
                if(DealerCards.getText().indexOf(" ") != -1){
                    deal1.setTotal();
                }
            }

            if(deal1.getTotal() > 21){
                this.messageBox("WINNER, DEALER BUST");
                TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                DealerCards.setText(str);
                TotalDealer.setVisible(true);
                restart.setVisible(true);
                hit.setVisible(false);
                stand.setVisible(false);
            }

            else if(deal1.getTotal() == 21){
                this.messageBox("LOSER, DEALER BLACKJACK");
                TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                DealerCards.setText(str);
                TotalDealer.setVisible(true);
                restart.setVisible(true);
                hit.setVisible(false);
                stand.setVisible(false);
            }

            else{
                if(deal1.getTotal() >= play1.getTotal()){
                    this.messageBox("LOSER, DEALER HIGHER TOTAL");
                    TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                    String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                    DealerCards.setText(str);
                    TotalDealer.setVisible(true);
                    restart.setVisible(true);
                    hit.setVisible(false);
                    stand.setVisible(false);
                }
                else{
                    this.messageBox("WINNER, PLAYER HIGHER TOTAL");
                    TotalDealer.setText("Total is " + Integer.toString(deal1.getTotal()));
                    String str = DealerCards.getText().replaceAll("PRIVATE", secondCard);
                    DealerCards.setText(str);
                    TotalDealer.setVisible(true);
                    restart.setVisible(true);
                    hit.setVisible(false);
                    stand.setVisible(false);
                }
            }
        }
    }

    public static void main(String[] args){
        BlackjackDriver GUI = new BlackjackDriver();
        GUI.setTitle("Blackjack");
        GUI.setSize(1000,500);
        GUI.setVisible(true);
        GUI.setLookAndFeel("Metal");
    }
}
