package xiao.offer3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目：滑动窗口的最大值
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 *     原则：
 *     对新来的元素k，将其与双端队列中的元素相比较
 *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
 */
public class MaxInWindows {
	public ArrayList<Integer> getMax(int arr[],int k){
		ArrayList<Integer> list=new ArrayList<>();
		if(arr==null||arr.length<k||k<=0) return list;
		
		LinkedList<Integer> queue=new LinkedList<>();
		/*for(int i=0;i<k-1;i++){
			while(!queue.isEmpty()&&arr[i]>arr[queue.getLast()]){
				queue.removeLast();
			}
			queue.add(i);
		}
		for(int i=k-1;i<arr.length;i++){
			while(!queue.isEmpty()&&arr[i]>arr[queue.getLast()]){
				queue.removeLast();
			}
			queue.add(i);
			if(i-queue.getFirst()+1>k){
				queue.removeFirst();
			}
			
			list.add(arr[queue.getFirst()]);
		}*/
		for(int i=0;i<arr.length;i++){
			while(!queue.isEmpty()&&arr[queue.peekLast()]<=arr[i]){
				queue.pollLast();
			}
			queue.addLast(i);
			if(i-k==queue.peekFirst()){
				queue.pollFirst();
			}
			if(i>=k-1){
				list.add(queue.getFirst());
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list=new MaxInWindows().getMax(new int[]{2,3,4,2,6,2,5,1},3);
		for(int i:list){
			System.out.println(i);
		}
	}

}
