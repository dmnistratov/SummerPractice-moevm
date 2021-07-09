import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualise extends JFrame{

    ActionMenu actionMenu;
    SortMenu drawMenu;
    JPanel panel;

    JButton button = new JButton("ok");
    Visualise(){
        actionMenu = new ActionMenu();
        drawMenu = new SortMenu();
        panel = new JPanel();

        panel.setBounds(1600, 0, 200, 900);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(1600, 900));
        setResizable(false);

        panel.setBackground(Color.black);
        add(drawMenu);
        add(actionMenu);
        add(panel);

        actionMenu.playStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getContentPane().getPreferredSize().width == 1600){
                    getContentPane().setPreferredSize(new Dimension(1800, 900));
                }
                else{
                    getContentPane().setPreferredSize(new Dimension(1600, 900));
                }
                pack();
                setLocationRelativeTo(null);
            }
        });
        pack();
        setLocationRelativeTo(null);
    }
}
