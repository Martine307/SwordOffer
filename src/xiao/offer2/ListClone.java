package xiao.offer2;
import java.util.HashMap;
class ComplexList{
	int val;
	ComplexList next;
	ComplexList sibling;
	
	ComplexList(int val){
		this.val=val;
	}
}

public class ListClone {
	public ComplexList listClone(ComplexList phead){
		if(phead==null) return null;
		HashMap<ComplexList,ComplexList> hm=new HashMap<ComplexList,ComplexList>();
		ComplexList newhead=new ComplexList(phead.val);
		ComplexList pre=phead, newpre=newhead;
		hm.put(pre, newpre);
		
		while(pre.next!=null){
			newpre.next=new ComplexList(pre.next.val);
			pre=pre.next;
			newpre=newpre.next;
			hm.put(pre, newpre);
			
		}
		
		
		pre=phead;
		newpre=newhead;
		while(newpre!=null){
			newpre.sibling=hm.get(pre.sibling);
			pre=pre.next;
			newpre=newpre.next;
		}
		return newpre;
	}
	
	public ComplexList listClone2(ComplexList phead){
		if(phead==null) return null;
		ComplexList pre=phead;
		while(pre!=null){
			ComplexList newpre=new ComplexList(pre.val);
			newpre.next=pre.next;
			newpre.sibling=null;
			
			pre.next=newpre;
			pre=newpre.next;
		}
		
		pre=phead;
		while(pre!=null){
			ComplexList newnode=pre.next;
			if(pre.sibling!=null){
				newnode.sibling=pre.sibling.next;
				
			}
			pre=newnode.next;
		}
		
		
		pre=phead;
		ComplexList copyhead=null;
		ComplexList copynode=null;
		
		if(pre!=null){
			copyhead=pre.next;
			copynode=pre.next;
			pre.next=copynode.next;
			pre=pre.next;
		}
		
		while(pre!=null){
			
			copynode.next = pre.next;
			copynode = copynode.next;
			pre.next = copynode.next;
			pre = pre.next;
		}
		return copyhead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
