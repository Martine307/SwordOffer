package xiao.offer2;

import java.util.ArrayList;
import java.util.Stack;




public class FindPath {

	public ArrayList<ArrayList<Integer>> findPath(TreeLinkNode root, int target){
		
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		Stack<Integer> stack=new Stack<>();
		findPathCore(root,target,stack,res);
		
		return res;
		
	}
	
	public void findPathCore(TreeLinkNode root,int target,Stack<Integer> stack,ArrayList<ArrayList<Integer>>res){
		
		if(root==null||root.val>target) return ;
		
		if(root.left==null&&root.right==null){
			if(root.val==target){
				ArrayList<Integer> al=new ArrayList<>();
				for(int i:stack){
					al.add(i);
					
				}
				
				al.add(root.val);
				res.add(al);
			}
		}else{
			System.out.println("f"+root.val);
			stack.push(root.val);
			findPathCore(root.left,target-root.val,stack,res);
			findPathCore(root.right,target-root.val,stack,res);
			int n=stack.pop();
			System.out.println("d"+n);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode t1=new TreeLinkNode(1);
		TreeLinkNode t2=new TreeLinkNode(2);
		TreeLinkNode t3=new TreeLinkNode(3);
		TreeLinkNode t4=new TreeLinkNode(4);
		TreeLinkNode t5=new TreeLinkNode(5);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.right=t5;
		
		ArrayList<ArrayList<Integer>> l=new FindPath().findPath(t1,7);
		
		for(ArrayList<Integer> i:l){
			for(int j:i){
				System.out.print(j);
				
			}
			System.out.println();
		}
	}

	

}
