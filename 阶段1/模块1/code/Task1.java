/*
输出1到100之间，既是3的倍数也是5的倍数的数字之和。

*/
public class Task1 {

	public static void main(String[] args) {

		int sum = 0;
		//初始化和为0
		for(int i = 0;i <= 100;i++) {
			//遍历0到100中的每一个数
			if((i % 3 == 0) && (i % 5 == 0)) {
				// 3和5整除
				sum+=i;
			}
		}
		System.out.println(sum);
		sum=(0 + (100 / 15) * 15) * (100 / 15 + 1) / 2;
		System.out.println(sum);
	}
}