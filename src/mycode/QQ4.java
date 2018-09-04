package mycode;
import java.util.Scanner;
public class QQ4 {
	
	//dp[i][j]表示总长度为j的歌单，使用前i首歌能组成的总数
	    static long mod = 1000000007;
	    static long[][] dp = new long[201][1001];
	    static int[] p = new int[201];
	  
	    public static void main(String[] args) {
	       /* Scanner sc = new Scanner(System.in);
	        int k = sc.nextInt();
	        int a = sc.nextInt();
	        int x = sc.nextInt();
	        int b = sc.nextInt();
	        int y = sc.nextInt();*/
	    	int k=5;
	    	int a=2;
	    	int x=3;
	    	int b=3;
	    	int y=3;
	  
	        dp[0][0] = 1;
	  
	        for (int i = 1; i <= x; i++)
	  
	            p[i] = a;
	  
	        for (int j = x + 1; j <= x + y; j++)
	  
	            p[j] = b;
	  
	        for (int i = 1; i <= x + y; i++)
	  
	            for (int j = 0; j <= k; j++) {
	                if (j >= p[i])
	                    dp[i][j] = (dp[i - 1][j] % mod + dp[i - 1][j - p[i]] % mod) % mod;
	                else
	                    dp[i][j] = dp[i - 1][j] % mod;
	 
	  
	            }
	        for(int i=0;i<=x+y;i++){
	        	for(int j=0;j<=k;j++)
	        		System.out.print(dp[i][j]);
	        	System.out.println();
	        }
	        System.out.println(dp[x + y][k]);
	    }
	          
	    
}
