package xiaozhaoti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class beike1 {
	static class Node{
		int s;
		int e;
		int seq;
		Node(int s,int e,int seq){
			this.s=s;
			this.e=e;
			this.seq=seq;
		}
	}
	static ArrayList<Integer> al;
	/**
	 * �ж��Ƿ����ֻɾ��һ�����ţ�ʹ��ʣ��Ķ�����ͻ
	 * nodes:��������
	 * index:�ñ�����index������
	 * last:��һ�����Ž���ʱ��
	 * delete:�Ƿ���ɾ��һ�����ţ���Ϊtrueʱ�����ֳ�ͻ��ֱ�ӷ���false
	 * */
	public static boolean help(Node[] nodes,int index,int last,boolean delete) {
		for(int i=index;i<nodes.length;i++) {
			if(nodes[i].s<last) {//��ǰ���ſ�ʼʱ�������ϸ����Ž���ʱ�䣬�����ֳ�ͻ
				boolean flag = false;//�Ǻš��Ƿ����ֻɾ��һ�����ţ�ʹ��ʣ��Ķ�����ͻ
				if(delete) {//���Ѿ�ɾ����
					return false;//����ʧ��
				}
				if(i>1) {//����ǰ���źŴ���1
					//ɾ����һ�����ţ������������ϸ����ŵĽ���ʱ��С�ڵ��ڵ�ǰ���ſ�ʼ
					if(nodes[i-2].e<=nodes[i].s&&help(nodes,i+1,nodes[i].e,true)) {
						flag = true;//�Ǻ�Ϊ�ɹ�
						al.add(nodes[i-1].seq);//��ӿ�ɾ�������ź�
					}
				}
				if(i==1&&al.size()<1) {//���ǵڶ������ţ�ֱ��ɾ����һ��,����Ҫ��������ж�,al.size()��ֹ�ظ�add
					if(help(nodes,i+1,nodes[i].e,true)) {
						flag = true;
						al.add(nodes[i-1].seq);
					}
				}
				if(help(nodes,i+1,last,true)) {//�ж��Ƿ����ɾ����ǰ����
					flag = true;
					al.add(nodes[i].seq);	
				}
				return flag;
			}else {
				last = nodes[i].e;//�������Ž���ʱ��
			}
		}
		return true;
	}
	public static void main(String args[]){
		al = new ArrayList<Integer>();
		int n=3;
		Node nodes[]=new Node[3];
		Node n1=new Node(1,3,1);
		nodes[0]=n1;
		nodes[1]=new Node(4,6,2);
		nodes[2]=new Node(1,9,3);
		Arrays.sort(nodes, new Comparator<Node>(){

			@Override
			public int compare(Node node1, Node node2) {
				// TODO Auto-generated method stub
				return node1.s-node2.s;
			}
			
		});
		/**
		 * ˼·��ȫ�ֱ���al��¼�����ֳ�ͻʱ����ɾ����������ţ�����al.sizeֻ����0��1��2.����,��Ϊ0��ʾ����Ҫɾ��Ҳû�г�ͻ
		 * help���������ж��Ƿ����ֻɾ��һ�����Ż��߲�ɾ�����ţ�ʹ������ʱ�䶼����ͻ
		 * �����ֳ�ͻʱ���ֱ���ɾ����һ�����ź͵�ǰ���ţ�ע��ɾ����һ������ʱ�����������)
		 * */
		if(help(nodes,0,1,false)) {//��help����true,�з�������ͻ
			if(al.size()==0) {//al����Ϊ0��ʾ������Ҫɾ���κ����ţ����޳�ͻ����������£����������������Ŷ�����ɾ��
				System.out.println(n);
				for(int i=1;i<=n;i++) {
					System.out.print(i+" ");
				}
			}else {//����ɾ��һ���Ų���ͻ
				Collections.sort(al);//�Ȱ���Ҫ����
				System.out.println(al.size());
				for(Integer i:al) System.out.print(i+" ");
			}
		}else {//��help����false,��������ζ����ͻ
			System.out.println(0);
		}
	}
}
