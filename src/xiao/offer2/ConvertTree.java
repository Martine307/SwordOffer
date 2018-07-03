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

����һ���ǵݹ��
����˼·��
1.��������������ķǵݹ��㷨��
2.�޸ĵ�ǰ�����ڵ���ǰһ�����ڵ��ָ��ָ��
    import java.util.Stack;
    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// ���ڱ�������������е���һ�ڵ�
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// ��������������еĵ�һ���ڵ��Ϊroot
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
���������ݹ��
����˼·��
1.�������������˫��������������ͷ�ڵ㡣
2.��λ��������˫�������һ���ڵ㡣
3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
4.�������������˫��������������ͷ�ڵ㡣
5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣*/

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
