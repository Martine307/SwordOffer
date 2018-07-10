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
 *һ���ڵ�������������һ���ڵ���������������ڵ�
 *�ڵ����丸�ڵ�����ӽڵ㣬��һ�����丸�ڵ�
 *û�������������Ǹ��ڵ�����ӽڵ㣬�ҵ�һ���ڵ㣬����ڵ����丸�ڵ�����ӽڵ㣬��ô����ڵ�ĸ��ڵ����
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
