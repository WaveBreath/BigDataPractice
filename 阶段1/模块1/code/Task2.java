/*
  1.从键盘上录入一个1到5的数字;

  2.当数字为1时打印菜单"新建";

     当数字为2时打印菜单"打开文件";

     当数字为3时打印菜单"保存";

      当数字为4时打印菜单"刷新";

      当数字为5时打印菜单"退出",并退出程序;

      此行代码可以终止java程序运行: System.exit(0);

*/
import java.util.Scanner;
public class Task2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] output = {"新建", "打开文件", "保存", "刷新", "退出"};
		while(true) {
			int input = sc.nextInt();
			if( input < 1 || input >5) {
				System.out.println('invalid number');
				continue;
			}
			System.out.println(output[input - 1]);
			if(input == 5) {
				System.exit(0);
			}
		}
	}
}