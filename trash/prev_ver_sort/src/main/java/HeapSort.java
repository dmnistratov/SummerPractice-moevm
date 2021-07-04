public class HeapSort extends SortVariant{

    public HeapSort(int[] a){
        super(a);
    }

    @Override
    public void sort()
    {
        int n = buf.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);

        for (int i=n-1; i>=0; i--){
            int temp = buf[0];
            buf[0] = buf[i];
            buf[i] = temp;

            heapify(i, 0);
        }
    }


    void heapify(int n, int i) {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && buf[l] > buf[largest])
            largest = l;

        if (r < n && buf[r] > buf[largest])
            largest = r;

        if (largest != i){
            int swap = buf[i];
            buf[i] = buf[largest];
            buf[largest] = swap;

            heapify(n, largest);
        }
    }

}
