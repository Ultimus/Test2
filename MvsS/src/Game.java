import sun.management.counter.Units;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * Created with IntelliJ IDEA.
 * User: maximilian
 * Date: 07.09.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JFrame implements ActionListener,MouseListener {



    //Variables
    public int maxPlayers;
    public Player actuallPlayer;
    public Player p1;
    public Player p2;
    public LinkedList<Unit> grave = new LinkedList<Unit>();
    public LinkedList<Unit> units = new LinkedList<Unit>();
    MouseListener mouseListener;
    public JButton gameEndButton;
    public boolean turnEnd;




    public Game(Player actualPlayer, Player p1, Player p2){
        this.actuallPlayer = actualPlayer;
        this.p1 = p1;
        this.p2 = p2;

        gameEndButton = new JButton("click mich!");
        gameEndButton.addActionListener(this);

        this.getContentPane().add(gameEndButton);
    }


    public static void main (String[] args){
        boolean gameends = false;
        Player actuallPlayer = new Player(1);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        Game game = new Game(p1,p1,p2);
        game.setUpField();

        while(gameends != true){
            actuallPlayer.newCard();
            game.doTurn(actuallPlayer);
            game.changePlayer();



        }

    }







     //Vllt ist das Feld nicht nötig, aber der Übersicht halber mache ich es trotzdem

    public int[][] setUpField(){
        int field[][]= new int [24][60];

        for(int i= 0; i< field.length-1; i++){
            for (int j = 0; j< field.length-1; j++){
                    field[i][j] = 0;
            }
        }

        return field;
    }

    public void setUpUnits(){
        Unit s = new Unit(0,0,1);
        Unit d = new Unit(24,0,2);

        units.add(s);
        units.add(d);
    }

    public void changePlayer(){
        if (this.actuallPlayer == p1) this.actuallPlayer = p2;
        else this.actuallPlayer = p1;

    }

    public boolean checkValidMove(Unit u, int tX, int tY){

        int p1Length = units.size();
        Unit temp;
        if (u.id == actuallPlayer.getNumber()){
            if (tX < 24 && tX > -1 && tY < 60 && tY > -1){
                for (int i = 0; i < p1Length-1; i++){
                     temp = units.get(i);
                    if (temp.x == tX && temp.y == tY) return false;
                }

            }

        }
        else return false;

        return true;


    }

    public void doValidMove(Unit unit, int x, int y){
            unit.setX(x);
            unit.setY(y);
    }


    public void doTurn(Player actuallPlayer){
        while (turnEnd){

        }
        turnEnd = false;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == gameEndButton) turnEnd = true;
    }




    @Override
    public void mouseClicked(MouseEvent e){
        //here is where all the magic will be
        for( int i = 0; i < units.size(); i++){
            Unit unit = units.get(i);
            if (e.getX() == unit.getX() && e.getY() == unit.getY()){
                unit.clicked = true;
                unit.displayMoveRange();
            }
        }

        //check if field is clicked, if unit is also clicked, check if move is valid, if so move, else make unit unclicked



    }

    @Override
    public void mouseExited(MouseEvent e){
    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }



    public Player getActuallPlayer() {
        return actuallPlayer;
    }

    public void setActuallPlayer(Player actuallPlayer) {
        this.actuallPlayer = actuallPlayer;
    }

    public LinkedList<Unit> getGrave() {
        return grave;
    }

    public void setGrave(LinkedList<Unit> grave) {
        this.grave = grave;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public LinkedList<Unit> getUnits() {
        return units;
    }

    public void setUnits(LinkedList<Unit> units) {
        this.units = units;
    }







}
