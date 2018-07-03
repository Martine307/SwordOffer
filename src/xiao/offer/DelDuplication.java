package xiao.offer;

public class DelDuplication {

	public static ListNode del(ListNode head){
		if(head==null||head.next==null) return head;
		
		ListNode pre=null;
		ListNode pnode=head;
		while(pnode!=null){
			ListNode pnext=pnode.next;
			if(pnext!=null&&pnode.val==pnext.val){
				int v=pnode.val;
				ListNode toDel=pnode;
				while(toDel!=null&&toDel.val==v){
					pnext=toDel.next;
					toDel=pnext;
					
					
				}
				if(pre==null) head=pnext;
				else pre.next=pnext;
				pnode=pnext;
			}
			else{
				pre=pnode;
				pnode=pnode.next;
				
				
			}
		}
		return head;
	}
	
	public static ListNode del1(ListNode head){
		if(head==null||head.next==null) return head;
		
		ListNode pre=null;
		ListNode pnode=head;
		while(pnode!=null){
			ListNode pnext=pnode.next;
			Boolean toDelNode=false;
			if(pnext!=null&&pnode.val==pnext.val){
				toDelNode=true;
				
			}
			
			if(!toDelNode){
				pre=pnode;
				pnode=pnode.next;
			}
			else{
				int v=pnode.val;
				ListNode toDel=pnode;
				while(toDel!=null&&toDel.val==v){
					pnext=toDel.next;
					toDel=pnext;
					
					
				}
				if(pre==null) head=pnext;
				else pre.next=pnext;
				pnode=pnext;
				
			}
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
		ListNode l=del(a);
		while(l!=null){
			System.out.print(l.val);
			l=l.next;
		}
	}

}
