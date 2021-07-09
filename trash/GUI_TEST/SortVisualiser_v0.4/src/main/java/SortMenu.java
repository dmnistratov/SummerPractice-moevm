import javax.swing.*;
import java.awt.*;

public class SortMenu extends JPanel {
    int[] array;

    int BAR_WIDTH;
    int NUM_BARS;

    SortMenu() {
        setBounds(0, 0, 1600, 800);
        setBackground(Color.gray);
        setLayout(null);
        array = new int[100];

        for (int i = 0; i < 100; i++){
            array[i] = i;
        }
        BAR_WIDTH = 1600 / 100;
        NUM_BARS = 100;
    }

    SortMenu setArray(int[] array){
        return this;
    }

    SortMenu setAlgorithm(){
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        for (int x = 0; x < NUM_BARS; x++) {
            int height = array[x] * 3;
            int xBegin = x + (BAR_WIDTH - 1) * x;
            int yBegin = 800 - height;

            if (x == 13 || x == 52){
                graphics.setColor(Color.red);
            }
            else{
                graphics.setColor(Color.white);
            }
            graphics.fillRect(xBegin, yBegin, BAR_WIDTH, height);
        }
    }
}
