public class ArrayString {

    public static String toString(int[] arr) {
        if (null == arr) return "null";
        else if (arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            sb.append(", ").append(arr[i]);
        }
        return sb.append(']').toString();
    }

    public static void main(String[] args) {
        int[] arr0 = null;
        int[] arr1 = {};
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println(toString(arr0));
        System.out.println(toString(arr1));
        System.out.println(toString(arr2));
    }
}
