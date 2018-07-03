package xiao.offer2;

public class Serialize {
	
	
	public String serialize(TreeNode root){
		
		StringBuilder sb=new StringBuilder();
		if(root==null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(serialize(root.pleft));
		sb.append(serialize(root.pright));
		return sb.toString();
	}
	
	int index=-1;
	public TreeNode deSerialize(String s){
		index++;
		String[] str=s.split(",");
		TreeNode t=null;
		if(!str[index].equals("#")){
			t=new TreeNode(Integer.valueOf(str[index]));
			t.pleft= deSerialize(s);
			t.pright=deSerialize(s);
		}
		
		return t;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode A = new TreeNode(8);  
        TreeNode B = new TreeNode(6);  
        TreeNode C = new TreeNode(10);  
        TreeNode D = new TreeNode(5);  
        TreeNode E = new TreeNode(7);  
        TreeNode F = new TreeNode(9);  
        TreeNode G = new TreeNode(11);  
  
        A.pleft = B;  
        A.pright = C;  
        B.pleft = D;  
        B.pright = E;  
        C.pleft = F;  
        C.pright = G;
        
        String res=new Serialize().serialize(A);
        System.out.println(res);
        TreeNode t=new Serialize().deSerialize(res);
        System.out.println(t.val);
	}

}
