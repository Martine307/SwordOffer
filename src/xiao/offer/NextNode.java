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
/**
 * @author XM
 *一个节点有右子树，下一个节点是右子树的最左节点
 *节点是其父节点的左子节点，下一个是其父节点
 *没有右子树、不是父节点的左子节点，找到一个节点，这个节点是其父节点的左子节点，那么这个节点的父节点就是
 */
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
