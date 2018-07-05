package JD2017;

import java.util.Scanner;

public class JD3 {
	public int gys(int num1,int num2){
		if(num1<num2){
			int temp=num1;
			num1=num2;
			num2=temp;
		}
		int c=num1%num2;
		if(c==0){
			return num2;
		}else{
			return gys(num2,c);
		}
		
	}
	
	public int getSum(int num,int n){
		int sum=0;
		while(num!=0){
			sum+=num%n;
			num=num/n;
		}
		
		return sum;
	}
	
	public void getRes(int num){
		if(num==0||num==1) return;
		int sum=0;
		for(int i=2;i<num;i++){
			int bitsum=getSum(num,i);
			sum+=bitsum;
			
		}
		int t=gys(sum,num-2);
		System.out.println(sum/t+"/"+(num-2)/t);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int num=sc.nextInt();
			new JD3().getRes(num);
		}
		
	}

}
