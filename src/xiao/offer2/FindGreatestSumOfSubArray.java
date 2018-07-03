package xiao.offer2;

public class FindGreatestSumOfSubArray {
	
		/*
		�㷨ʱ�临�Ӷ�O��n��
		��total��¼�ۼ�ֵ��maxSum��¼�����
		����˼�룺����һ����A������A������ۼ����Ǹ�����ô����A��ʹ��ֵ��С��A����Ϊ�ۼ�ֵ��
		          ��������й��׵ġ����ǰ�����ۼ�ֵ����������Ϊ�к����ܺͣ�total��¼��ǰֵ��
		��ʱ ���ʹ���maxSum ����maxSum��¼����
		b[j]=max{b[j-1]+a[j], a[j]}��b[j] ָ���Ǵ�0��ʼ��j������Ӷκ�
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
