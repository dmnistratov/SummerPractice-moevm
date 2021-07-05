import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class SortVisualiser {
    public static final int WIN_WIDTH = 1600;
    public static final int WIN_HEIGHT = 900;

    private JFrame window;
    private SortArray sortArray;
    private JPanel actionPanel;

    public SortVisualiser(){
        window = new JFrame("Sort visualisation");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIN_WIDTH,WIN_HEIGHT);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);

        sortArray = new SortArray();
        sortArray.setBounds(10, 25, 1024, 800);

        actionPanel = new JPanel();
        actionPanel.setBounds(1050, 25, 520, 800);
        actionPanel.setBackground(Color.RED);

        sortArray.repaint();
        window.add(sortArray);
        window.add(actionPanel);
        window.setVisible(true);

        sortArray.startSorting();
    }
    public static void main(String[] args){
        SortVisualiser sortVisualiser = new SortVisualiser();
    }

}
