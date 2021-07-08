package visuliser;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.*;
import javax.imageio.ImageIO;

public class ActionMenu extends JPanel{
        public JLabel infoText;
        public JButton helpButton, nextStep, prevStep, pause, startAlgorithm, createElements;
        public JComboBox chooseSort;
        public JSpinner elements;
        public ButtonGroup group;
        public JRadioButton inputElements, generateElements;

        ActionMenu() {
        infoText = new JLabel("", SwingConstants.CENTER);
        helpButton = new JButton("Help");
        nextStep = new JButton();
        prevStep = new JButton();
        pause = new JButton();
        String[] algStr = {"Bubble Sort", "Cocktail Sort", "Heap Sort", "Compare All Sorts"};
        chooseSort = new JComboBox(algStr);
        startAlgorithm = new JButton("Start sorting");
        elements = new JSpinner(new SpinnerNumberModel(2, 2, 200, 1));
        createElements = new JButton("Create Elements");
        group = new ButtonGroup();
        inputElements = new JRadioButton("Input");
        generateElements = new JRadioButton("Generate");

        helpButton.setBounds(450, 10, 60, 40);
        infoText.setBounds(10, 60, 500, 300);
        infoText.setText("Information display here");
        infoText.setOpaque(true);
        infoText.setBackground(Color.darkGray);
        infoText.setForeground(Color.white);
        nextStep.setBounds(300, 385, 40, 40);
        nextStep.setEnabled(false);
        pause.setBounds(240, 385, 40, 40);
        pause.setEnabled(false);
                try {
                        Image rightArrow = ImageIO.read(getClass().getClassLoader().getResource("right-icon.png"));
                        Image leftArrow = ImageIO.read(getClass().getClassLoader().getResource("left-icon.png"));
                        Image pauseIMG = ImageIO.read(getClass().getClassLoader().getResource("pause-icon.png"));
                        prevStep.setIcon(new ImageIcon(leftArrow));
                        nextStep.setIcon(new ImageIcon(rightArrow));
                        pause.setIcon(new ImageIcon(pauseIMG));

                } catch (Exception e) {
                        System.out.println(e);
                        // ERROR HANDLING #TODO
                }
        prevStep.setBounds(180, 385, 40, 40);
        prevStep.setEnabled(false);
        chooseSort.setBounds(10, 505, 500, 30);
        startAlgorithm.setBounds(10, 760, 500, 30);
        startAlgorithm.setEnabled(false);
        elements.setBounds(470, 590, 40, 30);
        elements.setValue(100);
        ((DefaultFormatter) ((JSpinner.DefaultEditor) elements.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
        createElements.setBounds(10, 640, 500, 30);
        inputElements.setBounds(10, 590, 225, 30);
        generateElements.setBounds(235, 590, 225, 30);
        generateElements.setSelected(true);
        group.add(inputElements);
        group.add(generateElements);
        chooseSort.setSelectedIndex(0);

        this.add(infoText);
        this.add(helpButton);
        this.add(nextStep);
        this.add(prevStep);
        this.add(pause);
        this.add(chooseSort);
        this.add(startAlgorithm);
        this.add(elements);
        this.add(createElements);
        this.add(inputElements);
        this.add(generateElements);
    }
}