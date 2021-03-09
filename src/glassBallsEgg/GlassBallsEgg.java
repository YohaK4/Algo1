package glassBallsEgg;

import java.util.Arrays;
import java.util.Iterator;

public class GlassBallsEgg {
	/***
	 * 
	 * 
	 * 
	 * @Author Yoha K4$ 
	 */
	public static void printMatrix(int[][] matrix) {
		System.out.printf("      N");
		System.out.println("");
		System.out.println("K");
		//System.out.println("\n");
		//System.out.println();
		for (int col = 1; col < matrix[0].length; col++) {
			System.out.printf("%4d", matrix[1][col]);

		}
		System.out.println();

		System.out.println("");
		for (int row = 2; row < matrix.length; row++) {
			for (int col = 1; col < matrix[row].length; col++) {
				System.out.printf("%4d", matrix[row][col]);
				if(col>=10) { System.out.printf(" ");}
			}
			System.out.println();
		}
	}



	/*public static int firstFloorThrow (int k, int n) {
		int h=n;
		//int[]arr=new int[k];
		for (int i = k; i > 0; i--) {
			int temp=(i,h);//==9
			h=n-temp;

			System.out.print(i+" ");
			System.out.println(temp);

			//arr[i-1]=h;


		}


		return h;
	}*/

	public static int step(int k, int lastBreak, int lastemp)
	{
		int step=0;
		int i=lastemp;
		for (int j = k; j >1; j--) {
			int tempstep=SearchminThrows(k,lastBreak-i);
			i+=tempstep;
			step+=tempstep;
			System.out.println("j infor= "+j+" stepin for = " +step);
			i=step;
			System.out.println("i="+i);
		}
		return step;
	}




	public static String findPathForWorker(int k, int n, int brk) {
		//optimize
		if(k>Math.log(n)) {
			//print binarysearch
		}

		int first=SearchminThrows(k,n);//FIRST THROW
		int temp=first;//also max checks
		String path="Path for worker= ";
		int lastBrk=n;
		int count=0;//check for min throw
		int i=first;
		int step=first;
		int lastemp=0;
		while (i > lastemp && lastBrk < n+1 && k>1) {
			path=path + temp+" ,";
			if (k<2) {
				break;
			}
			if(i>n+1) {
				return "no break";
			}

			if(i < brk) {

				step = SearchminThrows(k,lastBrk-i);
				i += step;
				lastemp = temp;
				//System.out.println("temp="+temp);
				temp += step;

				//System.out.println("temp="+temp);
				//System.out.println("lststemp="+lastemp);
			}
			else {
				//System.out.println("* "+i);
				//lasti=step;
				lastBrk = temp;
				lastBrk--;
				i = lastemp + 1;
				temp = i;
				path=path +"Break, "+"\n";
				// System.out.println("lstsBRK="+lastBrk);
				//  System.out.println("lststemp="+lastemp);
				//  System.out.println("temp="+temp);
				//  System.out.println("! "+i);
				k--;
			}
			//System.out.println("step="+step);

			count++;
			//System.out.println(path);
		}
		//temp=n-lasti;//for (int j = temp; j <= brk; j++) {
		//temp=i-laststep;
		//System.out.println("!!!!temp="+temp);

		for (int j = lastemp+1; j <= brk; j++) {
			if(j==lastBrk+1) {
				path=path +"\n"+"Breaks exat at "+(lastBrk+1);
				path=path +"\n"+"Checks="+count;
				path=path +"\n"+"*******DONE************"+"\n"+"\n";
				return path;


			}
			//System.out.println("j="+j);
			//System.out.println("temp="+temp);
			path=path+temp+" ,";
			count++;
			temp++;


		}

		//System.out.println("count="+count);
		path=path +"\n"+"Breaks exat at "+lastBrk;
		path=path +"\n"+"Checks="+count;
		path=path +"\n"+"*******DONE************"+"\n"+"\n";
		return path;

	}













	/*
	public static String findPathForWorker (int k, int n, int brk) {
		String path="";
		int countToCheck=0;
		int jump = firstFloorThrow(k,n);
		path+=jump+" ,";
		int step= jump-1;
		System.out.println("frst floor: "+jump);
		for (int i = k; i >0; i--) {

			while (jump<brk) {
				jump=jump+step;
				step--;
				//System.out.println(jump);
				path+="h= "+jump+", ";
				countToCheck++;
			}
			System.out.println("brk index"+(i+1)+" ball breaks at floor: "+jump);
			path+="\n"+" Break!" +"\n";
			jump=jump-step-1;

		}
		System.out.println("check count"+countToCheck);


		path+="\n"+" Break!" +"\n";

		path+=" Final! brk="+brk;
		return path;

	}		*/




