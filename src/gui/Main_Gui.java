package gui;

import javax.swing.*;
import java.awt.*;

public class Main_Gui extends JFrame {
    Main_Gui() {
        setTitle("시간표 마법사 💫");
        setSize(351, 759);
//        setLayout();

        showNorth();
        showCenter();
        showSouth();

        setVisible(true);
    }

    void showNorth(){
        JPanel panel = new JPanel();
        JLabel credit = new JLabel("학점: 18학점");

        panel.add(credit);
        add(panel, BorderLayout.NORTH);
    }
    void showCenter(){
        JPanel panel1 = new JPanel(); // 전체 테두리
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // 패널1의 레이아웃 설정
        JLabel major = new JLabel("전공");


        JPanel panel2 = new JPanel(); //전공 버튼 담을 테두리
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        //[전공 과목]
        JButton btn_Java = new JButton("JAVA프로그래밍 남수만");
        JButton btn_GUI = new JButton("GUI프로그래밍 우선미");
        JButton btn_Algorithem = new JButton("알고리즘 설계 최미경");
        JButton btn_BigData = new JButton("빅데이터 이해 송재숙");
        JButton btn_OS = new JButton("운영체제 송재숙");

        panel2.add(btn_Java);
        panel2.add(btn_GUI);
        panel2.add(btn_Algorithem);
        panel2.add(btn_BigData);
        panel2.add(btn_OS);

        JPanel panel3 = new JPanel(); // 교양 버튼 담을 테두리
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // 수직 정렬 설정

        JLabel culture = new JLabel("교양 필수");
        JButton btn_English3 = new JButton("English3 boris");
        panel3.add(btn_English3);


        panel1.add(major);
        panel1.add(panel2);
        panel1.add(culture);
        panel1.add(panel3);

        add(panel1, BorderLayout.CENTER);
    }
    void showSouth(){
        JPanel panel = new JPanel();
        JButton btn_next = new JButton("Next");

        panel.add(btn_next);
        add(panel, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        Main_Gui frame = new Main_Gui();
    }
}
