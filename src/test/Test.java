package test;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    public Test() {
        setTitle("iPhone 13 & 14 Layout");
        setSize(351, 759);
        setLayout(null); // Using absolute positioning
        getContentPane().setBackground(new Color(7, 11, 13));

        // Rectangle 2
        JPanel rectangle2 = new JPanel();
        rectangle2.setBounds(12, 21, 367, 87);
        rectangle2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        rectangle2.setBackground(new Color(39, 57, 64, 128)); // rgba equivalent
        rectangle2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rectangle2.setLayout(null);

        JLabel creditLabel = new JLabel("학점: 18 학점", SwingConstants.CENTER);
        creditLabel.setBounds(12, 20, 367, 40);
        creditLabel.setFont(new Font("Pretendard", Font.BOLD, 28));
        creditLabel.setForeground(Color.WHITE);
        rectangle2.add(creditLabel);

        // Rectangle 3
        JPanel rectangle3 = new JPanel();
        rectangle3.setBounds(12, 129, 367, 691);
        rectangle3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        rectangle3.setBackground(new Color(39, 57, 64, 128));
        rectangle3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        rectangle3.setLayout(null);

        // Section Labels
        JLabel majorLabel = createSectionLabel("전공", 32, 116);
        JLabel requiredCourseLabel = createSectionLabel("교양필수", 32, 625);

        // Adding Courses
        JPanel course1 = createCoursePanel("JAVA프로그래밍 남수만", 47, 177);
        JPanel course2 = createCoursePanel("GUI프로그래밍 우선미", 47, 261);
        JPanel course3 = createCoursePanel("알고리즘 설계 최미경", 47, 345);
        JPanel course4 = createCoursePanel("빅데이터 이해 송재숙", 47, 430);
        JPanel course5 = createCoursePanel("운영체제 송재숙", 47, 515);
        JPanel course6 = createCoursePanel("English3 boris", 52, 687);

        // Add Components
        add(rectangle2);
        add(rectangle3);
        add(majorLabel);
        add(requiredCourseLabel);
        add(course1);
        add(course2);
        add(course3);
        add(course4);
        add(course5);
        add(course6);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Method to create section labels
    private JLabel createSectionLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 244, 52);
        label.setFont(new Font("Inter", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        return label;
    }

    // Method to create course panels
    private JPanel createCoursePanel(String text, int x, int y) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, 287, 65);
        panel.setBackground(new Color(242, 142, 19));
        panel.setLayout(null);

        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Pretendard", Font.BOLD, 28));
        label.setForeground(new Color(7, 11, 13));
        label.setBounds(10, 5, 267, 55); // Center within the panel

        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test());
    }
}
