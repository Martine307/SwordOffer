package netease;

import java.util.Scanner;

public class Test1 {

	public StringBuffer machine(int n){
		StringBuffer sb= new StringBuffer();
		while(n>0){
			if(n%2==0){
				n=(n-2)/2;
				sb.append("2");
			}else{
				n=(n-1)/2;
				sb.append("1");
			}
		}
		
		sb=sb.reverse();
		return sb;
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		StringBuffer s=new Test1().machine(n);
		System.out.println(s);
	}

}
