package sortVisualiser.algorithm;

import sortVisualiser.SortArray;

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
    public void sort(){
        for (int out = buf.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(buf[in] > buf[in + 1])
                    toSwap(in, in + 1);
            }
        }
    }

    public void sort(SortArray srtArray){
        for (int out = srtArray.array.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(srtArray.array[in] > srtArray.array[in + 1])
                    srtArray.swapArray(in, in + 1);
            }
        }
    }
}
