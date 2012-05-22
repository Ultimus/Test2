package testtower;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 *param[0] = x;
	param [1] = y;
	param [2] = speed;
	param [3] =direction;
	param [4] = hp;
	param [5] = width;
	param [6]= heigth; 
*/


public class Parser {
	public BufferedReader reader;
	
	public String[] readEnemy(String filename){
		BufferedReader reader;
		String [] param = new String[10];
		
        try {
            reader = new BufferedReader(new FileReader(filename + ".txt"));
            String zeile = reader.readLine();
                param = zeile.split(";");
 
        } catch (IOException e) {
            System.err.println(filename+".txt konnte nicht gelesen werden");
        }
        for (int i = 0; i < param.length; i++){
        	System.out.println (param[i]);
        }
		return param;
	}
	
	public int[] Convert(String [] param){
		int[] converter = new int [param.length];
		for (int i = 0; i < param.length; i++){
			converter[i] = Integer.parseInt(param[i]);
		}
		
		return converter;
	}
		
	
	
	public void setEnemy (int[] param){
	/*	Enemy.setPos(param[0], param[1]);
		//setter für Speed fehlt
		setDirection.Enemy (param [3]);
		setHp.Enemy (param[4]);
		//set width und set heiight fehlt
	*/}
	
	public void setTower (int[] param){
		/*
		 * public int x;
	public int y;
	public int range;
	public int damage;
	public int level;
	public int size;
	public int speed;
	public double lastShot;
	public int coolDown;
	public int waited; 		//Variable die im Objekt selber den CoolDown Hochzaehlen kann
	public int price;
		 */
		
	}
	
	
	
}
