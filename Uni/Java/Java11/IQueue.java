public interface IQueue {
void offer (double d) ; // fuegt din die Warteschlange ein
double poll ( ) ; // gibt den ersten Wert der Warteschlange zurueck und entfernt ihn
double peek ( ) ; //  gibt den ersten Wert der Warteschlange zurueck ohne ihn zu entfernen
int size ( ) ; // gibt die Anzahl der Elemente in der Warteschlange ezurueck
}

