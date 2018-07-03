package xiao.offer3;

import java.util.Stack;
//二叉搜索树的第k个节点 
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val =val;
	}
}
public class KInBST {

	public TreeNode getK(TreeNode root,int k){
		if(root==null||k<=0) return null;
		return getKCore(root,k);
	}
	private TreeNode getKCore(TreeNode root, int k) {
		// TODO Auto-generated method stub
		TreeNode p=root;
		Stack<TreeNode> stack=new Stack<>();
		int count=0;
		while(p!=null||!stack.isEmpty()){
			while(p!=null){
				stack.push(p);
				p=p.left;
			}
			if(!stack.isEmpty()){
				p=stack.pop();
				count++;
				//System.out.println(count);
				if(count==k) return p;
				
				p=p.right;
			}
			
		}
		
		return null;
	}
	public static void main(String[] args) {
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
        System.out.println("第" + 3 + "大的节点是：");  
        System.out.println(new KInBST().getK(n1, 3).val);  

	}

}
