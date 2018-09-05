package xiao.test;

import java.util.HashMap;

public class LRU {

	public static class ListNode<V>{
		V val;
		ListNode<V> next;
		ListNode<V> last;
		ListNode(V val){
			this.val=val;
			
		}
	}
	public static class DoubleLinkedList<V>{
		
		
		ListNode<V> head;
		ListNode<V> tail;
		DoubleLinkedList(){
			this.head=null;
			this.tail=null;
		}
		public void addNode(ListNode<V> node) {
			if(node==null) return;
			if(head==null) {
				head=node;
				tail=node;
			}else {
				tail.next =node;
				node.last=tail;
				tail=node;
			} 
		}
		public void moveNodeToTail(ListNode<V> node) {
			if(node==tail) return;
			if(node==head) {
				head=node.next;
				head.last=null;
				
				
			}else {
				ListNode<V> pre=node.last;
				ListNode<V> aft=node.next;
				pre.next=aft;
				aft.last=pre;
			}
			node.last=tail;
			node.next=null;
			tail.next=node;
			tail=node;
		}
		public ListNode<V> removeHead() {
			if(head==null) return null;
			ListNode<V> curr=head;
			if(head==tail) {
				head=null;
				tail=null;
			}else {
				head=curr.next;
				curr.next=null;
				head.last=null;
			}
			return curr;
		}
		
	}
	
	public static class MyCache<K,V>{
		public HashMap<K,ListNode<V>> keyNodeMap;
		public HashMap<ListNode<V>,K> nodeKeyMap;
		public DoubleLinkedList<V> nodeList;
		public int capacity;
		MyCache(int capacity){
			this.capacity=capacity;
			keyNodeMap=new HashMap<>();
			nodeKeyMap=new HashMap<>();
			nodeList=new DoubleLinkedList<>();
			
		}
		
		public V get(K key) {
			if(keyNodeMap.containsKey(key)) {
				ListNode<V> node=keyNodeMap.get(key);
				nodeList.moveNodeToTail(node);
				return node.val;
			}
			return null;
		}
		public void set(K key,V value) {
			if(keyNodeMap.containsKey(key)) {
				ListNode<V> node=keyNodeMap.get(key);
				node.val=value;
				nodeList.moveNodeToTail(node);
			}else {
				ListNode<V> node=new ListNode<>(value);
				keyNodeMap.put(key, node);
				nodeKeyMap.put(node, key);
				nodeList.addNode(node);
				if(keyNodeMap.size()==capacity+1) {
					removeMostUnUsed();
				}
			}
			
		}

		private void removeMostUnUsed() {
			// TODO Auto-generated method stub
			ListNode<V> node=nodeList.removeHead();
			K key=nodeKeyMap.get(node);
			keyNodeMap.remove(key);
			nodeKeyMap.remove(node);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
		testCache.set("A", 1);
		testCache.set("B", 2);
		testCache.set("C", 3);
		System.out.println(testCache.get("B"));
		System.out.println(testCache.get("A"));
		testCache.set("D", 4);
		System.out.println(testCache.get("D"));
		System.out.println(testCache.get("C"));
	}

}
