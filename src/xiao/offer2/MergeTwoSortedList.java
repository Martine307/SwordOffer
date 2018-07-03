package xiao.offer2;

public class MergeTwoSortedList {
	public ListNode merge(ListNode p1,ListNode p2){
		if(p1==null) return p2;
		if(p2==null) return p1;
		ListNode head=new ListNode(-1);
		
		ListNode root=head;
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				head.next=p1;
				head=p1;
				p1=p1.next;
				
			}else{
				head.next=p2;
				head=p2;
				p2=p2.next;
				
			}
		}
		
		if(p1!=null) head.next=p1;
		if(p2!=null) head.next=p2;
		
		return root.next;
	}
	
	
	public ListNode merge2(ListNode p1,ListNode p2){
		if(p1==null) return p2;
		if(p2==null) return p1;
		
		if(p1.val<p2.val){
			p1.next=merge2(p1.next,p2);
			return p1;
		}else{
			p2.next=merge2(p1,p2.next);
			return p2;
		}
	}
	public static void main(String args[]){
		/*ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);*/
		ListNode a =null;
        
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(6);
        
//        a.next=b;
//        b.next=c;
//        
        d.next=e;
        e.next=f;
        
        ListNode n=new MergeTwoSortedList().merge2(a, d);
        
        while(n!=null){
 	        System.out.println(n.val);
 	        n=n.next;
         }
	}
}
