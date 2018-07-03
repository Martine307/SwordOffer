package trieTree;
import java.util.*;

public class myTrieTree {
	private trieTreeNode root=new trieTreeNode();
	
	
	public trieTreeNode getRoot() {
		return root;
	}


	private class trieTreeNode{
		//�ַ�ֵ
		char value;
		//�ַ����ӽڵ�
		Map<Integer,trieTreeNode> childMap=new HashMap<Integer,trieTreeNode>();
		//���ڵ�
		trieTreeNode parent;
		//�������
		int depth=0;
		//�Ƿ��Ǵ�β
		boolean isTail=false;
		//�ʵ�����
		int wordcount=0;
		//��
		StringBuilder word=new StringBuilder();
	}
	
	public void createTrieTree(String string){
		char str[]=string.toCharArray();
		//�ӵ�0�㿪ʼ����
		trieTreeNode parent=root;
		for(int i=0;i<str.length;i++){
			char c=str[i];
			//�����Լ��ڵ�
			trieTreeNode child=creatTrieTreeNode(c,i,parent);
			//�����ӽڵ�
			  //��Ϊֻ��26����ĸ(A=97)�����ú���λ����KEY���ᷢ����ͻ
		        int key= child.depth*100+child.value-96;
				parent.childMap.put(key, child);
				parent=child;
		}
		parent.isTail=true;
		parent.wordcount++;
		
	}
	
	public trieTreeNode creatTrieTreeNode(char value,int depth,trieTreeNode parent){
		//�ж����ֵ���ڹ���
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
