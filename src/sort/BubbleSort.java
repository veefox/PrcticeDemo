package sort;

/**
 * Created by veefox on 2020年11月16日, 0016
 * 题目：冒泡排序
 */
public class BubbleSort {

    //冒泡排序
    public static void sort(int[] arr) {
        //6, 5, 4, 3, 1, 2
        //5, 6, 4, 3, 1, 2
        //4, 6, 5, 3, 1, 2
        //3, 6, 5, 4, 1, 2
        //1, 6, 5, 4, 3, 2  第一趟结束，第二躺开始
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        for (int e: arr) {
            System.out.print(e + ", ");
        }
    }
}
