package visuliser;

import algorithms.BubbleSort;
import algorithms.CocktailSort;
import algorithms.HeapSort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortVisualiser {
    public static final int WIN_WIDTH = 1600;
    public static final int WIN_HEIGHT = 900;

    public JFrame window;
    public SortArray drawerPanel;
    public ActionMenu actionPanel;


    private SortVisualiser() {}

    public static Builder newBuilder(){
        return new SortVisualiser().new Builder();
    }

    public class Builder {
        private Builder() { }

        public Builder setWindow() {
            window = new JFrame("Sort Visualisation");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(WIN_WIDTH,WIN_HEIGHT);
            window.setLocationRelativeTo(null);
            window.setLayout(null);
            window.setResizable(false);
            return this;
        }

        public Builder setActionPanel(){
            actionPanel = new ActionMenu();
            actionPanel.setBounds(1050, 25, 520, 800);
            actionPanel.setLayout(null);
            actionPanel.setBackground(Color.gray);

            actionPanel.helpButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("help");
                }
            });

            actionPanel.nextStep.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawerPanel.setNext(true);
                    drawerPanel.repaint();
                    System.out.println("next");
                }
            });

            actionPanel.prevStep.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawerPanel.setPrev(true);
                    drawerPanel.repaint();
                    System.out.println("prev");
                }
            });

            actionPanel.pause.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("pause");
                    if (drawerPanel.pause) drawerPanel.setPause(false);
                    else drawerPanel.setPause(true);
                }
            });

            actionPanel.createElements.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawerPanel.setSizeOfArray((int)actionPanel.elements.getValue());
                    drawerPanel.generate();
                    switch (actionPanel.chooseSort.getSelectedIndex()){
                        case 0:
                            drawerPanel.setAlgorithm(new BubbleSort(drawerPanel.array));
                            break;
                        case 1:
                            drawerPanel.setAlgorithm(new CocktailSort(drawerPanel.array));
                            break;
                        case 2:
                            drawerPanel.setAlgorithm(new HeapSort(drawerPanel.array));
                            break;
                        case 3:
                            drawerPanel.setAlgorithm(new BubbleSort(drawerPanel.array));
                            break;

                    }
                    System.out.println("create");
                    drawerPanel.repaint();
                    actionPanel.startAlgorithm.setEnabled(true);
                }
            });

            actionPanel.startAlgorithm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("start");
                    drawerPanel.startSorting();
                    drawerPanel.animate();
                    actionPanel.prevStep.setEnabled(true);
                    actionPanel.nextStep.setEnabled(true);
                    actionPanel.pause.setEnabled(true);
                }
            });

            return this;
        }

        public Builder setDrawerPanel(){
            drawerPanel = new SortArray();
            drawerPanel.setBounds(10, 25, 1024, 800);
            drawerPanel.setBackground(Color.gray);
            return this;
        }

        public SortVisualiser build(){
            window.add(actionPanel);
            window.add(drawerPanel);
            window.setVisible(true);
            return new SortVisualiser();
        }

    }

    public static void main(String[] args){
        SortVisualiser sortVisualiser = SortVisualiser.newBuilder().setWindow().setDrawerPanel().setActionPanel().build();
        Thread drawThread = new Thread(sortVisualiser.drawerPanel);
        drawThread.start();
    }
}
