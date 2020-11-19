package sort;

/**
 * Created by veefox on 2020年11月16日, 0016
 * 题目：选择排序
 */
public class ChooseSort {

    //选择排序
    public static void sort(int[] arr) {
        //6, 5, 4, 3, 1, 2
        //1, 2, 3, 4, 6, 5
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i; // 遍历的区间最小的值
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 找到当前遍历区间最小的值的索引
                    min = j;
                }
            }
            if (min != i) {
                // 发生了调换
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        for (int e: arr) {
            System.out.print(e + ", ");
        }
    }
}
