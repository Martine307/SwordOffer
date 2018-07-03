package xiao.sort;

import java.util.Arrays;

public class InsertSort {
	public static void insertSort(int []a){
		int len=a.length;
		for(int i=1;i<len;i++){
			int toInsert=a[i];
			int j=i-1;
			while(j>=0&&a[j]>toInsert){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=toInsert;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a={3,7,2,1,4,6,25};
		insertSort(a);
		System.out.println(Arrays.toString(a));
	}

}
