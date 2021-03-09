package planeProb;

import java.awt.Point;
import java.util.Arrays;

class DoubleNode {
	double price,x,y;

	public DoubleNode(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {

		String toString="| ";
		if (this.y!=0) {toString=toString+this.y+"v ";//print y

		}
		else {
			toString="   "+toString+"   ";
		}
		if (this.x!=0) {toString=toString+this.x+"-> ";//print x

		} else {
			toString="   "+toString+"   ";
		}

		//return ("Price X= "+this.x+" Price Y= "+this.y);
		if(this.price!=0) 
		{
			toString=toString+", pr= "+this.price+" | ";

		}
		
		return toString;
	}
	
}

public class DeadZone {
	
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
	public static int minPriceWuthDeadArea(Node[][] mat, Point p1, Point p2) {
		DoubleNode[][] mat2 = createNewMatrix(mat, p1, p2);
		for (int i = 0; i < mat2.length; i++) {
			System.out.println(Arrays.toString(mat2[i]));
		}
		return minPrice(mat2);
	}

	private static DoubleNode[][] createNewMatrix(Node[][] mat, Point p1, Point p2) {
		int n = mat.length;
		int m = mat[0].length;
		DoubleNode[][] newMat = new DoubleNode[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i >= p1.y && i <= p2.y && j >=p1.x && j <= p2.x) {
					newMat[i][j] = new DoubleNode(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
				}
				else {
					newMat[i][j] = new DoubleNode(mat[i][j].x, mat[i][j].y);
				}
			}
		}
		return newMat;
	}

	public static int minPrice(DoubleNode[][] mat) {
		int n = mat.length, m = mat[0].length;
		mat[0][0].price = 0;
		for (int i = 1; i < n; i++) { mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;}
		for (int i = 1; i < m; i++) { mat[0][i].price = mat[0][i-1].price + mat[0][i-1].x;}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				mat[i][j].price = Math.min(mat[i-1][j].price + mat[i-1][j].y, mat[i][j-1].price + mat[i][j-1].x);
			}
		}
		if(mat[n-1][m-1].price == Double.POSITIVE_INFINITY) return -1;
		return (int) mat[n-1][m-1].price;
	}

	public static void main(String[] args) {
		Node[][] mat = {
				{new Node(1,5),new Node(4,1),new Node(0,6)},
				{new Node(4,7),new Node(2,5),new Node(0,3)},
				{new Node(1,0),new Node(2,0),new Node(0,0)}};
		
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println("\n"+"newMat after dead zone: "+"\n");
		System.out.println(minPriceWuthDeadArea(mat,new Point(1,1),new Point(2,1)));
		
	
		
		Node[][] mat2=setUp(7,8);
		for (int i = 0; i < mat2.length; i++) {
			System.out.println(Arrays.toString(mat2[i]));
		}


		System.out.println("\n"+"newMat after dead zone: "+"\n");
		System.out.println("New min Price="+minPriceWuthDeadArea(mat2,new Point(0,0),new Point(2,1)));
		
	}
}
