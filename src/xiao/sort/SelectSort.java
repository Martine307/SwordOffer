package xiao.sort;

public class SelectSort {
	public static int[] selectSort(int []array){
		int min=0;
		int len=array.length;
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len-1;j++){
				if(array[j]<array[min]) min=j;
			}
			
			int temp=array[i];
			array[i]=array[min];
			array[min]=temp;
			
		}
		return array;
	}
	
	public static void display(int []a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={3,7,2,1,4,6,25};
		int b[]=selectSort(a);
		display(b);
	}

}
