package xiao.offer3;

public class BalanceTree {

	//d递归
	public boolean isBalanceTree(TreeNode root){
		if(root==null) return true;
		
		int left=new TreeDepth().getDepth(root.left);
		int right=new TreeDepth().getDepth(root.right);
		int diff=left-right;
		if(diff>1||diff<-1) return false;
		
		return isBalanceTree(root.left)&&isBalanceTree( root.right);
	}
	
	//后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
	boolean flag=true;
	public boolean isBalanceTree2(TreeNode root){
		if(root==null) return true;
		getDepth(root);
		return flag;
			
	}
	private int getDepth(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		int left=getDepth(root.left);
		int right=getDepth(root.right);
		if(Math.abs(left-right)>1) flag=false;
		//flag=true;
		return left>right ? left+1:right+1;
		
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
       
        System.out.println(new BalanceTree().isBalanceTree2(n1)); 
	}

}
