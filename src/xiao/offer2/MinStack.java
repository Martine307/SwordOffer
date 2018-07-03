package xiao.offer2;

import java.util.Stack;

public class MinStack {

	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	public void push(int num){
		s1.push(num);
		
		if(s2.isEmpty()){
			s2.push(num);
		}else{
			if(s2.peek()<num) s2.push(s2.peek());
			else s2.push(num);
		}
	}
	public int pop(){
		int n=s1.pop();
		s2.pop();
		return n;
	}
	public int getMin(){
		return s2.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
