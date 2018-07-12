package xiao.offer2;
/*自下而上，动态规划，从最小的问题开始 ： 
f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。
对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。 
1）若第i个数字和第i+1个数字拼接成的数字在10~25范围内，则递归式子为：
f(i)=f(i+1)+f(i+2)

2）否则
f(i)=f(i+1)
因此，对于12258：

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
					count += 1;  //拼接的数字只有一种翻译方式
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
