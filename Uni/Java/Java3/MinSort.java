public class MinSort{
 public static void main(String[] ignore) {

	int[] a = {1,-2,3,7,4,13,8};
	int L = a.length;
	int[] b = minSort(a);
	

	for(int i = 0; i<L; i++){ 
		System.out.print(a[i]);
		System.out.print(" ");
	}
	

	System.out.println();
	for(int i = 0; i<L; i++){ 
		System.out.print(b[i]); 
		System.out.print(" "); 
	}

	System.out.println();
	b = reverse(a);

	for(int i = 0; i<L; i++){ 
		System.out.print(b[i]); 
		System.out.print(" "); 
	}

	System.out.println();		
	b = abs(a);

	for(int i = 0; i<L; i++){ 
		System.out.print(b[i]); 
		System.out.print(" "); 
	}

	System.out.println();
	b = filtereven(a);

	for(int i = 0; i<b.length; i++){ 
		System.out.print(b[i]); 
		System.out.print(" "); 
	}

	System.out.println();
	System.out.println(findevenmax(a));
	}

	


	public static int[] minSort(int[] input){
	
		int v_Min = input[0];
		int v_Max = input[0];
		int[] retArray = new int[input.length];	
	
		for(int j = 0; j < input.length; j++){	
		
			if(j != 0) { v_Min = v_Max;}

			for (int i = 0; i < input.length; i++){
			
				if(j==0){
				
					if(v_Min > input[i]){ v_Min = input[i];}
					if(v_Max < input[i]){ v_Max = input[i];}
			
				}
				else{				
				
					if(retArray[j-1] < input[i] && input[i] < v_Min){
						
						v_Min = input[i];
						
					}
				}
			}

			retArray[j]= v_Min;
		}

		return retArray;
		
	}



	public static int first(int[] input){

		return input[0];

	}


	public static int[] reverse (int[] input){
	
		input = minSort (input);
		int[] a = new int [input.length];

		for(int i = (input.length - 1), j = 0; j < input.length ; i--, j++){

			a[j] = input[i];

		}

	return a;		

	}

  public static int[] filtereven(int[] input){
		
	int l = 0;	
		
	for(int i = 0; i < input.length; i++){
		
		if(input[i]%2== 0){
			l++;
			}		
	}


		int[] a = new int[l];
		int g = 0;
	
		for(int i = 0; i < input.length && g<l; i++){
			
			if(input[i]%2== 0){
				a[g] = input[i];
				g++;
			}	
		}
	
		return a;
	
	}


	public static int[] abs(int[] input){

		for(int i = 0; i < input.length; i++){
	
		input[i] = Math.abs(input[i]); 
		
		}
	return input;

	}


	static int findevenmax(int[] input){

		int[] a = new int[input.length];
		a = filtereven(input);
		a = minSort(a);
		a = reverse(a);

	return a[0];
		
	
	}
	}
