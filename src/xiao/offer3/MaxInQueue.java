package xiao.offer3;


import java.util.LinkedList;

public class MaxInQueue {

	LinkedList<Integer> data=new LinkedList<>();
	LinkedList<Integer> max=new LinkedList<>();
	public void poll(){
		int val=data.getFirst();
		data.poll();
		if(max.getFirst()==val) max.poll();
		
	}
	
	public void offer(int val){
		data.offer(val);
		while(!max.isEmpty()&&val>max.getLast()){
			int i=max.removeLast();
			//System.out.println(i);
		}
			
		
		max.offer(val);
	}
	
	public int getMax(){
		return max.getFirst();
		
	}
	
	public int size(){
		return max.size();
	}
	public int peek(){
		return max.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxInQueue queue=new MaxInQueue();
		queue.offer(2);
		System.out.println(queue.getMax()+"|"+queue.peek());
		queue.offer(1);
		System.out.println(queue.getMax()+"|"+queue.peek());
		queue.offer(3);
		System.out.println(queue.getMax()+"|"+queue.peek());
		
		queue.poll();
		System.out.println(queue.getMax()+"|"+queue.peek());
		
		
	}

}
