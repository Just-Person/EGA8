import java.util.HashMap;
import java.util.Random;

public class Backpack {
    private HashMap<Integer,Integer> prices = new HashMap<>();
    private HashMap<Integer,Integer> backpacks = new HashMap<>();
    private HashMap<Integer,Integer> weights = new HashMap<>();
    private int maxweight = 0;
    private int sum = 0, sumweight = 0, size =0;
    Backpack (int size,int maxweight)
    {
        this.size = size;
        this.maxweight = maxweight;
        Random rnd = new Random();
        for(int i =0; i< this.size; i++) {
            prices.put(i, Math.abs(rnd.nextInt()) % 10 + 1);
        }
    }
    public int max()
    {
        int max = 0, maxindex = 0;
        for (int i = 0; i < this.size; i++)
        {
            if (prices.get(i)!=null)
                if (prices.get(i)>max)
                {
                    max = prices.get(i);
                    maxindex = i;
                }
        }
        if (weights.get(maxindex) + this.sumweight <=this.maxweight)
        {
            this.sumweight +=weights.get(maxindex);
            this.sum +=prices.get(maxindex);
            prices.remove(maxindex);
            return 1;
        }
        else return 0;
    }
}
