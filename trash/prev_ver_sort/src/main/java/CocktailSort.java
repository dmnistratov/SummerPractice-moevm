public class CocktailSort extends SortVariant{

    public CocktailSort(int[] a){
        super(a);
    }

    @Override
    public void sort()
    {
        boolean swapped = true;
        int start = 0;
        int end = buf.length;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end - 1; ++i) {
                if (buf[i] > buf[i + 1]) {
                    int temp = buf[i];
                    buf[i] = buf[i + 1];
                    buf[i + 1] = temp;
                    swapped = true;
                }
            }

            if (swapped)
                break;

            swapped = false;
            end = end - 1;

            for (int i = end - 1; i >= start; i--) {
                if (buf[i] > buf[i + 1]) {
                    int temp = buf[i];
                    buf[i] = buf[i + 1];
                    buf[i + 1] = temp;
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }
}
