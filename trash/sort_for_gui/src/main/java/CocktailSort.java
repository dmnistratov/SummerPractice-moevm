import java.util.ArrayList;
import java.util.Arrays;

public class CocktailSort extends SortVariant{

    public CocktailSort(int[] a){
        super(a);
    }

    @Override
    public ArrayList<int[]> sort(){
        int buff;
        int left = 0;
        int right = buf.length - 1;
        ArrayList<int[]> sort_mas = new ArrayList<int[]>();
        do {
            for (int i = left; i < right; i++) {
                if (buf[i] > buf[i + 1]) {
                    buff = buf[i];
                    buf[i] = buf[i + 1];
                    buf[i + 1] = buff;
                }
            }
            sort_mas.add(Arrays.copyOf(buf,buf.length));
            right--;
            for (int i = right; i > left; i--) {
                if (buf[i] < buf[i - 1]) {
                    buff = buf[i];
                    buf[i] = buf[i - 1];
                    buf[i - 1] = buff;
                }
            }
            sort_mas.add(Arrays.copyOf(buf,buf.length));
            left++;
        } while (left < right);
        sorted = Arrays.copyOf(buf,buf.length);
        return sort_mas;
    }
}
