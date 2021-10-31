import java.util.Arrays;
public class encode {

	public static void main(String[] args) {
		char t='肉';
		int tool=t;
		System.out.printf("%c %x",t,tool);
		int arr[]={1,2,3};
		int brr[][]=new int[2][3];
		brr[0]=arr;
		System.out.println(Arrays.toString(brr));
		System.out.println(arr);
	}	
}