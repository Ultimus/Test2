public class Hut{
 public static void main (String args[]){
	int startcoin = Integer.parseInt (args[0]);
	int coin = startcoin;
	int setcoins = 1;

	for (int counter = 0; coin < (2* startcoin); counter++){
		coin = coin - setcoins;
		System.out.println ("Runde: "+counter+ "\t\tEinsatz: "+setcoins);
		int erbse = (int) (1+(Math.random()*3));
		int c = (int) (1+(Math.random()*3));
		if  (c == erbse)
		{
			coin +=setcoins * 2;
			setcoins = 1;
		}
		else	{
			setcoins *= 2;
			if (coin == 0){
				System.out.println ("Pleite");
			if (setcoins > coin )
				coin -= setcoins;
				setcoins = 1;
			}
		}
	}
	System.out.println ("Der Einsatz war: "+startcoin);
	System.out.println ("Am Ende des Spiels hat man : "+coin);
	
 }


}

