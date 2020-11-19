public class Main {

    public static void main(String[] args) {
        simple();
        middle();
    }

    private static void middle() {
        //两数相加
//        AddTwoNumbers.addTwoNumbers(null, null);

        //无重复字符的最长子串
//        LongestSubstringWithoutRepeatingCharacters.start();

        //最长回文子串
//        LongestPalindromicSubstring.start();

        //三数之和
//        ThreeSum.start();

        //删除链表的倒数第N个节点
//        RemoveNodeFromEndOfList.start();

        //括号生成
//        List<String> list = GenerateParentheses.Solution2.generateParenthesis(4);
//        for (String s:list) {
//            System.out.print(s + ",");
//        }

        //下一个排列
//        NextPermutation.start();

        //冒泡排序
//        BubbleSort.sort(new int[] {6, 5, 4, 3, 1, 2});

        //快速排序
//        int[] nn = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        QuickSort.quickSort(nn, 0, nn.length - 1);
//        for (int e: nn) {
//            System.out.print(e + ", ");
//        }

        //在排序数组中查找元素的第一个和最后一个位置
//        int[] nn = new int[] {8};
//        int[] mm = FindFirstAndLastPositionOfElementinSortedArray.Solution.searchRange(nn, 8);
//        int[] ll = FindFirstAndLastPositionOfElementinSortedArray.searchRange(nn, 8);
//        for (int a: mm) {
//            System.out.print(a + ", ");
//        }
//        System.out.println();
//        for (int a: ll) {
//            System.out.print(a + ", ");
//        }

        //组合总和
//        int[] nn = new int[] {2,3,5};
//        int target = 8;
//        List<List<Integer>> mm = CombinationSum.Solution.combinationSum(nn, target);
//        for (List<Integer> data: mm) {
//            for (Integer i:data) {
//                System.out.print(i+ ",");
//            }
//            System.out.println();
//        }

        //全排列
//        Permutations.start();

        //跳跃游戏
//        JumpGame.start();

        //子集
//        SubSets.start();
        recursion(4267);
    }

    public static void recursion(int value) {
        int quotient;
        quotient = value / 10;
        if (quotient != 0) {
            recursion(quotient);
        }
        System.out.print(value % 10 + ",");
    }


    private static void simple() {
        //合并2个有序链表
//        TestManager.mergeTwoListNode();

        //删除排序数组中的重复项，返回删除后数组的长度--原地删除
//        ArrayManager.deleteRepeatArray();

        //实现 strStr() 函数
//        StringManager.firstIndex();

        //搜索插入位置-二分法
//        ArrayManager.searchIndex();

        //外观数列
//        TestManager.countAndSay(6);
//        System.out.println(TestManager.countAndSay(6));

        //最大子序和
//        ArrayManager.maxSubArray();

        //最后一个字符长度
//        System.out.println(StringManager.lengthOfLastWord("HHello World"));

        //加1
//        ArrayManager.plueOne();

        //二进制求和
//        System.out.print(StringManager.addBinary("1110", "111"));

        //爬楼梯
//        System.out.print(TestManager.climbStairs(4));

        //对称二叉树、最大深度
//       TreeManager.start();

//        //股票最大利润
//        System.out.println(FindMaxSum.maxRate(new int[]{7,1,5,3,6,4,9}));

        //找出不重复的数 异或位运算
//        System.out.println(SimpleNumber.singleNumber(new int[]{2,3,1,4,3,2,4}));

        //是否是环形链表
//        System.out.println(LinkedListCycle.hasCycle(null));

        //多数元素
//        MajorityElement.start();

        /**
         * 动态规划典型
         */
        //打家劫舍
//        HouseRobber.start();

        //反转链表
//        ReverseLinkedList.start();

        //翻转二叉树
//        InvertBinaryTree.start();

        //回文链表
//        PalindromeLinkedList.start();

        //移动零
//        MoveZeroes.start();

        //找到所有数组中消失的数字
//        FindAllNumbersDisappearedAnAnArray.start();

        //汉明距离
//        System.out.println(HammingDistance.hammingDistance(1,4));
    }
}
