public class Merge{
	
	public static void sort (int [] a){
	sort (a, 0, a.length);
	}

	public static void sort (int[] a, int lo, int hi){


		int N = hi-lo;
		if (N <= 1) return;
		
		int mid = lo + N/2;
		sort (a , lo, mid);
		sort (a , mid , hi);
		
		int[] aux = new int[N];
		int i = lo, j = mid;
		
		for (int k = 0; k < N; k++){
			if (i == mid) aux[k] = a[j++];
			else if (j == hi) aux[k] = a[i++];
			else if (a[j] < a[i]) aux[k] = a[j++];
			else aux[k] = a[i++];
		}
		
	
		for (int k = 0; k < N; k++){
			a[lo+k] = aux[k];
		}

	}

	public static void main (String[] args){
		int[] a = {12, 3, 16,4, 8, 32};
		sort (a);
		for (int i = 0; i < a.length; i++){
			System.out.print (a[i]+", ");
		}

	}
}


/*for (int l = 0; l < aux.length; l++){
			System.out.print (aux [l]+", ");
			System.out.println();}*/

