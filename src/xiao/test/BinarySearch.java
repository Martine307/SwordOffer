package xiao.test;

public class BinarySearch {
	/**
	 * ʹ�õݹ�Ķ��ֲ���
	 *title:recursionBinarySearch
	 *@param arr ��������
	 *@param key �����ҹؼ���
	 *@return �ҵ���λ��
	 */
	public static int recursionBinarySearch(int[] arr,int key,int low,int high){
		
		if(key < arr[low] || key > arr[high] || low > high){
			return -1;				
		}
		
		int middle = (low + high) / 2;			//��ʼ�м�λ��
		if(arr[middle] > key){
			//�ȹؼ��ִ���ؼ�����������
			return recursionBinarySearch(arr, key, low, middle - 1);
		}else if(arr[middle] < key){
			//�ȹؼ���С��ؼ�����������
			return recursionBinarySearch(arr, key, middle + 1, high);
		}else {
			return middle;
		}	
		
	}
	
	/**
	 * ��ʹ�õݹ�Ķ��ֲ���
	 *title:commonBinarySearch
	 *@param arr
	 *@param key
	 *@return �ؼ���λ��
	 */
	public static int commonBinarySearch(int[] arr,int key){
		int low = 0;
		int high = arr.length - 1;
		int middle = 0;			//����middle
		
		if(key < arr[low] || key > arr[high] || low > high){
			return -1;				
		}
		
		while(low <= high){
			middle = (low + high) / 2;
			if(arr[middle] > key){
				//�ȹؼ��ִ���ؼ�����������
				high = middle - 1;
			}else if(arr[middle] < key){
				//�ȹؼ���С��ؼ�����������
				low = middle + 1;
			}else{
				return middle;
			}
		}
		
		return -1;		//�����Ȼû���ҵ����򷵻�-1
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
