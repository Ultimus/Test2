import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: maximilian
 * Date: 07.09.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class Game {



    //Variables
    int maxPlayers;
    int actuallPlayer= 1;
    LinkedList<Unit> grave = new LinkedList<Unit>();
    LinkedList<Unit> units = new LinkedList<Unit>();







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
        int temp = actuallPlayer+1;
        if (temp > maxPlayers) actuallPlayer = 1;
        else actuallPlayer++;

    }

    public boolean checkValidMove(Unit u, int tX, int tY){

        int p1Length = units.size();
        Unit temp;
        if (u.id == actuallPlayer){
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

    public void doValidMove(int index, int x, int y){
            Unit temp = units.get(index);
            temp.setX(x);
            temp.setY(y);
            units.remove(index);
            units.add(temp);

    }








}
