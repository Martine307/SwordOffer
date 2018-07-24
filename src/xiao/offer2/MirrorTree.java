package xiao.offer2;

import java.util.Stack;

public class MirrorTree {
	public void getMirror(TreeLinkNode root){
		if(root==null) return;
		
		if(root.left==null&&root.right==null) return;
		
		TreeLinkNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		if(root.left!=null) getMirror(root.left);
		if(root.right!=null) getMirror(root.right);
		
		 
	}
	
	public void Mirror(TreeLinkNode root) {
        if(root==null) return ;
        Stack<TreeLinkNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeLinkNode t=stack.pop();
            
        	TreeLinkNode temp=null;
            temp=t.left;
            t.left=t.right;
            t.right=temp;
            
            if(t.left!=null) stack.push(t.left);
            if(t.right!=null) stack.push(t.right);
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
