import java.util.LinkedList;

/**
 * Created by maximilian on 15.02.14.
 */
public class Player {

    int number;
    LinkedList<Cards> hand = new LinkedList<Cards>();

    public Player(int number){
        this.number = number;

    }

    public void newCard(){

    }




    public LinkedList<Cards> getHand() {
        return hand;
    }

    public void setHand(LinkedList<Cards> hand) {
        this.hand = hand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
