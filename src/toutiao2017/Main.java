package toutiao2017;

import java.util.Scanner;
public class Main{
  public int getDays(long x,long f,long d,long p){
	 if(d/x<f) return (int) (d/x);
     return (int) ((d+f*p)/(x+p));
}  
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long x=sc.nextLong();
        long f=sc.nextLong();
        long d=sc.nextLong();
        long p=sc.nextLong();;
        int days=new Main().getDays(x,f,d,p);
        System.out.println(days);
    }
}
