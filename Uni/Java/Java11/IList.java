public interface IList{
int find (double value);
double get (int index);
boolean delete (int index) ;
boolean insert (int index , double value) ;
boolean swap (int index1, int index2);
boolean append (double value);
boolean append (IList list); 
int size ();
void print ();
}

