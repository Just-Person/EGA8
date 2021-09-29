import java.io.FileNotFoundException;

public class Main
{
   public static void main (String[] args) throws FileNotFoundException {
        Backpack backpack = new Backpack();
        System.out.println("Все наши предметы (Индекс, Цена, Вес, Положен/Не положен): ");
        backpack.print();
        System.out.println("Максимально возможный вес - " + backpack.getMaxweight());
        while (backpack.max() != 0)
        {
        backpack.print();
        System.out.println("Текущий вес рюкзака - " + backpack.getSumweight());
        System.out.println("Текущая ценность рюкзака - " + backpack.getSum());
        }
    }
}
