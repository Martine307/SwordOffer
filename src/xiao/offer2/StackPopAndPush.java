package xiao.offer2;

import java.util.Stack;

public class StackPopAndPush {

	
	public boolean isPopOrder(int a[],int b[]){
		if(a==null||b==null||a.length<=0||b.length<=0) return false;
		
		Stack<Integer> s=new Stack<>();
		int count=0;
		for(int i=0;i<a.length;i++){
			s.push(a[i]);
			
			
			while(!s.isEmpty()&&s.peek()==b[count]){
				s.pop();
				count++;
			}
		}
		return s.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
