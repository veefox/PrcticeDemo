package simple.array;

/**
 * Created by veefox on 2020年10月26日, 0026
 */
public class FindMaxSum {

    public static void start() {
        int[] nn = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nn));
    }

    //[-2,1,-3,4,-1,2,1,-5,4]
    public static int maxSubArray(int[] nums) {

        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;

    }


    //输入: [7,1,5,3,6,4]
//    输出: 5
    public static int maxRate(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;


//        int maxRate = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > maxRate) {
//                    maxRate = prices[j] - prices[i];
//                }
//            }
//        }
//        return maxRate;

    }

}
