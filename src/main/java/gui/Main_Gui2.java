package gui;

import javax.swing.*;
import java.awt.*;

public class Main_Gui2 extends JFrame {
    Main_Gui2() {
        setTitle("시간표 마법사 💫");
        setSize(355, 770);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("카피바라기여우엉>.<");

        add(label, BorderLayout.CENTER);

        setVisible(true);
    }


}

