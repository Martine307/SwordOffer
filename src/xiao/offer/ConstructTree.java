package xiao.offer;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}
}

public class ConstructTree {

	
	public TreeNode reconstructTree(int pre[],int in[]){
		
		if(pre==null||in==null) return null;
		TreeNode t=construct(pre,0,pre.length-1,in,0,in.length-1);
		return t;
		
	}
	
	public TreeNode construct(int pre[],int prestart,int preend,int in[],int instart,int inend){
		
		if(prestart>preend||instart>inend) return null;
		
		TreeNode root=new TreeNode(pre[prestart]);
		for(int i=0;i<in.length;i++){
			if(in[i]==pre[prestart]){
				root.left=construct(pre,prestart+1,prestart+i-instart,in,instart,i-1);
				root.right=construct(pre,prestart+i-instart+1,preend,in,i+1,inend);
				break;
			}
		}
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,4,7,3,5,6,8};
		int b[]={4,7,2,1,5,3,8,6};
		new ConstructTree().reconstructTree(a,b);

	}

}
