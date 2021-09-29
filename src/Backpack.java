import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Backpack {
    private HashMap<Integer,Integer> prices = new HashMap<>();
    private HashMap<Integer,Integer> backpacks = new HashMap<>();
    private HashMap<Integer,Integer> weights = new HashMap<>();
    private int maxweight = 0;
    private int sum = 0;
    private int sumweight = 0;
    private int size =0;
    String path = "D:/JetBrains/testEGA8.txt";
    File file = new File(path);
    Backpack () throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] backpack = line.split(" ");
        int [] values = new int[3];
        int counter = 0;
        this.size = Integer.parseInt(backpack[0]);
        for (int i = 0; i < this.size; i++) {
            line = scanner.nextLine();
            backpack = line.split(" ");
            for (String value : backpack) {
                values[counter] = Integer.parseInt(value);
                counter++;
            }
            prices.put(i, values[1]);
            weights.put(i, values[2]);
            counter = 0;
        }
        line = scanner.nextLine();
        backpack = line.split(" ");
        this.maxweight = Integer.parseInt(backpack[0]);
        scanner.close();
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
            this.backpacks.put(maxindex, prices.get(maxindex));
            prices.remove(maxindex);
            System.out.println("Положили элемент - " + maxindex + " "
                    + backpacks.get(maxindex)+ " " + weights.get(maxindex));
            return 1;
        }
        else
        {
            System.out.println("Мы ничего не положили! Место закончилось!");
            return 0;
        }
    }
    public void print()
    {
        for (int i = 0; i< this.size; i++)
        {
            if (prices.get(i) != null)
                System.out.println(i + " " + prices.get(i) + " " +weights.get(i) + " 0");
            if (backpacks.get(i) != null)
                System.out.println(i + " " + backpacks.get(i) + " " +weights.get(i) + " 1");
        }
    }
    public int getSumweight() {
        return sumweight;
    }
    public int getSum() {
        return sum;
    }
    public int getMaxweight() {
        return maxweight;
    }
}
