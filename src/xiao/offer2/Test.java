package xiao.offer2;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        
        for (Integer i=0; i<list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);   //ִ��ɾ��ָ��Ԫ�صĹ���     ִ�н����[11,12,13,14,15,16]
            }
        }
       /* for (int i=0; i<list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);   //ִ��ɾ��ָ��λ�õ�Ԫ�صĹ���          ִ�н����[11,13,15]
            }
        }*/
        for(Integer i : list){
            System.out.println(i);
        }
    
	}

}
