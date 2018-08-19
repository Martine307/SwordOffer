package xiaozhaoti;

import java.util.Arrays;
import java.util.Scanner;

public class wangyi2 {
	
	public static int getScore(int arr[],int cols){
		Arrays.sort(arr);
		
		int num[]=new int[cols];
		for(int j=1;j<=cols;j++){
			for(int i=0;i<arr.length;i++){
			
				if(arr[i]==j) {
					num[j-1]++;
					
				}
				
			}
			
		}
		
		int min=num[0];
		for(int i=1;i<num.length;i++){
			
			if(num[i]<min) min=num[i];
		}
		if(min==0) return 0;
		else return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[]=new int[]{1, 1, 2 ,2, 2 ,3 ,1, 2 ,3};
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int arr[]=new int[m];
		for(int i=0;i<m;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println(getScore(arr,n));
	}

}
