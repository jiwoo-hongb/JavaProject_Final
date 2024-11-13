package gui;

import data.CourseLoader;
import function.CourseSelector;
import function.MyButton;

import javax.swing.*;
import java.awt.*;

public class Test_Main extends JFrame {
    Gui_Design design = new Gui_Design();

    // CourseLoader와 CourseSelector 객체 생성
    CourseLoader courseLoader = new CourseLoader();
    CourseSelector courseSelector = new CourseSelector(courseLoader);

    Test_Main() {
        setTitle("시간표 마법사 💫");
        setSize(351, 759);
        setLayout(new BorderLayout());

        showNorth();
        showCenter();
        showSouth();

        setVisible(true);
    }

    void showNorth(){
        MyPanel panel = new MyPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        panel.setBackground(design.getPanelColor());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JLabel credit = new JLabel("학점: 18학점", SwingConstants.CENTER);
        credit.setFont(new Font("Pretendard", Font.BOLD, 28));
        credit.setForeground(Color.WHITE);

        panel.add(credit);
        add(panel, BorderLayout.NORTH);
    }

    void showCenter(){
        MyPanel panel1 = new MyPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JLabel major = new JLabel("전공");
        major.setForeground(Color.WHITE);

        MyPanel panel2 = new MyPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        // [전공 과목] 버튼들
        MyButton btn_Java = new MyButton("JAVA프로그래밍2 남수만");
        btn_Java.setBackground(design.getBtnColor());
        btn_Java.addActionListener(courseSelector);  // CourseSelector에서 처리하도록 설정

        MyButton btn_GUI = new MyButton("GUI프로그래밍 우선미");
        btn_GUI.setBackground(design.getBtnColor());
        btn_GUI.addActionListener(courseSelector);  // CourseSelector에서 처리하도록 설정

        panel2.add(btn_Java);
        panel2.add(btn_GUI);

        panel1.add(major);
        panel1.add(panel2);
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
        Test_Main frame = new Test_Main();
    }
}
