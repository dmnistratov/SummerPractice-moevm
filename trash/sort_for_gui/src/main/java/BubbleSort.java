import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort extends SortVariant {

    public BubbleSort(int[] a){
        super(a);
    }

    private void toSwap(int first, int second) {
        int dummy = buf[first];
        buf[first] = buf[second];
        buf[second] = dummy;
    }

    @Override
    public ArrayList<int[]> sort(){
        ArrayList<int[]> sort_mas = new ArrayList<int[]>();
        sort_mas.add(start);

        for (int out = buf.length - 1; out >= 1; out--){
            boolean skip = true;
            for (int in = 0; in < out; in++){
                if(buf[in] > buf[in + 1]) {
                    toSwap(in, in + 1);
                    skip = false;
                }
            }
            if(skip){
                break;
            }
            sort_mas.add(Arrays.copyOf(buf, buf.length));
        }
        sorted = Arrays.copyOf(buf,buf.length);
        return sort_mas;
    }
}
