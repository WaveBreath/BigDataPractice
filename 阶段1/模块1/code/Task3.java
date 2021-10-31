/*
1.定义5个元素数组

2.可以使用初始化数组的两种方式之一为数组元素赋值

3.遍历数组求数组中的最小值

*/
public class Task3 {

	public static void main(String[] args) {
		int[] arr5 = new int[5];
		// 定义5个元素数组,初始化数组全为0
		int min = arr5[0];
		// 假设最小值在首位
		for(int i = 1;i < 5;i++) {
			min = min > arr5[i] ? min : arr5[i];
			// 如果比最小值小，更新最小值
		}
		System.out.println(min);
	}
}