package shenxinfu;

public class Q1 {
	
	public void canGet(int hole,int day,int arr[]){
		
		int dp[][]=new int[2][hole];
		for(int i=0;i<2;i++){
			for(int j=0;j<hole;j++){
				dp[i][j]=1;
			}
		}
		
		for(int i=0;i<day;i++){
			for(int j=0;j<hole;j++){
				if(j+1==arr[i]){
					dp[i%2][j]=0;
				}
				if(i>0&&dp[(i-1)%2][1]==0) dp[i%2][0]=0;
				if(i>0&&dp[(i-1)%2][hole-2]==0) dp[i%2][hole-1]=0;
				if(i>0&&j>0&&j<hole-1&&dp[(i-1)%2][j-1]==0&&dp[(i-1)%2][j+1]==0) dp[i%2][j]=0;
			}
		}
		int index = 0;
	    for (int j = 0; j < hole; j++) {
	        if (dp[(day-1)%2][j] == 1) {
	            index = 1;
	            break;
	        }
	    }

	    if (index == 1)
	       System.out.println("NO");
	    else
	    	System.out.println("YEs");

	   
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hole=4;
		int day=1;
		int arr[]={1,2,3,4};
		new Q1().canGet(hole, day, arr);
	}

}
