package shenxinfu;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int users=sc.nextInt();
		TreeSet<Integer> set=new TreeSet<Integer>();
		for(int i=0;i<users;i++){
			set.add(sc.nextInt());
		}
		System.out.println(set.size());
		for(Integer i:set){
			System.out.println(i);
		}
	}
}
