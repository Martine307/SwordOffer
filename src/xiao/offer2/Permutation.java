package xiao.offer2;

public class Permutation {
	/**
	 * 题目：输入一个字符串，输出字符串的所有排列
	 * 思路：拿abc来讲，a先和自己作交换，后面就是bc的排列，a再和b做交换，后面就是ac的排列，a和c作交换，后面就是bc的排列。
	 * a和b做交换后，成为bac，想要a再和c作交换，就要先把a和b的交换再换回去。
         *
	 */
	public static void swap(char[] c, int i,int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	public static void permutation(char[] c,int low,int high){
		// 如果low指向了最后一个字符  
		if(low==high)
			System.out.println(c);
		//int i=0;
		 // low指向当前我们做排列操作的字符串的第一个字符  
		for (int i = low; i <= high; i++)
	    {
	            swap(c,low, i);
	            permutation(c, low+1, high);
	            swap(c,low,i); //将原来的交换还原，以保证依次将每个字符换到首位进行递归。
	    }
	}
	
	public static void main(String[] args){
		char[] str = {'a','b','c'};
		permutation(str,0,str.length-1);
	}
}
