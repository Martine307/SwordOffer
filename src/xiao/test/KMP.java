package xiao.test;

public class KMP {
	
	public int[] getNext(String ps){
		char[] p=ps.toCharArray();
		int next[]=new int[p.length];
		next[0]=-1;
		int j=0;
		int k=-1;
		
		while(j<p.length-1){
			if(k==-1||p[j]==p[k]){
				next[++j]=++k;
			}else{
				k=next[k];
			}
		}
		return next;
		
	}
	
	public int kmp(String ts,String ps){
		char[]t=ts.toCharArray();
		char[]p=ps.toCharArray();
		int[] next=getNext(ps);
		int i=0;
		int j=0;
		while(i<t.length&&j<p.length){
			if(t[i]==p[j]||j==-1){
				i++;
				j++;
			}else{
				j=next[j];
			}
		}
		if(j==p.length) return i-j;
		return -1;
	}
		
}
