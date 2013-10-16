import org.junit.Assert.*;
import org.junit.*;;


public class Arrays{



 static void count (char[] kette, char z){
	 int counter = 0;
		for (int i = 0; i < kette.length; i++){

			if (z == a[i]){
				counter++;
			}
		}	
	// der counter wird erhöht sobald der gesuchte Buchstabe gefunden wurde
		System.out.println ("Der Buchstabe: "+z+"wurde "+counter+"mal gefunden");

 } 

 static int seek(char[] kette, char[] find){
 
        int len = kette.length;
        int seeker = 0;
	int k = 0;
 	int len_ = find.length;

	for (int i = 0; i < len; i++) {
		
		if (kette[i] == find[0]){ //Das Array kette wird so lange durchsucht bis ein Buchstabe mit dem ersten Buchstaben von find übereinstimmt 
			
			for (int j = 0; j < len; j++){ //Die darauffolgenden Buchstaben werden verglichen
				
				if (kette[i] == find[j]) {
					seeker++;
		
					if (seeker == 1) // wenn seeker den ersten übereinstimmenden Buchstaben findet wird k auf den Wert im Array gesetzt
						{ kette[i] = k;}
				}
			}
		}
	}
					

}
if (seeker == len_ ){
	System.out.println (k);
}
else
{
	System.out.println ("-1");
}


}


        boolean isPalindrom(char[] kette){


	
	  boolean drom;
	
          int len = kette.length;
		
	  int pruefe = 0;
          char[] reverse = new char[len];
        
        
          // kette umdrehen
        	for (int i = 0; i < len; i++) {
            		reverse[i] = kette[len - 1 - i];
        	}
		
		for (i = 0; i < len; i ++)
		{
			if (reverse[i] == kette [i])	
				pruefe++;
		}
		
		if (pruefe == len)
			drom = true;
		else
			drom = false;
		       

	  System.out.println (drom);

      } 




}
  public static void main (String args[]){

	char[] kette = Charakter.parseChar [0];
	char z = Character.parseChar [1];
	char[] find = Charakter.parseChar [2];
	static char[] a ={'H','a','l','l','o',' ','W','e','l','t'};
	static char[] b = {'W','e','l','t'};
	static char[] c = {'o','t','t','o',};


	if (kette == 'a')
		kette = a;
	if (kette == 'b')
		kette = b;
	if (kette == 'c')
		kette = c;

	if (find == 'a' || !=kette)
		find = a;
	if (find == 'b' || !=kette)
		find = b;
	if (find == 'c' || !=kette)
		find = c


}
@Test
public void test1(){
char kette = count(a);
char z = count ('l');
assertEquals = (3, z);
}

@Test
public void test2() {
char kette = count (c);
char z = count ('t');
asserEquals = (2, z);
}
 
@Test
public void test3(){
char kette  = seek (a);
char find = seek (b); 
assertEquals = (6, seeker);
}

@Test
public void test4(){
char kette  = seek (b);
char find = seek (c); 
assertEquals = (-1, seeker);
}

@Test
public void test5(){
char kette = isPalindrom (a);
assertEquals = (false, drom);
}

Test
public void test6(){
char kette = isPalindrom (c);
assertEquals = (true, drom);
}

}
