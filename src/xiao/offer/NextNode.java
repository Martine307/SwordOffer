package xiao.offer;
 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class NextNode {
	public TreeLinkNode getNextNode(TreeLinkNode node){
		if(node==null) return null;
		if(node.right!=null){
			node=node.right;
			while(node.left!=null){
				node=node.left;
			}
			return node;
		}else if(node.next!=null&&node.next.left==node){
			return node.next;
		}else if(node.next!=null&&node.next.right==node){
		
			while(node.next!=null&&node.next.left!=node){
				node=node.next;
			}
			return node.next;
		}
		return node.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
