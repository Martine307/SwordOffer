package xiaozhaoti;

import java.util.Scanner;

public class wangyi1 {
	public static int binarySearch(int arr[],int key){
		int low=0;
		int high=arr.length-1;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(key==arr[mid]) return mid;
			if(key>arr[mid]){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return low;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int numHeap=sc.nextInt();
		int arr[]=new int[numHeap];
		int sum=0;
		for(int i=0;i<numHeap;i++){
			arr[i]=sc.nextInt()+sum;
			sum=arr[i];
		}
		int numSearch=sc.nextInt();
		
		int search[]=new int[numSearch];
		for(int i=0;i<numSearch;i++){
			search[i]=sc.nextInt();
		}
		for(int i=0;i<search.length;i++){
			System.out.println(binarySearch(arr,search[i])+1);
		}
		
	}

}
