package zhaohang;

public class Z3 {
	public static boolean check(int k,int arr[],int h){
		int cnt=0;
		for(int i=0;i<arr.length;i++){
			cnt+=(arr[i]+k-1)/k;
			
		}
		if(cnt<=h) return true;
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int j=10000000;int k=j;
		int arr[]=new int[]{4,7,8,9,11};
		int h=8;
		while(i<=j){
			int mid=(i+j)>>1;
			if(check(mid,arr,h)){
				k=mid;
				j=mid-1;
			}else{
				i=mid+1;
			}
		}
		System.out.println(k);
	}

}
