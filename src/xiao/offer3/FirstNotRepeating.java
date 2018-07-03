package xiao.offer3;

import java.util.HashMap;

public class FirstNotRepeating {
	public char getFirst(String s){
		if(s==null||s.length()<=0) return '\0';
		
		HashMap<Character,Integer> hm=new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			//System.out.println(c);
			if(hm.containsKey(c)){
				int times=hm.get(c);
				hm.put(c, times+1);
			}else{
				hm.put(c, 1);
			}
		}
		
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(hm.get(c)==1)
				return c;
		}
		return '\0';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c=new FirstNotRepeating().getFirst("abaccd");
		System.out.println(c);
	}

}
