package xiao.offer;

public class TwoDimensions {

	
	public boolean searchInTwoDimensions(int array[][],int item){
		
		int row_len=array.length;
		int col_len=array[0].length;
		if(row_len==0 || col_len==0) return false;
		
		
		int row=0;
		int col=col_len-1;
		
		while(row<row_len&&col>=0){
			int number=array[row][col];
			if(number==item){
				return true;
			}
			if(number>item){
				col--;
			}else{
				
				row++;
			}
		}
		
		
		
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]={{1,2,8,9},{2,4,9,12},{4,7,10,14}};
		int item=3;
		boolean flag=new TwoDimensions().searchInTwoDimensions(a, item);
		System.out.println(flag);
	}

}
