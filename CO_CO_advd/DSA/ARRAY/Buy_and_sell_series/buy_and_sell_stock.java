package DSA.ARRAY.Buy_and_sell_series;


public class buy_and_sell_stock {

    public static int max_profit(int[] prices) {
        int lbd = Integer.MAX_VALUE;   //lowest buying day
        int pist  = 0;                  // profit if sold today
        int mp = 0;                     //maximum profit
        
        for(int i=0; i<prices.length; i++){
            if(prices[i]<lbd) lbd = prices[i];

            pist = prices[i]- lbd;
            if(pist>mp) mp = pist;
        }

        return mp;

    }

    public static void main(String[] args) {
        int[] prices = { 2,1,2,0,1 };
        int max_profit = max_profit(prices);
        System.out.println(max_profit);
    }
}
