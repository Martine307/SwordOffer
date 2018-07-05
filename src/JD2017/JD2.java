package JD2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
//采购单（京东2017秋招真题）
public class JD2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int priceNum=sc.nextInt();
			int listNum=sc.nextInt();
			ArrayList<Integer> price=new ArrayList<>();
			for(int i=0;i<priceNum;i++){
				price.add(sc.nextInt());
			}
			
			HashMap<String,Integer> map=new HashMap<>();
			for(int i=0;i<listNum;i++){
				String object=sc.next();
				if(map.containsKey(object)){
					int count=map.get(object);
					count++;
					map.put(object, count);
				}else{
					map.put(object, 1);
				}
			}
			Collection<Integer> c=map.values();
			ArrayList<Integer> al=new ArrayList<>(c);
			Collections.sort(price);
			Collections.sort(al);
			int max=0;int min=0;
			for(int i=0;i<al.size();i++){
				max+=al.get(al.size()-i-1)*price.get(price.size()-i-1);
				min+=al.get(al.size()-i-1)*price.get(i);
				
			}
			System.out.print(min+" "+max+"\n");
			
		}
		
	}

}
