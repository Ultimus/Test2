import java.io.*; //include Java's standard Input and Output routines

class Test {
  public static void main (String[] args) throws IOException {

    // Defines the standard input stream
    BufferedReader stdin = new BufferedReader
      (new InputStreamReader(System.in));
    String message; // Creates a varible called message for input

    System.out.print ("Enter the message : ");
    System.out.flush(); // empties buffer, before you input text
    int num1 = Integer.parseInt( stdin.readLine());
	num1 += 8;


    System.out.print("You "); 
    System.out.println("entered : " + num1);

  } // method main
}

