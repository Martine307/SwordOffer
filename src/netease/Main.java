package netease;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        for(int i=1;i<=number;i++){
        	int num=sc.nextInt();
        	int a[]=new int[num];
        	for(int j=0;j<num;j++){
        		a[j]=sc.nextInt();
        	}
        	int n4=0,n2=0,odd=0;
        	for(int k=0;k<a.length;k++){
            	if(a[k]%4==0) n4++;
            	else if(a[k]%2==0) n2++;
            	else odd++;
            }
        	
        	if(n2>0){
        		if(n4>=odd){
        			System.out.println("yes");
        		}else{
        			System.out.println("no");}
        		
        	}else{
        		if(n4>=odd-1){
        			System.out.println("yes");
        		}else{
        			System.out.println("no");}
        	}
        }
        
    }
}