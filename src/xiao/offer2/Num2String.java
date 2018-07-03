package xiao.offer2;
/*自下而上，动态规划，从最小的问题开始 ： 
f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。
对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。 
递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)； 其中，如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。 
因此，对于12258：
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
