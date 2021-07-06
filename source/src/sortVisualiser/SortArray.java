package sortVisualiser;

import sortVisualiser.algorithm.BubbleSort;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;


public class SortArray extends JPanel{
    public static final int WIN_WIDTH = 1024;
    public static final int WIN_HEIGHT = 800;
    private static final int BAR_WIDTH = 5;
    private static final int NUM_BARS = WIN_WIDTH/ BAR_WIDTH + 1;
    public int[] array;
    public boolean pause;

    public SortArray() {
        array = new int[NUM_BARS];
        pause = false;
        setBackground(Color.darkGray);
    }

    public void init(){
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
        shuffleArray();
    }

    public void setPause(boolean b){
        pause = b;
    }
    public void startSorting(){
        BubbleSort Bsort = new BubbleSort(array);
        Bsort.sort(this);
    }

    public void swapArray(int firstIndex, int secondIndex){
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;

        repaint();
        int delay = 1; // number of milliseconds to sleep

        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - delay);
    }
    void shuffleArray() {
        Random rng = new Random();
        for (int i = 0; i < NUM_BARS; i++){
            int swapWithIndex = rng.nextInt(NUM_BARS - 1);
            int temp = array[i];
            array[i] = array[swapWithIndex];
            array[swapWithIndex] = temp;
        }
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        graphics.setColor(Color.white);
        for (int x = 0; x < NUM_BARS; x++) {
            int height = array[x] * 3;
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = WIN_HEIGHT - height;

            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }
    }
}
