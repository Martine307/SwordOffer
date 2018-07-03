package xiao.test;

public class BigNumSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a ="12345";
		String b = "3866";
		System.out.println(sum(a, b)); 
	}


public static String sum(String aNum, String bNum) {
    // �ַ�����ת
    String n1 = new StringBuffer(aNum).reverse().toString();
    String n2 = new StringBuffer(bNum).reverse().toString();
    int len = 0;
    int aLen = aNum.length();
    int bLen = bNum.length();
    // ��ȡ��ַ����ĳ���
    len = (aLen >= bLen) ? aLen : bLen;
    //�ж��Ƿ����
    boolean overFlow = false;
    int nTakeOver = 0;
    // ���ַ�����λ��0
    if (aLen < bLen) {
        for (int i = aLen; i < bLen; i++) {
            n1 += "0";
        }
    } else {
        for (int i = bLen; i < aLen; i++) {
            n2 += "0";
        }
    }
    //���������
    StringBuffer buffer = new StringBuffer();
    int bwInt = 0;
    for (int i = 0; i < len; i++) {
        int result = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i)+ "");
        result += bwInt;
        //��ǰ�����������Ƿ����10
        if (result >= 10) {
            //���λ����10�� �����λ��1
            if (i == len - 1) {
                overFlow = true;
                //�����λ���λ����Ϊ1
                nTakeOver = 1;
            }
            //������ӣ��������10���ȡʮλ�����ֵ
            bwInt = result/10;
            //��ǰλ����Ӹ�λ��
            buffer.append(result % 10);
        } else {
            buffer.append(result);
            //û����λ��ʮλ��Ϊ0
            bwInt = 0;
        }
    }
    //��λ��1
    if (overFlow) {
        buffer.append(nTakeOver);
    }
    return buffer.reverse().toString();
}
}