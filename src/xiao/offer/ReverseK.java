package xiao.offer;

public class ReverseK {

	public static ListNode getK(ListNode head,int k){
		if(head==null||k<=0) return null;
		ListNode first= head;
		ListNode second=head;
		int count=0;
		while(count<k-1){
			if(first.next!=null){
				first=first.next;
				count++;
			}else{
				return null;
			}
			
		}
		
		while(first.next!=null){
			first=first.next;
			second=second.next;
		}
		
		return second;
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
       
        
        System.out.println(getK(a,9).val);
	}

}
