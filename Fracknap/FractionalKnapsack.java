import java.util.Arrays;

/**
 * FractionalKnapsack
 */
public class FractionalKnapsack {

    public static double calcknap(Knapitems[] items, int W){
        Arrays.sort(items, (item1, item2) -> Double.compare(item2.ratio, item1.ratio));
        int Tw = 0;
        double Tp = 0;
        for (int i = 0; i < items.length; i++) {
            if (Tw+items[i].weight<W) {
                Tw += items[i].weight;
                Tp += items[i].profit;
                items[i].accepted = true;
            }
            else{
                Tp += ((double)(W-Tw)/items[i].weight)*items[i].profit/items[i].weight;
            }
        }
        
        return Tp;
    }
    public static void main(String[] args) {
        Knapitems items [] = {new Knapitems(60, 10), new Knapitems(100, 20), new Knapitems(120, 30)};
        int W = 50; 

        double maxValue = calcknap(items,W);
        System.out.println("Maximum value obtainable: " + maxValue);

        for (int i = 0; i < items.length; i++) {
            if (items[i].accepted == true) {
                System.out.println("item "+(i+1)+" taken");
            }
        }
    }
    
}

class Knapitems{
    int weight;
    int profit;
    double ratio;
    boolean accepted = false;

    Knapitems(int p, int w){
        this.weight = w;
        this.profit = p;
        this.ratio = (double)profit / weight;
    }
}