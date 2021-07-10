package algorithms;

import java.util.Arrays;

public class BogoSort extends SortVariant{
    public BogoSort(int[] a){
        super(a);
    }

    public void setStepSort(){
        int[] buff = Arrays.copyOf(stepSort.get(0), stepSort.get(0).length);
        while(!isSorted(buff)) {
            shuffle(buff);
            stepSort.add(Arrays.copyOf(buff, buff.length));
        }
    }

    private boolean isSorted(int[] i) {
        for(int x = 0; x < i.length - 1; ++x) {
            if(i[x] > i[x+1]) {
                return false;
            }
        }
        return true;
    }

    private void shuffle(int[] i) {
        for(int x = 0; x < i.length; ++x) {
            int index1 = (int) (Math.random() * i.length),
                    index2 = (int) (Math.random() * i.length);
            int a = i[index1];
            pair.add(new int[]{0,0});
            i[index1] = i[index2];
            i[index2] = a;
        }
    }
}
