package netease;

public class DP {

	public int dp(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return dp(n-1)+dp(n-2);
	}
	
	public int dp1(int n){
		int a[]=new int[n+1];
		if(n==0) return 0;
		if(n==1) return 1;
		a[0]=0;a[1]=1;
		for(int i=2;i<=n;i++){
			a[i]=a[i-1]+a[i-2];
		}
		
		return a[n];
	}
	public int dp2(int n){
		int a[]=new int[n+1];
		if(n==0) return 0;
		if(n==1) return 1;
		if(a[n]!=0) return a[n];
		
		return a[n]=dp2(n-1)+dp(n-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res=new DP().dp2(10);
		System.out.println(res);
	}

}
