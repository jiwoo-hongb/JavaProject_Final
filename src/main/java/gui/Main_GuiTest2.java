package gui;

import javax.swing.*;
import java.awt.*;

public class Main_GuiTest2 extends JFrame {

    public Main_GuiTest2() {
        // Set up the main frame
        setTitle("Custom Layout");
        setSize(390, 844);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use absolute positioning

        // Main background panel (iPhone 13 & 14 - 2 equivalent)
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 390, 844);
        mainPanel.setBackground(new Color(7, 11, 13));
        mainPanel.setLayout(null);
        add(mainPanel);

        // Rectangle 14
        JPanel rect14 = new JPanel();
        rect14.setBounds(19, 32, 352, 782);
        rect14.setBackground(new Color(39, 57, 64, 128)); // rgba(39, 57, 64, 0.5)
        rect14.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, true));
        rect14.setLayout(null);
        mainPanel.add(rect14);

        // Rectangle 15
        JPanel rect15 = new JPanel();
        rect15.setBounds(38, 348, 314, 87);
        rect15.setLayout(null);
        mainPanel.add(rect15);

        // Rectangle 16
        JPanel rect16 = new JPanel();
        rect16.setBounds(38, 72, 313, 80);
        rect16.setBorder(BorderFactory.createLineBorder(new Color(242, 142, 19), 1));
        rect16.setBackground(new Color(7, 11, 13)); // Assuming no specific background
        rect16.setLayout(null);
        mainPanel.add(rect16);

        // 월요일 label
        JLabel mondayLabel = new JLabel("월요일");
        mondayLabel.setBounds(58, 93, 81, 37);
        mondayLabel.setFont(new Font("Pretendard", Font.BOLD, 28));
        mondayLabel.setForeground(Color.WHITE);
        mainPanel.add(mondayLabel);

        // Polygon 1
        JPanel polygon1 = new JPanel();
        polygon1.setBounds(331, 123, 35, 33);
        polygon1.setBackground(new Color(242, 142, 19));
        // Polygon rotation is not directly supported in Swing; you'll need custom painting for this.
        mainPanel.add(polygon1);

        // 금융자산관리의 이해 곽세영
        JLabel text1 = new JLabel("금융자산관리의 이해 곽세영", SwingConstants.CENTER);
        text1.setBounds(38, 173, 314, 59);
        text1.setFont(new Font("Pretendard", Font.BOLD, 28));
        text1.setForeground(Color.WHITE);
        mainPanel.add(text1);

        // Ellipse 1 for 금융자산관리의 이해
        JPanel ellipse1 = new JPanel();
        ellipse1.setBounds(48, 180, 19, 19);
        ellipse1.setBorder(BorderFactory.createLineBorder(new Color(242, 142, 19), 1));
        ellipse1.setBackground(null);
        mainPanel.add(ellipse1);

        // 생활과 공예 황성실
        JLabel text2 = new JLabel("생활과 공예 황성실", SwingConstants.CENTER);
        text2.setBounds(37, 413, 314, 59);
        text2.setFont(new Font("Pretendard", Font.BOLD, 28));
        text2.setForeground(Color.WHITE);
        mainPanel.add(text2);

        // Ellipse 1 for 생활과 공예
        JPanel ellipse2 = new JPanel();
        ellipse2.setBounds(47, 420, 19, 19);
        ellipse2.setBorder(BorderFactory.createLineBorder(new Color(242, 142, 19), 1));
        ellipse2.setBackground(null);
        mainPanel.add(ellipse2);

        // 금융공학의 이해 고석빈
        JLabel text3 = new JLabel("금융공학의 이해 고석빈", SwingConstants.CENTER);
        text3.setBounds(37, 253, 314, 59);
        text3.setFont(new Font("Pretendard", Font.BOLD, 28));
        text3.setForeground(Color.WHITE);
        mainPanel.add(text3);

        // Ellipse 1 for 금융공학의 이해
        JPanel ellipse3 = new JPanel();
        ellipse3.setBounds(47, 260, 19, 19);
        ellipse3.setBorder(BorderFactory.createLineBorder(new Color(242, 142, 19), 1));
        ellipse3.setBackground(null);
        mainPanel.add(ellipse3);

        // 인공지능을 위한 코딩 이성현
        JLabel text4 = new JLabel("인공지능을 위한 코딩 이성현", SwingConstants.CENTER);
        text4.setBounds(38, 333, 314, 59);
        text4.setFont(new Font("Pretendard", Font.BOLD, 28));
        text4.setForeground(Color.WHITE);
        mainPanel.add(text4);

        // Ellipse 1 for 인공지능을 위한 코딩
        JPanel ellipse4 = new JPanel();
        ellipse4.setBounds(48, 340, 19, 19);
        ellipse4.setBorder(BorderFactory.createLineBorder(new Color(242, 142, 19), 1));
        ellipse4.setBackground(new Color(242, 142, 19));
        mainPanel.add(ellipse4);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main_GuiTest2();
    }
}
