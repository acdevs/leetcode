package leetcode;

public class P0028_FindtheIndexoftheFirstOccurrenceinString {
    public static void main(String[] args) {
        String haystack = "mississipi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    static int strStr(String haystack, String needle) {
        int n = 0;
        int h = 0;
        int index = 0;
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        while (h < haystackLen) {
            if(haystack.charAt(h) == needle.charAt(n)){
                if(n == 0) index = h;
                if(n == needleLen - 1){
                    return index;
                }
                n++;
            }else{
                if(n > 0) h = index;
                n = 0;
            }
            h++;
        }
        return -1;
    }
}
