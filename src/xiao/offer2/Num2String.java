package xiao.offer2;
/*���¶��ϣ���̬�滮������С�����⿪ʼ �� 
f(r)��ʾ��rΪ��ʼ��r��Сȡ0�������Ҷ�����ɵ������ܹ�������ַ�����������
���ڳ���Ϊn�����֣�f(n)=0,f(n-1)=1,��f(0)�� 
���ƹ�ʽΪ f(r-2) = f(r-1)+g(r-2,r-1)*f(r)�� ���У����r-2��r-1�ܹ�������ַ�����g(r-2,r-1)=1������Ϊ0�� 
��ˣ�����12258��
f(5) = 1
f(4) = 1 
f(3) = f(4)+0 = 1 
f(2) = f(3)+f(4) = 2 
f(1) = f(2)+f(3) = 3 
f(0) = f(1)+f(2) = 5

*/

public class Num2String {
	public int num2String(int num){
		if(num<0) return 0;
		return getCountOfTranslation(String.valueOf(num));
	}
	public int getCountOfTranslation(String num) {
		// TODO Auto-generated method stub
		int len=num.length();
		int g=0;
		int f1=1;
		int f2=1;
		
		for(int i=len-2;i>=0;i--){
			System.out.println(num.charAt(i)+""+num.charAt(i+1));
			System.out.println(num.charAt(i)+num.charAt(i+1));
			if(Integer.parseInt(num.charAt(i)+""+num.charAt(i+1))<26&&Integer.parseInt(num.charAt(i)+""+num.charAt(i+1))>=10) g=1;
			else g=0;
			
			int temp=f2;
			f2=f2+g*f1;
			f1=temp;
		}
		return f2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=new Num2String().num2String(12258);
		System.out.println(s);
	}

}
