package testtower;
import java.util.LinkedList;

	public class Wave {
		public LinkedList<Wave> waves;
		private int number;
		private long start = System.currentTimeMillis(); //Zeit bis zum nächsten Monster
		public Enemy enemy;
		public int enemycounter;
		public long timer = System.currentTimeMillis(); //Zeit bis zur nächsten Welle
		public Wave actual;
		
		
		
		public Wave (int number, Enemy enemy){
			this.number = number; 
			this.enemy = enemy;
			waves = new LinkedList <Wave>();
		}
		 
		
		
		
		
		public void addWave (Wave wave){
			waves.add(wave);
			
		}

		public void spawn (int counter, Enemy enemy){
				if ((System.currentTimeMillis() - start) == 700){
					if (counter < this.number){
					//Monster aufs Spielfeld setzen
					start = System.currentTimeMillis();
					counter++;
					}
				}
		}
		
		public Wave nextWave (){
			actual = waves.removeFirst();
			return actual;
		}
		
		public void Wavetimer (){	
			if ((System.currentTimeMillis()- timer)==3000){
					nextWave (); //If true führe nextWave aus
			}
		}
		
			
		
		
		
	}
