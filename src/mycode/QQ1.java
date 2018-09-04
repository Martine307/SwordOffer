package mycode;

public class QQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int n=8;
		int m=2;
		int cnt=1;
		int i=1;
		while(i<=n){
			if(cnt%2==1){
				for(int j=0;j<m;j++){
					sum+=-i;
					i++;
				}
				cnt++;
			}else{
				for(int j=0;j<m;j++){
					sum+=i;
					i++;
				}
				cnt++;
			}
			
		}
		System.out.println(sum);
	}

}
