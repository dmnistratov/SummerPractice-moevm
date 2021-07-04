import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BubbleSort a = new BubbleSort(new int[] {4,2,3});
        a.sort();
        System.out.println(Arrays.toString(a.buf));
        HeapSort b = new HeapSort(new int[] {4,2,3});
        b.sort();
        System.out.println(Arrays.toString(b.buf));
        CocktailSort c = new CocktailSort(new int[] {4,2,3});
        c.sort();
        System.out.println(Arrays.toString(c.buf));
    }
}
