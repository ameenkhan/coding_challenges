package com.akpg.custom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Subtstring_Unique_SizeK {
    /**
     * Given a string s and an int k, return all unique substrings of size k with k distinct characters
     *
     * Example 1:
     * s = abcabc, k = 3
     * [abc, bca, cab]
     *
     * Example 2:
     * s = abacab, k = 3
     * [bac, cab]
     *
    */
    public static void main(String[] args) {
        String str = "abacab";
        int k = 3;
        for (String s : example(str, k)) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> example(String s, int k) {
        ArrayList<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        Set<String> resultSet = new LinkedHashSet<>();
        Set<Character> seen = new HashSet<>();

        while (left <= right && right < s.length()) {
            if (!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                if (seen.size() == k) {
                    resultSet.add(s.substring(left, right + 1));
                }
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        for (String str : resultSet) {
            res.add(str);
        }
        return res;
    }
}
