package xiao.sort;

import java.util.Arrays;

public class MergeSort {
	public static void  mergeSort(int []a,int left,int right){
		int mid=(right+left)/2;
		if(left<right){
			
			mergeSort(a,left,mid);
			mergeSort(a,mid+1,right);
			merge(a,left,mid,right);
			System.out.println(Arrays.toString(a));
		}
	}
	
	public static void merge(int []a, int left,int mid,int right){
		int temp[]=new int[right-left+1];
		int i=left;
		int j=mid+1;
		int k=0;
		while(i<=mid&&j<=right){
			if(a[i]<=a[j]){
				temp[k]=a[i];
				k++;
				i++;
			}else{
				temp[k]=a[j];
				k++;
				j++;
			}
		}
		
		while(i<=mid){
			temp[k]=a[i];
			
			k++;
			i++;
		}
		while(j<=right){
			temp[k]=a[j];
			
			k++;
			j++;
		}
		
		
		for(int point=0;point<temp.length;point++){
			a[point+left]=temp[point];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("ÅÅÐò½á¹û£º" + Arrays.toString(a));
	}

}
