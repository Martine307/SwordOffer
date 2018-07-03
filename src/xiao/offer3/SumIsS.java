package xiao.offer3;

import java.util.ArrayList;
import java.util.Arrays;

public class SumIsS {
	
	public ArrayList<Integer> getTwoNum(int arr[],int s){
		ArrayList<Integer> list=new ArrayList<>();
		
		if(arr==null||arr.length<2) return list; ;
		
		int low=0;
		int high=arr.length-1;
		
		while(low<high){
			int plus=arr[low]+arr[high];
			if(plus==s) {
				
				list.add(arr[low]);
				list.add(arr[high]);
				return list;
			}else if(plus<s){
				low++;
			}else{
				high--;
			}
		}
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,4,7,11,15};
		System.out.println(Arrays.toString(new SumIsS().getTwoNum(a, 15).toArray())); 
	}

}
