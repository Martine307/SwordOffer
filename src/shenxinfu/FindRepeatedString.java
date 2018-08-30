package shenxinfu;

import java.util.Scanner;

public class FindRepeatedString {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String s = sc.next();
			String[] sub = new String[s.length()];
			//存储所求的最长子字符串，可能有多个
			String[] res = new String[s.length()];
			//存储所求的最长子字符串的长度
			int maxLength = 0;
			//存储所求的最长子字符串出现的个数
			int maxCount = 0;
			//存储后缀子串，后缀字符串能间接表示所有的子字符串
			//每个后缀字符串的所有前缀字符串合起来即是所有子字符串
			for(int i = 0; i < s.length(); i++)
				{sub[i] = s.substring(i);
					//System.out.println(sub[i]);
				}
			//i为子字符串的长度
			for(int i = 1; i <= s.length()/2; i++){
				//存储每个长度的重复子字符串的个数
				int Count = 0;
				for(int j = 0; 2*i+j <= s.length(); j++){
					if(sub[j].substring(0, i).equals(sub[j+i].substring(0, i))){					
						maxLength = 2*i;
						
						Count ++;
						maxCount = Count;
					}
				}
			}
			if(maxCount == 0)
				System.out.println(0);
			else{
				System.out.println(maxLength);
				
			}
		}
	}
}