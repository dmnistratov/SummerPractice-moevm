package visualiser;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;

public class ActionMenu extends JPanel {
    JButton helpButton, settingsButton, startStep, endStep, nextStep, prevStep, playStep, infoButton;
    ImageIcon pauseIcon, playIcon;

    ActionMenu() {
        setBounds(0, 800, 1600, 100);
        setBackground(Color.darkGray);
        setLayout(null);

        helpButton = new JButton();
        settingsButton = new JButton();
        startStep = new JButton();
        endStep = new JButton();
        nextStep = new JButton();
        prevStep = new JButton();
        playStep = new JButton();
        infoButton = new JButton();

        helpButton.setBounds(10, 18, 64, 64);
        settingsButton.setBounds(1524, 18, 64, 64);
        playStep.setBounds(768, 18, 64, 64);
        prevStep.setBounds(664, 18, 64, 64);
        startStep.setBounds(560, 18, 64, 64);
        nextStep.setBounds(872, 18, 64, 64);
        endStep.setBounds(976, 18, 64, 64);
        infoButton.setBounds(1430, 18, 64, 64);
        try {
            Image rightArrow = ImageIO.read(getClass().getClassLoader().getResource("right-icon.png"));
            Image leftArrow = ImageIO.read(getClass().getClassLoader().getResource("left-icon.png"));
            Image playIMG = ImageIO.read(getClass().getClassLoader().getResource("play-icon.png"));
            Image startArrow = ImageIO.read(getClass().getClassLoader().getResource("double-left-icon.png"));
            Image endArrow = ImageIO.read(getClass().getClassLoader().getResource("double-right-icon.png"));
            Image helpIMG = ImageIO.read(getClass().getClassLoader().getResource("help-icon.png"));
            Image consoleIMG = ImageIO.read(getClass().getClassLoader().getResource("console-icon.png"));
            Image settingsIMG = ImageIO.read(getClass().getClassLoader().getResource("setting-icon.png"));
            Image pauseIMG = ImageIO.read(getClass().getClassLoader().getResource("pause-icon.png"));
            pauseIcon = new ImageIcon(pauseIMG);
            playIcon = new ImageIcon(playIMG);
            prevStep.setIcon(new ImageIcon(leftArrow));
            nextStep.setIcon(new ImageIcon(rightArrow));
            helpButton.setIcon(new ImageIcon(helpIMG));
            settingsButton.setIcon(new ImageIcon(settingsIMG));
            startStep.setIcon(new ImageIcon(startArrow));
            endStep.setIcon(new ImageIcon(endArrow));
            infoButton.setIcon(new ImageIcon(consoleIMG));
            playStep.setIcon(playIcon);

        } catch (Exception e) {
            System.out.println(e);
            // ERROR HANDLING #TODO
        }

        add(helpButton);
        add(settingsButton);
        add(playStep);
        add(prevStep);
        add(startStep);
        add(nextStep);
        add(endStep);
        add(infoButton);
    }
}
