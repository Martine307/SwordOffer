package xiao.offer4;

import java.util.Arrays;
/*
1������ 
2�����������������ּ������ 
3������0�ĸ��� 
4�����2��3��ȣ�����˳�� 
5��������ֶ��ӣ�����˳��*/

public class Joker {

	public boolean isContinuous(int []arr){
		int len=arr.length;
		if(arr==null||len<=0) return false;
		int numberOfZero=0;
		int numberOfInteval=0;
		Arrays.sort(arr);
		
		for(int i=0;i<len-1;i++){
			if(arr[i]==0) {
				numberOfZero++;
				continue;
			}
			if(arr[i]==arr[i+1]) return false;
			numberOfInteval+=arr[i+1]-arr[i]-1;
		}
		
		if(numberOfZero>=numberOfInteval) return true;
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
