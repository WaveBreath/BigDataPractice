/*
1.键盘录入班级人数
2.根据录入的班级人数创建数组
3.利用随机数产生0-100的成绩(包含0和100)
(1)打印该班级的不及格人数

(2)打印该班级的平均分

(3)演示格式如下:
*/
import java.util.Random;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入班级人数:");
		int stuNum=sc.nextInt();
		int[] score=new int[stuNum];
		int sum = 0;
		int failCnt = 0;
		Random generator=new Random();
		for(int i = 0;i < stuNum;i++) {
			score[i] = generator.nextInt(101);
			if(score[i] < 60)
				failCnt++;
			sum += score[i];
		}
		System.out.println("不及格人数:" + failCnt);
		System.out.println("班级平均分:" + (sum * 1.0 / stuNum));
	}
}