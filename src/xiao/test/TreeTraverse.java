package xiao.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val){
		this.val=val;
	}
}
public class TreeTraverse {

	public void before(TreeNode root){
		if(root==null) return ;
		
		System.out.println(root.val);
		before(root.left);
		before(root.right);
	}
	public void middle(TreeNode root){
		if(root==null) return ;
		
		
		middle(root.left);
		System.out.println(root.val);
		middle(root.right);
	}
	public void after(TreeNode root){
		if(root==null) return ;
		
		
		after(root.left);
		
		after(root.right);
		System.out.println(root.val);
	}
	
	public void before2(TreeNode root){
		if(root==null) return ;
		Stack<TreeNode> s=new Stack<>();
		TreeNode p=root;
		while(!s.isEmpty()||p!=null){
			
			while(p!=null){
				System.out.println(p.val);
				s.push(p);
				p=p.left;
			}
			
			if(!s.isEmpty()){
				p=s.pop();
				
				p=p.right;
			}
			
			
			
		}
	}
	public void middle2(TreeNode root){
		if(root==null) return ;
		Stack<TreeNode> s=new Stack<>();
		TreeNode p=root;
		while(!s.isEmpty()||p!=null){
			
			while(p!=null){
				s.push(p);
				p=p.left;
			}
			if(!s.isEmpty()){
				p=s.pop();
				System.out.println(p.val);
				p=p.right;
			}
			
			
			
			
			
		}
	}
	public void after2(TreeNode root){
		if(root==null) return ;
		Stack<TreeNode> s=new Stack<>();
		Stack<TreeNode> out=new Stack<>();
		TreeNode p=root;
		while(!s.isEmpty()||p!=null){
			
			if(p!=null){
				s.push(p);
				out.push(p);
				p=p.right;
			}else{
				//out.push(null);
				p=s.pop();
				p=p.left;
			}
			
			
			
			
			
			
			
		}
		while(!out.isEmpty()){
			TreeNode temp=out.pop();
			//if(temp!=null)
			System.out.println(temp.val);
			
		}
	}
	
	public void level(TreeNode root){
		if(root==null) return ;
		LinkedList<TreeNode> s=new LinkedList<>();
		TreeNode p=root;
		s.offer(p);
		while(!s.isEmpty()){
			p=s.poll();
			System.out.println(p.val);
			
			if(p.left!=null)
				s.offer(p.left);
			if(p.right!=null)
				s.offer(p.right);
			
			
			
			
			
			
			
			
		}
	}
	
		   
		
	public ArrayList<ArrayList<Integer>> level2(TreeNode root){
		
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		ArrayList<Integer> arr=new ArrayList<>();
		LinkedList<TreeNode> s=new LinkedList<>();
		TreeNode p=root;
		s.offer(p);
		int now=1;
		int next=0;
		while(!s.isEmpty()){
			
			p=s.poll();
			now--;
			arr.add(p.val);
			
			if(p.left!=null){
				s.offer(p.left);
				next++;
			}
			if(p.right!=null){
				s.offer(p.right);
				next++;
			}
			
			if(now==0){
				res.add(new ArrayList<Integer>(arr));
				//res.add(arr);这样输出res是空的，，，你没添加数据，，只开辟了内存 


				/*ArrayList里存放的是索引，，如果，直接add(path)，，相当于添加了多个重复的path对象。
				
				所以，，每次添加都需要 new创建新的对象。
				*/
				arr.clear();
				now=next;
				next=0;
			}
			
			
			
			
			
		}
		return res;
	}
	
public ArrayList<ArrayList<Integer>> zhiPrint(TreeNode root){
		
		ArrayList<ArrayList<Integer>> res=new ArrayList<>();
		
		Stack<TreeNode> s1=new Stack<>();
		TreeNode p=root;
		s1.push(p);
		Stack<TreeNode> s2=new Stack<>();
		
		
		int layer=1;
		
		while(!s1.isEmpty()||!s2.isEmpty()){
			if(layer%2!=0){
				ArrayList<Integer> temp=new ArrayList<>();
				while (!s1.empty()) {
					TreeNode node=s1.pop();
					if(node!=null){
						temp.add(node.val);
						if(node.left!=null)
							s2.push(node.left);
						if(node.right!=null)
							s2.push(node.right);
					}
				}
				if(!temp.isEmpty()){
					res.add(temp);
					layer++;
				}
			}else{
				ArrayList<Integer> temp=new ArrayList<>();
				while (!s2.empty()) {
					TreeNode node=s2.pop();
					if(node!=null){
						temp.add(node.val);
						
						if(node.right!=null)
							s1.push(node.right);
						if(node.left!=null)
							s1.push(node.left);
					}
				
				}
				if(!temp.isEmpty()){
					res.add(temp);
					layer++;
				}
			}
			
			
			
			
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1=new TreeNode(1);
		TreeNode t2=new TreeNode(2);
		TreeNode t3=new TreeNode(3);
		TreeNode t4=new TreeNode(4);
		TreeNode t5=new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.right=t5;
		
		ArrayList<ArrayList<Integer>> l=new TreeTraverse().level2(t1);
		for(ArrayList<Integer> i:l){
			for(int j:i){
				System.out.print(j);
				
			}
			System.out.println();
		}
	}

}
