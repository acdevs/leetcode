public class P0516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
    }

    static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n]; //memoization
        return findSub(0, n - 1, s, memo);
    }

    static int findSub(int s, int e, String str, int[][] memo){
        if (memo[s][e] != 0) {
            return memo[s][e];
        }
        if(s > e) return 0;
        if( s == e) return 1;
        if(str.charAt(s) == str.charAt(e)){
            memo[s][e] = 2 + findSub(s + 1, e - 1, str, memo);
        }else{
            memo[s][e] = Math.max(findSub(s + 1, e, str, memo), findSub(s, e - 1, str, memo));
        }
        return memo[s][e];
    }
}