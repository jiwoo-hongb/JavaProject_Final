package gui;

import javax.swing.*;
import java.awt.*;

public class Main_Gui2 extends JFrame {
    Gui_Design design = new Gui_Design();

    Main_Gui2() {
        setTitle("시간표 마법사 💫");
        setSize(355, 770);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showCenter_2();

        setVisible(true);
    }

    void showCenter_2(){
        MyPanel panel = new MyPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        RoundPanel panel_Background_Color2 = new RoundPanel(20);
        panel_Background_Color2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel_Background_Color2.setBackground(design.getPanelColor());

        String[] dayOfTheWeek = {"월요일", "화요일", "수요일", "목요일", "금요일"};
        JComboBox<String> day = new JComboBox<String>(dayOfTheWeek);

        panel_Background_Color2.add(day);
        panel.add(panel_Background_Color2);
        add(panel, BorderLayout.CENTER);
    }



    public static void main(String[] args) {
        Main_Gui2 main = new Main_Gui2();
    }

}

