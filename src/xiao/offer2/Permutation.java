package xiao.offer2;

public class Permutation {
	/**
	 * ��Ŀ������һ���ַ���������ַ�������������
	 * ˼·����abc������a�Ⱥ��Լ����������������bc�����У�a�ٺ�b���������������ac�����У�a��c���������������bc�����С�
	 * a��b�������󣬳�Ϊbac����Ҫa�ٺ�c����������Ҫ�Ȱ�a��b�Ľ����ٻ���ȥ��
         *
	 */
	public static void swap(char[] c, int i,int j){
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	public static void permutation(char[] c,int low,int high){
		// ���lowָ�������һ���ַ�  
		if(low==high)
			System.out.println(c);
		//int i=0;
		 // lowָ��ǰ���������в������ַ����ĵ�һ���ַ�  
		for (int i = low; i <= high; i++)
	    {
	            swap(c,low, i);
	            permutation(c, low+1, high);
	            swap(c,low,i); //��ԭ���Ľ�����ԭ���Ա�֤���ν�ÿ���ַ�������λ���еݹ顣
	    }
	}
	
	public static void main(String[] args){
		char[] str = {'a','b','c'};
		permutation(str,0,str.length-1);
	}
}
