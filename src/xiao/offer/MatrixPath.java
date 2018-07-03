package xiao.offer;

public class MatrixPath {
	
	
	public static boolean hasPath(char matrix[],int rows,int cols, char str[]){
		if(matrix==null||rows<=0||cols<=0||str==null||str.length<=0) return false;
		boolean visited[]=new boolean[rows*cols];
		
		for(int i=0;i<visited.length;i++){
			visited[i]=false;
		}
		int pathlen=0;
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				if(hasPathCore(matrix,rows,cols,str,visited,row,col,pathlen)){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean hasPathCore(char matrix[],int rows,int cols,char str[],boolean visited[],int row,int col,int pathlen){
		if(pathlen==str.length) return true;
		
		boolean haspath=false;
		if(row>=0&&row<rows&&col>=0&&col<cols&&matrix[cols*row+col]==str[pathlen]&&!visited[cols*row+col]){
			pathlen++;
			visited[cols*row+col]=true;
			
		    haspath=hasPathCore(matrix,rows,cols,str,visited,row,col+1,pathlen)||hasPathCore(matrix,rows,cols,str,visited,row,col-1,pathlen)||
					hasPathCore(matrix,rows,cols,str,visited,row+1,col,pathlen)||hasPathCore(matrix,rows,cols,str,visited,row-1,col,pathlen);
			
			if(!haspath){
				pathlen--;
				visited[cols*row+col]=false;
			}
		}
		return haspath;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
