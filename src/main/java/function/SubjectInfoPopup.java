package function;

import javax.swing.*;
import java.awt.*;
import gui.Gui_Design;
import gui.RoundPanel;

/**
 * SubjectInfoPopup 클래스는 과목 정보를 팝업 창으로 표시하는 기능을 제공합니다.
 * 사용자가 과목을 선택하면 해당 과목에 대한 상세 정보를 팝업으로 띄워줍니다.
 *
 * <p>이 팝업은 과목명, 교수명, 시간, 장소, 학점, 영역을 포함하여 과목에 대한 세부 정보를 보여줍니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * SubjectInfoPopup.showSubjectInfo(parent, "수학", "홍길동", "월 10:00", "101호", "3", "전공");
 * </pre>
 * </p>
 */

public class SubjectInfoPopup {

    /** 디자인을 위한 Gui_Design 객체 */
    static Gui_Design design = new Gui_Design();

    /**
     * 과목 정보를 팝업 창으로 표시합니다.
     * 주어진 과목명, 교수명, 시간, 장소, 학점, 영역에 대한 정보를 포함하여 팝업을 생성합니다.
     *
     * @param parent 팝업 창의 부모 컴포넌트
     * @param subjectName 과목명
     * @param professor 교수명
     * @param time 수업 시간
     * @param location 수업 장소
     * @param credits 학점
     * @param category 과목 영역 (예: 전공, 교양)
     */
    public static void showSubjectInfo(Component parent, String subjectName, String professor, String time, String location, String credits, String category) {
        // 팝업 창 생성
        JFrame popup = new JFrame("교과목 정보");
        popup.setSize(300, 200);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setLayout(new GridLayout(6, 1));

        // 배경색 설정 (ContentPane의 배경색 변경)
        popup.getContentPane().setBackground(design.getBackgroundColor());

        // 라운드 패널 생성
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

        // 팝업 창에 패널 추가
        popup.add(panel, BorderLayout.CENTER);

        // 팝업 창을 부모 컴포넌트 근처에 표시
        popup.setLocationRelativeTo(parent);
        popup.setVisible(true);
    }
}
