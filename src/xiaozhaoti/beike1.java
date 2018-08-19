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
	 * 判断是否可以只删除一个社团，使得剩余的都不冲突
	 * nodes:所有社团
	 * index:该遍历到index个社团
	 * last:上一个社团结束时间
	 * delete:是否已删除一个社团，若为true时还出现冲突则直接返回false
	 * */
	public static boolean help(Node[] nodes,int index,int last,boolean delete) {
		for(int i=index;i<nodes.length;i++) {
			if(nodes[i].s<last) {//当前社团开始时间早于上个社团结束时间，即出现冲突
				boolean flag = false;//记号。是否可以只删除一个社团，使得剩余的都不冲突
				if(delete) {//若已经删除过
					return false;//返回失败
				}
				if(i>1) {//若当前社团号大于1
					//删除上一个社团，必须满足上上个社团的结束时间小于等于当前社团开始
					if(nodes[i-2].e<=nodes[i].s&&help(nodes,i+1,nodes[i].e,true)) {
						flag = true;//记号为成功
						al.add(nodes[i-1].seq);//添加可删除的社团号
					}
				}
				if(i==1&&al.size()<1) {//若是第二个社团，直接删除第一个,不需要做多余的判断,al.size()防止重复add
					if(help(nodes,i+1,nodes[i].e,true)) {
						flag = true;
						al.add(nodes[i-1].seq);
					}
				}
				if(help(nodes,i+1,last,true)) {//判断是否可以删除当前社团
					flag = true;
					al.add(nodes[i].seq);	
				}
				return flag;
			}else {
				last = nodes[i].e;//更新社团结束时间
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
		 * 思路：全局变量al记录当出现冲突时可以删除的社团序号，所以al.size只能是0、1、2.其中,若为0表示不需要删除也没有冲突
		 * help函数功能判断是否可以只删除一个社团或者不删除社团，使得所有时间都不冲突
		 * 若出现冲突时，分别尝试删除上一个社团和当前社团（注意删除上一个社团时需满足的条件)
		 * */
		if(help(nodes,0,1,false)) {//若help返回true,有方法不冲突
			if(al.size()==0) {//al长度为0表示，不需要删除任何社团，都无冲突，这种情况下，根据题意所有社团都可以删除
				System.out.println(n);
				for(int i=1;i<=n;i++) {
					System.out.print(i+" ");
				}
			}else {//必须删除一个才不冲突
				Collections.sort(al);//先按需要排序
				System.out.println(al.size());
				for(Integer i:al) System.out.print(i+" ");
			}
		}else {//若help返回false,则无论如何都会冲突
			System.out.println(0);
		}
	}
}
