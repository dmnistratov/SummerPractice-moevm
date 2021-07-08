package algorithms;

import sortVisualiser.SortArray;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class BubbleSort extends SortVariant {

    private static final Logger log = Logger.getLogger(BubbleSort.class);

    public BubbleSort(int[] a){
        super(a);
    }

    private void toSwap(int[] buff,int first, int second) {
        int dummy = buff[first];
        buff[first] = buff[second];
        buff[second] = dummy;

    }

    public void sort(SortArray srtArray){
        log.info("Bubble");
        for (int out = srtArray.array.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(srtArray.array[in] > srtArray.array[in + 1])
                    srtArray.swapArray(in, in + 1);
            }
        }
    }

    @Override
    public void setStepSort() {
        log.info("Bubble steps");
        for (int out = stepSort.get(0).length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                int size = stepSort.size();
                int[] buff = Arrays.copyOf(stepSort.get(size-1), stepSort.get(size-1).length);
                if(buff[in] > buff[in + 1]) {
                    toSwap(buff, in, in + 1);
                    stepSort.add(Arrays.copyOf(buff, buff.length));
                }
            }
        }
    }
}
