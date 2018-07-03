package xiao.offer3;

import java.util.Arrays;

public class InversePairs {
	static int count;
	public static void mergeSort(int arr[],int low,int high){
		int mid=(low+high)/2;
		if(low<high){
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,high);
		}
	}
	public static void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int i=low; int j=mid+1;
		int temp[]=new int[high-low+1];
		int k=0;
		while(i<=mid&&j<=high){
			if(arr[i]>arr[j]){
				temp[k++]=arr[j++];
				
				count+=mid-i+1;
			}else{
				temp[k++]=arr[i++];
			}
		}
		
		while(i<=mid){
			temp[k++]=arr[i++];
		}
		while(j<=high){
			temp[k++]=arr[j++];
		}
		
		for(int pointer=0;pointer<temp.length;pointer++){
			arr[low+pointer]=temp[pointer];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 7,5,6,4 };
        mergeSort(a, 0, a.length - 1);
        System.out.println("ÅÅÐò½á¹û£º" + Arrays.toString(a));
        System.out.println(count);
	}

}
