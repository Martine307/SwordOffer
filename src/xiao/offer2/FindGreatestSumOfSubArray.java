package xiao.offer2;

public class FindGreatestSumOfSubArray {
	
		/*
		算法时间复杂度O（n）
		用total记录累计值，maxSum记录和最大
		基于思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
		          整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。
		此时 若和大于maxSum 则用maxSum记录下来
		b[j]=max{b[j-1]+a[j], a[j]}，b[j] 指的是从0开始到j的最大子段和
		*/
	public int findSum(int arr[]){
		if(arr==null||arr.length<=0) return 0;
		int total=arr[0];
		int maxsum=arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			if(total>=0)total+=arr[i];
			else total=arr[i];
			
			if(total>maxsum) maxsum=total;
		}
		return maxsum;
	}
	//dp
	public int findSum2(int arr[]){
		int total=arr[0];
		int maxsum=arr[0];
		for(int i=1;i<arr.length;i++){
			
			total=Math.max(arr[i], total+arr[i]);
			maxsum=Math.max(total, maxsum);
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		int arr[]={1,-2,3,10,-4,7,2,-5};
		System.out.println(new FindGreatestSumOfSubArray().findSum2(arr));
	}
}
