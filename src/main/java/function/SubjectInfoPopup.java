package function;

import javax.swing.*;
import java.awt.*;
import gui.Gui_Design;
import gui.RoundPanel;

public class SubjectInfoPopup {
    static Gui_Design design = new Gui_Design();

    public static void showSubjectInfo(Component parent, String subjectName, String professor, String time, String location, String credits, String category) {
        // 팝업 창 생성
        JFrame popup = new JFrame("교과목 정보");
        popup.setSize(300, 200);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setLayout(new GridLayout(6, 1));

        // 배경색 설정 (ContentPane의 배경색 변경)
        popup.getContentPane().setBackground(design.getBackgroundColor());

        RoundPanel panel = new RoundPanel(20);
        panel.setBackground(design.getPanelColor());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));
        // 교과목 정보를 JLabel로 추가
        JLabel subjectLabel = new JLabel("교과목: " + subjectName);
        subjectLabel.setForeground(Color.WHITE);
        subjectLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        JLabel professorLabel = new JLabel("교수: " + professor);
        professorLabel.setForeground(Color.WHITE);
        professorLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        JLabel timeLabel = new JLabel("시간: " + time);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        JLabel locationLabel = new JLabel("장소: " + location);
        locationLabel.setForeground(Color.WHITE);
        locationLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        JLabel creditsLabel = new JLabel("학점: " + credits);
        creditsLabel.setForeground(Color.WHITE);
        creditsLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        JLabel categoryLabel = new JLabel("영역: " + category);
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setFont(new Font("Pretendard", Font.BOLD, 10));

        // JLabel 추가
        panel.add(Box.createVerticalStrut(10));
        panel.add(subjectLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(professorLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(timeLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(locationLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(creditsLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(categoryLabel);

        popup.add(panel, BorderLayout.CENTER);

        // 팝업 창을 부모 컴포넌트 근처에 표시
        popup.setLocationRelativeTo(parent);
        popup.setVisible(true);
    }
}
