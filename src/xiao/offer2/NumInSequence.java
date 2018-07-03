package xiao.offer2;
/*
 * ��Ҫ˼·��
���������������ҵ�1001λ���֣�
1��1λ������ֵ��10����0~9������Ϊ10��1=10������Ȼ1001>10��������10����ֵ���ں����ҵ�991��1001-10��λ���֡�
2��2λ������ֵ��90����10~99������Ϊ90��2=180������991>180�������ں����ҵ�811��991-180��λ���֡�
3��3λ������ֵ��900����100~999������Ϊ900��3=2700������811<2700��˵����811λ������λ��Ϊ3����ֵ�С�����811=270��3+1�����Ե�811λ�Ǵ�100��ʼ�ĵ�270����ֵ��370�ĵڶ������֣�����7��
���˹��ɣ�������������֡�

�ؼ��㣺λ������ֵ����

ʱ�临�Ӷȣ�O(logn)����λ�����в���
 */
public class NumInSequence {
	
	public int numInSequence(int index){
		if(index<0) return -1;
		
		int digits=1;
		while(true){
			int numbers=countOfIntegers(digits);
			if(index<numbers*digits){
				return getNum(index, digits);
			}
			
			index=index-numbers*digits;
			digits++;
		}
	}
	
	public int getNum(int index,int digits) {
		// TODO Auto-generated method stub
		int beginnum=0;
		if(digits==1) beginnum=0;
		else beginnum=(int) Math.pow(10, digits-1);
		
		int number=beginnum+index/digits;
		int indexfromright=digits-index%digits;
		for(int i=1;i<indexfromright;i++)
			number/=10;
		return number%10;
	}

	public int countOfIntegers(int digits) {
		// TODO Auto-generated method stub
		if(digits==1) return 10;
		
		return 9*(int) Math.pow(10, digits-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new NumInSequence().numInSequence(1001));
	}

}
