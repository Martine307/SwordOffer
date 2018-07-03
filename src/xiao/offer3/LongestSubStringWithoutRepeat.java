package xiao.offer3;
/*主要思路：使用动态规划，记录当前字符之前的最长非重复子字符串长度f(i-1)，其中i为当前字符的位置。每次遍历当前字符时，分两种情况：

1）若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。
2）若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离d。若d大于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，则可以添加当前字符到前一个非重复子字符串中，所以，f(i) = f(i-1)+1。若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符，则不可以添加当前字符，所以，f(i) = d。

关键点：动态规划，两个重复字符的距离

时间复杂度：O(n)*/
public class LongestSubStringWithoutRepeat {
	public int getLongest(String s){
		if(s==null||s.length()<=0) return 0;
		int maxLen=0;
		int currentLen=0;
		int positions[]=new int[26];
		for(int i=0;i<positions.length;i++){
			positions[i]=-1;
		}
		for(int i=0;i<s.length();i++){
			int index=s.charAt(i)-'a';
			int preposition=positions[index];
			//当前字符与它上次出现位置之间的距离
			int distance=i-preposition;
			//当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
			if(preposition<0||distance>currentLen) currentLen++;
			else{
				 //更新最长非重复子字符串的长度
				if(currentLen>maxLen) maxLen=currentLen;
				currentLen=distance;
			}
			positions[index]=i;
			
		}
		if (currentLen > maxLen)
        {
            maxLen = currentLen;
        }
        return maxLen;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestSubStringWithoutRepeat().getLongest("arabcacfr")); //4
        System.out.println(new LongestSubStringWithoutRepeat().getLongest("bbb")); //1
        System.out.println(new LongestSubStringWithoutRepeat().getLongest("")); //0
	}

}
