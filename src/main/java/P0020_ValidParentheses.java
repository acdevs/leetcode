import java.util.ArrayList;

public class P0020_ValidParentheses {
    public static void main(String[] args) {
        String s = ")";
//        String s = "{{{([])}}}[]{([])}[[]][()(}{()}]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        ArrayList<Integer> openType = new ArrayList<>(); //() : 1, [] : 2, {} : 3
        int closeType = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if(bracket == '(') {
                openType.add(1);
                count++;
            }
            else if (bracket == '[') {
                openType.add(2);
                count++;
            }
            else if(bracket == '{') {
                openType.add(3);
                count++;
            }
            else if (bracket == ')') {
                int last = openType.size() - 1;
                if(last != -1 && openType.get(last) == 1) {
                    count--;
                    openType.remove(last);
                }
                else return false;
            }else if (bracket == ']') {
                int last = openType.size() - 1;
                if(last != -1 && openType.get(last) == 2) {
                    count--;
                    openType.remove(last);
                }
                else return false;
            }else if (bracket == '}') {
                int last = openType.size() - 1;
                if(last != -1 && openType.get(last) == 3) {
                    count--;
                    openType.remove(last);
                }
                else return false;
            }
        }
        if(count == 0){
            return true;
        }
        return false;
    }
}
