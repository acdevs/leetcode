package leetcode;

public class P2405_OptimalPartitionofString {
    public static void main(String[] args) {
        String str = "ababc";
        System.out.println(partitionString(str));
    }

    static int partitionString(String s) {
        int k = 0;
        int l = s.length();
        int i = 0;
        int[] alpha = new int[26];
        while(i < l){
            int c = s.charAt(i) - 97;
            if(alpha[c] == 1){
                k += 1;
                alpha = new int[26];
            }
            if(i == l-1) k+=1;
            alpha[c] = 1;
            i++;
        }
        return k;
    }
}

