package Solutions;

import Utils.KMP;

/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 */
class Solution28 {

    /**
     * Using KMP algorithm
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);
    }

    public static void main(String[] args)
    {
        Solution28 s = new Solution28();
        s.strStr("hello", "ll");
    }
}