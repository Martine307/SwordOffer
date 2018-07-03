package xiao.offer3;

public class UglyNumber {
	public int getUglyNumber(int index){
		if(index<=0) return 0;
		int arr[]=new int[index];
		arr[0]=1;
		int count=1;
		
		int index2=0;
		int index3=0;
		int index5=0;
		while(count<index){
			int min=getMin(arr[index2]*2,arr[index3]*3,arr[index5]*5);
			arr[count]=min;
			while(arr[index2]*2<=arr[count]) index2++;
			while(arr[index3]*3<=arr[count]) index3++;
			while(arr[index5]*5<=arr[count]) index5++;
			
			count++;
			
		}
		return arr[index-1];
	}
	public int getMin(int i, int j, int k) {
		int min=(i<j) ? i:j;
		min=(min<k) ? min:k;
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=new UglyNumber().getUglyNumber(1500);
		System.out.println(i);
	}

}
