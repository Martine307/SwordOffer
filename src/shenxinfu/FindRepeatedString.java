package shenxinfu;

import java.util.Scanner;

public class FindRepeatedString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			String[] sub = new String[s.length()];
			//�洢���������ַ����������ж��
			String[] res = new String[s.length()];
			//�洢���������ַ����ĳ���
			int maxLength = 0;
			//�洢���������ַ������ֵĸ���
			int maxCount = 0;
			//�洢��׺�Ӵ�����׺�ַ����ܼ�ӱ�ʾ���е����ַ���
			//ÿ����׺�ַ���������ǰ׺�ַ��������������������ַ���
			for(int i = 0; i < s.length(); i++)
				{sub[i] = s.substring(i);
					//System.out.println(sub[i]);
				}
			//iΪ���ַ����ĳ���
			for(int i = 1; i <= s.length()/2; i++){
				//�洢ÿ�����ȵ��ظ����ַ����ĸ���
				int Count = 0;
				for(int j = 0; 2*i+j <= s.length(); j++){
					if(sub[j].substring(0, i).equals(sub[j+i].substring(0, i))){					
						maxLength = 2*i;
						
						Count ++;
						maxCount = Count;
					}
				}
			}
			if(maxCount == 0)
				System.out.println(0);
			else{
				System.out.println(maxLength);
				
			}
		}
	}
}