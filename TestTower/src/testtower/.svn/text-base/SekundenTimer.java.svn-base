package testtower;

//Niels Lorenz

public class SekundenTimer extends Thread {
	private SekundenLauscher[] sLauscher;
	private int maxAnzahlLauscher;
	private long zeit;
	public SekundenTimer() {
		maxAnzahlLauscher = 10;
		sLauscher = new SekundenLauscher[maxAnzahlLauscher];
		for (int i = 0; i < maxAnzahlLauscher; i++) {
			sLauscher[i] = null;
		}
	}
	//Anmeldung der Lauscher:
	public void setzeSekundenLauscher(SekundenLauscher pLauscher) {
		for (int i = 0; i < maxAnzahlLauscher; i++) {
			if (sLauscher[i] == null) {
				sLauscher[i] = pLauscher;
				return;
			}
		}
	}//setzeSekundenLauscher
	
	//Abmeldung der Lauscher:
	public void entferneSekundenLauscher(SekundenLauscher pLauscher) {
		for (int i = 0; i < maxAnzahlLauscher; i++) {
			if (sLauscher[i] == pLauscher) {
				sLauscher[i] = null;
			}
		}
	}//entferneSekundenLauscher
	
	//Versandmethode:
	private void versendeSekundenEreignis() {
		for (int i = 0; i < maxAnzahlLauscher; i++) {
			if (sLauscher[i] != null) {
				sLauscher[i].bearbeiteSekunde(this);
			}
		}
	}//versendeSekundenEreignis
	
	// Threadkern kommt jetzt:
	public void run() {
		zeit = System.currentTimeMillis();
		while (true) { //Endlosschleife
			//Jede Sekunde Meldung an alle Lauscher:
			if ((System.currentTimeMillis() - zeit) > 1000) {
				zeit = System.currentTimeMillis();
				this.versendeSekundenEreignis();
			}
		}//while
	}//run
}

