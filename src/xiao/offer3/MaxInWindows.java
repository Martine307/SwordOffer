package xiao.offer3;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ��Ŀ���������ڵ����ֵ
 * ˼·����������Ӧ���Ƕ��У���Ϊ�˵õ��������ڵ����ֵ����������Դ�����ɾ��Ԫ�أ����ʹ��˫�˶��С�
 *     ԭ��
 *     ��������Ԫ��k��������˫�˶����е�Ԫ����Ƚ�
 *     1��ǰ���kС�ģ�ֱ���Ƴ����У���Ϊ���ٿ��ܳ�Ϊ���滬�����ڵ����ֵ��!��,
 *     2��ǰ���k���X���Ƚ������±꣬�ж�X�Ƿ��Ѳ��ڴ���֮�ڣ������ˣ�ֱ���Ƴ�����
 *     ���еĵ�һ��Ԫ���ǻ��������е����ֵ
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
