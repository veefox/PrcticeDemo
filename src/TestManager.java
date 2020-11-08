public class TestManager {


    //外观数列  1 <= n <= 30
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//            6.     312211
//    利用递归和StringBuffer来解析，通过StringBuffer可以大幅度明显感知到其的效率，把数组长度加1来
//
//    比如 n=6时,那么用递归得到上一层的字符串str=“111221”
//    我们将start指向下标0,我们从下标1开始遍历,遍历到“2”下标3的时候,sb拼上(3-0)个1即sb.append(3).append(1),将start指针指向下标3,接着重复以上操作,直到到达str的最后一位,sb直接拼上即可。
    public static String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        // 拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start)) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();

    }

    //外观数列
    // start  i=5
    //   3
    //111221
    public static String count(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        // 拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        for (int i = 1; i <= length; i++) {
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(start)) {
                res.append(i-start).append(str.charAt(start));
                start = i;
            }
        }


        return res.toString();

    }

    //爬楼梯
//    输入： 3
//    输出： 3
//    解释： 有三种方法可以爬到楼顶。
//    1.  1 阶 + 1 阶 + 1 阶
//    2.  1 阶 + 2 阶
//    3.  2 阶 + 1 阶

//    输入： 4
//    输出： 5
//    解释： 有5种方法可以爬到楼顶。
//    1.  1 阶 + 1 阶 + 1 阶 + 1 阶
//    2.  1 阶 + 1 阶 + 2 阶
//    3.  1 阶 + 2 阶 + 1 阶
//    4.  2 阶 + 1 阶 + 1 阶
//    5.  2 阶 + 2 阶
    public static int climbStairs(int n) {

        int f0 = 0, f1 = 1, fn = 0;
        for (int i = 0; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f0;
    }


}
