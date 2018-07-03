package xiao.offer3;

import java.util.Arrays;

public class FindNumsAppearOnce {
	//a:97 A:65  
	

	//数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
	
	/*利用异或结果的最低位为1的flag将数组中的数字分为两类，一类是与flag按位与为0，
	另一类为不为0，这样再分别异或一次就能够找出这两个数。很是巧妙。
	其中有一个语法上容易忽略的坑：==的优先级比&高，所以&时需要加括号。 */
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
	public int findFirstBit1(int sum) {//从右往左数第一个1
		// TODO Auto-generated method stub
		int index=0;
		//运算符优先级  ==> && > &
		while((sum & 1)==0 && index<4*8){
			sum=sum>>1;
			index++;
		}
		return index;
	}
	
	//一个出现一次 ，其他数字出现3次
	
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
