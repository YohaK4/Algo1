package algo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Hezion {
	//******************************************************
	public static int Hezion(int[] a) { //nisiti lemamesh et ze be stail 2 eivarim maximalim
		//ze le tov aval meargel ,anu zrihim max sheni

		if(a.length==1) {
			return a[0];
		}

		int max=Math.max(a[0], a[1]);
		int min = Math.min(a[0], a[1]);
		//int index = 0;
		for (int i = 2; i < a.length-1 && i<7; i+=2) { //ani yaruz al zugot
			if(a[i]<=a[i+1]) {
				min=Math.min(min, a[i]);
				max=Math.max(max, a[i+1]);

			}
			else    //a[i]>a[i+1]
			{
				min=Math.min(min, a[i+1]);
				max=Math.max(max, a[i]);

			}

		}
		if(a.length-1<7 && a.length%2==0) { //bemida ve kamut eviarim izugit
			//nivdok eivar aharon

			max=Math.max(max, a[a.length-1]);//hasam elion
		}
		else
		{
			min=Math.min(min, a[a.length-1]);

		}

	
	return max;


}




//********************************************************
public static void main(String[] args) {
	int arrandom[] = buildArray.buildRandomArray();

	int arrmore[] = buildArray.buildSortIncreasingArray();
	int arrmless[] = buildArray.buildSortDecreasingArray();
	System.out.println("\n~~~~~~~~~~~ Try Random Array ~~~~~~~~~~~");
	int comp1 = Hezion(arrandom); //haiti zarih et ze 
	System.out.println("try1 = " + comp1);
	System.out.println("\n!!!!!!!!!!!!!!!!! Try Array++ !!!!!!!!!!!!!!!!!!!");
	comp1 = Hezion(arrmore);
	System.out.println("try2 = " + comp1);
	System.out.println("\n$$$$$$$$$$$$ Try Array-- $$$$$$$$$$$$$$$$$");
	comp1 = Hezion(arrmless);
	System.out.println("try3 = " + comp1);
	Arrays.sort(arrandom);
	int hezionplus = arrandom[arrandom.length/2 +2];
	System.out.println("Hezion plus "+hezionplus);
	System.out.println("Array length: "+arrandom.length);

}



}

