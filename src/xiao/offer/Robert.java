package xiao.offer;

public class Robert {
	
	public static int getCount(int matrix[],int m,int n,int k){
		if(matrix==null||matrix.length<=0||m<0||n<0||k<0) return -1;
		
		boolean visited[]=new boolean[m*n];
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		}
		
		int count=getCountCore(matrix,m,n,0,0,k,visited);
		return count;
	}
	
	public static int getCountCore(int matrix[],int m,int n,int row,int col,int k,boolean visited[]){
		int count=0;
		if(check(matrix, m, n, row, col, k, visited)){
			visited[n*row+col]=true;
			count=getCountCore( matrix, m, n, row, col-1, k, visited)+getCountCore( matrix, m, n, row, col+1, k, visited)
			+getCountCore( matrix, m, n, row-1, col, k, visited)+getCountCore( matrix, m, n, row+1, col, k, visited);
		}
		return count;
		
	}
	
	public static boolean check(int matrix[],int m,int n,int row,int col,int k,boolean visited[]){
		if(row>=0&&row<m&&col>=0&&col<n&&getSum(row)+getSum(col)<=k&&!visited[n*row+col]) return true;
		
		return false;
	}
	public static int  getSum(int num){
		int sum=0;
		while(num>0){
			sum=sum+num%10;
			num=num/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
