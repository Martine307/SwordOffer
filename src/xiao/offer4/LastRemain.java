package xiao.offer4;

import java.util.ArrayList;
//62
public class LastRemain {
	
	public int lastRemain(int n,int m){
		if(n<=0) return -1;
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(i);
		}
		
		int tempIndex=(m-1)%list.size();//���ڼ�¼������������������
		while(list.size()!=1){
			list.remove(tempIndex);
			tempIndex=(tempIndex+m-1)%list.size();//��¼��ǰ����
		}
		return list.get(0);
	}
}
