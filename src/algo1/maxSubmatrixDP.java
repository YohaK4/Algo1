/**
 * 
 */
package algo1;

import java.util.Scanner;  // Import the Scanner class

/**
 * @author john1
 *
 */
public class maxSubmatrixDP {


	static int countSubmatrixDP(int m[][],int n) {
		int count=0;
		int l=m.length-1; //l=length
		int b=m[0].length-1;//b-width
		if (n==0) {System.out.println("0 stands for holes.");}
		
		for (int x = 0; x < l+1; x++) {

			for (int y = 0; y < b+1; y++) {

				if(m[x][y]==n||m[x][y]>n) {
					count++;					
				}
			}
		}
		
		return count;
	}



	static int[][] maxSubmatrixDP(int m[][]) {
		///m MATRIX NxM
		int maxSize=0;
		int maxI=0;
		int maxJ=0;
		int l=m.length-1; //l=length
		int b=m[0].length-1;//b-width
		int helpArr[][]=new int[m.length][m[0].length];
		int temp;

		mat1(helpArr);

		for (int x = l; x > -1; x--) {

			for (int y = 0; y < b+1; y++) {

				//Step 1 copy first row & first column of m[][]

				if(x==l || y==0) {
					helpArr[x][y]=m[x][y];					
				}

				//Step 2 build matrix h[][]
				else {
					if(m[x][y]==0) 
					{
						helpArr[x][y]=0;
					}
					else {
						temp=Math.min(helpArr[x+1][y], Math.min(helpArr[x][y-1],helpArr[x+1][y-1]))+1;
						if (maxSize<temp)
						{
							maxSize=temp;
							maxI=x;
							maxJ=y;
						}
						helpArr[x][y]=temp;
					}


				}

			}	

		}

		printMatrix(helpArr);
		System.out.println("Maximum size sub-matrix is: " + maxSize);
		System.out.println("xStart = " + ( (l-maxI)-maxSize+1) + " yStart = " + (maxJ-maxSize+1));
		System.out.println("xEnd   = " + (l-maxI) + " yEnd   = " + maxJ);
		System.out.println("********************");
		return helpArr;
	}

	//****************************************************************

	//****************************************************************

	//****************************************************************

	//****************************************************************
	public static void main(String[] args)
	{
		int[][] mat = {
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
				{1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0},
				{1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1},
				{1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1},
				{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
				{0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1}
		};
		System.out.println("matrix mat ");
		printMatrix(mat);
		System.out.println(" matrix help" );
		int[][] arr=maxSubmatrixDP(mat);
		
		
		//*!*!*!*!*!*!*!*!*!*!*!*!*!*!*!**!*!*!*!*!*!*!*!*!*!**!*!*!*!!*!***!*!!*

		System.out.println(" How many subMTRX are in array:Size of minimal subMTRX? " );
		System.out.println(" To stop search, insert -1 " );

		Scanner scann = new Scanner(System.in);
		int searchN=0;
		while (searchN!=-1) {
			System.out.print("N= ");
			searchN= scann.nextInt(); 
				if (searchN==-1) {
					System.out.println("Goodbay"); 
					break;
					}// Read user input
			System.out.println("for N="+searchN+", there are "+countSubmatrixDP(arr, searchN));
		}
	}

	public static void printMatrix(int m[][]) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			//System.out.println("i= "+i);
			System.out.println();
		}
	}

	public static void mat1(int m[][]) {

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				m[i][j]=1;
			}
			//System.out.println("i= "+i);
			//System.out.println();
		}

	}





}












/**
 * @param args
 */



