package simple.array;

/**
 * Created by veefox on 2020年10月29日, 0029
 */
public class SimpleNumber {


//    示例 1:
//    输入: [2,3,1,4,3,2,4]
//    输出: 1

//    示例 2:
//    输入: [4,1,2,1,2]
//    输出: 4
//    异或算法:两个操作数的位中，相同则结果为0，不同则结果为1
//    一个数和0异或等于自身 11^0 = 11
//    一个数和自身异或为0
//    异或满足交换律和结合律
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;

    }
}
