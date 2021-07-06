package sortVisualiser;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;

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
        actionPanel.setLayout(null);
        actionPanel.setBackground(Color.GRAY);

        JLabel infoText = new JLabel("", SwingConstants.CENTER);
        JButton helpButton = new JButton("Help");
        JButton nextStep = new JButton();
        JButton prevStep = new JButton();
        JButton stopStep = new JButton();
        JButton continueStep = new JButton("Continue animation");
        String[] algStr = {"Bubble Sort", "Cocktail Sort", "Heap Sort", "Compare All Sorts"};
        JComboBox chooseSort = new JComboBox(algStr);
        JButton startAlgorithm = new JButton("Start sorting");
        JSpinner elements = new JSpinner(new SpinnerNumberModel(2, 2, 100, 1));
        JButton createElements = new JButton("Create Elements");
        ButtonGroup group = new ButtonGroup();
        JRadioButton inputElements = new JRadioButton("Input");
        JRadioButton generateElements = new JRadioButton("Generate");

        helpButton.setBounds(450, 10, 60, 40);
        infoText.setBounds(10, 60, 500, 300);
        infoText.setText("Information display here");
        infoText.setOpaque(true);
        infoText.setBackground(Color.darkGray);
        infoText.setForeground(Color.white);
        nextStep.setBounds(300, 385, 40, 40);
        nextStep.setEnabled(false);
        stopStep.setBounds(240, 385, 40, 40);
        stopStep.setEnabled(false);
        prevStep.setBounds(180, 385 ,40, 40);
        prevStep.setEnabled(false);

        try {
            Image rightArrow = ImageIO.read(getClass().getResource("../resources/right-icon.png"));
            Image leftArrow = ImageIO.read(getClass().getResource("../resources/left-icon.png"));
            Image pause = ImageIO.read(getClass().getResource("../resources/pause-icon.png"));
            prevStep.setIcon(new ImageIcon(leftArrow));
            nextStep.setIcon(new ImageIcon(rightArrow));
            stopStep.setIcon(new ImageIcon(pause));

        } catch (Exception e) {
            System.out.println(e);
            // ERROR HANDLING #TODO
        }
        continueStep.setBounds(180, 445, 160, 40);
        continueStep.setEnabled(false);
        chooseSort.setBounds(10, 505, 500, 30);
        startAlgorithm.setBounds(10, 760, 500, 30);
        startAlgorithm.setEnabled(false);
        elements.setBounds(470, 590, 40, 30);
        ((DefaultFormatter)((JSpinner.DefaultEditor)elements.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        createElements.setBounds(10, 640, 500, 30);
        inputElements.setBounds(10, 590, 225, 30);
        generateElements.setBounds(235, 590, 225, 30);
        group.add(inputElements);
        group.add(generateElements);
        chooseSort.setSelectedIndex(0);

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Help info! #TODO", "Help info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        createElements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /*
               sortArray.init();
                sortArray.repaint();
              */
                startAlgorithm.setEnabled(true);
            }
        });

        stopStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortArray.setPause(true);
            }
        });

        continueStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortArray.setPause(false);
            }
        });

        startAlgorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prevStep.setEnabled(true);
                nextStep.setEnabled(true);
                continueStep.setEnabled(true);
                stopStep.setEnabled(true);
            }
        });
        actionPanel.add(infoText);
        actionPanel.add(helpButton);
        actionPanel.add(nextStep);
        actionPanel.add(prevStep);
        actionPanel.add(stopStep);
        actionPanel.add(continueStep);
        actionPanel.add(chooseSort);
        actionPanel.add(startAlgorithm);
        actionPanel.add(elements);
        actionPanel.add(createElements);
        actionPanel.add(inputElements);
        actionPanel.add(generateElements);


        window.add(sortArray);
        window.add(actionPanel);
        window.setVisible(true);

        sortArray.init();
        sortArray.startSorting();
    }
    public static void main(String[] args){
        SortVisualiser sortVisualiser = new SortVisualiser();
    }
}
