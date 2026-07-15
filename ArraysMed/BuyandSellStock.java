package ArraysMed;

public class BuyandSellStock {
    public int maxProfit(int[] prices) {
        int buyPrice=Integer.MAX_VALUE;
        int maxp=0;

        for(int i=0;i<prices.length;i++) {
            if(buyPrice<prices[i]) {
                int profit=prices[i]-buyPrice;

                maxp=Math.max(maxp,profit);
            }
            else {
                buyPrice=prices[i];
            }
        }
        return maxp;
    }
}

//dry run
// Initial:

// buyPrice = ∞, maxp = 0

// i=0 → 7

// buyPrice = 7

// i=1 → 1

// buyPrice = 1

// i=2 → 5

// profit = 5 - 1 = 4 → maxp = 4

// i=3 → 3

// profit = 3 - 1 = 2 → maxp = 4

// i=4 → 6

// profit = 6 - 1 = 5 → maxp = 5

// i=5 → 4

// profit = 4 - 1 = 3 → maxp = 5
