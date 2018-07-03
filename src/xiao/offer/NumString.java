package xiao.offer;

public class NumString {
	private static int index=0;
	public static boolean isNumeric(char []str){
		
		if(str==null||str.length<=0) return false;
		boolean flag=scanInteger(str);
		
		if(index<str.length&&str[index]=='.'){
			index++;
			flag=scanUnsignedInteger(str) || flag;
		}
		

		if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }
         
        return flag && index == str.length;
	}		     
	
	        public  static boolean scanInteger(char[] str) {
		        if (index < str.length && (str[index] == '+' || str[index] == '-') )
		            index++;
		        return scanUnsignedInteger(str);
		         
		    }
		     
		    private static boolean scanUnsignedInteger(char[] str) {
		        int start = index;
		        while (index < str.length && str[index] >= '0' && str[index] <= '9')
		            index++;
		        return start < index; //是否存在整数
		    }
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
