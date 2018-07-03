package xiao.offer2;
class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
}


public class Circle {

	public  ListNode hasCircle(ListNode head){
		if(head==null) return null;
		ListNode first= head;
		ListNode second=head;
		
		first=head.next;
		second=first.next;		
		while(first!=null&&second!=null){
			if(first==second){
				return first;
			}
			first=first.next;
			second=second.next;
			if(second!=null)		
				second=second.next;
			
			
		}
		
			/*if(head==null)
			            return null;
			         
			        ListNode slow = head.next;
			        if(slow==null)
			            return null;
			         
			        ListNode fast = slow.next;
			        while (slow != null && fast != null) {
			            if(slow==fast){
			                return fast;
			            }
			            slow=slow.next;
			            fast=fast.next;
			             
			            if(fast!=slow){
			                fast=fast.next;
			            }
			        }*/
			        return null;
		
		
		
	
	}
	public  int lenCircle(ListNode head){
		
		
		int count=1;
		
		ListNode first=hasCircle(head);
		if(first==null) return 0;
		
		ListNode pnode=first;
		while(pnode.next!=first){
			count++;
			pnode=pnode.next;
		}
		
		
		return count;
	}
	
	public ListNode entry(ListNode head){
		int count=lenCircle(head);
		ListNode p1=head;
		ListNode p2=head;
		for(int i=0;i<count;i++){
			p1=p1.next;
		
		}
		
		while(p2!=p1){
			p2=p2.next;
			p1=p1.next;
		}
		return p1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=c;
       
       
        int n=new Circle().entry(a).val;
        System.out.println(n);
	}

}

