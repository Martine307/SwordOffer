package xiao.offer2;



class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class HasTree {

	public boolean hasTree(TreeLinkNode t1,TreeLinkNode t2){
		if(t1==null||t2==null) return false;
		boolean flag=false;
		if(Equal(t1.val,t2.val)){
			flag=tree1hastree2(t1,t2);
		}
		if(!flag){
			 hasTree(t1.left,t2);
			 
		}
		if(!flag){
			 hasTree(t1.right,t2);
			 
		}
		return flag;
	}
	
	public boolean tree1hastree2(TreeLinkNode t1,TreeLinkNode t2){
		//顺序一定是先判断t2在t1
		if(t2==null) return true;
		if(t1==null) return false;
		if(!Equal(t1.val,t2.val)){
			return false;
		}
		
		return tree1hastree2(t1.left,t2.left)&&tree1hastree2(t1.right,t2.right);
		
	}
	
	public boolean Equal(double n1,double n2){
		if(Math.abs(n1-n2)<0.000001)
			return true;
		return false;
	}
}
