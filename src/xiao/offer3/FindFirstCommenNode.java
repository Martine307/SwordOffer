package xiao.offer3;

import java.util.HashMap;

/*
找出2个链表的长度，然后让长的先走两个链表的长度差，然后再一起走
（因为2个链表用公共的尾部）

方法2：考虑hashmap 
*/
class Node{
	int val;
	Node next;
	Node(int val){
		this.val=val;
	}

}



public  class FindFirstCommenNode {
	

	 public Node FindFirstCommonNode(Node pHead1, Node pHead2) {
	        Node current1 = pHead1;
	        Node current2 = pHead2;
	 
	 
	        HashMap<Node, Integer> hashMap = new HashMap<Node, Integer>();
	        while (current1 != null) {
	            hashMap.put(current1, null);
	            current1 = current1.next;
	        }
	        while (current2 != null) {
	            if (hashMap.containsKey(current2))
	                return current2;
	            current2 = current2.next;
	        }
	 
	        return null;
	 
	    }
	public Node getFirstNode(Node head1,Node head2){
		if(head1==null||head2==null) return null;
		Node p1=head1;
		Node p2=head2;
		int len1=getLen(p1);
		int len2=getLen(p2);
		
		
		if(len1>len2){
			int dif=len1-len2;
			
			while(dif>0){
				p1=p1.next;
				dif--;
			}
		}else{
			int dif=len2-len1;
			
			while(dif>0){
				p2=p2.next;
				dif--;
			}
		}
		
		while(p1!=p2){
			p1=p1.next;
			p2=p2.next;
		}
		return p1;
		
	}
	private int getLen(Node head) {
		// TODO Auto-generated method stub
		Node curr=head;
		int count=0;
		while(curr!=null) {
			curr=curr.next;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
