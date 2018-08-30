package toutiao2017;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		int res=0;
		for(int i=0;i<n;i++){
			if(i+1<n&&arr[i+1]-arr[i]>20){
				res+=2;
				continue;
			}else if(i+1<n&&arr[i+1]-arr[i]>10){
				res+=1;
				i=i+1;
				continue;
			}else if(i+1<n){
				if(i+2<n&&arr[i+2]-arr[i+1]>10){
					res+=1;
					i=i+1;
				}else if(i+2<n){
					i=i+2;
				}else{
					res+=1;
					i=i+1;
				}
			}else{
				res+=2;
			}
		}
		System.out.println(res);
	}

}
