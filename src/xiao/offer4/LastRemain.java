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
		
		int tempIndex=(m-1)%list.size();//用于记录最初需清除的数字索引
		while(list.size()!=1){
			list.remove(tempIndex);
			tempIndex=(tempIndex+m-1)%list.size();//记录当前索引
		}
		return list.get(0);
	}
}
