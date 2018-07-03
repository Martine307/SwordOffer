package xiao.test;

public class BigNumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="12345";
		String b = "3866";
		System.out.println(sum(a, b)); 
	}


public static String sum(String aNum, String bNum) {
    // 字符串翻转
    String n1 = new StringBuffer(aNum).reverse().toString();
    String n2 = new StringBuffer(bNum).reverse().toString();
    int len = 0;
    int aLen = aNum.length();
    int bLen = bNum.length();
    // 获取最长字符串的长度
    len = (aLen >= bLen) ? aLen : bLen;
    //判断是否溢出
    boolean overFlow = false;
    int nTakeOver = 0;
    // 短字符串高位补0
    if (aLen < bLen) {
        for (int i = aLen; i < bLen; i++) {
            n1 += "0";
        }
    } else {
        for (int i = bLen; i < aLen; i++) {
            n2 += "0";
        }
    }
    //保存计算结果
    StringBuffer buffer = new StringBuffer();
    int bwInt = 0;
    for (int i = 0; i < len; i++) {
        int result = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i)+ "");
        result += bwInt;
        //当前计算结果数字是否大于10
        if (result >= 10) {
            //最高位大于10则 在向高位借1
            if (i == len - 1) {
                overFlow = true;
                //定义借位后高位数字为1
                nTakeOver = 1;
            }
            //两数相加，如果大于10则获取十位数结果值
            bwInt = result/10;
            //当前位置添加个位数
            buffer.append(result % 10);
        } else {
            buffer.append(result);
            //没有上位则十位数为0
            bwInt = 0;
        }
    }
    //高位加1
    if (overFlow) {
        buffer.append(nTakeOver);
    }
    return buffer.reverse().toString();
}
}