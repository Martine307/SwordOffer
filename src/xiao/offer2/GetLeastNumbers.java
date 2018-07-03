package xiao.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
/*
 * 

	˼·һ�����ÿ��������еĻ�ȡ�ָ���ᣩ��λ�ú���getPartitiion��
	��������ĵ�k��������������ʹ�ñȵ�k������С���������ֶ�λ���������ߣ��ȵ�k�����ִ���������ֶ�λ��������ұߡ�
	����֮��λ��������ߵ�k�����־�����С��k�����֣���k�����ֲ�һ��������ģ���O(N)  ��Ҫ�޸�����
 */
	public ArrayList<Integer> getLeastNumbers(int arr[],int k){
		if(arr.length ==0||arr==null||k>arr.length||k<=0)  
            return null;  
		ArrayList<Integer> list=new ArrayList<Integer>();
	    int length = arr.length;  
	   
	    int start = 0;  
	    int end = length -1;  
	    int index = getPivot(arr,start,end);  
	    System.out.println(index);
	    while(index != k-1){  
	        if(index >k-1){  
	            end = index - 1;  
	            index = getPivot(arr,start,end);  
	            System.out.println(index);
	        }  
	        else{  
	            start = index + 1;  
	            index = getPivot(arr,start,end);  
	            System.out.println(index);
	        }  
	       // System.out.println(Arrays.toString(arr));
	    }
	    
	    for(int i=0;i<k;i++)
	    { 
	    	list.add(arr[i]);
	    	System.out.println(arr[i]);
	    }
	    return list;
	}
	public int getPivot(int array[],int low,int high){
		int left=low;
		int right=high;
		int pivot_item=array[left];
		
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
			System.out.println(Arrays.toString(array));
		}
		return right;
	}
	
	
	//���ȶ���(Ĭ����С��---����)ʵ������--����
	
	public ArrayList<Integer> getLeastNumbersByHeap(int arr[],int k){
		if(arr.length ==0||arr==null||k>arr.length||k<=0)  
            return null;  
		ArrayList<Integer> list=new ArrayList<Integer>();
	    int length = arr.length;  
	    
	    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k,new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
	    	
	    });
	

	    	for (int i = 0; i < length; i++) {
	            if (maxHeap.size() != k) {
	                maxHeap.offer(arr[i]);
	            } else if (maxHeap.peek() > arr[i]) {
	                Integer temp = maxHeap.poll();
	                temp = null;
	                maxHeap.offer(arr[i]);
	            }
	        }
	        for (Integer integer : maxHeap) {
	        	list.add(integer);
	        }
	        return list; 
	    
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 33,38, 65, 97, 76, 13, 27, 49 };
		new GetLeastNumbers().getLeastNumbers(a, 3);
	}

}
