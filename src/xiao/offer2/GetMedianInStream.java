package xiao.offer2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedianInStream {
	int count =0;
	PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>(){

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
		
	});
	public void insert(Integer num){
		

			if (count %2 == 0) {//����������Ϊż��ʱ���¼����Ԫ�أ�Ӧ������С����
			        //��ע�ⲻ��ֱ�ӽ���С���ѣ����Ǿ������ɸѡ��ȡ����������Ԫ�ؽ���С���ѣ�
			        //1.�¼����Ԫ�����뵽����ѣ��ɴ����ɸѡ����������Ԫ��
			        maxHeap.offer(num);
			        int filteredMaxNum = maxHeap.poll();
			        //2.ɸѡ��ġ�������е����Ԫ�ء�����С����
			        minHeap.offer(filteredMaxNum);
			    } else {//����������Ϊ����ʱ���¼����Ԫ�أ�Ӧ����������
			        //��ע�ⲻ��ֱ�ӽ������ѣ����Ǿ�С����ɸѡ��ȡС���������Ԫ�ؽ������ѣ�
			        //1.�¼����Ԫ�����뵽С���ѣ���С����ɸѡ��������С��Ԫ��
			        minHeap.offer(num);
			        int filteredMinNum = minHeap.poll();
			        //2.ɸѡ��ġ�С�����е���СԪ�ء���������
			        maxHeap.offer(filteredMinNum);
			    }
			 count++;
	}
	public double getMedian(){
		if(count%2==0) return (minHeap.peek() + maxHeap.peek())/2;
		else return minHeap.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
