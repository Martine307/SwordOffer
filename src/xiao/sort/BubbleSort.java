package xiao.sort;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int a[]){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j+1]<a[j]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			System.out.println(Arrays.toString(a));
		}
		return a;
	}
	public static int[] optimizeBubbleSort(int []a){
		
		for(int i=0;i<a.length;i++){
			boolean swap=false;
			for(int j=0;j<a.length-i-1;j++){
				if(a[j+1]<a[j]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					swap=true;
				}
			}
			
			if(!swap){
				return a;
			}
		}
		return a;
	}
	public static void display(int []a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={3,7,2,1,4,6,25};
		int b[]=bubbleSort(a);
		display(b);
	}

}
