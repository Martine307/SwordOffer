package xiao.offer2;


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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
