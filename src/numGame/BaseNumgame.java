package numGame;

import java.util.Arrays;

public class BaseNumgame {
	
	public static void printMatrix(int m[][]) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			//System.out.println("i= "+i);
			System.out.println();
		}
	}
	
	public static int bestGain(int[] arr) {
		int bestGain=0;
		int n=arr.length;
		int [][]helpArr=new int[n][n];

		for (int i = 0; i < helpArr.length; i++) {
			helpArr[i][i]=arr[i];//MIMUSH
		}
		
		for (int i = n-2; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
					helpArr[i][j]=Math.max(arr[i]-helpArr[i+1][j], arr[j]-helpArr[i][j-1]);
				}
			}
		

		printMatrix(helpArr);
		System.out.println("");
		return helpArr[0][n-1];
	}
	
	
	public static int numberGameGils(int[] arr) {
		int n = arr.length;
		int[][] m = new int[n][n];
		for (int i = 0; i < m.length; i++) {
			m[i][i] = arr[i];
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
				m[i][j] = Math.max(arr[i] - m[i+1][j], arr[j] - m[i][j-1]);
			}
		}
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		return m[0][n-1];
	}
	
	public static void main(String[] args) 
	{
	int[] arr=new int[] {1,3,6,1,3,6,1,3,6};
	
	System.out.println("bestgain= "+bestGain(arr));
	}
	
	
}
