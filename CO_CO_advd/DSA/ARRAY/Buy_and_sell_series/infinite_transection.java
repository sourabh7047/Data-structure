package DSA.ARRAY.Buy_and_sell_series;

public class infinite_transection {

    public static int max_profit(int[] prices) {
        int bp=0, sp =0, profit=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                bp++;
            } else {
                profit += prices[sp]- prices[bp];
                sp = bp = i;
            }
        }
        profit += prices[sp]- prices[bp];
        return profit;

    }

    public static void main(String[] args) {

    }
}
