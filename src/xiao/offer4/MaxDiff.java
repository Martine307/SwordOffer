package xiao.offer4;

public class MaxDiff {
//63
	public int maxDiff(int arr[]){
		if(arr==null||arr.length<2) return 0;
		
		int min=arr[0];
		int maxDiff=arr[1]-min;
		for(int i=2;i<arr.length;i++){
			if(arr[i-1]<min) min=arr[i-1];
			
			int res=arr[i]-min;
			if(res>maxDiff) maxDiff=res;
		}
		
		return maxDiff;
	}
	
	
	//64
/*//	
	解题思路：
	1.需利用逻辑与的短路特性实现递归终止。
	 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
	3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。*/
	public int getSum(int n){
		int res=n;
		boolean flag=(n>0) && ((res+=getSum(n-1))>0);
		return res;
	}
	
	//65
	

		
	/*//第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。 
	第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
	第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
	继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。*/
	public int add(int num1,int num2){
		while(num2!=0){
			int sum=num1^num2;
			int carry=(num1&num2)<<1;
			num1=sum;
			num2=carry;
		}
		return num1;
	}
	
	
	//66
	
	 
	
		public int[] multiply(int[] A) {
			if(A==null)
				return null;
			int length=A.length;
			int[] B=new int[length];
			B[0]=1;
			//计算左三角
			for(int i=1;i<length;i++){
				B[i]=B[i-1]*A[i-1];
			}
			//计算右三角   temp用来记录有三角每一行的值
			int temp=1;
			for(int i=length-2;i>=0;i--){
				temp*=A[i+1];
				B[i]*=temp;
			}
			return B;
		}
	
	
}
