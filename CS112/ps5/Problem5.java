import java.util.Arrays;

public class Problem5 {
    public static int removeDups(int[] arr) {
        int currentNum = arr[0];
        int nextIndex = 0;
        // int usefulDigits=0;
        // move forward
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != currentNum) {
                nextIndex++;
                arr[nextIndex] = arr[i];
                currentNum = arr[i];
                // arr[nextIndex-1]=0;
            }
        }

        //set 0
        for (int i = nextIndex + 1; i < arr.length; i++) {
            arr[i] = 0;
        }
        return nextIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 5, 5, 10, 12, 12 };
        int ret = removeDups(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ret);
    }
}