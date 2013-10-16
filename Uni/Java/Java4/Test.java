import java.io.*;

public class test {
	
	public int read(String text) {
		//Required to read from prompt
		InputStreamReader istream = new InputStreamReader(System.in);
		BufferedReader bufRead = new BufferedReader(istream);
		int value = 0;
		System.out.print("Enter "+text+" value: ");
		try {
			String input = bufRead.readLine();
			value = Integer.parseInt(input);
		} catch (IOException err) {
			System.out.println("Error reading line");
		} catch (NumberFormatException err) {
			System.out.println("Error Converting Number");
		}
		return main;
    }

public void main (String args[]){
System.out.println (value);	
}}
