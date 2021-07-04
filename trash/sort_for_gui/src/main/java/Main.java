import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        BubbleSort a = new BubbleSort(new int[] {4,2,3,20,135,1,5,5,10,3,9});
        ArrayList<int[]> aS = a.sort();
        for(int i = 0; i < aS.size(); i++) {
            System.out.println(Arrays.toString(aS.get(i)));
        }
        System.out.println("\n");
        HeapSort b = new HeapSort(new int[] {4,2,3,20,135,1,5,5,10,3,9});
        ArrayList<int[]> bS = b.sort();
        for(int i = 0; i < bS.size(); i++){
            System.out.println(Arrays.toString(bS.get(i)));
        }
        System.out.println("\n");
        CocktailSort c = new CocktailSort(new int[] {4,2,3,20,135,1,5,5,10,3,9});
        ArrayList<int[]> cS = c.sort();
        for(int i = 0; i < cS.size(); i++){
            System.out.println(Arrays.toString(cS.get(i)));
        }
    }
}
