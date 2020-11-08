package array;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 2^31.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int c = x ^ y;
        String string = Integer.toBinaryString(c);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if ("1".equals(String.valueOf(string.charAt(i)))) {
                count += 1;
            }
        }
        return count;

    }


}
