package xiao.offer3;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
	
	public int getDepth(TreeNode root){
		if(root==null) return 0;
		return Math.max(getDepth(root.left),getDepth(root.left))+1;
	}
	//²ã´Î±éÀú
	public int getDepth2(TreeNode root){
		if(root==null) return 0;
		TreeNode p=root;
		int count=0;
		int depth=0;
		int nextcount=1;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.offer(p);
		while(queue.size()!=0){
			TreeNode top=queue.poll();
			count++;
			if(top.left!=null)
			queue.offer(top.left);
			if(top.right!=null)
			queue.offer(top.right);
			if(count==nextcount){
				count=0;
				nextcount=queue.size();
				depth++;
			}
			
			
		}
		return depth;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(5);  
        TreeNode n2 = new TreeNode(3);  
        TreeNode n3 = new TreeNode(7);  
        TreeNode n4 = new TreeNode(2);  
        TreeNode n5 = new TreeNode(4);  
        TreeNode n6 = new TreeNode(6);  
        TreeNode n7 = new TreeNode(8);  
//      TreeNode n8 = new TreeNode(8);  
//      TreeNode n9 = new TreeNode(9);  
          
        n1.left = n2;  
        n1.right = n3;  
          
        n2.left = n4;  
        n2.right = n5;  
          
        n3.left = n6;  
        n3.right = n7;  
          
//      n4.left = n8;  
//      n4.right = n9;  
       
        System.out.println(new TreeDepth().getDepth2(n1)); 
	}

}
