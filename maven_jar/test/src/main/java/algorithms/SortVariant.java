package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class SortVariant {
    public final int[] start;
    public int[] buf;
    public int[] sorted;

    public SortVariant(int[] a){
        this.start = a;
        this.buf = Arrays.copyOf(a, a.length);
    }

    public int[] returnStart(){
        return start;
    }

    public boolean check_sorted(){
        return true;
    }

    public static boolean check_sorted(int[] buf){
        return true;
    }

}
