package xiao.offer;

import java.util.Stack;

public class TwoStack {
	
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	public void push(int val){
		s1.push(val);
	}
	public int pop(){
		if(s2.empty()){
		while(!s1.isEmpty()){
			int temp=s1.pop();
			s2.push(temp);
		}
		}
		if(!s2.isEmpty()) return s2.pop();
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
