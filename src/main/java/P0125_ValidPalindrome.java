public class P0125_ValidPalindrome {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "0p";
//        String s = "AmanaplanacanalPanama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(!isAplhaNumeric(s.charAt(i)) || !isAplhaNumeric(s.charAt(j))){
                if(!isAplhaNumeric(s.charAt(i))) i++;
                if(!isAplhaNumeric(s.charAt(j))) j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isAplhaNumeric(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
