package trieTree;
import java.util.*;

public class myTrieTree {
	private trieTreeNode root=new trieTreeNode();
	
	
	public trieTreeNode getRoot() {
		return root;
	}


	private class trieTreeNode{
		//字符值
		char value;
		//字符的子节点
		Map<Integer,trieTreeNode> childMap=new HashMap<Integer,trieTreeNode>();
		//父节点
		trieTreeNode parent;
		//树的深度
		int depth=0;
		//是否是词尾
		boolean isTail=false;
		//词的数量
		int wordcount=0;
		//词
		StringBuilder word=new StringBuilder();
	}
	
	public void createTrieTree(String string){
		char str[]=string.toCharArray();
		//从第0层开始插入
		trieTreeNode parent=root;
		for(int i=0;i<str.length;i++){
			char c=str[i];
			//创建自己节点
			trieTreeNode child=creatTrieTreeNode(c,i,parent);
			//插入子节点
			  //因为只有26个字母(A=97)所以用后两位来存KEY不会发生冲突
		        int key= child.depth*100+child.value-96;
				parent.childMap.put(key, child);
				parent=child;
		}
		parent.isTail=true;
		parent.wordcount++;
		
	}
	
	public trieTreeNode creatTrieTreeNode(char value,int depth,trieTreeNode parent){
		//判断这个值存在过吗？
		int key=depth*100+value-96;
		trieTreeNode child=getTrieTreeChild(key,parent);
		if(child==null){
			child =new trieTreeNode();
			child.value=value;
			child.depth=depth;
			child.parent=parent;
			child.word.append(parent.word).append(value);
			
		}
		return child;
		
		
		}

	
	public trieTreeNode getTrieTreeChild(int key,trieTreeNode parent){
		
		return parent.childMap.get(key);	
		}
	
	
	int i=0;
	public int queryTrieWord(char [] ch,int i,int end,trieTreeNode parent){
		if(i==end){
			return parent.wordcount;
			}
		if(parent.childMap.get(i*100+ch[i]-96)!=null){
			System.out.println(i++);
			parent=getTrieTreeChild(i*100+ch[i]-96, parent);
			return queryTrieWord(ch,i+1,end, parent);
		}else{
			return 10;
		}
	}

	
	public void display(){
		
		Queue<trieTreeNode> st=new LinkedList<trieTreeNode>();
		st.offer(root);
		//int i=0;
		while(!st.isEmpty()){
			if(!st.isEmpty())root=st.poll();
			for(Map.Entry<Integer, trieTreeNode> entry : root.childMap.entrySet()){
				 st.offer(entry.getValue());
				 System.out.print(entry.getValue().value+" ");
			}
			//System.out.println(i++);
			 
		}
	  System.out.println("#####");
	}

}
