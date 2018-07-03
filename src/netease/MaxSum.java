package netease;

public class MaxSum {
	
	
	public int maxSum(int a[],int n){
		int maxsum=0;
		for(int i=0;i<n;i++){
			int currentsum=0;
			for(int j=i;j<n;j++){
				currentsum+=a[j];
				if(currentsum>maxsum){
					maxsum=currentsum;
				}
			}
		}
		return maxsum;
	}
	public int maxSumDP(int a[],int n){
		int M[]=new int[n+1];
		int maxsum=0;
		if(a[0]>0) M[0]=a[0];
		else M[0]=0;
		for(int i=1;i<n;i++){
			if(M[i-1]+a[i]>0) {M[i]=M[i-1]+a[i]; }
			else {M[i]=0;}
	
		}
		for(int i=0;i<n;i++){
			if(M[i]>maxsum) maxsum=M[i];
		}
		return maxsum;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,-3,4,-2,-1,6};
		int n=6;
		
		int res=new MaxSum().maxSumDP(a, n);
		System.out.println(res);
		
	}

}
