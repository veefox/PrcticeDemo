package simple.array;

/**
 * Created by yaoweiye on 2020年10月27日, 0027
 */
public class PlusOne {

    public static void start() {
        int[] nn = new int[] {9,9,9};
        for (int x: plusOne(nn)) {
            System.out.print(x);
        }
    }


//    输入: [1,2,3]
//    输出: [1,2,4]
//    输入[1,2,9,2]
//    输出[1,2,]
//    输入[9,9,9,9,1,9]
//    输出[1,0,0,0,0,0,0]
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        if (digits[length - 1] != 9) {
            digits[length - 1] += 1;
            return digits;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    return digits;
                }
            }
            digits= new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
    }

}
