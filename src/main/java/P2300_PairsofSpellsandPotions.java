import java.util.Arrays;

public class P2300_PairsofSpellsandPotions {
    //Approach: Sorting + Binary Search!
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;
        int[] res = successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(res));
    }
    static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        //sorting potions...
        Arrays.sort(potions);
        int len = potions.length;
        for (int i = 0; i < spells.length; i++){
            int spell = spells[i];
            int maxpotion = potions[len - 1];
            int minpotion = (int) Math.ceil((1.0 *success) / spell);
            if(minpotion > maxpotion){
                pairs[i] = 0;
            }else{
                int index = lowerbound(potions, minpotion);
                pairs[i] = len - index;
            }
        }
        return pairs;
    }
    private static int lowerbound(int[] potions, int target){
        int lo = 0;
        int hi = potions.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(target > potions[mid]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
