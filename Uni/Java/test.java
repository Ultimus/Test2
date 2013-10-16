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


public class test {
	public BufferedReader reader;
	
	public static String[] readEnemy(){
		BufferedReader reader;
		String [] param = new String[20]; // todo chars zaehlen
		
        try {
            reader = new BufferedReader(new FileReader("xxx.txt"));
            String zeile = reader.readLine();
            int i = 0;
		  System.out.println (zeile);
            //while (zeile != null) {
                param = zeile.split(";");//.toString();
                i++;
            //}
 
        } catch (IOException e) {
            System.err.println("Error2");
        }
        for (int i = 0; i < param.length; i++){
        	System.out.println (param[i]);
        }
		return param;
	}
	public static void main (String [] args){
		readEnemy();	
	}
	
}

