package xiao.sort;

import java.util.Arrays;

public class QuickSort {
	
	
	public static void quickSort(int []array,int low,int high){
		int pivot;
		
		if(low<high){
			pivot=getPivot(array,low,high);
			System.out.println(pivot);
			System.out.println(Arrays.toString(array));
			quickSort(array,low,pivot-1);
			quickSort(array,pivot+1,high);
			
		}
	}
	
	
	public static int getPivot(int []array,int low,int high){
		int left=low;
		int right=high;
		int pivot_item=array[low];
		
		while(left<right){
			while(left<right&&array[right]>=pivot_item) right--;
			if(left<right){
				int temp=array[left];
				array[left] = array[right];     
				array[right]=temp;
			}
			
			while(left<right&&array[left]<pivot_item) left++;
			
			if(left<right){
				int temp=array[left];
				array[left] = array[right];   
				array[right]=temp;
			}
			
		}
		return right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
		quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
	}

}
