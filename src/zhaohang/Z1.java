package zhaohang;

public class Z1 {

	public static int getMin(int num[]){
		int count=0;
		for(int i=0;i<num.length;i++){
			for(int j=0;j<num.length-i-1;j++){
				if(num[j]>num[j+1]){
					count++;
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="CDDCC";
		char[] arr=s.toCharArray();
		int len=arr.length;
		int num[]=new int[len];
		for(int i=0;i<len;i++){
			if(arr[i]=='C') num[i]=1;
			else num[i]=2;
		}
		int min=getMin(num);
		for(int i=0;i<len;i++){
			if(arr[i]=='C') num[i]=2;
			else num[i]=1;
		}
		int res=Math.min(min, getMin(num));
		System.out.println(res);
	}

}
