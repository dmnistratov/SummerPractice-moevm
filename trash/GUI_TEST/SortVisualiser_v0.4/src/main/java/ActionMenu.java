import javax.swing.*;
import java.awt.*;

public class ActionMenu extends JPanel {
    JButton helpButton, settingsButton, startStep, endStep, nextStep, prevStep, playStep;

    ActionMenu(){
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

        helpButton.setBounds(10 , 18, 64, 64);
        settingsButton.setBounds(1524, 18, 64, 64);
        playStep.setBounds(768, 18, 64, 64);
        prevStep.setBounds(664, 18, 64, 64);
        startStep.setBounds(560, 18, 64, 64);
        nextStep.setBounds(872, 18, 64, 64);
        endStep.setBounds(976, 18, 64, 64);
        add(helpButton);
        add(settingsButton);
        add(playStep);
        add(prevStep);
        add(startStep);
        add(nextStep);
        add(endStep);
    }
}
