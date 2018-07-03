package xiao.offer4;

public class StrToInt {

    public static int StrToInt(String str) {
        int len = str.length();
        if(len == 0) return 0;
        int index = 0;
        boolean minus = false;
        if (str.charAt(0) == '+') {
       	 index++;
        } else if(str.charAt(0) == '-') {
       	 minus = true;
       	 index++;
        } 
        if(index != 0 && len == 1) {//万一只有一个正负号符号，而没有数字的情况要格外注意啊 ！！！
        	return 0;
        }
        int num = StrToInt(str, index, minus);
        if(num != 0) num = minus ? num*(-1) : num;
        return  num;
    }
    
    public static int StrToInt(String str,int index,boolean minus) {
    	int result = 0;
    	int len = str.length();
    	for(int i = index; i < len; i++) {
    		if(str.charAt(i) >= '0' && str.charAt(i)<= '9') {//各个位置上的字符是否合格
    			result = result*10;
    			result += str.charAt(i)-'0';//累加的过程，从高位到低位
    		//	ascii
    			System.out.println((int )str.charAt(i));
    			
        		if((minus && (result*-1) > 0) || (!minus && (result < 0))) {//溢出时就是原来是正数，加着加着变成了负数，或者原来是负数加着加着变成了正数
        			result = 0; 
        			break;
        		}
    		} else {
    			result = 0;
    			break;
    		}
    	}
    	return result;
    }
    
    public static void main(String []args){
    	System.out.println(new StrToInt().StrToInt("-14444966666666"));
    }

}
