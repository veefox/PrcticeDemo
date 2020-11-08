package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaoweiye on 2020年11月2日, 0002
 */
public class MajorityElement {

    public static void start() {
        int[] nn = new int[]{2, 2, 1, 1, 1, 2, 2,1,1};
        System.out.println(majorityElement(nn));
    }

    //多数元素：指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//    输入: [2,1,1,1,2,2,2]
//    输出: 2
    public static int majorityElement(int[] nums) {
        //排序
//        Arrays.sort(nums);
//        return nums[nums.length / 2];

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int time = n / 2;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > time) {
                return item.getKey();
            }
        }
        return 0;
    }

}
