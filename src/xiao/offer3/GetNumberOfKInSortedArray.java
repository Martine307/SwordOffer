package xiao.offer3;

import java.util.Arrays;

public class GetNumberOfKInSortedArray {
	
	public int getNumber(int arr[],int k){
		if(arr==null||arr.length<=0) return 0;
		int firstK=getFirstK(arr,k,0,arr.length-1);
		int lastK=getLastK(arr,k,0,arr.length-1);
		
		if(firstK!=-1&&lastK!=-1) return lastK-firstK+1;
		return 0;
	}
	private int getLastK(int[] arr, int k, int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return -1;
		int mid=(i+j)/2;
		int num=arr[mid];
		if(num==k){
			if(mid==arr.length-1||mid<arr.length-1&&arr[mid+1]!=k){
				return mid;
			}else{
				i=mid+1;
			}
		}else if(num>k){
			j=mid-1;
		}else{
			i=mid+1;
		}
		return getLastK(arr,k,i,j);
	}
	private int getFirstK(int[] arr, int k, int i, int j) {
		// TODO Auto-generated method stub
		if(i>j) return -1;
		int mid=(i+j)/2;
		int num=arr[mid];
		if(num==k){
			if(mid==0||mid>0&&arr[mid-1]!=k){
				return mid;
			}else{
				j=mid-1;
			}
		}else if(num>k){
			j=mid-1;
		}else{
			i=mid+1;
		}
		return getFirstK(arr,k,i,j);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1,2,3,3,3,3,4,5 };
		int count=new GetNumberOfKInSortedArray().getNumber(a,3);
        
        System.out.println(count);
	}

}
