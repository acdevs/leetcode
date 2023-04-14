public class P0003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        String str = "abcabcbbb";
//        String str = "defghjdf";
        System.out.println(partitionString(str));
    }

    static int partitionString(String s) {
        int l = s.length();
        int i = 0;
        int[] alpha = new int[95];
        int size = 0;
        int max = 0;
        while(i < l){
            int c = s.charAt(i) - 32;
            if(alpha[c] == 1){
                if(max < size) max = size;
                while(true){
                    i--;
                    if(s.charAt(i) == c + 32){
                        i++;
                        break;
                    }
                }
                size = 0;
                alpha = new int[95];
                continue;
            }
            if(i == l-1){
                size++;
                if(max < size) max = size;
            }
            alpha[c] = 1;
            size++;
            i++;
        }
        return max;
    }
}
