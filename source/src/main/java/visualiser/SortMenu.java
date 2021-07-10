package visualiser;

import algorithms.SortVariant;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SortMenu extends JPanel {
    public static final int WIN_WIDTH = 1600;
    public static final int WIN_HEIGHT = 800;
    int[] array;

    int BAR_WIDTH;
    int NUM_BARS;

    Timer time;
    SortVariant algorithm;

    SortMenu() {
        setBounds(0, 0, WIN_WIDTH, WIN_HEIGHT);
        setBackground(Color.gray);
        setLayout(null);
        array = new int[100];
    }

    void setArray(int[] newArray) {
        System.arraycopy(newArray, 0, array, 0, NUM_BARS);
    }

    SortMenu setArraySize(int size) {
        NUM_BARS = size;
        BAR_WIDTH = WIN_WIDTH / NUM_BARS;

        array = new int[NUM_BARS];
        return this;
    }

    SortMenu setArrayFromString(String text) {
        String strInt[];
        strInt = text.split(" ");
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = Integer.parseInt(strInt[i]);
        }
        return this;
    }

    SortMenu generateInRange(int min, int max) {
        Random rng = new Random();
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = min + rng.nextInt(max - min + 1);
        }
        return this;
    }

    void shuffleArray() {
        Random rng = new Random();
        for (int i = 0; i < NUM_BARS; i++) {
            int swapWithIndex = rng.nextInt(NUM_BARS - 1);
            int temp = array[i];
            array[i] = array[swapWithIndex];
            array[swapWithIndex] = temp;
        }
    }

    SortMenu generateSequenceArray() {
        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i + 1;
        }
        shuffleArray();
        return this;
    }

    SortMenu setAlgorithm(SortVariant sortAlgorithm) {
        algorithm = sortAlgorithm;
        return this;
    }

    int getMax() {
        int temp = 0;
        for (int i = 0; i < NUM_BARS; i++) {
            if (temp < array[i])
                temp = array[i];
        }
        return temp;
    }

    void startStep(){
        System.arraycopy(algorithm.getFirstStep(), 0, array, 0, NUM_BARS);
        repaint();
    }

    void prevStep(){
        System.arraycopy(algorithm.getPrevStep(), 0, array, 0, NUM_BARS);
        repaint();
    }

    void nextStep(){
        System.arraycopy(algorithm.getNextStep(), 0, array, 0, NUM_BARS);
        repaint();
    }

    void endStep(){
        System.arraycopy(algorithm.getLastStep(), 0, array, 0, NUM_BARS);
        repaint();
    }

    SortMenu startSorting(){
        algorithm.setStepSort();
        return this;
    }
    void animate(){
        int delay = 2;

        repaint();
        time = new Timer();
        int i = 0;
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                System.arraycopy(algorithm.getNextStep(), 0, array, 0, NUM_BARS);
                repaint();
                if (algorithm.position == algorithm.stepSort.size() - 1){
                    System.out.println("timer stopped");
                    time.cancel();
                    return;
                }
            }
        }, delay, delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        for (int x = 0; x < NUM_BARS; x++) {
            int height = array[x] * WIN_HEIGHT / getMax();
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = WIN_HEIGHT - height;

            if (x == 13 || x == 52) {
                graphics.setColor(Color.red);
            } else {
                graphics.setColor(Color.white);
            }
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }
    }
}
