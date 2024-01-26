import java.util.Arrays;

public class P0881_BoatstoSavePeople {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 4;
        System.out.println(numRescueBoats(people, limit));
    }

//    Greedy Algorithm Approach 2-Pointer.
    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int boats = 0;
        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit)
                i++;
            j--;
        }
        return boats;
    }
}
