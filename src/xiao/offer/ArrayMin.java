package xiao.offer;

public class ArrayMin {
	
	
	public static int getMin(int array[]){
		if(array==null||array.length<=0) return 0;
		
		int low=0;
		int high=array.length-1;
		int mid=low;
		
		while(array[low]>=array[high]){
			if(high-low==1){
				mid=high;
				break;
			}
			
			mid=low+(high-low)/2;
			
			if(array[low]==array[mid]&&array[mid]==array[high]) return getMinInOrder(array,low,high);
			
			if(array[mid]>=array[low]){
				low=mid;
			}else if(array[mid]<=array[high]){
				high=mid;
			}
		}
		
		return array[mid];
	}
	
	public static int getMinInOrder(int a[],int low,int high){
		int min=a[low];
		for(int i=low+1;i<=high;i++){
			if(a[i]<min) min=a[i];
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,4,5,1,2};
		int min=getMin(a);
		System.out.println(min);
	}

}
