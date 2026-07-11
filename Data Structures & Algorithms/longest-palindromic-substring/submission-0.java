class Solution {

    int start = 0;
    int maxLen = 1;

    public String longestPalindrome(String s) {

        int n = s.length();

        for (int i = 0; i < n; i++) {
            expand(s, i, i);       // Odd length
            expand(s, i, i + 1);   // Even length
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }

            left--;
            right++;
        }
    }
}