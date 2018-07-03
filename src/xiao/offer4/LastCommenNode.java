package xiao.offer4;
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}
}
public class LastCommenNode {
	
	public TreeNode getLCA(TreeNode root,TreeNode first,TreeNode second){
		if(root==null||first==null||second==null) return null;
		
		if(root.val>first.val&&root.val>second.val){
			getLCA(root.left,first,second);
		}
		if(root.val<first.val&&root.val<second.val){
			getLCA(root.right,first,second);
		}
		
		return root;
		
	}
	
	
	

}
