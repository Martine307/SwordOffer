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
        if(index != 0 && len == 1) {//��һֻ��һ�������ŷ��ţ���û�����ֵ����Ҫ����ע�Ⱑ ������
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
    		if(str.charAt(i) >= '0' && str.charAt(i)<= '9') {//����λ���ϵ��ַ��Ƿ�ϸ�
    			result = result*10;
    			result += str.charAt(i)-'0';//�ۼӵĹ��̣��Ӹ�λ����λ
    		//	ascii
    			System.out.println((int )str.charAt(i));
    			
        		if((minus && (result*-1) > 0) || (!minus && (result < 0))) {//���ʱ����ԭ�������������ż��ű���˸���������ԭ���Ǹ������ż��ű��������
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
