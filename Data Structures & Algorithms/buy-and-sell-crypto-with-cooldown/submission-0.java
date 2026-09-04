class Solution {
    int[] price;
    int[][] memo;
    public int maxProfit(int[] prices) {
        price = prices;
        memo = new int[prices.length][2];
        for(int i = 0; i<memo.length; i++)
        {
            for(int j = 0; j<memo[0].length; j++)
            {
                memo[i][j] = -1;
            }
        }
        return recurse(0, true);
    }

    public int recurse(int index, boolean can)
    {
        int canBuy = can ? 1 : 0;
        if(index>=price.length)
        {
            return 0;
        }
        if(memo[index][canBuy]>-1)
        {
            return memo[index][canBuy];
        }
        if(can)
        {   
            int buy = -price[index] + recurse(index+1, false);
            int skip = recurse(index+1, true);
            memo[index][1] = Math.max(buy, skip);
        }
        if(!can)
        {
           int sell = price[index] + recurse(index+2, true);
            int skip = recurse(index+1, false);
            memo[index][0] = Math.max(sell, skip);
        }
        return memo[index][canBuy];
    }
}
