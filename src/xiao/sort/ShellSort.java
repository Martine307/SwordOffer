package xiao.sort;

import java.util.Arrays;

public class ShellSort {

	public static void shellSort(int array[]){
		int len=array.length;
		if(array==null||len==0) return;
		
		int increment=len/2;
		while(increment>=1){
			for(int i=increment;i<len;i+=increment){
				
				int toInsert=array[i];
				int j=i-increment;
				while(j>=0&&array[j]>toInsert){
					array[j+increment]=array[j];
					j-=increment;
				}
				array[j+increment]=toInsert;
				
			}
			
			increment=increment/2;
			System.out.println(Arrays.toString(array));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 57, 68, 59, 52, 72, 28, 96, 33 };
        shellSort(a);
	}

}
