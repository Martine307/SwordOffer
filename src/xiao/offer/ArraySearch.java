package xiao.offer;

public class ArraySearch {

	public static int getIndex(int array[],int n){
		if(array==null||array.length==0) return -1;
		
		int low=0;
		int high=array.length-1;
		int mid=low;
		
		while(low<=high){
			
			mid=low+(high-low)/2;
			if(array[mid]==n) return mid;
			
			if(array[mid]>array[low]){
				if(n>=array[low]&&n<=array[mid]){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}else{
				if(n<=array[high]&&n>=array[mid]){
					low=mid+1;
				}else{
					
					high=mid-1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={3,4,5,1,1};
		System.out.println(getIndex(a,1));
	}

}
