import java.util.*;

public class LongestCommonSubsequence {
    // Function to find the length of the Longest Common Subsequence
    public static int longestCommonSubsequence(String text1, String text2, StringBuilder sequence) {
        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store lengths of LCSs
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array using Dynamic Programming
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Construct the LCS sequence
        int length = dp[m][n];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                sequence.insert(0, text1.charAt(i - 1)); // Insert character at the beginning
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return length; // Return the length of LCS
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        StringBuilder sequence = new StringBuilder();
        int length = longestCommonSubsequence(text1, text2, sequence);
        System.out.println("Length of Longest Common Subsequence: " + length);
        System.out.println("Longest Common Subsequence: " + sequence.toString());
    }
}
