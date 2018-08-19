package xiaozhaoti;

import java.util.Scanner;

public class wangyi3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int nums[]=new int[n];
		boolean temp[]=new boolean[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			if(sc.nextInt()==1)
				temp[i]=true;
			else
				temp[i]=false;
		}
		/*int n=6;
		int m=3;
		int nums[]=new int[]{1,3,5,2,5,4};
		boolean temp[]=new boolean[]{true,true,false,true,false,false};*/
		
		int max=0;
		int sum=0;
		for(int i=0;i<n;i++){
			int nnum=0;
			if(temp[i])
				sum+=nums[i];
			else{
				if(i+m<=n+1){
					int k=i;
					/*for(;k<i+m;k++){
						if(temp[k]==false) break;
					}*/
					
	
					for(int j=k;j<i+m&&j<n;j++){
		                if(temp[j]==false){
		                    nnum+=nums[j];
		                }
		            }
		            max=Math.max(nnum, max);
				}
			}
		}
		System.out.println(sum+max);
	}

}
