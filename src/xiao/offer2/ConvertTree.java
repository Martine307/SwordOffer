package xiao.offer2;
class TreeNode{
	int val;
	TreeNode pleft;
	TreeNode pright;
	
	TreeNode(int val){
		this.val=val;
	}
}


/*

方法一：非递归版
解题思路：
1.核心是中序遍历的非递归算法。
2.修改当前遍历节点与前一遍历节点的指针指向。
    import java.util.Stack;
    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }      
            p = p.right;
        }
        return root;
    }
方法二：递归版
解题思路：
1.将左子树构造成双链表，并返回链表头节点。
2.定位至左子树双链表最后一个节点。
3.如果左子树链表不为空的话，将当前root追加到左子树链表。
4.将右子树构造成双链表，并返回链表头节点。
5.如果右子树链表不为空的话，将该链表追加到root节点之后。
6.根据左子树链表是否为空确定返回的节点。*/

public class ConvertTree {
	public TreeNode convert(TreeNode root){
		if(root==null) return null;
		if(root.pleft==null&&root.pright==null) return root;
		
		TreeNode l=convert(root.pleft);
		TreeNode pnode=l;
		while(pnode!=null&&pnode.pright!=null){
			pnode=pnode.pright;
		}
		if(l!=null){
			pnode.pright=root;
			root.pleft=pnode;
		}
		
		
		TreeNode r=convert(root.pright);
		
		
		if(r!=null){
			root.pright=r;
			r.pleft=root;
		}
		
		return l != null ? l : root;
	}
}
