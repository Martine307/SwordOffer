package xiao.offer;

public class PrintOneToMaxN {
	public static void printOneToMaxN(int n){
		if(n<=0) return;
		
		StringBuffer s=new StringBuffer();
		for(int i=0;i<n;i++){
			s.append('0');
		}
		while(!increment(s)){
			printN(s);
		}
	}
	public static boolean increment(StringBuffer s){
		boolean isOverFlow=false;
		int isTake=0;
		int len=s.length();
		for(int i=len-1;i>=0;i--){
			int sum=s.charAt(i) -'0'+isTake;
			
			if(i==len-1) sum++;
			if(sum>=10){
				if(i==0){
					isOverFlow=true;
				}else{
					sum-=10;
					isTake=1;
					s.setCharAt(i, (char)( '0'+sum));
				}
			}else{
				s.setCharAt(i, (char) ('0'+sum));
				
				break;
			}
		}
		return isOverFlow;
	}
	public static void printN(StringBuffer s){
		boolean isBegin=true;
		
		for(int i=0;i<s.length();i++){
			if(isBegin&&s.charAt(i)!='0'){
				isBegin=false;
			}
			
			if(!isBegin){
				System.out.print(s.charAt(i));
			}
			
			
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printOneToMaxN(2);
		//System.out.println('b'-'a');
		System.out.println(('0'+12));
	}

}
