package xiao.offer2;
/*���¶��ϣ���̬�滮������С�����⿪ʼ �� 
f(r)��ʾ��rΪ��ʼ��r��Сȡ0�������Ҷ�����ɵ������ܹ�������ַ�����������
���ڳ���Ϊn�����֣�f(n)=0,f(n-1)=1,��f(0)�� 
1������i�����ֺ͵�i+1������ƴ�ӳɵ�������10~25��Χ�ڣ���ݹ�ʽ��Ϊ��
f(i)=f(i+1)+f(i+2)

2������
f(i)=f(i+1)
��ˣ�����12258��

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
		
		
		int arr[]=new int[len];
		arr[len-1]=1;
		int count;
		for(int i=len-2;i>=0;i--){
			System.out.println(num.charAt(i)+""+num.charAt(i+1));
			System.out.println(num.charAt(i)+num.charAt(i+1));
			count=arr[i+1];
			if(Integer.parseInt(num.charAt(i)+""+num.charAt(i+1))<26&&Integer.parseInt(num.charAt(i)+""+num.charAt(i+1))>=10){
				if(i<len-2){
					//f(i) = f(i+1) + f(i+2)
                    count += arr[i + 2];
				}else if(i==len-2){
					count += 1;  //ƴ�ӵ�����ֻ��һ�ַ��뷽ʽ
				}
				
			}
			arr[i]=count;
			
		}
		return arr[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s=new Num2String().num2String(12222);
		System.out.println(s);
	}

}
