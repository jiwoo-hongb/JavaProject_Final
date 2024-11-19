package gui;

import function.Click_ActionListener;
import function.MyButton;
import function.TimeTable;

import javax.swing.*;
import java.awt.*;

public class Main_Gui extends JFrame {
    Gui_Design design = new Gui_Design();
//    Click_ActionListener click = new Click_ActionListener();
    TimeTable timeTable;

    Main_Gui() {
        timeTable = new TimeTable();
        Click_ActionListener click = new Click_ActionListener(timeTable);
        setTitle("시간표 마법사 💫");
        setSize(351, 759);
        setLayout(new BorderLayout());

        showNorth();
        showCenter(click);
        showSouth();

        setVisible(true);
    }

    void showNorth(){
        MyPanel panel = new MyPanel();
//        panel.setBounds(12, 21, 367, 87);
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        panel.setBackground(design.getPanelColor());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//        panel.setLayout(null);

        JLabel credit = new JLabel("학점: 18학점", SwingConstants.CENTER);
//        credit.setBounds(12, 20, 367, 40);
        credit.setFont(new Font("Pretendard", Font.BOLD, 28));
        credit.setForeground(Color.WHITE);

        panel.add(credit);
        add(panel, BorderLayout.NORTH);
    }
    void showCenter(Click_ActionListener click){
        MyPanel panel1 = new MyPanel();; // 전체 테두리
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // 패널1의 레이아웃 설정
        JLabel major = new JLabel("전공");
        major.setForeground(Color.WHITE);

        MyPanel panel2 = new MyPanel(); //전공 버튼 담을 테두리
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        //[전공 과목]
        MyButton btn_Java = new MyButton("JAVA프로그래밍2");
        btn_Java.setBackground(design.getBtnColor());
        btn_Java.addActionListener(click);

        MyButton btn_GUI = new MyButton("GUI프로그래밍");
        btn_GUI.setBackground(design.getBtnColor());
        btn_GUI.addActionListener(click);

        MyButton btn_Algorithem = new MyButton("알고리즘설계");
        btn_Algorithem.setBackground(design.getBtnColor());
        btn_Algorithem.addActionListener(click);

        MyButton btn_BigData = new MyButton("빅데이터처리");
        btn_BigData.setBackground(design.getBtnColor());
        btn_BigData.addActionListener(click);

        MyButton btn_OS = new MyButton("운영체제");
        btn_OS.setBackground(design.getBtnColor());
        btn_OS.addActionListener(click);

        panel2.add(btn_Java);
        panel2.add(btn_GUI);
        panel2.add(btn_Algorithem);
        panel2.add(btn_BigData);
        panel2.add(btn_OS);

        JPanel panel3 = new JPanel(); // 교양 버튼 담을 테두리
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // 수직 정렬 설정

        JLabel culture = new JLabel("교양 필수");
        culture.setForeground(Color.WHITE);
        MyButton btn_English3 = new MyButton("English3");
        btn_English3.setBackground(design.getBtnColor());
        btn_English3.addActionListener(click);
        panel3.add(btn_English3);


        panel1.add(major);
        panel1.add(panel2);
        panel1.add(culture);
        panel1.add(panel3);

        add(panel1, BorderLayout.CENTER);
    }
    void showSouth(){
        MyPanel panel = new MyPanel();
        JButton btn_next = new JButton("Next");
        btn_next.setBackground(design.getPanelColor());
        btn_next.setForeground(Color.WHITE);

        panel.add(btn_next);
        add(panel, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        Main_Gui frame = new Main_Gui();
    }
}
