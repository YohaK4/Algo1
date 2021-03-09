package lisAndLds;

public class Ls {



	public static String lis (int[] arr) {
		int []helparr=new int[arr.length];
		String lis="DONE~! ";
		int maxI=0;
		int max=1;
		for (int i = 0; i < helparr.length; i++) {
			helparr[i]=1;
		}//HASAMA

		for (int i = 0; i < helparr.length; i++) {

			for (int j = 0; j < i; j++) {		//O(N?) O(LOGN?)

				if(arr[i]>arr[j]) {
					if(helparr[i]<helparr[j]+1) {
						helparr[i]++;
						maxI=i;
					}
				}
			}
		}//helpArr-full with max-Find INDEX

		for (int i = 0; i < helparr.length; i++) {
			max=Math.max(max, helparr[i]);
		}
		System.out.println("LIS size: "+max);
		
		
		for (int i = helparr.length-1; i >0; i--) {
			
			for (int j = 0; j <i; j++) {
				if(helparr[i]==max &&helparr[i]==helparr[j]+1) {
					lis=arr[i]+", "+lis;
					//System.out.println(arr[i]);
					max--;
				}
				
			}
		}
		lis=arr[0]+", "+lis;
		return lis;
		//works great

	}
	
	public static String lds (int[] arr) {
		int []helparr=new int[arr.length];
		int max=1;
		String lds="DONE~! ";
		for (int i = 0; i < helparr.length; i++) {
			helparr[i]=1;
		}//HASAMA

		for (int i = 0; i < helparr.length; i++) {

			for (int j = 0; j < i; j++) {		//O(N?) O(LOGN?)

				if(arr[i]<arr[j]) {		//Only change from LIS
					if(helparr[i]<helparr[j]+1) {
						helparr[i]++;
					}
				}
			}
		}//helpArr-full with max-Find INDEX


		for (int i = 0; i < helparr.length; i++) {
			max=Math.max(max, helparr[i]);
		}
		System.out.println("LDS size: "+max);
		for (int i = helparr.length-1; i >1; i--) {
			
			for (int j = 0; j <i; j++) {
				if(helparr[i]==max &&helparr[i]==helparr[j]+1) {
					lds=arr[i]+", "+lds;
					//System.out.println(arr[i]);
					max--;
				}
				
			}
		}
		return lds;
		//works great

	}







	public static void main(String[] args) 
	{
		int[] arr=new int[] {1,2,3,4,5,6,1,2,7,8,3,4,5,6,7,8,9,8,7,6,5,4,3,2,1,0,-1,-2};
		System.out.println("LIS: "+lis(arr));
		System.out.println("LDS: "+lds(arr));

	}
}
