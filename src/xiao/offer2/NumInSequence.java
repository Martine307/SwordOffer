package xiao.offer2;
/*
 * 主要思路：
举例分析，比如找第1001位数字，
1）1位数的数值有10个：0~9，数字为10×1=10个，显然1001>10，跳过这10个数值，在后面找第991（1001-10）位数字。
2）2位数的数值有90个：10~99，数字为90×2=180个，且991>180，继续在后面找第811（991-180）位数字。
3）3位数的数值有900个：100~999，数字为900×3=2700个，且811<2700，说明第811位数字在位数为3的数值中。由于811=270×3+1，所以第811位是从100开始的第270个数值即370的第二个数字，就是7。
按此规律，可求出其他数字。

关键点：位数的数值个数

时间复杂度：O(logn)，按位数进行查找
 */
public class NumInSequence {
	
	public int numInSequence(int index){
		if(index<0) return -1;
		
		int digits=1;
		while(true){
			int numbers=countOfIntegers(digits);
			if(index<numbers*digits){
				return getNum(index, digits);
			}
			
			index=index-numbers*digits;
			digits++;
		}
	}
	
	public int getNum(int index,int digits) {
		// TODO Auto-generated method stub
		int beginnum=0;
		if(digits==1) beginnum=0;
		else beginnum=(int) Math.pow(10, digits-1);
		
		int number=beginnum+index/digits;
		int indexfromright=digits-index%digits;
		for(int i=1;i<indexfromright;i++)
			number/=10;
		return number%10;
	}

	public int countOfIntegers(int digits) {
		// TODO Auto-generated method stub
		if(digits==1) return 10;
		
		return 9*(int) Math.pow(10, digits-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumInSequence().numInSequence(1001));
	}

}
