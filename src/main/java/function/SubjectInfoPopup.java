package function;

import javax.swing.*;
import java.awt.*;
import gui.Gui_Design;

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

        // 교과목 정보를 JLabel로 추가
        JLabel subjectLabel = new JLabel("교과목: " + subjectName);
        subjectLabel.setForeground(Color.WHITE);
        JLabel professorLabel = new JLabel("교수: " + professor);
        professorLabel.setForeground(Color.WHITE);
        JLabel timeLabel = new JLabel("시간: " + time);
        timeLabel.setForeground(Color.WHITE);
        JLabel locationLabel = new JLabel("장소: " + location);
        locationLabel.setForeground(Color.WHITE);
        JLabel creditsLabel = new JLabel("학점: " + credits);
        creditsLabel.setForeground(Color.WHITE);
        JLabel categoryLabel = new JLabel("영역: " + category);
        categoryLabel.setForeground(Color.WHITE);

        // JLabel 추가
        popup.add(subjectLabel);
        popup.add(professorLabel);
        popup.add(timeLabel);
        popup.add(locationLabel);
        popup.add(creditsLabel);
        popup.add(categoryLabel);

        // 팝업 창을 부모 컴포넌트 근처에 표시
        popup.setLocationRelativeTo(parent);
        popup.setVisible(true);
    }
}
