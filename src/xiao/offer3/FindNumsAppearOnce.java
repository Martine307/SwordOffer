package xiao.offer3;

import java.util.Arrays;

public class FindNumsAppearOnce {
	//a:97 A:65  
	

	//����������������һ�ε����֣��������ֶ��������Σ��ҳ�����������
	
	/*��������������λΪ1��flag�������е����ַ�Ϊ���࣬һ������flag��λ��Ϊ0��
	��һ��Ϊ��Ϊ0�������ٷֱ����һ�ξ��ܹ��ҳ������������������
	������һ���﷨�����׺��ԵĿӣ�==�����ȼ���&�ߣ�����&ʱ��Ҫ�����š� */
	public int[] getNums(int arr[]){
		if(arr==null||arr.length<2) return null;
		int num[]=new int[2];
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum=sum^arr[i];

		}
		System.out.println(sum);
		
		int index=findFirstBit1(sum);
		for(int i=0;i<arr.length;i++){
			if(isBit1(arr[i],index)){
				num[0]^=arr[i];
			}else{
				num[1]^=arr[i];
			}
		}
		return num;
	}
	public boolean isBit1(int i, int index) {
		// TODO Auto-generated method stub
		i=i>>index;
		if((i&1)==1) return true;
		return false;
	}
	public int findFirstBit1(int sum) {//������������һ��1
		// TODO Auto-generated method stub
		int index=0;
		//��������ȼ�  ==> && > &
		while((sum & 1)==0 && index<4*8){
			sum=sum>>1;
			index++;
		}
		return index;
	}
	
	//һ������һ�� ���������ֳ���3��
	
	public int findNumInThree(int a[]){
		int bit[]=new int[32];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<32;j++){
				bit[j]+=((a[i]>>j)&1);
				
			}
		}
		int res=0;
		for(int j=0;j<32;j++){
			if(bit[j]%3!=0){
				System.out.println(j);
				res += (1 << j);
				
				
			}
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]=new int[]{2,4,6,3,4,2};
		int x[]=new FindNumsAppearOnce().getNums(a);
		System.out.println(Arrays.toString(x));
		
		int b[]=new int[]{2,2,2,5};
		int z=new FindNumsAppearOnce().findNumInThree(b);
		System.out.println(z);
	}

}
