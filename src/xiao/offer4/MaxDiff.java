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
	����˼·��
	1.�������߼���Ķ�·����ʵ�ֵݹ���ֹ��
	 2.��n==0ʱ��(n>0)&&((sum+=Sum_Solution(n-1))>0)ִֻ��ǰ����жϣ�Ϊfalse��Ȼ��ֱ�ӷ���0��
	3.��n>0ʱ��ִ��sum+=Sum_Solution(n-1)��ʵ�ֵݹ����Sum_Solution(n)��*/
	public int getSum(int n){
		int res=n;
		boolean flag=(n>0) && ((res+=getSum(n-1))>0);
		return res;
	}
	
	//65
	

		
	/*//��һ������Ӹ�λ��ֵ�������λ���õ�010��������ÿλ��Ӿ��൱�ڸ�λ����������101^111�� 
	�ڶ����������λֵ���õ�1010���൱�ڸ�λ��������õ�101����������һλ�õ�1010��(101&111)<<1��
	�������ظ����������� ��λ��� 010^1010=1000����λֵΪ100=(010&1010)<<1��
	�����ظ�����������1000^100 = 1100����λֵΪ0������ѭ����1100Ϊ���ս����*/
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
			//����������
			for(int i=1;i<length;i++){
				B[i]=B[i-1]*A[i-1];
			}
			//����������   temp������¼������ÿһ�е�ֵ
			int temp=1;
			for(int i=length-2;i>=0;i--){
				temp*=A[i+1];
				B[i]*=temp;
			}
			return B;
		}
	
	
}
