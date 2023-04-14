package leetcode;

public class P0121_BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    static int maxProfit(int[] prices) {
        int len = prices.length;
        int MAXPROFIT = 0;
        for (int i = 0; i < len; i++) {
            int PROFIT = 0;
            int max = 0;
            for (int j = i + 1; j < len; j++) {
                if(max < prices[j]) max = prices[j];
            }
            if(max > prices[i]) PROFIT = max - prices[i];
            if(MAXPROFIT < PROFIT) MAXPROFIT = PROFIT;
        }
        return MAXPROFIT;
    }
}
