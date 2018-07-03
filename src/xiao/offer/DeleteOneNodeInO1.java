package xiao.offer;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
}
public class DeleteOneNodeInO1 {
	
	
	public static ListNode del(ListNode head,ListNode toDel){
		if(head==null||toDel==null) return null;
		if(toDel.next!=null){
			ListNode temp=toDel.next;
			toDel.val=temp.val;
			toDel.next=temp.next;
			
			temp.next=null;
		}else if(head==toDel){
			toDel=null;
			head=null;
			return null;
		}else{
			ListNode node=head;
			while(node.next!=toDel){
				node=node.next;
			}
			node.next=null;
			toDel=null;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head=new ListNode(0);
		ListNode p=head;
		for(int i=1;i<=5;i++){
			ListNode node=new ListNode(i);
			p.next=node;
			p=p.next;
		}
	}

}
