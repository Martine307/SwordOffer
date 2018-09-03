package zhaohang;

import java.util.ArrayList;
import java.util.Scanner;

public class Z2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> l=new ArrayList<>();
		String s=sc.nextLine();
		String []arr=s.split(" ");
		for(int i=0;i<arr.length;i++){
			l.add(Integer.valueOf(arr[i]));
		}
		/*while(sc.hasNext()){
			
			l.add(sc.nextInt());
		}*/
		for(int i=0;i<l.size();i++)
		System.out.println(l.get(i));
	}

}
