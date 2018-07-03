package xiao.offer3;

import java.util.Arrays;

public class ReverseSentence {

	public String reverseSentence(String s){
		if(s==null||s.length()<=0) return null;
		
		char[] c=s.toCharArray();
		System.out.println(Arrays.toString(c));
		
		reverse(c,0,c.length-1);
		int blank=0;
		for(int i=0;i<c.length;i++){
			if(c[i]==' '){
				
				reverse(c,blank,i-1);
				blank=i+1;
			}
		}
		reverse(c,blank,c.length-1);
		
		return String.valueOf(c);
		
	}
	private void reverse(char[] c, int low, int high) {
		// TODO Auto-generated method stub
		while(low<high){
			char temp=c[low];
			c[low]=c[high];
			c[high]=temp;
			low++;
			high--;
		}
	}
	
	
	//abcdefg->cdefgab
	
	public String leftReverse(String s,int k){
		if(s==null||s.length()<=0||k<=0) return null;
		char[] c=s.toCharArray();
		reverse(c,0,k-1);
		reverse(c,k,s.length()-1);
		reverse(c,0,c.length-1);
		return String.valueOf(c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s=new ReverseSentence().reverseSentence("I am a student.");
		System.out.println(s);
		String x=new ReverseSentence().leftReverse("abcdefg",2);
		System.out.println(x);
	}

}
