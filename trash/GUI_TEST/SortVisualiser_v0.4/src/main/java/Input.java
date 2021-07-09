import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import com.jidesoft.swing.RangeSlider;

public class Input {
    JFrame window;
    Visualise visWindow;
    JPanel mainPanel, generatePanel, inputPanel, radioBoxPanel;
    JLabel infoSort, infoArray, infoSize, infoRange, infoInputMethod;
    JComboBox chooseSort;
    JSlider sizeSlider;
    RangeSlider rangeSlider;
    JTextField arrayInput;
    JButton okButton;
    ButtonGroup group;
    JRadioButton inputElements, generateElements;

    Input(){
        window = new JFrame();
        visWindow = new Visualise();
        mainPanel = new JPanel();
        generatePanel = new JPanel();
        inputPanel = new JPanel();
        radioBoxPanel = new JPanel();
        infoSort = new JLabel("Sorting Algorithm:");
        infoArray = new JLabel("Array Settings:");
        infoSize = new JLabel("Size of Array:");
        infoRange = new JLabel("Range of Array Generation:");
        infoInputMethod = new JLabel("Input array:");
        String[] algStr = {"Bubble Sort", "Cocktail Sort", "Heap Sort"};
        chooseSort = new JComboBox(algStr);
        sizeSlider = new JSlider(2, 200);
        group = new ButtonGroup();
        inputElements = new JRadioButton("Input");
        generateElements = new JRadioButton("Generate");
        rangeSlider = new RangeSlider(1, 800);
        arrayInput = new JTextField();
        okButton = new JButton("Create");

        inputElements.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    generatePanel.setVisible(false);
                    inputPanel.setVisible(true);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    generatePanel.setVisible(true);
                    inputPanel.setVisible(false);
                }
            }
        });
        generateElements.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    generatePanel.setVisible(true);
                    inputPanel.setVisible(false);
                }
                else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    generatePanel.setVisible(false);
                    inputPanel.setVisible(true);
                }
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visWindow.setVisible(true);
                window.setVisible(false);
            }
        });

        visWindow.actionMenu.settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visWindow.setVisible(false);
                window.setVisible(true);
            }
        });

        generatePanel.add(infoRange);
        generatePanel.add(rangeSlider);
        inputPanel.setVisible(false);
        inputPanel.add(infoInputMethod);
        inputPanel.add(arrayInput);
        group.add(inputElements);
        group.add(generateElements);
        generateElements.setSelected(true);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(infoSort);
        mainPanel.add(chooseSort);
        mainPanel.add(infoArray);
        mainPanel.add(infoSize);
        mainPanel.add(sizeSlider);
        radioBoxPanel.add(inputElements);
        radioBoxPanel.add(generateElements);
        mainPanel.add(radioBoxPanel);
        mainPanel.add(generatePanel);
        mainPanel.add(inputPanel);
        mainPanel.add(okButton);
        window.add(mainPanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

}
