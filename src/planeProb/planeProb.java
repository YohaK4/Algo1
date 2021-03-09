package planeProb;

import java.util.Iterator;

public class planeProb {

	public static void printMatrix(Node[][] nodes) {
		for(int i = 0; i < nodes.length; i++) {
			for(int j = 0; j < nodes[0].length; j++) {
				System.out.print(nodes[i][j] + " ");
			}
			//System.out.println("i= "+i);
			System.out.println("\n");
		}
	}

	public static Node [][] setUp(int n, int m) {  //O(n*m)
		//int n= shurot-length
		//int m= amudot- height
		int x=0,y=0;
		Node[][] mat=new Node [m+1][n+1];//
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {	

				
				do{
					double dx= Math.random()*100/6; 
					double dy= Math.random()*100/4; 
					//System.out.println("dx= "+dx+" dy= "+dy);
					x=(int)dx;
					y=(int)dy;
				}while (x==0||y==0); 
				//	System.out.println("x= "+x+" y= "+y);
				if(i==m) {x=0;}
				if(j==n) {y=0;}
				mat[i][j]= new Node(y,x); 

			}
		}


		return mat;
	}


	public static Node bestPath(Node [][] mat){//O(m*n)
		int m=mat.length; 		//shurot --i
		int n=mat[0].length;	//amudot --j
		//String path="";
		/*if(i==0&&j==0) {
		 *	mat[0][0].price=0;
		 *}
		 *	else if(i==0&&j>0) {
		 *		mat[0][j].price=mat[0][j-1].price+mat[0][j-1].x;
		 *		mat[0][j].pathNum=1;
		 *	}
		 *	else if(j==0&&i>0) {
		 *			mat[i][0].price=mat[i-1][0].price+mat[i-1][0].y;
		 *			mat[i][0].pathNum=1;
		 *		}
		 *		else {*
		 *///!!\\	
		for (int j = 1; j < n; j++) {
			mat[0][j].price=mat[0][j-1].price+mat[0][j-1].x;
			mat[0][j].pathNum=1;
		}
		for (int i = 1; i < m; i++) {
			mat[i][0].price=mat[i-1][0].price+mat[i-1][0].y;
			mat[i][0].pathNum=1;
		}		
		//!!*/

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {

				int xprice=mat[i-1][j].price+mat[i-1][j].y;
				int yprice=mat[i][j-1].price+mat[i][j-1].x;
				mat[i][j].price=Math.min(xprice, yprice); //Price$$

				//for paths*********************************\\	

				if (yprice==xprice) {
					mat[i][j].pathNum=mat[i-1][j].pathNum+mat[i][j-1].pathNum;		// If path along x==path along y(by price)- count both paths as potential path

				}
				else if(xprice>yprice) {
					mat[i][j].pathNum=mat[i-1][j].pathNum;

				}
				else {
					mat[i][j].pathNum=mat[i][j-1].pathNum;

				}
			}
		}





		return mat [m-1][n-1];		


	}
	
	public static boolean condition(int x,int y) {
		return (x==y);
		
	}
	public static int choosePathBy(int j,int i, Node [][]mat, int turns) {
		
		int count=0;
		int y= mat[i-1][j].price+mat[i-1][j].y;
		int x= mat[i][j-1].price+mat[i][j-1].x;
		boolean condition=condition(x,y);
		if(condition) {
			while(i>0 && j>0) { //check both
				
				y= mat[i-1][j].price+mat[i-1][j].y;
				x= mat[i][j-1].price+mat[i][j-1].x;
				
				
				if (y<x) {
					count++;
					i--;
				}
				else if(x>y ) {
					count++;

					j--;
				}
				else {//both paths work!
					turns+=count;
					choosePathBy(j,i,mat,turns);
				}
			}
		}
		
		return count;
		
	}

	
	public static String onePath(Node [][]mat)// O(M+N)
	{

		int i= mat.length -1;
		int j= mat[0].length -1;
		String ans="";
		boolean ybigger=false;
		if(i>j) {
			ybigger=true;
		}
		
		while(i>0 && j>0) { //check both
			
			int y= mat[i-1][j].price+mat[i-1][j].y;
			int x= mat[i][j-1].price+mat[i][j-1].x;
			
			
			if (y<x) {
				ans="1"+ans;
				i--;
			}
			else if(x<y ) {
				ans= "0"+ans;
				j--;
			}
			else {
				int xCount=choosePathBy(i,j-1,mat,0);
				int yCount=choosePathBy(i,j-1,mat,0);
				if (xCount<yCount) {
					
				}
				//both paths work!
				
			}
		}
		if(ybigger) {
			while(i>0) {
				ans="1"+ans;
				i--;
			}
			
		}
		else {
			while(j>0) { //fill both
				ans="0"+ans;
				j--;
			}
		}
	
	
		return ans;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Node [][] mat=setUp(4,5);
		//printMatrix(mat);
		//Node peak=bestPath(mat);
		//System.out.println("**done**");
		//System.out.println(peak.toString());
		//System.out.println("**new mtrx**");
		//printMatrix(mat);
		//System.out.println(onePath(mat));

		Node[][] Arr2= {{new Node(1,5),new Node(4,1), new Node(0,6)},{new Node(4,7),new Node(2,5),new Node(1,5),new Node(0,3)},{new Node(1,0),new Node(2,0),new Node(0,0)}};
		printMatrix(Arr2);
		Node peak2=bestPath(Arr2);
		System.out.println(peak2.toString());
		System.out.println(onePath(Arr2));
	}

}
