package xiao.test;

import java.util.ArrayList;

public class PrintArray {
	
	ArrayList <Integer> l=new ArrayList<>();
	public void printMatrix(int array[][]){
		int row=array.length;
		int col=array[0].length;
		
		if(array==null||row<=0||col<=0) return;
		int start=0;
		while(col>start*2&&row>start*2){
			printX(array,start,row,col);
			start++;
		}
	}
	public void printX(int array[][],int start,int row,int col){
		
		int endX=col-start-1;
		int endY=row-start-1;
		for(int i=start;i<=endX;i++){
			l.add(array[start][i]);
		}
		
		if(start<endY){
			for(int i=start+1;i<=endY;i++){
				l.add(array[i][endX]);
			}
		}
		
		if(start<endX&&start<endY){
			for(int i=endX-1;i>=start+1;i--){
				l.add(array[endY][i]);
			}
		}
		
		if(start<endX&&start<endY-1){
			for(int i=endY-1;i>=start+1;i--){
				l.add(array[i][start]);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
