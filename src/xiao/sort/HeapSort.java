package xiao.sort;

import java.util.Arrays;

public class HeapSort {
	
	
	public static void heapSort(int array[]){
		buildHeap(array);
		int sortlength=array.length-1;
		while(sortlength>0){
			int temp=array[0];
			array[0]=array[sortlength];
			array[sortlength]=temp;
			sortlength--;
			
			maxHeap(array,0,sortlength);
		}
		
	}
	
	public static void maxHeap(int array[],int index,int len){
		int largest=index;
		int left=index*2+1;
		int right=index*2+2;
		
		if(left<array.length&&array[left]>array[largest]&&left<=len){
			largest=left;
			
		}
		if(right<array.length&&array[right]>array[largest]&&right<=len){
			largest=right;
			
		}
		
		if(index!=largest){
			int temp=array[index];
			array[index]=array[largest];
			array[largest]=temp;
			
			maxHeap(array,largest,len);
		}
	}
	 public static void adjustHeap(int []arr,int i,int length){
	        int temp = arr[i];//先取出当前元素i
	        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
	            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
	                k++;
	            }
	            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
	                arr[i] = arr[k];
	                i = k;
	            }else{
	                break;
	            }
	        }
	        arr[i] = temp;//将temp值放到最终的位置
	    }
	public static void buildHeap(int array[]){
		int len=array.length;
		int first_non_leaf=(len-1)/2;
		System.out.println(first_non_leaf);
		for(int i=first_non_leaf;i>=0;i--){
			maxHeap(array,i,len);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]b={16,4,10,14,7,9,3,2,8,1};
		heapSort(b);
		System.out.println(Arrays.toString(b));
	}

}
