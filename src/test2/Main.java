package test2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int worknum=sc.nextInt();
		int peoplenum=sc.nextInt();
		int a[]=new int[worknum+peoplenum];
		int b[]=new int[peoplenum];
		HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
		for(int i=0;i<worknum;i++){
			int level=sc.nextInt();
			int money=sc.nextInt();
			a[i]=level;
			hs.put(level, money);
		}
		for(int i=0;i<peoplenum;i++){
			int level=sc.nextInt();
			int money=0;
			a[worknum+i]=level;
			b[i]=level;
			if(!hs.containsKey(level)){
				hs.put(level, money);
			}
			
			
		}
		
		
		Arrays.sort(a);
		
		int max=0;
		for(int i=0;i<peoplenum+worknum;i++){
			System.out.println(a[i]);
			int tempmax=Math.max(max, hs.get(a[i]));
			hs.put(a[i],tempmax);
		}
		Iterator it=hs.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) it.next();
			int k=entry.getKey();
			int v=entry.getValue();
			System.out.println(k+"aaa"+v);
		}
		for(int i=0;i<peoplenum;i++){
			System.out.println(hs.get(b[i]));
		}
		
	}

}