	public static int[][] GlassballsminThrows (int k, int n) {

		int [][] fixmat=new int[k+1][n+1];
		fixmat[0][0]=0; //cant have no balls or no floors!		
		fixmat[1][0]=1;
		for (int i = 1; i < k+1; i++) {
			fixmat[i][1]=1;	
		}

		for (int j = 1; j < n+1; j++) {
			fixmat[1][j]=j;

		}

		int h=0;
		int minh=n;
		//printMatrix(fixmat);
		for (int i = 2; i < k+1; i++) {
			//System.out.println("1st");
			for (int j = 2; j < n+1; j++) {
				//System.out.println("2nd");
				minh=n;
				for (int x = j; x > 0; x--) {

					//System.out.println("3ed");
					//System.out.println("long"+fixmat[i][j-x]);
					//System.out.println("short"+fixmat[i-1][x-1]);

					h=(Math.max((fixmat[i][j-x]),(fixmat[i-1][x-1])));
					//System.out.println(h);
					if (h<minh) 
					{
						minh=h;
						//System.out.println("minimal floor= "+(n-minh));	

					}


				}

				fixmat[i][j]=minh+1;								
				//int h=0;
				//	fixmat[i][j]=1+Math.min(				
				//int max=Math.max((n-h, k),(h-1,k-1));
				
			}

		}

		//printMatrix(fixmat);
		return fixmat;
	}



	public static int SearchminThrows (int k, int n) {
		if(k==0||n==0) {
			System.out.println("error: n!=0 && k!=0");
			return -1;
		}
		else {
			int [][] tempmat= GlassballsminThrows(k,n);
			int minh=n;
			int minh2=n;
			//Shitat HaSHIKOR-WHen WIll I get floor that gives max
			for (int i = 2; i <= k; i++) {
				//System.out.println("1st");
				for (int j = 0; j <= n; j++) {
					//System.out.println("2nd");
					if(tempmat[i][j]==tempmat[k][n]) 
					{

						System.out.println(minh);
						minh= (Math.min(j,minh));
					}
					

				}

				if(k==3) {
					System.out.println("minh= "+minh);
				}
				else {
					System.out.println("minh= "+(n/2-minh));
				}

			}


			return tempmat[k][n];
		}

	}


	public static int[][] GlassballsminThree (int n) 
	{


		int [][] fixmat=new int[4][n+1];
		fixmat[0][0]=0; //cant have no balls or no floors!		
		fixmat[1][0]=1;
		for (int i = 1; i < 4; i++) {
			fixmat[i][1]=1;	
		}

		for (int j = 1; j < n+1; j++) {
			fixmat[1][j]=j;

		}

		int h=0;
		int minh=n;
		//printMatrix(fixmat);
		for (int i = 2; i < 4; i++) {
			//System.out.println("1st");
			for (int j = 2; j < n+1; j++) {
				//System.out.println("2nd");
				minh=n;
				for (int x = j; x > 0; x--) {

					//System.out.println("3ed");
					//System.out.println("long"+fixmat[i][j-x]);
					//System.out.println("short"+fixmat[i-1][x-1]);

					h=Math.max((fixmat[i][j-x]),(fixmat[i-1][x-1]));
					//System.out.println(h);
					if (h<minh) {
						minh=h;
					}


				}
				fixmat[i][j]=minh+1;

				//int h=0;
				//	fixmat[i][j]=1+Math.min(				
				//int max=Math.max((n-h, k),(h-1,k-1));
			}


		}


		return fixmat;
	}

	public static void main(String[] args) 
	{
		int [][] mat=GlassballsminThrows(3,100);
		printMatrix(mat);
		System.out.println(SearchminThrows(7,100));
		//GlassballsminFloor(3,100);
		//printMatrix(mat);
		//System.out.println(SearchminThrows(3,100));
		//System.out.println(findPathForWorker(3,100,8));
		//System.out.println(findPathForWorker(3,100,99));
		//System.out.println(findPathForWorker(2,100,13));
		//	System.out.println(findPathForWorker(2,100,99));
		//	//Arrays.toString(GlassballsminThree(100));

	}

}
