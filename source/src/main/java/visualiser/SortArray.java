package visualiser;

import algorithms.SortVariant;

import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;


public class SortArray extends JPanel implements Runnable{
    public static final int WIN_WIDTH = 1024;
    public static final int WIN_HEIGHT = 800;
    private static int BAR_WIDTH = 5;
    private static int NUM_BARS = WIN_WIDTH/ BAR_WIDTH;
    public int[] array;
    public SortVariant ISort;
    public boolean pause, next, prev;
    public int pos = 0;

    public SortArray() {
        array = new int[NUM_BARS];
        pause = false;
        next = false;
        prev = false;
        setBackground(Color.darkGray);
    }

    public void generate(){
        array = new int[NUM_BARS];
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i;
        }
        shuffleArray();
    }
    public void setNext(boolean b){
        next = b;
        array = ISort.getNextStep();
    }

    public void setPrev(boolean b){
        prev = b;
        array = ISort.getPrevStep();
    }

    public void setSizeOfArray(int sizeOfArray){
        array = new int[sizeOfArray];
        BAR_WIDTH = WIN_WIDTH/sizeOfArray;
        NUM_BARS = sizeOfArray;
    }

    public void setAlgorithm(SortVariant algorithm){
        ISort = algorithm;
    }
    public void setPause(boolean b){
        pause = b;
    }

    public void startSorting(){
        ISort.setStepSort();
        /*
        BubbleSort Bsort = new BubbleSort(array);
        Bsort.sort(this);*/
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

    public void animate() {
        int delay = 1; // number of milliseconds to sleep

        for (pos = 0; pos < ISort.stepSort.size(); pos++) {
            array = ISort.stepSort.get(pos);
            repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
            while (pause){
                try {
                    if (next){
                        pos++;
                        pause = false;
                        next = false;
                        prev = false;
                    }
                    else if (prev){
                        pos--;
                        pause = false;
                        next = false;
                        prev = false;
                    }
                    Thread.sleep(1000)  ;
                } catch (InterruptedException e){

                }
            }
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

    @Override
    public void run(){
    }
}
