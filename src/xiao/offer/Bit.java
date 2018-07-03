package xiao.offer;

public class Bit {
	public static int getNumber(int n){
		int flag=1;
		int count=0;
		while(flag!=0){
			if((flag&n)!=0) count++;
			
			flag=flag<<1;
		}
		return count;
	}
	public static int getNumber1(int n){
		
		int count=0;
		while(n!=0){
			count++;
			
			n=n-1&n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getNumber1(3));
	}

}
