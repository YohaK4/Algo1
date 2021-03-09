package lisAndLds;

import java.util.Arrays;
import java.util.Comparator;

public class Lsnlog {
	// Binary search (note boundaries in the caller) 
	// A[] is ceilIndex in the caller 

	public static boolean ConditionUp (int i, int j) {
		if (i>=j) return true;
		else return false;

	}
	public static boolean ConditionDown (int i, int j) {
		if (i<=j) return true;
		else return false;

	}

	public static boolean ConditionGenaric (int i, int j) {

		//any condition set
		if (i<=j-1||i<=j+1) return true;
		else return false;

	}

	static int CeilIndexGenaric(int A[], int l, int r, int key) 
	{ 
		//any condition set
		while (r - l > 1) { 
			int m = l + (r - l) / 2; 
			if (ConditionGenaric(A[m],key)) 
				r = m; 
			else
				l = m; 
		} 

		return r; 
	} 






	static int CeilIndexUP(int A[], int l, int r, int key) 
	{ 
		while (r - l > 1) { 
			int m = l + (r - l) / 2; 
			if (ConditionUp(A[m],key)) 
				r = m; 
			else
				l = m; 
		} 

		return r; 
	} 
	static int CeilIndexDown(int A[], int l, int r, int key) 
	{ 
		while (r - l > 1) { 
			int m = l + (r - l) / 2; 
			if (A[m] <= key) 
				r = m; 
			else
				l = m; 
		} 

		return r; 
	} 
	static int LongestIncreasingSubsequenceLength(int Arr[]) 
	{ 
		// Add boundary case, when array size is one 

		int[] helparr = new int[Arr.length]; 
		int x = 1; // always points empty slot 

		helparr[0] = Arr[0]; 

		for (int i = 1; i < Arr.length; i++) { 
			if (Arr[i] < helparr[0]) {
				// new smallest value 
				helparr[0] = Arr[i]; }

			else if (Arr[i] > helparr[x - 1]) { 
				// A[i] wants to extend largest subsequence 
				helparr[x] = Arr[i]; 
				x++;
			}

			else {
				// A[i] wants to be current end candidate of an existing 
				// subsequence. It will replace ceil value in tailTable 
				helparr[-Arrays.binarySearch(helparr, 0, x - 1, Arr[i])-1] = Arr[i]; 
			}

		} 

		return x; 
	} 

	// Driver program to test above function 
	static int LongestDecreasingSubsequenceLength(int Arr[]) 
	{ 
		// to!! Add boundary case, when array size is one 

		int[] helparr = new int[Arr.length]; 
		int x = 1; // always points empty slot 

		helparr[0] = Arr[0]; 

		for (int i = 1; i < Arr.length; i++) { 

			if (Arr[i] > helparr[0]) {
				// new largest value 
				helparr[0] = Arr[i]; }

			else if (Arr[i] < helparr[x - 1]) { 
				// A[i] wants to extend largest subsequence 	
				helparr[x] = Arr[i]; 
				x++;
			}

			else {
				// A[i] wants to be current end candidate of an existing 
				// subsequence. It will replace ceil value in tailTable 
				helparr[Arrays.binarySearch(helparr, 0, x - 1, Arr[i])-1] = Arr[i]; 

			}

		} 

		return x; 
	} 

	static int LongestGenaricSubsequenceLength(int Arr[]) 
	{ 
		// to!! Add boundary case, when array size is one 

				int[] helparr = new int[Arr.length]; 
				int x = 1; // always points empty slot 

				helparr[0] = Arr[0]; 

				for (int i = 1; i < Arr.length; i++) { 

					if (Arr[i] > helparr[0]) {
						// new largest value 
						helparr[0] = Arr[i]; }

					else if (Arr[i] < helparr[x - 1]) { 
						// A[i] wants to extend largest subsequence 	
						helparr[x] = Arr[i]; 
						x++;
					}

					else {
						// A[i] wants to be current end candidate of an existing 
						// subsequence. It will replace ceil value in tailTable 
						helparr[Arrays.binarySearch(helparr, 0, x - 1, Arr[i])-1] = Arr[i]; 

					}

				} 

				return x; 
	} 

	
	public static void main(String[] args) 
	{ 
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 , 14,20,25,59}; 
		int B[] = { 6, 5, 4, 3,5,2,1,0,-1,-2,-3,-4 };
		int C[] = { 1, 2, 3, 4 };
		
		System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A)); 
		System.out.println("Length of Longest Decreasing Subsequence is " + LongestDecreasingSubsequenceLength(B)); 
		System.out.println("Length of Longest Decreasing Subsequence is " + LongestGenaricSubsequenceLength(C));

	} 
}
