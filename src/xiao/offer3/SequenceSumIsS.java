package xiao.offer3;

import java.util.ArrayList;
import java.util.Arrays;
//和为s的正整数
public class SequenceSumIsS {
	public ArrayList<ArrayList<Integer>> getS(int s){
		
		if(s<3) return null;
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		int small=1;
		int big=2;
		int sum=small+big;
		
		while(small<(s+1)/2){
			
			//先while 在if
			while(sum<s){
				big++;
				sum+=big;
				
				
			}
			if(sum==s) {
				ArrayList<Integer> sublist=new ArrayList<>();
				for(int i=small;i<=big;i++){
					sublist.add(i);
					
				}
				list.add(sublist);
			}
			
			sum-=small;
			small++;
			
			
			
			
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> l=new SequenceSumIsS().getS(15);
		System.out.println(l.size());
		for(ArrayList<Integer> sub :l){
			System.out.println(Arrays.toString(sub.toArray()));
		}
	}

}
