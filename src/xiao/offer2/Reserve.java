package xiao.offer2;



public class Reserve {

	public  ListNode reserveList(ListNode head){
		if(head==null||head.next==null) return head;
		ListNode pre= null;
		ListNode pnode=head;
		
		
		while(pnode!=null){
			ListNode pnext=pnode.next;
			if(pnext==null) {head=pnode;}
			pnode.next=pre;
			
			pre=pnode;
			pnode=pnext;
			
			
		}
	return head;	
	}
	
	public  ListNode reserveList2(ListNode head){
		if(head==null||head.next==null) return head;
		
		
		ListNode re=reserveList2(head.next);
		//System.out.println(re.val);
		head.next.next=head;
		head.next=null;
		return re;
		
		
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
        
       
       
       ListNode n=new Reserve().reserveList2(a);
       while(n!=null){
	       // System.out.println(n.val);
	        n=n.next;
        }
	}

}

