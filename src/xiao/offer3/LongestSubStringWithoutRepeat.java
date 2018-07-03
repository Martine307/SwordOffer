package xiao.offer3;
/*��Ҫ˼·��ʹ�ö�̬�滮����¼��ǰ�ַ�֮ǰ������ظ����ַ�������f(i-1)������iΪ��ǰ�ַ���λ�á�ÿ�α�����ǰ�ַ�ʱ�������������

1������ǰ�ַ���һ�γ��֣�������ظ����ַ�������f(i) = f(i-1)+1��
2������ǰ�ַ����ǵ�һ�γ��֣������ȼ��㵱ǰ�ַ������ϴγ���λ��֮��ľ���d����d����f(i-1)����˵��ǰһ�����ظ����ַ�����û�а�����ǰ�ַ����������ӵ�ǰ�ַ���ǰһ�����ظ����ַ����У����ԣ�f(i) = f(i-1)+1����dС�ڻ����f(i-1)����˵��ǰһ�����ظ����ַ������Ѿ�������ǰ�ַ����򲻿�����ӵ�ǰ�ַ������ԣ�f(i) = d��

�ؼ��㣺��̬�滮�������ظ��ַ��ľ���

ʱ�临�Ӷȣ�O(n)*/
public class LongestSubStringWithoutRepeat {
	public int getLongest(String s){
		if(s==null||s.length()<=0) return 0;
		int maxLen=0;
		int currentLen=0;
		int positions[]=new int[26];
		for(int i=0;i<positions.length;i++){
			positions[i]=-1;
		}
		for(int i=0;i<s.length();i++){
			int index=s.charAt(i)-'a';
			int preposition=positions[index];
			//��ǰ�ַ������ϴγ���λ��֮��ľ���
			int distance=i-preposition;
			//��ǰ�ַ���һ�γ��֣�����ǰһ�����ظ����ַ�����û�а�����ǰ�ַ�
			if(preposition<0||distance>currentLen) currentLen++;
			else{
				 //��������ظ����ַ����ĳ���
				if(currentLen>maxLen) maxLen=currentLen;
				currentLen=distance;
			}
			positions[index]=i;
			
		}
		if (currentLen > maxLen)
        {
            maxLen = currentLen;
        }
        return maxLen;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestSubStringWithoutRepeat().getLongest("arabcacfr")); //4
        System.out.println(new LongestSubStringWithoutRepeat().getLongest("bbb")); //1
        System.out.println(new LongestSubStringWithoutRepeat().getLongest("")); //0
	}

}
