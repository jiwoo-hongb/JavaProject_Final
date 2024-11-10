package gui;

import javax.swing.*;
import java.awt.*;

public class Main_Gui extends JFrame {
    Main_Gui() {
        setTitle("시간표 마법사 💫");
        setSize(351, 759);
        setLayout(null);

        showNorth();
        showCenter();
        showSouth();

        setVisible(true);
    }

    void showNorth(){
        JPanel panel = new JPanel();
        JLabel credit = new JLabel("학점: 18학점");

        panel.add(credit);
        add(panel);
    }
    void showCenter(){
        JPanel panel1 = new JPanel(); // 전체 테두리
        JLabel major = new JLabel("전공");


        JPanel panel2 = new JPanel(); //전공 버튼 담을 테두리
        JPanel panel3 = new JPanel(); //교양 버튼 담을 테두리

        //[전공 과목]
        JButton btn_Java = new JButton();
        JTextField txf_Java = new JTextField("JAVA프로그래밍 남수만");
        btn_Java.add(txf_Java);

        JButton btn_GUI = new JButton();
        JTextField txf_GUI = new JTextField("GUI프로그래밍 우선미");
        btn_GUI.add(txf_GUI);

        JButton btn_Algorithem = new JButton();
        JTextField txf_Algorithem = new JTextField("알고리즘 설계 최미경");
        btn_Algorithem.add(txf_Algorithem);

        JButton btn_BigData = new JButton();
        JTextField txf_BigData = new JTextField("빅데이터 이해 송재숙");
        btn_BigData.add(txf_BigData);

        JButton btn_OS = new JButton();
        JTextField txf_OS = new JTextField("운영체제 송재숙");
        btn_OS.add(txf_OS);

        JLabel culture = new JLabel("교양 필수");
        JButton btn_English3 = new JButton();
        JTextField txf_English3 = new JTextField("English3 boris");
        btn_English3.add(txf_English3);

        panel2.add(btn_Java);
        panel2.add(btn_GUI);
        panel2.add(btn_Algorithem);
        panel2.add(btn_BigData);
        panel2.add(btn_OS);
        panel3.add(btn_English3);

        panel1.add(major);
        panel1.add(panel2);
        panel1.add(culture);
        panel1.add(panel3);

        add(panel1);
    }
    void showSouth(){
        JPanel panel = new JPanel();
        JButton btn_next = new JButton("Next");

        panel.add(btn_next);
        add(panel);

    }
    public static void main(String[] args) {
        Main_Gui frame = new Main_Gui();
    }
}
