package xiao.offer2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/** ����˼·��
 * �Ƚ���������ת����String���飬Ȼ��String������������ź�����ַ�������ƴ�ӳ������ؼ������ƶ��������
 * ����������£�
 * ��ab > ba �� a > b��
 * ��ab < ba �� a < b��
 * ��ab = ba �� a = b��
 * ����˵����
 * ���� "3" < "31"���� "331" > "313"������Ҫ������ƴ���������бȽ�*/
public class PrintMinNumInArray {

	public String printMinNumInArray(int nums[]){
		if(nums==null||nums.length<=0) return null;
		int len=nums.length;
		String s[]=new String[len];
		StringBuilder sb=new StringBuilder();
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<len;i++){
			s[i]=String.valueOf(nums[i]);
			
			list.add(s[i]);
		}
		
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String c1=o1+o2;
				String c2=o2+o1;
				return c1.compareTo(c2);
			}

			
			
		});
		for(String num:list){
			sb.append(num);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]={3,32,321};
		String s=new PrintMinNumInArray().printMinNumInArray(nums);
		System.out.println(s);
	}

}
