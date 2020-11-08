package string;

/**
 * Created by yaoweiye on 2020年10月22日, 0022
 */
public class FirstIndex {

    public static void start() {
        System.out.println(strStr("hellohello", "ll"));
        String ss = "hello";
        System.out.println(ss.substring(2, ss.length()));
    }

    public static int str(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();

        for (int start = 0; start < n - L + 1; ++start) {
            if (haystack.substring(start, start + L).equals(needle)) {
                return start;
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int count = 0;
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                for (int j = 0; j < needle.length(); j++) {
                    if (k < haystack.length()) {
                        if (needle.charAt(j) == haystack.charAt(k)) {
                            count += 1;
                            k++;
                        }
                    }
                }
            }
            if (count == needle.length()) return i;
        }
        return -1;

    }
}
